package ejb;

import java.util.List;

import javax.ejb.Remote;

import modelo.BtpDependencia;
import modelo.BtpVersao;

/**
 * Interface que possui os métodos que o EJB de casoTeste precisa implementar.
 */
@Remote
public interface DependenciaRemote
{
	public BtpDependencia salvar(BtpDependencia btpDependencia) throws Exception;

	public void excluir(BtpDependencia btpDependencia);

	public List<BtpDependencia> listar(BtpVersao btpVersao);

}