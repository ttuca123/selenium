package managed;

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

import modelo.BtpDefeito;
import modelo.BtpDemanda;
import modelo.BtpSistema;
import modelo.BtpVersao;
import ejb.DefeitoRemote;
import ejb.DemandaRemote;
import ejb.SistemaRemote;
import ejb.VersaoRemote;
import enumerators.EnumDefCategoria;
import enumerators.EnumDefFase;
import enumerators.EnumDefOrigem;
import enumerators.EnumDefPrioridade;
import enumerators.EnumDefStatus;
import enumerators.EnumTipoDemanda;

@ViewScoped
@ManagedBean(name = "defeitoBean")
public class DefeitoBean

{

	@EJB
	private VersaoRemote srvVersao;

	@EJB
	private DefeitoRemote srvDefeito;

	@EJB
	private DemandaRemote srvDemanda;

	@EJB
	private SistemaRemote srvSistema;

	private List<BtpDefeito> listaDefeitos;

	private List<BtpDefeito> defeitosFiltradas;

	private DataModel<BtpDefeito> defeitos;

	private BtpSistema btpSistema;

	private BtpVersao btpVersao;

	private BtpDemanda btpDemanda;

	private BtpDefeito btpDefeito = new BtpDefeito();

	public DefeitoBean()
	{
		listaDefeitos = new ArrayList<BtpDefeito>();
	}

	public void novo() throws Exception
	{
		btpDefeito = new BtpDefeito();
		btpDefeito.setBtpSistema(btpSistema);
	}

	public void selecionar()
	{
		btpDefeito = defeitos.getRowData();
	}

	public DataModel<BtpDefeito> getDefeitoList()
	{

		listaDefeitos = new ArrayList<BtpDefeito>();

		if ( btpSistema != null )
		{
			listaDefeitos = srvDefeito.listar(btpVersao);
		}
		defeitos = new ListDataModel<BtpDefeito>(listaDefeitos);

		return defeitos;
	}

	public void inserir() throws Exception
	{
		btpDefeito.setDefDtaCadastro(new Date());
		
		if (btpDefeito.getUsuSeqUsuario().isEmpty() )
		{
			btpDefeito.setEnumDefStatus(EnumDefStatus.NOVO);
		}
		else
		{
			btpDefeito.setEnumDefStatus(EnumDefStatus.ATRIBUIDO);
		}

		BtpDefeito defeito = srvDefeito.salvar(btpDefeito);

		if ( defeito.getDefSeqDefeito() != null )
		{
			addMessage("OK", "Registro Inserido Com sucesso!!!");
		}

		btpDefeito = new BtpDefeito();

	}

	public void alterar() throws Exception
	{
		srvDefeito.salvar(btpDefeito);

		addMessage("OK", "Defeito atualizada com sucesso!!!");

		btpDefeito = new BtpDefeito();
	}
	
	public void addMessage(String summary, String detail)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public void excluir() throws Exception
	{
		listaDefeitos.remove(btpDefeito);

		srvDefeito.excluir(btpDefeito);

		btpDefeito = new BtpDefeito();

		addMessage("OK", "Registro Excluido com sucesso!!!");

	}

	public List<BtpDemanda> getLstDemandas()
	{
		if ( btpVersao == null )
		{
			return null;
		}
		return srvDemanda.listar(btpVersao);
	}

	public Collection<EnumDefCategoria> getLstCategorias()
	{
		return Arrays.asList(EnumDefCategoria.values());
	}

	public Collection<EnumDefPrioridade> getLstPrioridades()
	{
		return Arrays.asList(EnumDefPrioridade.values());
	}

	public Collection<EnumDefFase> getLstFases()
	{
		return Arrays.asList(EnumDefFase.values());
	}

	public Collection<EnumDefStatus> getLstStatus()
	{
		return Arrays.asList(EnumDefStatus.values());
	}

	public Collection<EnumDefOrigem> getLstOrigens()
	{
		return Arrays.asList(EnumDefOrigem.values());
	}

	public Collection<EnumTipoDemanda> getLstClassificacoes()
	{
		return Arrays.asList(EnumTipoDemanda.values());
	}

	public DefeitoRemote getSrvDefeito()
	{
		return srvDefeito;
	}

	public void setSrvDefeito(DefeitoRemote srvDefeito)
	{
		this.srvDefeito = srvDefeito;
	}

	public SistemaRemote getSrvSistema()
	{
		return srvSistema;
	}

	public void setSrvSistema(SistemaRemote srvSistema)
	{
		this.srvSistema = srvSistema;
	}

	public List<BtpDefeito> getListaDefeitos()
	{
		return listaDefeitos;
	}

	public void setListaDefeitos(List<BtpDefeito> listaDefeitos)
	{
		this.listaDefeitos = listaDefeitos;
	}

	public List<BtpDefeito> getDefeitosFiltradas()
	{
		return defeitosFiltradas;
	}

	public void setDefeitosFiltradas(List<BtpDefeito> defeitosFiltradas)
	{
		this.defeitosFiltradas = defeitosFiltradas;
	}

	public DataModel<BtpDefeito> getDefeitos()
	{
		return defeitos;
	}

	public void setDefeitos(DataModel<BtpDefeito> defeitos)
	{
		this.defeitos = defeitos;
	}

	public BtpDemanda getBtpDemanda()
	{
		return btpDemanda;
	}

	public void setBtpDemanda(BtpDemanda btpDemanda)
	{
		this.btpDemanda = btpDemanda;
	}

	public BtpSistema getBtpSistema()
	{
		return btpSistema;
	}

	public void setBtpSistema(BtpSistema btpSistema)
	{
		this.btpSistema = btpSistema;
	}

	public BtpDefeito getBtpDefeito()
	{
		return btpDefeito;
	}

	public void setBtpDefeito(BtpDefeito btpDefeito)
	{
		this.btpDefeito = btpDefeito;
	}

	public List<BtpSistema> getLstSistemas()
	{
		return srvSistema.listar();
	}

	public Collection<BtpVersao> getLstVersoes()
	{
		if ( btpSistema == null )
		{
			return null;
		}
		return srvVersao.listar(btpSistema, null);
	}

	public BtpVersao getBtpVersao()
	{
		return btpVersao;
	}

	public void setBtpVersao(BtpVersao btpVersao)
	{
		this.btpVersao = btpVersao;
	}

}
