package managed;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.BtpSistema;
import modelo.BtpVersao;
import ejb.VersaoRemote;

@ViewScoped
@ManagedBean(name = "changeLogBean")
public class ChangeLogBean
{

	@EJB
	private VersaoRemote srvVersao;

	public List<BtpVersao> getListaVersoes()
	{
		BtpSistema prax = new BtpSistema();
		prax.setSisSeqSistema(1L);

		return srvVersao.listar(prax, null);
	}
}
