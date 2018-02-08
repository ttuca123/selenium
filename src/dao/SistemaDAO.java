package dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.BtpSistema;

/**
 * Classe utilizada para realizar as operações com o bando de dados.
 */
public class SistemaDAO
{
	private EntityManager entityManager;

	public SistemaDAO(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	/**
	 * Método para salvar ou atualizar o versao.
	 * 
	 * @param versao
	 * @return
	 * @throws java.lang.Exception
	 */
	public BtpSistema salvar(BtpSistema versao) throws Exception
	{
		if ( versao.getSisSeqSistema() == null )
		{
			this.entityManager.persist(versao);
		}
		else
		{
			if ( entityManager.find(BtpSistema.class, versao.getSisSeqSistema()) == null )
			{
				throw new Exception("Sistema nao existe!");
			}
			return entityManager.merge(versao);
		}
		return versao;
	}

	/**
	 * Método que exclui a versao do banco de dados.
	 * 
	 * @param id
	 */
	public void excluir(Long id)
	{
		BtpSistema versao = entityManager.find(BtpSistema.class, id);
		entityManager.remove(versao);
	}

	/**
	 * Consulta a versao por ID.
	 * 
	 * @param id
	 * @return
	 */
	public BtpSistema consultarPorId(Long id)
	{
		return entityManager.find(BtpSistema.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<BtpSistema> listar()
	{
		return (List<BtpSistema>) entityManager.createQuery(
				"select v from BtpSistema v  order by v.sisNomSistema asc").getResultList();
	}
}