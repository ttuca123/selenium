package ejb;

import java.util.List;

import javax.ejb.Remote;

import modelo.BtpModulo;
import modelo.BtpSistema;

/**
 * Interface que possui os métodos que o EJB de casoTeste precisa implementar.
 */
@Remote
public interface ModuloRemote
{
	public BtpModulo salvar(BtpModulo btpModulo) throws Exception;

	public void excluir(BtpModulo btpModulo);

	public List<BtpModulo> listar(BtpSistema btpSistema);

}