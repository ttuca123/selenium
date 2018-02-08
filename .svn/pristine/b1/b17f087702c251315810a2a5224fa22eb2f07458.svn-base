package ejb;

import java.util.List;

import javax.ejb.Remote;

import modelo.BtpDemanda;
import modelo.BtpInstrucaoSql;
import modelo.BtpVersao;

/**
 * Interface que possui os métodos que o EJB de casoTeste precisa implementar.
 */
@Remote
public interface InstrucaoRemote
{
	public BtpInstrucaoSql salvar(BtpInstrucaoSql btpInstruacaoSql)
			throws Exception;

	public void excluir(BtpInstrucaoSql btpInstruacaoSql);

	public BtpInstrucaoSql consultarPorId(Long id);

	public List<BtpInstrucaoSql> listar(BtpVersao versao);

	public List<BtpDemanda> listarDemandas(BtpVersao btpVersao);

}