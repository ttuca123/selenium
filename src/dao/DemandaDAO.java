package dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.BtpDemanda;
import modelo.BtpVersao;

public class DemandaDAO
{

	private EntityManager entityManager;

	public DemandaDAO(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	public BtpDemanda salvar(BtpDemanda btpDemanda) throws Exception
	{
		if ( btpDemanda.getDemSeqDemanda() == null )
		{
			this.entityManager.persist(btpDemanda);
		}
		else
		{
			if ( entityManager.find(BtpDemanda.class, btpDemanda.getDemSeqDemanda()) == null )
			{
				throw new Exception("Demanda nao existe!");
			}
			return entityManager.merge(btpDemanda);
		}
		return btpDemanda;
	}

	/**
	 * Método que exclui a btpDemanda do banco de dados.
	 * 
	 * @param id
	 */
	public void excluir(Long id)
	{
		BtpDemanda btpDemanda = entityManager.find(BtpDemanda.class, id);
		entityManager.remove(btpDemanda);
	}

	/**
	 * Consulta a btpDemanda por ID.
	 * 
	 * @param id
	 * @return
	 */
	public BtpDemanda consultarPorId(Long id)
	{
		return entityManager.find(BtpDemanda.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<BtpDemanda> listar()
	{
		return (List<BtpDemanda>) entityManager.createQuery(
				"select d from BtpDemanda d where d.btpVersao.situacao=1 order by d.demSeqDemanda desc")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<BtpDemanda> listar(BtpVersao btpVersao)
	{
		return (List<BtpDemanda>) entityManager.createQuery(
				"select d from BtpDemanda d where d.btpVersao.id="+btpVersao.getId()+" order by d.demSeqDemanda  desc")
				.getResultList();
	}
}