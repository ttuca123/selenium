package dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.BtpServico;
import modelo.BtpTeste;
import modelo.ErrosVO;
import modelo.EstatisticaVO;
import modelo.TesteNaoExecutadoVO;
import enumerators.EnumTipoErro;

/**
 * Classe utilizada para realizar as operações com o bando de dados.
 */
public class ServicoDAO
{
	
	
	private EntityManager entityManager;

	/**
	 * Construtor da classe DAO que chama os métodos do EntityManager.
	 * 
	 * @param entityManager
	 */
	public ServicoDAO(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	/**
	 * Método para salvar ou atualizar o servico.
	 * 
	 * @param servico
	 * @return
	 * @throws java.lang.Exception
	 */
	public BtpServico salvar(BtpServico servico) throws Exception
	{
		if ( servico.getId() == null )
		{
			this.entityManager.persist(servico);
		}
		else
		{
			if ( entityManager.find(BtpServico.class, servico.getId()) == null )
			{
				throw new Exception("Servico nao existe!");
			}
			BtpServico srv = entityManager.merge(servico);
			return srv;
		}
		return servico;
	}

	/**
	 * Método que exclui a servico do banco de dados.
	 * 
	 * @param id
	 */
	public void excluir(Long id)
	{
		BtpServico servico = entityManager.find(BtpServico.class, id);
		entityManager.remove(servico);
	}

	/**
	 * Consulta a servico por ID.
	 * 
	 * @param id
	 * @return
	 */
	public BtpServico consultarPorId(Long id)
	{
		return entityManager.find(BtpServico.class, id);
	}

	/**
	 * Consulta a servico por ID.
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<BtpServico> listar()
	{
		return (List<BtpServico>) entityManager.createQuery(
				"select s from BtpServico s order by s.codigo").getResultList();
	}

	
	private final String SQL_GET_VERSAO = "(SELECT CODIGO FROM versao WHERE SITUACAO =1 AND SISTEMA=1 AND VER_FLG_DASHBOARD=1)";
	
	private final String SQL_GET_NR_TESTE = "(SELECT ver_nr_teste FROM versao WHERE SITUACAO =1 AND SISTEMA=1 AND VER_FLG_DASHBOARD=1)";
	
	private final String SQL_GET_QTD_CASOS_ATIVOS = "(SELECT count(*) TOTAL FROM CAT_CASO_TESTE where CAT_FLG_SITUACAO=1)";
	
	private final String SQL_GET_QTD_CASOS_TODOS = "(SELECT count(*) TOTAL FROM CAT_CASO_TESTE)";

	
	@SuppressWarnings({ "unchecked" })
	public List<EstatisticaVO> listaEstatistica()
	{

		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append(" SELECT 'TOTAL DE CASOS DE TESTES', count(*), 1 TOTAL FROM CAT_CASO_TESTE where CAT_FLG_SITUACAO=1");
		sqlQuery.append(" UNION ");
		sqlQuery.append("	SELECT 'TOTAL DE CASOS EXECUTADOS', count(*),  count(*)/"+ SQL_GET_QTD_CASOS_ATIVOS+" FROM testes where versao = "+SQL_GET_VERSAO+"  and ver_nr_teste = "+SQL_GET_NR_TESTE);
		sqlQuery.append("	UNION ");
		sqlQuery.append(" SELECT 'TOTAL DE CASOS NÃO EXECUTADOS', count(*),  count(*)/"+ SQL_GET_QTD_CASOS_ATIVOS+" FROM CAT_CASO_TESTE where CAT_FLG_SITUACAO=1"
				+ "	AND NOT EXISTS (select 1 from testes where versao = "+SQL_GET_VERSAO+" and caso_teste =ID_CASO) ");
		sqlQuery.append("	UNION ");
		
		sqlQuery.append("	SELECT 'TOTAL DE CASOS IGNORADOS', count(*), count(*)/"+SQL_GET_QTD_CASOS_TODOS+" FROM CAT_CASO_TESTE where CAT_FLG_SITUACAO=2");
		sqlQuery.append("	UNION ");
		sqlQuery.append("	SELECT 'TOTAL DE CASOS COM FALHAS',  count(*),  count(*)/"+ SQL_GET_QTD_CASOS_ATIVOS+"  FROM testes WHERE status=0 and versao =  "+SQL_GET_VERSAO+" and ver_nr_teste = "+SQL_GET_NR_TESTE);
		sqlQuery.append("	UNION ");
		sqlQuery.append("	 SELECT 'TOTAL DE CASOS COM SUCESSO',  count(*),  count(*)/"+ SQL_GET_QTD_CASOS_ATIVOS+" FROM testes WHERE status=1 and versao =  "+SQL_GET_VERSAO+" and ver_nr_teste = "+SQL_GET_NR_TESTE);

		Query query = entityManager.createNativeQuery(sqlQuery.toString());

		List<EstatisticaVO> esta = new ArrayList<EstatisticaVO>();
		List<Object[]> results = query.getResultList();
		for (int i = 0; i < results.size(); i++)
		{
			String desc = (String) results.get(i)[0];

			Integer qtd = ((BigInteger) results.get(i)[1]).intValue();

			Double perc = ((BigDecimal) results.get(i)[2]).doubleValue();
			EstatisticaVO evo = new EstatisticaVO(desc, qtd, perc);

			esta.add(evo);
		}

		return esta;

	}

	@SuppressWarnings({ "unchecked" })
	public List<TesteNaoExecutadoVO> listaNaoExecutados()
	{

		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery
				.append("SELECT ID_CASO, CAT_DSC_CASO_TESTE  FROM CAT_CASO_TESTE where CAT_FLG_SITUACAO=1	AND NOT EXISTS (select 1 from testes where versao = "+SQL_GET_VERSAO+" and caso_teste =ID_CASO) order by CAT_DSC_CASO_TESTE");

		Query query = entityManager.createNativeQuery(sqlQuery.toString());

		List<TesteNaoExecutadoVO> testes = new ArrayList<TesteNaoExecutadoVO>();
		List<Object[]> results = query.getResultList();
		for (int i = 0; i < results.size(); i++)
		{
			String id = (String) results.get(i)[0];
			String desc = (String) results.get(i)[1];

			TesteNaoExecutadoVO tne = new TesteNaoExecutadoVO(id, desc);

			testes.add(tne);
		}

		return testes;

	}

	@SuppressWarnings({ "unchecked" })
	public List<ErrosVO> listaEstatisticaErros()
	{

		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery
				.append("select erro, count(*) from testes where versao="+SQL_GET_VERSAO+" and ver_nr_teste = "+SQL_GET_NR_TESTE+"  group by erro");

		Query query = entityManager.createNativeQuery(sqlQuery.toString());

		List<Object[]> results = query.getResultList();
		List<ErrosVO> esta = new ArrayList<ErrosVO>();

		for (int i = 0; i < results.size(); i++)
		{
			EnumTipoErro codigo = EnumTipoErro.valueOf(((Integer) results.get(i)[0])
					.intValue());
			Integer qtd = ((BigInteger) results.get(i)[1]).intValue();

			ErrosVO evo = new ErrosVO(codigo, qtd);

			esta.add(evo);
		}

		return esta;

	}

	public BtpTeste findTeste(Integer codigo)
	{
		BtpTeste retorno = new BtpTeste();

		retorno = entityManager.find(BtpTeste.class, codigo);

		return retorno;
	}
}