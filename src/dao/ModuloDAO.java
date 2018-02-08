package dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.BtpModulo;
import modelo.BtpSistema;

public class ModuloDAO
{

	private EntityManager entityManager;

	public ModuloDAO(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	public BtpModulo salvar(BtpModulo btpModulo) throws Exception
	{
		if ( btpModulo.getModSeqModulo() == null )
		{
			this.entityManager.persist(btpModulo);
		}
		else
		{
			if ( entityManager.find(BtpModulo.class, btpModulo.getModSeqModulo()) == null )
			{
				throw new Exception("Modulo nao existe!");
			}
			return entityManager.merge(btpModulo);
		}
		return btpModulo;
	}

	/**
	 * Método que exclui a btpModulo do banco de dados.
	 * 
	 * @param id
	 */
	public void excluir(Long id)
	{
		BtpModulo btpModulo = entityManager.find(BtpModulo.class, id);
		entityManager.remove(btpModulo);
	}

	/**
	 * Consulta a btpModulo por ID.
	 * 
	 * @param id
	 * @return
	 */
	public BtpModulo consultarPorId(Long id)
	{
		return entityManager.find(BtpModulo.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<BtpModulo> listar(BtpSistema btpSistema)
	{
		if (btpSistema==null) {
			return null;
		} 
		return (List<BtpModulo>) entityManager.createQuery(
				"select m from BtpModulo m where m.btpSistema.sisSeqSistema="+btpSistema.getSisSeqSistema()
				+ " order by m.modSeqModulo desc")
				.getResultList(); 
	}

}