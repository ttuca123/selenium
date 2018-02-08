package ejb;

import java.util.List;

import javax.ejb.Remote;

import modelo.BtpSistema;
import modelo.BtpVersao;
import enumerators.EnumStatusVersao;

/**
 * Interface que possui os métodos que o EJB de casoTeste precisa implementar.
 */
@Remote
public interface VersaoRemote
{
	public BtpVersao salvar(BtpVersao versao) throws Exception;

	public void excluir(BtpVersao versao);

	public BtpVersao consultarPorId(Long id);

	public List<BtpVersao> listar(BtpSistema btpSistema,
			EnumStatusVersao enumStatusVersao);

	public List<BtpVersao> listar(EnumStatusVersao enumStatusVersao);	
}