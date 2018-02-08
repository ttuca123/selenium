package bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.BtpDemanda;
import modelo.BtpInstrucaoSql;
import modelo.BtpVersao;
import dao.InstrucaoDAO;
import ejb.InstrucaoRemote;

/**
 * EJB de Caso de Teste com a lógica de negocio.
 */
@Stateless
public class SrvInstrucao implements InstrucaoRemote
{
	@PersistenceContext(unitName = "upTestes")
	private EntityManager em;

	public BtpInstrucaoSql salvar(BtpInstrucaoSql btpInstruacaoSql)
			throws Exception
	{
		InstrucaoDAO dao = new InstrucaoDAO(em);
		return dao.salvar(btpInstruacaoSql);
	}

	public void excluir(BtpInstrucaoSql btpInstruacaoSql)
	{
		InstrucaoDAO dao = new InstrucaoDAO(em);
		dao.excluir(btpInstruacaoSql.getInsSeqInstrucao());
	}

	public BtpInstrucaoSql consultarPorId(Long id)
	{
		InstrucaoDAO dao = new InstrucaoDAO(em);
		return dao.consultarPorId(id);
	}

	public List<BtpInstrucaoSql> listar(BtpVersao btpVersao)
	{
		InstrucaoDAO dao = new InstrucaoDAO(em);
		return dao.listar(btpVersao);
	}

	@Override
	public List<BtpDemanda> listarDemandas(BtpVersao btpVersao)
	{
		InstrucaoDAO dao = new InstrucaoDAO(em);
		return dao.listarDemandas(btpVersao);

	}
}