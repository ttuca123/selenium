package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import modelo.BtpSistema;
import modelo.BtpVersao;
import enumerators.EnumStatusVersao;

/**
 * Classe utilizada para realizar as operações com o bando de dados.
 */
public class VersaoDAO
{
	private EntityManager entityManager;

	public VersaoDAO(EntityManager entityManager)
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
	public BtpVersao salvar(BtpVersao versao) throws Exception
	{
		if ( versao.getId() == null )
		{
			this.entityManager.persist(versao);
		}
		else
		{
			if ( entityManager.find(BtpVersao.class, versao.getId()) == null )
			{
				throw new Exception("Versao nao existe!");
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
		BtpVersao versao = entityManager.find(BtpVersao.class, id);
		entityManager.remove(versao);
	}

	/**
	 * Consulta a versao por ID.
	 * 
	 * @param id
	 * @return
	 */
	public BtpVersao consultarPorId(Long id)
	{
		return entityManager.find(BtpVersao.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<BtpVersao> listar(BtpSistema btpSistema,
			EnumStatusVersao enumStatusVersao)
	{
		List<BtpVersao> consulta = new ArrayList<BtpVersao>();
		List<BtpVersao> retorno = new ArrayList<BtpVersao>();

		String sqlString = "select v from BtpVersao v where v.btpSistema.sisSeqSistema="
				+ btpSistema.getSisSeqSistema();

		sqlString = sqlString.concat(" order by v.verDtaIniPublic desc");

		consulta = (List<BtpVersao>) entityManager.createQuery(sqlString)
				.getResultList();

		if ( enumStatusVersao != null )
		{
			for (BtpVersao vers : consulta)
			{
				if ( vers.getSituacao().equals(enumStatusVersao) )
				{
					retorno.add(vers);
				}

			}
		}
		else
		{
			retorno = consulta;
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<BtpVersao> listar(EnumStatusVersao enumStatusVersao)
	{

		List<BtpVersao> retorno = new ArrayList<BtpVersao>();

		String sqlString = "select v from BtpVersao v order by v.verDtaIniPublic desc";

		List<BtpVersao> consulta = entityManager.createQuery(sqlString)
				.getResultList();

		if ( enumStatusVersao != null )
		{
			for (BtpVersao vers : consulta)
			{
				if ( vers.getSituacao().equals(enumStatusVersao) )
				{
					retorno.add(vers);
				}

			}
		}
		else
		{
			retorno = consulta;
		}

		return retorno;
	}
}