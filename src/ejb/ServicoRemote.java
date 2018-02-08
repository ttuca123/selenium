package ejb;

import java.util.List;

import javax.ejb.Remote;

import modelo.BtpServico;
import modelo.BtpTeste;
import modelo.ErrosVO;
import modelo.EstatisticaVO;
import modelo.TesteNaoExecutadoVO;

/**
 * Interface que possui os métodos que o EJB de servico precisa implementar.
 */
@Remote
public interface ServicoRemote
{
	public BtpServico salvar(BtpServico servico) throws Exception;

	public void excluir(BtpServico btpServico);

	public BtpServico consultarPorId(Long id);

	public List<BtpServico> listar();

	public List<EstatisticaVO> listaEstatistica();

	public List<ErrosVO> listaEstatisticaErros();

	public BtpTeste getTeste(Integer codigo);

	public List<TesteNaoExecutadoVO> listaTestesNaoExecutados();

}