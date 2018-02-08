package ejb;

import java.util.List;

import javax.ejb.Remote;

import modelo.BtpSistema;

/**
 * Interface que possui os métodos que o EJB de casoTeste precisa implementar.
 */
@Remote
public interface SistemaRemote
{
	public BtpSistema salvar(BtpSistema versao) throws Exception;

	public void excluir(BtpSistema versao);

	public BtpSistema consultarPorId(Long id);

	public List<BtpSistema> listar();

}