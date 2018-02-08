package utils;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

public final class VelocityUtils
{

	private static final String INPUT_ENCODING = "input.encoding";

	private static final String ISO_8859_15 = "ISO-8859-15";

	private static final String FILE_RESOURCE_LOADER_PATH = "file.resource.loader.path";

	private static final String INPUT_LOCALE = "input.locale";

	private static final String PT_BR = "pt_BR";

	private static final String FILE = "file";

	private static final String SLASH = "/";

	private static final String RESOURCE_LOADER = "resource.loader";

	private static final String FILE_RESOURCE_LOADER_CLASS = "file.resource.loader.class";

	private static final String ORG_APACHE_VELOCITY_RUNTIME_RESOURCE_LOADER_FILE_RESOURCE_LOADER = "org.apache.velocity.runtime.resource.loader.FileResourceLoader";

	private static final String ORG_APACHE_VELOCITY_RUNTIME_RESOURCE_LOADER_CLASSPATH_RESOURCE_LOADER = "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader";

	private static final String RESOURCES_TEMPLATE_VELOCITY = "templateVelocity";

	/**
	 * @author Anderson Luna Almeida [anderson.almeida@cagece.com.br] 25/01/2012 -
	 *         16:08:44.
	 * 
	 * @param modulo
	 * @param funcionalidade
	 * @param nomeTemplate
	 * @param parametros
	 * @return
	 */
	public static String getStringPorTemplate(String funcionalidade,
			String nomeTemplate, Map<String, Object> parametros)
	{
		try
		{
			final VelocityContext velocityContext = getVelocityContext();

			final Template template = getTemplate(funcionalidade, nomeTemplate);
			
	    template.setEncoding("ISO-8859-15");

			final StringWriter writer = new StringWriter();

			if ( parametros != null )
			{
				Set<String> listaChave = parametros.keySet();
				for (String chave : listaChave)
				{
					velocityContext.put(chave, parametros.get(chave));
				}
			}

			template.merge(velocityContext, writer);

			return writer.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @author Anderson Luna[andersonluna.comp@gmail.com] 02/12/2013 - 09:45:54.
	 * 
	 * @param modulo
	 * @param funcionalidade
	 * @param nomeArquivoTemplate
	 * @return
	 * @throws Exception
	 */
	private static Template getTemplate(final String funcionalidade,
			final String nomeArquivoTemplate) throws Exception
	{
		if ( FacesContext.getCurrentInstance() != null )
		{
			final ServletContext facesContext = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();

			final String pathDoTemplate = facesContext
					.getRealPath(RESOURCES_TEMPLATE_VELOCITY + SLASH + SLASH
							+ funcionalidade);

			System.out.println(pathDoTemplate);
			
			final Properties props = getVelocityProperties();
			props.put(FILE_RESOURCE_LOADER_PATH, pathDoTemplate);

			final VelocityEngine velocityEngine = getInitVelocityEngine(props);
			return velocityEngine.getTemplate(nomeArquivoTemplate);
		}
		else
		{
			return getTemplateByPath(
					ORG_APACHE_VELOCITY_RUNTIME_RESOURCE_LOADER_CLASSPATH_RESOURCE_LOADER,
					nomeArquivoTemplate);
		}
	}

	/**
	 * @author Thuan Saraiva[thuan.saraiva@cagece.com.br] 21 de jul de 2015 -
	 *         09:18:41.
	 * @param path
	 * @return
	 * @throws Exception
	 * @throws ParseErrorException
	 * @throws ResourceNotFoundException
	 */
	private static Template getTemplateByPath(final String path,
			final String nomeArquivoTemplate) throws ResourceNotFoundException,
			ParseErrorException, Exception
	{
		final Properties props = new Properties();
		props.put(INPUT_ENCODING, ISO_8859_15);
		props.put(INPUT_LOCALE, PT_BR);

		props.put(RESOURCE_LOADER, FILE);
		props.put(FILE_RESOURCE_LOADER_CLASS, path);

		/*
		 * The default name for the loop counter variable reference, which is
		 * specified in the velocity.properties file, is $velocityCount. By default
		 * the counter starts at 1, but this can be set to either 0 or 1 in the
		 * velocity.properties file. Here's what the loop counter properties section
		 * of the velocity.properties file appears:
		 */
		// Default name of the loop counter
		// variable reference.
		props.put("directive.foreach.counter.name", "velocityCount");

		// Default starting value of the loop
		// counter variable reference.
		props.put("directive.foreach.counter.initial.value", "1");

		props.put("resource.manager.defaultcache.size", "0");

		final VelocityEngine velocityEngine = getInitVelocityEngine(props);
		return velocityEngine.getTemplate(nomeArquivoTemplate);
	}

	private static VelocityEngine getInitVelocityEngine(final Properties props)
			throws Exception
	{
		// cria e inicializa a engine
		final VelocityEngine ve = new VelocityEngine();

		ve.init(props);
		return ve;
	}

	/**
	 * 
	 * @author Anderson Luna[andersonluna.comp@gmail.com] 01/12/2013 - 17:25:20.
	 * @return
	 */
	public static VelocityContext getVelocityContext()
	{
		final VelocityContext context = new VelocityContext();
		//
		// // setando no contexto as classes velocityTools para apresenta��o
		// context.put("number", new NumberTool());
		// context.put("render", new RenderTool());
		// context.put("date", new DateTool());
		// context.put("math", new MathTool());
		//
		// final FormatosVelocity formatTools = new FormatosVelocity();
		//
		// context.put("formatos", formatTools);
		// context.put("format", formatTools);

		return context;
	}

	private static Properties getVelocityProperties()
	{

		// poss�vel setar v�rias propriedades atrav�s de um arquivo properties
		// como encoding,locale...
		final Properties props = new Properties();
		props.put(INPUT_ENCODING, ISO_8859_15);
		props.put(INPUT_LOCALE, PT_BR);

		props.put(RESOURCE_LOADER, FILE);
		props.put(FILE_RESOURCE_LOADER_CLASS,
				ORG_APACHE_VELOCITY_RUNTIME_RESOURCE_LOADER_FILE_RESOURCE_LOADER);

		/*
		 * The default name for the loop counter variable reference, which is
		 * specified in the velocity.properties file, is $velocityCount. By default
		 * the counter starts at 1, but this can be set to either 0 or 1 in the
		 * velocity.properties file. Here's what the loop counter properties section
		 * of the velocity.properties file appears:
		 */
		// Default name of the loop counter
		// variable reference.
		props.put("directive.foreach.counter.name", "velocityCount");

		// Default starting value of the loop
		// counter variable reference.
		props.put("directive.foreach.counter.initial.value", "1");

		props.put("resource.manager.defaultcache.size", "0");

		return props;
	}

	/**
	 * 
	 * @author Anderson Luna[andersonluna.comp@gmail.com] 24/03/2015 - 10:45:28.
	 * @param modulo
	 * @param funcionalidade
	 * @param nomeArquivoTemplate
	 * @return
	 * @throws Exception
	 */
	public static Template getVelocityTemplate(final String funcionalidade,
			final String nomeArquivoTemplate) throws Exception
	{
		final Properties props = VelocityUtils.getVelocityProperties();

		final ServletContext facesContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();

		final String path = facesContext.getRealPath(RESOURCES_TEMPLATE_VELOCITY
				+ SLASH + SLASH + funcionalidade);

		props.put(VelocityUtils.FILE_RESOURCE_LOADER_PATH, path);

		final VelocityEngine ve = VelocityUtils.getInitVelocityEngine(props);

		return ve.getTemplate(nomeArquivoTemplate);
	}

	/**
	 * 
	 * @author Anderson Luna[andersonluna.comp@gmail.com] 02/12/2013 - 09:45:54.
	 * @param realPath
	 * @param pasta
	 * @param nomeArquivoTemplate
	 * @return
	 * @throws Exception
	 */
	public static Template getVelocityTemplateResource(final String realPath,
			final String nomeArquivoTemplate) throws Exception
	{
		final Properties props = VelocityUtils.getVelocityProperties();

		props.put(VelocityUtils.FILE_RESOURCE_LOADER_PATH, realPath
				+ RESOURCES_TEMPLATE_VELOCITY);

		final VelocityEngine ve = VelocityUtils.getInitVelocityEngine(props);

		// carrega o template
		return ve.getTemplate(nomeArquivoTemplate);
	}

}