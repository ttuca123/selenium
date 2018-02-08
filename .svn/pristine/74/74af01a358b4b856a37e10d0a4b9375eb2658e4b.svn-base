package ejb;

import javax.ejb.Remote;

import modelo.BtpCasoTeste;

/**
 * Interface que possui os métodos que o EJB de casoTeste precisa implementar.
 */
@Remote
public interface CasoTesteRemote
{
	public BtpCasoTeste salvar(BtpCasoTeste casoTeste) throws Exception;

	public void excluir(BtpCasoTeste btpServico);

	public BtpCasoTeste consultarPorId(Long id);

}