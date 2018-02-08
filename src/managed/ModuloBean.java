package managed;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import modelo.BtpModulo;
import modelo.BtpSistema;
import ejb.ModuloRemote;
import ejb.SistemaRemote;

@ViewScoped
@ManagedBean(name = "moduloBean")
public class ModuloBean

{

	@EJB
	private ModuloRemote srvModulo;

	@EJB
	private SistemaRemote srvSistema;

	private List<BtpModulo> listaModulos;

	private List<BtpModulo> modulosFiltradas;

	private DataModel<BtpModulo> modulos;

	private BtpSistema btpSistema;

	private BtpModulo btpModulo = new BtpModulo();

	public ModuloBean()
	{
		listaModulos = new ArrayList<BtpModulo>();
	}

	public void novo() throws Exception
	{
		btpModulo = new BtpModulo();
	}

	public void selecionar()
	{
		btpModulo = modulos.getRowData();
	}

	public DataModel<BtpModulo> getModuloList()
	{

		listaModulos = new ArrayList<BtpModulo>();

		if ( btpSistema != null )
		{
			listaModulos = srvModulo.listar(btpSistema);
		}
		modulos = new ListDataModel<BtpModulo>(listaModulos);

		return modulos;
	}

	public void inserir() throws Exception
	{

		BtpModulo modulo = srvModulo.salvar(btpModulo);

		if ( modulo.getModSeqModulo() != null )
		{
			addMessage("OK", "Registro Inserido Com sucesso!!!");
		}

		btpModulo = new BtpModulo();

	}

	public void alterar() throws Exception
	{
		srvModulo.salvar(btpModulo);

		addMessage("OK", "Modulo atualizada com sucesso!!!");

		btpModulo = new BtpModulo();
	}

	public void addMessage(String summary, String detail)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}

	public void excluir() throws Exception
	{
		listaModulos.remove(btpModulo);

		srvModulo.excluir(btpModulo);

		btpModulo = new BtpModulo();

		addMessage("OK", "Registro Excluido com sucesso!!!");

	}

	public ModuloRemote getSrvModulo()
	{
		return srvModulo;
	}

	public void setSrvModulo(ModuloRemote srvModulo)
	{
		this.srvModulo = srvModulo;
	}

	public SistemaRemote getSrvSistema()
	{
		return srvSistema;
	}

	public void setSrvSistema(SistemaRemote srvSistema)
	{
		this.srvSistema = srvSistema;
	}

	public List<BtpModulo> getListaModulos()
	{
		return listaModulos;
	}

	public void setListaModulos(List<BtpModulo> listaModulos)
	{
		this.listaModulos = listaModulos;
	}

	public List<BtpModulo> getModulosFiltradas()
	{
		return modulosFiltradas;
	}

	public void setModulosFiltradas(List<BtpModulo> modulosFiltradas)
	{
		this.modulosFiltradas = modulosFiltradas;
	}

	public DataModel<BtpModulo> getModulos()
	{
		return modulos;
	}

	public void setModulos(DataModel<BtpModulo> modulos)
	{
		this.modulos = modulos;
	}

	public BtpSistema getBtpSistema()
	{
		return btpSistema;
	}

	public void setBtpSistema(BtpSistema btpSistema)
	{
		this.btpSistema = btpSistema;
	}

	public BtpModulo getBtpModulo()
	{
		return btpModulo;
	}

	public void setBtpModulo(BtpModulo btpModulo)
	{
		this.btpModulo = btpModulo;
	}

	public List<BtpSistema> getLstSistemas()
	{
		return srvSistema.listar();
	}

}
