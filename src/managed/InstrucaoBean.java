package managed;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

import modelo.BtpDemanda;
import modelo.BtpInstrucaoSql;
import modelo.BtpSistema;
import modelo.BtpVersao;
import utils.Funcoes;
import ejb.InstrucaoRemote;
import ejb.SistemaRemote;
import ejb.VersaoRemote;
import enumerators.EnumMomentoExecucao;
import enumerators.EnumStatusVersao;

@ViewScoped
@ManagedBean(name = "instrucaoBean")
public class InstrucaoBean

{

	@EJB
	private InstrucaoRemote srvInstrucao;

	@EJB
	private VersaoRemote srvVersao;

	@EJB
	private SistemaRemote srvSistema;

	private List<BtpInstrucaoSql> listaInstrucoes;

	private List<BtpInstrucaoSql> instrucaoFiltradas;

	private DataModel<BtpInstrucaoSql> instrucao;

	private BtpInstrucaoSql btpInstrucao = new BtpInstrucaoSql();

	private BtpVersao btpVersao;

	private BtpSistema btpSistema;

	private BtpVersao cadBtpVersao;

	private BtpSistema cadBtpSistema;

	private Boolean ignorarPublicadas = true;

	public Boolean getIgnorarPublicadas()
	{
		return ignorarPublicadas;
	}

	public void setIgnorarPublicadas(Boolean ignorarPublicadas)
	{
		this.ignorarPublicadas = ignorarPublicadas;
	}

	public List<BtpSistema> getLstSistemas()
	{
		return srvSistema.listar();
	}

	public InstrucaoBean()
	{
		listaInstrucoes = new ArrayList<BtpInstrucaoSql>();
	}

	public void novo() throws Exception
	{
		btpInstrucao = new BtpInstrucaoSql();
		cadBtpSistema = null;
		cadBtpVersao = null;

	}

	public void selecionar()
	{
		btpInstrucao = instrucao.getRowData();
		btpVersao = null;
	}

	public DataModel<BtpInstrucaoSql> getInstrucaoList()
	{
		listaInstrucoes = srvInstrucao.listar(btpVersao);
		instrucao = new ListDataModel<BtpInstrucaoSql>(listaInstrucoes);
		return instrucao;
	}

	/**
	 * INSERIR
	 * 
	 * @author Evandro Custódio Gonçalves[evandro.custodio@cagece.com.br]
	 *         26/10/2015 - 13:51:24.
	 * @return
	 * @throws Exception
	 */
	public String inserir() throws Exception
	{
		String resultado = "falha";

		btpInstrucao.setInsDtaCadastro(new Date());

		BtpInstrucaoSql instru = srvInstrucao.salvar(btpInstrucao);

		boolean retorno = false;

		if ( instru.getInsSeqInstrucao() != null )
		{
			retorno = true;
			addMessage("OK", "Registro Inserido Com sucesso!!!");
		}

		if ( retorno )
		{
			resultado = "instrucao";
		}

		btpInstrucao = new BtpInstrucaoSql();

		return resultado;
	}

	/**
	 * ALTERAR
	 * 
	 * @author Evandro Custódio Gonçalves[evandro.custodio@cagece.com.br]
	 *         26/10/2015 - 13:51:18.
	 * @return
	 * @throws Exception
	 */
	public void alterar() throws Exception
	{
		srvInstrucao.salvar(btpInstrucao);

		addMessage("OK", "Instrucao atualizada com sucesso!!!");

		btpInstrucao = new BtpInstrucaoSql();
	}

	public void addMessage(String summary, String detail)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public void excluir() throws Exception
	{
		listaInstrucoes.remove(btpInstrucao);

		srvInstrucao.excluir(btpInstrucao);

		btpInstrucao = new BtpInstrucaoSql();

		addMessage("OK", "Registro Excluido com sucesso!!!");

	}

	public Collection<BtpVersao> getLstVersoes()
	{
		if ( btpSistema == null )
		{
			return null;
		}
		List<BtpVersao> versoes = new ArrayList<BtpVersao>();

		for (BtpVersao ver : srvVersao.listar(btpSistema, null))
		{

			if ( ignorarPublicadas )
			{
				if ( !ver.getSituacao().equals(EnumStatusVersao.PUBLICADA)
						&& !ver.getSituacao().equals(EnumStatusVersao.REPUBLICADA) )
				{
					versoes.add(ver);
				}
			}
			else
			{
				versoes.add(ver);
			}

		}

		return versoes;
	}

	public Collection<EnumMomentoExecucao> getLstMomentoExecucao()
	{
		return Arrays.asList(EnumMomentoExecucao.values());
	}

	public List<BtpDemanda> getLstDemandas()
	{
		return srvInstrucao.listarDemandas(cadBtpVersao);
	}

	public InstrucaoRemote getSrvInstrucao()
	{
		return srvInstrucao;
	}

	public void setSrvInstrucao(InstrucaoRemote srvInstrucao)
	{
		this.srvInstrucao = srvInstrucao;
	}

	public List<BtpInstrucaoSql> getListaInstrucoes()
	{
		return listaInstrucoes;
	}

	public void setListaInstrucoes(List<BtpInstrucaoSql> listaInstrucoes)
	{
		this.listaInstrucoes = listaInstrucoes;
	}

	public List<BtpInstrucaoSql> getInstrucaoFiltradas()
	{
		return instrucaoFiltradas;
	}

	public void setInstrucaoFiltradas(List<BtpInstrucaoSql> instrucaoFiltradas)
	{
		this.instrucaoFiltradas = instrucaoFiltradas;
	}

	public DataModel<BtpInstrucaoSql> getInstrucao()
	{
		return instrucao;
	}

	public void setInstrucao(DataModel<BtpInstrucaoSql> instrucao)
	{
		this.instrucao = instrucao;
	}

	public BtpInstrucaoSql getBtpInstrucao()
	{
		return btpInstrucao;
	}

	public void setBtpInstrucao(BtpInstrucaoSql btpInstrucao)
	{
		this.btpInstrucao = btpInstrucao;
	}

	public BtpVersao getBtpVersao()
	{
		return btpVersao;
	}

	public void setBtpVersao(BtpVersao btpVersao)
	{
		this.btpVersao = btpVersao;
	}

	public BtpSistema getBtpSistema()
	{
		return btpSistema;
	}

	public void setBtpSistema(BtpSistema btpSistema)
	{
		this.btpSistema = btpSistema;
	}

	public BtpSistema getCadBtpSistema()
	{
		return cadBtpSistema;
	}

	public BtpVersao getCadBtpVersao()
	{
		return cadBtpVersao;
	}

	public void setCadBtpSistema(BtpSistema cadBtpSistema)
	{
		this.cadBtpSistema = cadBtpSistema;
	}

	public void setCadBtpVersao(BtpVersao cadBtpVersao)
	{
		this.cadBtpVersao = cadBtpVersao;
	}

	public void downloadSQL(BtpInstrucaoSql btpInstrucao) throws IOException
	{
		StringBuilder ret = new StringBuilder();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		ret.append("--- PUBLICADO EM "
				+ dataFormatada.format(btpInstrucao.getInsDtaCadastro()) + "\n");
		ret.append("--- REFERÊNCIA: SGD "
				+ btpInstrucao.getBtpDemanda().getDemNumSGD() + "\n");
		ret.append("--- DESENVOLVEDOR: " + btpInstrucao.getUsuSeqUsuario() + "\n");
		ret.append("--- EXECUÇÃO: "
				+ btpInstrucao.getInsMomentoExecucao().getValor() + "\n");
		ret.append("\n");
		ret.append("--- OBJETIVO: " + btpInstrucao.getInsDscObjetivo() + "\n");
		ret.append("\n");
		ret.append("--- INICIO INSTRUÇÃO SQL ---\n");
		ret.append("\n");
		ret.append(btpInstrucao.getInsScriptSql());
		ret.append("\n\n");
		ret.append("--- FIM INSTRUÇÃO SQL ---\n");

		Funcoes.download(ret, btpInstrucao.getBtpDemanda().getBtpVersao()
				.getBtpSistema().getSisDscSigla()
				+ "-v"
				+ btpInstrucao.getBtpDemanda().getBtpVersao().getVerIdVersao()
				+ "-SGD" + btpInstrucao.getBtpDemanda().getDemNumSGD() + ".sql");

	}

}
