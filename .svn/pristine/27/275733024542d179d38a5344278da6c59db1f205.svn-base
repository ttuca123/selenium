package managed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import modelo.BtpSistema;
import ejb.SistemaRemote;
import enumerators.EnumSituacao;
import enumerators.EnumSituacaoSimNao;
import enumerators.EnumTipoPublicacao;

@ViewScoped
@ManagedBean(name = "sistemaBean")
public class SistemaBean

{

	@EJB
	private SistemaRemote srvSistema;

	private List<BtpSistema> listaSistemas;

	private List<BtpSistema> sistemasFiltradas;

	private DataModel<BtpSistema> sistemas;

	private BtpSistema btpSistema = new BtpSistema();

	public SistemaBean()
	{
		listaSistemas = new ArrayList<BtpSistema>();
	}

	public void novo() throws Exception
	{
		btpSistema = new BtpSistema();
	}

	public void selecionar()
	{
		btpSistema = sistemas.getRowData();
	}

	public DataModel<BtpSistema> getSistemaList()
	{
		
		sistemas = new ListDataModel<BtpSistema>(srvSistema.listar());

		return sistemas;
	}

	public void inserir() throws Exception
	{

		BtpSistema sistema = srvSistema.salvar(btpSistema);

		if ( sistema.getSisSeqSistema() != null )
		{
			addMessage("OK", "Registro Inserido Com sucesso!!!");
		}

		btpSistema = new BtpSistema();

	}

	public void alterar() throws Exception
	{
		srvSistema.salvar(btpSistema);

		addMessage("OK", "Sistema atualizada com sucesso!!!");

		btpSistema = new BtpSistema();
	}

	public void addMessage(String summary, String detail)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public void excluir() throws Exception
	{
		listaSistemas.remove(btpSistema);

		srvSistema.excluir(btpSistema);

		btpSistema = new BtpSistema();

		addMessage("OK", "Registro Excluido com sucesso!!!");

	}

	public List<BtpSistema> getListaSistemas()
	{
		return listaSistemas;
	}

	public void setListaSistemas(List<BtpSistema> listaSistemas)
	{
		this.listaSistemas = listaSistemas;
	}

	public List<BtpSistema> getSistemasFiltradas()
	{
		return sistemasFiltradas;
	}

	public void setSistemasFiltradas(List<BtpSistema> sistemasFiltradas)
	{
		this.sistemasFiltradas = sistemasFiltradas;
	}

	public DataModel<BtpSistema> getSistemas()
	{
		return sistemas;
	}

	public void setSistemas(DataModel<BtpSistema> sistemas)
	{
		this.sistemas = sistemas;
	}

	
	public BtpSistema getBtpSistema()
	{
		return btpSistema;
	}

	public void setBtpSistema(BtpSistema btpSistema)
	{
		this.btpSistema = btpSistema;
	}

	public List<BtpSistema> getLstSistemas()
	{
		return srvSistema.listar();
	}
	

	public Collection<EnumSituacaoSimNao> getLstSituacao()
	{
		return Arrays.asList(EnumSituacaoSimNao.values());
	}
	

	public Collection<EnumTipoPublicacao> getLstTipoPublicacao()
	{
		return Arrays.asList(EnumTipoPublicacao.values());
	}
	
	public Collection<EnumSituacao> getLstStatus()
	{
		return Arrays.asList(EnumSituacao.values());
	}


}
