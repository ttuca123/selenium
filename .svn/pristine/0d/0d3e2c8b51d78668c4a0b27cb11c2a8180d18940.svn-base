package dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.BtpDependencia;
import modelo.BtpVersao;

public class DependenciaDAO
{

	private EntityManager entityManager;

	public DependenciaDAO(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	public BtpDependencia salvar(BtpDependencia btpDependencia) throws Exception
	{
		if ( btpDependencia.getVedSeqVersaoDependencia() == null )
		{
			this.entityManager.persist(btpDependencia);
		}
		else
		{
			if ( entityManager.find(BtpDependencia.class,
					btpDependencia.getVedSeqVersaoDependencia()) == null )
			{
				throw new Exception("Dependẽncia nao existe!");
			}
			return entityManager.merge(btpDependencia);
		}
		return btpDependencia;
	}

	/**
	 * Método que exclui a btpDependencia do banco de dados.
	 * 
	 * @param id
	 */
	public void excluir(Long id)
	{
		BtpDependencia btpDependencia = entityManager
				.find(BtpDependencia.class, id);
		entityManager.remove(btpDependencia);
	}

	/**
	 * Consulta a btpDependencia por ID.
	 * 
	 * @param id
	 * @return
	 */
	public BtpDependencia consultarPorId(Long id)
	{
		return entityManager.find(BtpDependencia.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<BtpDependencia> listar(BtpVersao btpVersao)
	{
		return (List<BtpDependencia>) entityManager.createQuery(
				"select d from BtpDependencia d where d.btpVersaoPai.id="
						+btpVersao.getId()+ " order by d.vedSeqVersaoDependencia desc").getResultList();
	}
}