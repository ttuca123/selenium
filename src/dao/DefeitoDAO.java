package dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.BtpDefeito;
import modelo.BtpVersao;

public class DefeitoDAO
{

	private EntityManager entityManager;

	public DefeitoDAO(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	public BtpDefeito salvar(BtpDefeito btpDefeito) throws Exception
	{
		if ( btpDefeito.getDefSeqDefeito() == null )
		{
			this.entityManager.persist(btpDefeito);
		}
		else
		{
			if ( entityManager.find(BtpDefeito.class, btpDefeito.getDefSeqDefeito()) == null )
			{
				throw new Exception("Defeito nao existe!");
			}
			return entityManager.merge(btpDefeito);
		}
		return btpDefeito;
	}

	/**
	 * Método que exclui a btpDefeito do banco de dados.
	 * 
	 * @param id
	 */
	public void excluir(Long id)
	{
		BtpDefeito btpDefeito = entityManager.find(BtpDefeito.class, id);
		entityManager.remove(btpDefeito);
	}

	/**
	 * Consulta a btpDefeito por ID.
	 * 
	 * @param id
	 * @return
	 */
	public BtpDefeito consultarPorId(Long id)
	{
		return entityManager.find(BtpDefeito.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<BtpDefeito> listar(BtpVersao btpVersao)
	{
		if ( btpVersao == null )
		{
			return null;
		}
		return (List<BtpDefeito>) entityManager.createQuery(
				"select d from BtpDefeito d where d.btpVersao.id=" + btpVersao.getId()
						+ " order by d.defSeqDefeito desc").getResultList();
	}

}