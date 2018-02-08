package ejb;

import java.util.List;

import javax.ejb.Remote;

import modelo.BtpDefeito;
import modelo.BtpVersao;

/**
 * Interface que possui os métodos que o EJB de Defeito precisa implementar.
 */
@Remote
public interface DefeitoRemote
{
	public BtpDefeito salvar(BtpDefeito btpDefeito) throws Exception;

	public void excluir(BtpDefeito btpDefeito);

	public List<BtpDefeito> listar(BtpVersao btpVersao);

}