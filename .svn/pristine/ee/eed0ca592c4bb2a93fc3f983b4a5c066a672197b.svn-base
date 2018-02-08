package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import modelo.BtpDemanda;
import modelo.BtpInstrucaoSql;
import modelo.BtpVersao;

public class InstrucaoDAO
{
	private EntityManager entityManager;

	public InstrucaoDAO(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	public BtpInstrucaoSql salvar(BtpInstrucaoSql btpInstruacaoSql)
			throws Exception
	{
		if ( btpInstruacaoSql.getInsSeqInstrucao() == null )
		{
			this.entityManager.persist(btpInstruacaoSql);
		}
		else
		{
			if ( entityManager.find(BtpInstrucaoSql.class,
					btpInstruacaoSql.getInsSeqInstrucao()) == null )
			{
				throw new Exception("Instrução SQL nao existe!");
			}
			return entityManager.merge(btpInstruacaoSql);
		}
		return btpInstruacaoSql;
	}

	public void excluir(Long id)
	{
		BtpInstrucaoSql btpInstruacaoSql = entityManager.find(
				BtpInstrucaoSql.class, id);
		entityManager.remove(btpInstruacaoSql);
	}

	public BtpInstrucaoSql consultarPorId(Long id)
	{
		return entityManager.find(BtpInstrucaoSql.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<BtpInstrucaoSql> listar(BtpVersao btpVersao)
	{
		List<BtpInstrucaoSql> insSaida = new ArrayList<BtpInstrucaoSql>();

		if ( btpVersao != null )
		{
			List<BtpDemanda> demandas = (List<BtpDemanda>) entityManager.createQuery(
					"select d from BtpDemanda d where d.btpVersao.id="
							+ btpVersao.getId()).getResultList();

			for (BtpDemanda btpdemanda : demandas)
			{
				for (BtpInstrucaoSql btpInstrucaoSql : btpdemanda.getLstSQLs())
				{
					insSaida.add(btpInstrucaoSql);
				}
			}
		}
		return insSaida;
	}

	@SuppressWarnings("unchecked")
	public List<BtpDemanda> listarDemandas(BtpVersao btpVersao)
	{
		if ( btpVersao != null )
		{

			List<BtpDemanda> demandas = (List<BtpDemanda>) entityManager.createQuery(
					"select d from BtpDemanda d where d.btpVersao.id="
							+ btpVersao.getId()).getResultList();

			List<BtpDemanda> insSaida = new ArrayList<BtpDemanda>();

			for (BtpDemanda btpdemanda : demandas)
			{
				insSaida.add(btpdemanda);
			}
			return insSaida;
		}
		else
		{
			return null;
		}
	}

}