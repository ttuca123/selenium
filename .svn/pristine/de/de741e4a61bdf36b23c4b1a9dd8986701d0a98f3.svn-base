package dao.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAOImpl<T, ID extends Serializable> implements
		IGenericDAO<T, Serializable>
{
	private EntityManager entityManager;

	private final Class<T> oClasse;

	@Override
	public Class<T> getClasse()
	{
		return this.oClasse;
	}

	public EntityManager getEntityManager()
	{
		if ( entityManager == null )
		{
			throw new IllegalStateException("Erro");
		}
		return entityManager;
	}

	@PersistenceContext(unitName = "upTestes")
	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public GenericDAOImpl()
	{
		this.oClasse = (Class<T>) ((ParameterizedType) getClasse()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T inserir(T objeto) throws Exception
	{
		getEntityManager().persist(objeto);
		return objeto;
	}
	
	@Override
	public T atualizar(T objeto) throws Exception
	{
		getEntityManager().merge(objeto);
		return objeto;
	}

	@Override
	public void excluir(T objeto) throws Exception
	{
      this.atualizar(objeto);
      getEntityManager().remove(objeto);     
	}

	@Override
	public T consultarPorId(Long id)
	{		
		return (T) getEntityManager().find(oClasse, id);
	}

}