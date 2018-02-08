package converters;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Collection;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.Id;

@FacesConverter(value = "converterPadrao")
public class ConverterPadrao implements Converter
{

	@SuppressWarnings("rawtypes")
	public Object getAsObject(FacesContext context, UIComponent component,
			String value)
	{
		if ( value == null || value.equals("") )
			return null;

		try
		{
			Long id = Long.valueOf(value);

			Collection items = (Collection) component.getAttributes().get("itens");

			return findById(items, id);
		}
		catch (Exception ex)
		{
			throw new ConverterException(
					"Não foi possível aplicar conversão de item com valor [" + value
							+ "] no componente [" + component.getId() + "]", ex);
		}
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object obj)
	{
		if ( obj == null || obj == "" || getIdByReflection(obj) == null )
			return "";

		if ( getIdByReflection(obj) != null )
		{
			return getIdByReflection(obj).toString();
		}
		return null;
	}

	private Long getIdByReflection(Object bean)
	{
		try
		{
			Field idField = getIdAnnotation(bean);
			idField.setAccessible(true);

			return (Long) idField.get(bean);
		}
		catch (Exception ex)
		{
			throw new RuntimeException(
					"Não foi possível obter a propriedade 'id' do item", ex);
		}
	}

	@SuppressWarnings("rawtypes")
	private Object findById(Collection collection, Long idToFind)
	{
		for (Object obj : collection)
		{
			Long id = getIdByReflection(obj);

			if ( id.equals(idToFind) )
				return obj;
		}

		return null;
	}

	/**
	 * Método que retorna a fild com a annotation @Id de um bean.
	 *
	 * @author Anderson Luna[andersonluna.comp@gmail.com] 30/10/2013 - 10:02:06.
	 * @param entity
	 * @return
	 */
	public static Field getIdAnnotation(Object entity)
	{
		if ( entity != null )
		{
			try
			{
				final PropertyDescriptor[] properties = Introspector.getBeanInfo(
						entity.getClass()).getPropertyDescriptors();

				for (final PropertyDescriptor property : properties)
				{
					if ( property.getReadMethod() != null
							&& property.getWriteMethod() != null )
					{
						final Field field = getField(property.getName(), entity.getClass());

						if ( field != null )
						{
							if ( field.isAnnotationPresent(Id.class) )
							{
								return field;
							}
						}
					}
				}
			}
			catch (IntrospectionException iex)
			{
				iex.printStackTrace();
			}
			catch (IllegalArgumentException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	private static Field getField(final String fieldName, final Class<?> cls)
	{
		Field field = null;
		try
		{
			field = cls.getDeclaredField(fieldName);
		}
		catch (final NoSuchFieldException e)
		{
			if ( !cls.getSuperclass().equals(Object.class) )
			{
				return getField(fieldName, cls.getSuperclass());
			}

		}
		return field;
	}

}
