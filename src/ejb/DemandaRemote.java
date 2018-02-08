package ejb;

import java.util.List;

import javax.ejb.Remote;

import modelo.BtpDemanda;
import modelo.BtpVersao;

/**
 * Interface que possui os métodos que o EJB de casoTeste precisa implementar.
 */
@Remote
public interface DemandaRemote
{
	public BtpDemanda salvar(BtpDemanda btpDemanda) throws Exception;

	public void excluir(BtpDemanda btpDemanda);

	public List<BtpDemanda> listar();
	
	public List<BtpDemanda> listar(BtpVersao btpVersao);

}