package managed;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import modelo.BtpCasoTeste;
import modelo.BtpServico;
import modelo.BtpSistema;
import modelo.BtpTeste;
import modelo.BtpVersao;
import modelo.ErrosVO;
import modelo.EstatisticaVO;
import modelo.TesteNaoExecutadoVO;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import utils.Funcoes;
import bean.SrvCasoTeste;
import bean.SrvVersao;
import ejb.CasoTesteRemote;
import ejb.ServicoRemote;
import ejb.SistemaRemote;
import ejb.VersaoRemote;
import enumerators.EnumSituacao;
import enumerators.EnumStatus;
import enumerators.EnumStatusVersao;
import enumerators.EnumTipoErro;
import enumerators.EnumTipoServico;

@ViewScoped
@ManagedBean(name = "servicoBean")
public class ServicoBean

{

	@EJB
	private ServicoRemote srvServico;

	@EJB
	private CasoTesteRemote srvCasoTeste;

	@EJB
	private VersaoRemote srvVersao;

	@EJB
	private SistemaRemote srvSistema;

	private List<BtpServico> listaServicos;

	private List<BtpServico> servicosFiltrados;

	private DataModel<BtpServico> servicos;

	private BtpServico btpServico = new BtpServico();

	private List<BtpCasoTeste> listaCasos;

	private List<BtpCasoTeste> casosFiltrados;

	private DataModel<BtpCasoTeste> casos;

	private DataModel<EstatisticaVO> estatisticas;
	
	private DataModel<TesteNaoExecutadoVO> listaNaoExecutados;

	@SuppressWarnings("unused")
	private DataModel<BtpTeste> listaTestesErros;

	private DataModel<ErrosVO> estatisticasErros;

	private BtpTeste teste;

	private BtpCasoTeste btpCasoTeste = new BtpCasoTeste();

	private BtpVersao btpVersao;

	private BtpSistema btpSistema;

	public ServicoBean()
	{
		listaServicos = new ArrayList<BtpServico>();

	}

	public void novo() throws Exception
	{
		btpServico = new BtpServico();

	}

	public void novoCaso()
	{
		btpCasoTeste = new BtpCasoTeste();
		btpCasoTeste.setServico(btpServico);
	}

	public void selecionar()
	{
		btpServico = servicos.getRowData();
	}

	public void selecionarCaso()
	{
		btpCasoTeste = casos.getRowData();
	}

	public DataModel<BtpServico> getServicoList()
	{
		listaServicos = srvServico.listar();
		servicos = new ListDataModel<BtpServico>(listaServicos);
		return servicos;
	}

	public DataModel<BtpCasoTeste> getLstCasosTestes()
	{
		casos = new ListDataModel<BtpCasoTeste>(btpServico.getLstCasosTestes());
		return casos;
	}

	/**
	 * INSERIR
	 * 
	 * @author Evandro Custodio Goncalves[evandro.custodio@cagece.com.br]
	 *         26/10/2015 - 13:51:24.
	 * @return
	 * @throws Exception
	 */
	public String inserir() throws Exception
	{
		String resultado = "falha";
		if ( btpServico.getLstCasosTestes() != null )
		{
			int ct = 0;
			int cti = 0;
			int ctig = 0;
			for (BtpCasoTeste casot : btpServico.getLstCasosTestes())
			{
				switch (casot.getCatFlgSituacao())
				{
					case ATIVO:
						ct++;
						break;
					case INATIVO:
						cti++;
						break;
					case IGNORADO:
						ctig++;
				}
			}
			btpServico.setNrCasos(ct);
			btpServico.setNrCasosIgnorados(ctig);
		}
		else
		{
			btpServico.setNrCasos(0);
			btpServico.setNrCasosIgnorados(0);
		}
		BtpServico serv = srvServico.salvar(btpServico);

		boolean retorno = false;

		if ( serv.getId() != null )
		{
			retorno = true;
			addMessage("OK", "Registro Inserido Com sucesso!!!");
		}

		if ( retorno )
		{
			resultado = "servicos";
		}

		btpServico = new BtpServico();

		return resultado;
	}

	public void inserirCaso() throws Exception
	{
		btpServico.getLstCasosTestes().add(btpCasoTeste);
		srvCasoTeste.salvar(btpCasoTeste);
		btpCasoTeste = new BtpCasoTeste();
	}

	/**
	 * ALTERAR
	 * 
	 * @author Evandro Custodio Goncalves[evandro.custodio@cagece.com.br]
	 *         26/10/2015 - 13:51:18.
	 * @return
	 * @throws Exception
	 */
	public void alterar() throws Exception
	{
		if ( btpServico.getLstCasosTestes() != null )
		{
			int ct = 0;
			int cti = 0;
			int ctig = 0;
			for (BtpCasoTeste casot : btpServico.getLstCasosTestes())
			{
				switch (casot.getCatFlgSituacao())
				{
					case ATIVO:
						ct++;
						break;
					case INATIVO:
						cti++;
						break;
					case IGNORADO:
						ctig++;
				}
			}
			btpServico.setNrCasos(ct);
			btpServico.setNrCasosIgnorados(ctig);
		}
		else
		{
			btpServico.setNrCasos(0);
			btpServico.setNrCasosIgnorados(0);
		}
		srvServico.salvar(btpServico);

		addMessage("OK", "Servico atualizado com sucesso!!!");

		btpServico = new BtpServico();
	}

	public void alterarCaso() throws Exception
	{
		srvCasoTeste.salvar(btpCasoTeste);
		btpCasoTeste = new BtpCasoTeste();

		addMessage("OK", "Caso de testes atualizado com sucesso!!!");

	}

	public void addMessage(String summary, String detail)
	{
		FacesMessage message = null;
		if ( summary.equals("ERROR") )
		{
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		}
		else if ( summary.equals("FATAL") )
		{
			message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail);
		}
		else if ( summary.equals("WARN") )
		{
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
		}
		else
		{
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		}
		;
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public void excluir() throws Exception
	{
		listaServicos.remove(btpServico);

		srvServico.excluir(btpServico);

		btpServico = new BtpServico();

		addMessage("OK", "Registro Excluido com sucesso!!!");

	}

	public void excluirCaso() throws Exception
	{

		btpServico.getLstCasosTestes().remove(btpCasoTeste);

		srvCasoTeste.excluir(btpCasoTeste);

		addMessage("OK", "Caso de teste Excluido com sucesso!!!");

	}

	public String getTotalCasos()
	{
		Integer total = 0;

		for (BtpServico serv : getServicoList())
		{
			total += serv.getNrCasos();
		}

		return String.format("%04d", total);
	}

	public String getTotalCasosIgnorados()
	{
		Integer total = 0;

		for (BtpServico serv : getServicoList())
		{
			total += serv.getNrCasosIgnorados();
		}

		return String.format("%04d", total);
	}

	public String getResumoCasos()
	{
		Integer ok = 0;
		Integer naoOk = 0;

		for (BtpServico serv : getServicoList())
		{
			switch (serv.getStatus())
			{
				case OK:
					ok++;
					break;
				case NAO_IMPLEMENTADO:
					naoOk++;
					break;
			}
		}
		Double total = (ok.doubleValue() + naoOk.doubleValue());
		Double percOk = (ok.doubleValue() / total);
		Double percNaoOk = (naoOk.doubleValue() / total);

		return String.format("%03d", ok) + " ["
				+ NumberFormat.getPercentInstance().format(percOk)
				+ "] IMPLEMENTADO <br />" + String.format("%03d", naoOk) + " ["
				+ NumberFormat.getPercentInstance().format(percNaoOk)
				+ "] NÃO IMPLEMENTADOS ";
	}

	public String getResumoTipoServicos()
	{
		Integer simples = 0;
		Integer casado = 0;
		Integer integrado = 0;

		for (BtpServico serv : getServicoList())
		{
			switch (serv.getTipoServico())
			{
				case SIMPLES:
					simples++;
					break;
				case CASADO:
					casado++;
					break;
				case INTEGRADO:
					integrado++;
					break;
			}

		}
		Double total = (simples.doubleValue() + casado.doubleValue() + integrado
				.doubleValue());
		Double percSimples = (simples.doubleValue() / total);
		Double percCasado = (casado.doubleValue() / total);
		Double percIntegrado = (integrado.doubleValue() / total);

		return String.format("%03d", simples) + " ["
				+ NumberFormat.getPercentInstance().format(percSimples)
				+ "] SIMPLES <br />" + String.format("%03d", casado) + " ["
				+ NumberFormat.getPercentInstance().format(percCasado)
				+ "] CASADOS <br />" + String.format("%03d", integrado) + " ["
				+ NumberFormat.getPercentInstance().format(percIntegrado)
				+ "] INTEGRADOS ";
	}

	public String getTotal()
	{
		Integer qtd = listaServicos.size();
		return qtd.toString();
	}

	public BtpServico getBtpServico()
	{
		return btpServico;
	}

	public void setBtpServico(BtpServico btpServico)
	{
		this.btpServico = btpServico;
	}

	public DataModel<BtpServico> getServicos()
	{
		return servicos;
	}

	public void setServicos(DataModel<BtpServico> servicos)
	{
		this.servicos = servicos;
	}

	public Collection<EnumStatus> getLstStatus()
	{
		return Arrays.asList(EnumStatus.values());
	}

	public Collection<EnumSituacao> getLstSituacao()
	{
		return Arrays.asList(EnumSituacao.values());
	}

	public Collection<EnumTipoServico> getLstTipoServico()
	{
		return Arrays.asList(EnumTipoServico.values());
	}

	public List<BtpServico> getListaServicos()
	{
		return listaServicos;
	}

	public List<BtpServico> getServicosFiltrados()
	{
		return servicosFiltrados;
	}

	public void setListaServicos(List<BtpServico> listaServicos)
	{
		this.listaServicos = listaServicos;
	}

	public void setServicosFiltrados(List<BtpServico> servicosFiltrados)
	{
		this.servicosFiltrados = servicosFiltrados;
	}

	public BtpCasoTeste getBtpCasoTeste()
	{
		return btpCasoTeste;
	}

	public DataModel<BtpCasoTeste> getCasos()
	{
		return casos;
	}

	public List<BtpCasoTeste> getCasosFiltrados()
	{
		return casosFiltrados;
	}

	public List<BtpCasoTeste> getListaCasos()
	{
		return listaCasos;
	}

	public void setBtpCasoTeste(BtpCasoTeste btpCasoTeste)
	{
		this.btpCasoTeste = btpCasoTeste;
	}

	public void setCasos(DataModel<BtpCasoTeste> casos)
	{
		this.casos = casos;
	}

	public void setCasosFiltrados(List<BtpCasoTeste> casosFiltrados)
	{
		this.casosFiltrados = casosFiltrados;
	}

	public void setListaCasos(List<BtpCasoTeste> listaCasos)
	{
		this.listaCasos = listaCasos;
	}

	public void downloadFiltro() throws IOException
	{
		StringBuilder ret = new StringBuilder();
		List<BtpServico> servs = new ArrayList<BtpServico>();
		String nomeArquivo = "";
		if ( servicosFiltrados == null )
		{
			servs = listaServicos;
			nomeArquivo = "instrucao.sql";
		}
		else
		{
			servs = servicosFiltrados;
			nomeArquivo = "instrucao-filtro.sql";
		}
		ret.append("/* \n Script responsavel pela geracao das massas de teste para a execucao dos testes. \n Criado em ");
		ret.append(new Date().toString());
		ret.append("\n*/\n\n--- INSTRUCAO PARA CRIACAO DA TABELA: TEA_TESTES_AUTOMATIZADO2");
		ret.append("\n");
		ret.append("CREATE TABLE \"PRAX\".\"TEA_TESTES_AUTOMATIZADO2\" (\n \"IMO_COD_INSCRICAO\" NUMBER(19,0),\n \"CLI_NUM_CPF_CNPJ\" VARCHAR2(15 BYTE),\n \"SER_COD_SERVICO\" NUMBER(19,0),\n \"REALIZADO\" NUMBER,\n \"CASO_TESTE\" VARCHAR2(64 BYTE),\n \"VERSAO\" VARCHAR2(64 BYTE),\n \"DATA_EXECUCAO\" TIMESTAMP (6) )\n TABLESPACE \"TS_PRAX_TEA\" ;");
		ret.append("\n\n");
		ret.append("CREATE INDEX \"PRAX\".\"IX_TEA_TESTES_AUTOMATIZADO2\" ON \"PRAX\".\"TEA_TESTES_AUTOMATIZADO2\"\n(\"CASO_TESTE\", \"SER_COD_SERVICO\", \"IMO_COD_INSCRICAO\") TABLESPACE \"TS_PRAX\";");

		for (BtpServico btpServico : servs)
		{
			for (BtpCasoTeste btpCasoTeste : btpServico.getLstCasosTestes())
			{
				if ( btpCasoTeste.getCatFlgSituacao().equals(EnumSituacao.ATIVO) )
				{
					ret.append("\n\n");
					ret.append("--- ");
					ret.append(btpCasoTeste.getIdCaso() + " - "
							+ btpCasoTeste.getServico().getDescricao());
					ret.append("\n");
					ret.append(btpCasoTeste.getSqlInstrucao());
					ret.append("\n");
					ret.append("COMMIT;");
				}
			}
		}
		Funcoes.download(ret, nomeArquivo);

	}

	public void downloadServico(BtpServico serv) throws IOException
	{
		StringBuilder ret = new StringBuilder();

		ret.append("/* \n Script responsavel pela geracao das massas de teste para a execucao dos testes. \n Criado em ");
		ret.append(new Date().toString());
		ret.append("\n*/\n\n--- INSTRUCAO PARA CRIACAO DA TABELA: TEA_TESTES_AUTOMATIZADO2");
		ret.append("\n");
		ret.append("CREATE TABLE \"PRAX\".\"TEA_TESTES_AUTOMATIZADO2\" (\n \"IMO_COD_INSCRICAO\" NUMBER(19,0),\n \"CLI_NUM_CPF_CNPJ\" VARCHAR2(15 BYTE),\n \"SER_COD_SERVICO\" NUMBER(19,0),\n \"REALIZADO\" NUMBER,\n \"CASO_TESTE\" VARCHAR2(64 BYTE),\n \"VERSAO\" VARCHAR2(64 BYTE),\n \"DATA_EXECUCAO\" TIMESTAMP (6) )\n TABLESPACE \"TS_PRAX_TEA\" ;");
		ret.append("\n\n");
		ret.append("CREATE INDEX \"PRAX\".\"IX_TEA_TESTES_AUTOMATIZADO2\" ON \"PRAX\".\"TEA_TESTES_AUTOMATIZADO2\"\n(\"CASO_TESTE\", \"SER_COD_SERVICO\", \"IMO_COD_INSCRICAO\") TABLESPACE \"TS_PRAX\";");

		for (BtpCasoTeste btpCasoTeste : serv.getLstCasosTestes())
		{
			if ( btpCasoTeste.getCatFlgSituacao().equals(EnumSituacao.ATIVO) )
			{
				ret.append("\n\n");
				ret.append("--- ");
				ret.append(btpCasoTeste.getIdCaso() + " - "
						+ btpCasoTeste.getServico().getDescricao());
				ret.append("\n");
				ret.append(btpCasoTeste.getSqlInstrucao());
				ret.append("\n");
				ret.append("COMMIT;");
			}
		}
		Funcoes.download(ret, "instrucao-srv" + serv.getCodServico() + ".sql");

	}

	public String opcaoServicos()
	{
		return "faces/servicos.xhtml";
	}

	public void listarEstatistica()
	{

		System.out.println("Atualizando Lista");
	}

	public void mostrarLog(Integer codigo)
	{
		teste = srvServico.getTeste(codigo);

	}

	public ListDataModel<EstatisticaVO> getListaEstatistica()
	{

		estatisticas = new ListDataModel<EstatisticaVO>(
				srvServico.listaEstatistica());			

		return (ListDataModel<EstatisticaVO>) estatisticas;
	}
	

	public ListDataModel<TesteNaoExecutadoVO> getListaTestesNaoExecutados()
	{

		listaNaoExecutados = new ListDataModel<TesteNaoExecutadoVO>(
				srvServico.listaTestesNaoExecutados());			

		return (ListDataModel<TesteNaoExecutadoVO>) listaNaoExecutados;
	}

	public ListDataModel<ErrosVO> getListaEstatisticaErros()
	{

		estatisticasErros = new ListDataModel<ErrosVO>(
				srvServico.listaEstatisticaErros());

		return (ListDataModel<ErrosVO>) estatisticasErros;
	}

	public ListDataModel<BtpTeste> getListaTestesErros()
	{

		btpSistema = srvSistema.consultarPorId(1L);

		List<BtpTeste> lstTestesErros = new ArrayList<BtpTeste>();

		btpVersao = srvVersao.listar(btpSistema, EnumStatusVersao.TESTES).get(0);

		List<BtpTeste> lista = btpVersao.getLstTestes();
		for (BtpTeste teste : lista)
		{
			if ( (!teste.getErro().equals(EnumTipoErro.SEM_ERRO))
					&& (teste.getResteste().equals(btpVersao.getVerNrTeste())) )
			{
				lstTestesErros.add(teste);
			}

		}

		return new ListDataModel<BtpTeste>(lstTestesErros);
	}

	public void executarTeste(final BtpCasoTeste casoTeste)
	{

		Thread thread = new Thread("SeleniumGrid" + casoTeste.getCatNomClasse())
		{
			public void run()
			{
				TestListenerAdapter tla1 = new TestListenerAdapter();
				TestNG testng1 = new TestNG();
				try
				{

					testng1.setTestClasses(new Class[] { Class.forName(casoTeste
							.getCatNomClasse()) });
					testng1.addListener(tla1);
					testng1.run();
				}
				catch (Exception e)
				{
					System.out.println("Classe " + casoTeste.getCatNomClasse()
							+ " Inexistente !!!");
				}
			};
		};

		thread.start();
		addMessage("OK", "Testes automatizado iniciado com sucesso!!!");

	}

	public DataModel<EstatisticaVO> getEstatisticas()
	{
		return estatisticas;
	}

	public void setEstatisticas(DataModel<EstatisticaVO> estatisticas)
	{
		this.estatisticas = estatisticas;
	}

	public DataModel<ErrosVO> getEstatisticasErros()
	{
		return estatisticasErros;
	}

	public void setEstatisticasErros(DataModel<ErrosVO> estatisticasErros)
	{
		this.estatisticasErros = estatisticasErros;
	}

	public CasoTesteRemote getSrvCasoTeste()
	{
		return srvCasoTeste;
	}

	public ServicoRemote getSrvServico()
	{
		return srvServico;
	}

	public VersaoRemote getSrvVersao()
	{
		return srvVersao;
	}

	public void setListaTestesErros(DataModel<BtpTeste> listaTestesErros)
	{
		this.listaTestesErros = listaTestesErros;
	}

	public void setSrvCasoTeste(SrvCasoTeste srvCasoTeste)
	{
		this.srvCasoTeste = srvCasoTeste;
	}

	public void setSrvServico(ServicoRemote srvServico)
	{
		this.srvServico = srvServico;
	}

	public void setSrvVersao(SrvVersao srvVersao)
	{
		this.srvVersao = srvVersao;
	}

	public BtpTeste getTeste()
	{
		return teste;
	}

	public void setTeste(BtpTeste teste)
	{
		this.teste = teste;
	}

	public BtpVersao getBtpVersao()
	{
		return this.btpVersao;
	}

	public void setBtpVersao(BtpVersao btpVersao)
	{
		this.btpVersao = btpVersao;
	}

	public void setSrvCasoTeste(CasoTesteRemote srvCasoTeste)
	{
		this.srvCasoTeste = srvCasoTeste;
	}

	public void setSrvVersao(VersaoRemote srvVersao)
	{
		this.srvVersao = srvVersao;
	}

}
