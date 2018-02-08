package bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.BtpServico;
import modelo.BtpTeste;
import modelo.ErrosVO;
import modelo.EstatisticaVO;
import modelo.TesteNaoExecutadoVO;
import dao.ServicoDAO;
import ejb.ServicoRemote;

/**
 * EJB de servico com a lógica de negocio.
 */
@Stateless
public class SrvServico implements ServicoRemote
{
	@PersistenceContext(unitName = "upTestes")
	private EntityManager em;

	public BtpServico salvar(BtpServico servico) throws Exception
	{
		ServicoDAO dao = new ServicoDAO(em);
		return dao.salvar(servico);
	}

	public void excluir(BtpServico btpServico)
	{
		ServicoDAO dao = new ServicoDAO(em);
		dao.excluir(btpServico.getId());
	}

	public BtpServico consultarPorId(Long id)
	{
		ServicoDAO dao = new ServicoDAO(em);
		return dao.consultarPorId(id);
	}

	public List<BtpServico> listar()
	{
		ServicoDAO dao = new ServicoDAO(em);
		return dao.listar();
	}

	public List<EstatisticaVO> listaEstatistica()
	{
		ServicoDAO dao = new ServicoDAO(em);
		return dao.listaEstatistica();
	}

	public List<ErrosVO> listaEstatisticaErros()
	{
		ServicoDAO dao = new ServicoDAO(em);
		return dao.listaEstatisticaErros();
	}

	public BtpTeste getTeste(Integer codigo)
	{
		ServicoDAO dao = new ServicoDAO(em);
		return dao.findTeste(codigo);
	}

	@Override
	public List<TesteNaoExecutadoVO> listaTestesNaoExecutados()
	{
		ServicoDAO dao = new ServicoDAO(em);
		return dao.listaNaoExecutados();
	}
}