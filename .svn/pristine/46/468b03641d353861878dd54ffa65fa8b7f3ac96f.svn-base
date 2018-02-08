package bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.BtpDemanda;
import modelo.BtpVersao;
import dao.DemandaDAO;
import ejb.DemandaRemote;

@Stateless
public class SrvDemanda implements DemandaRemote
{
	@PersistenceContext(unitName = "upTestes")
	private EntityManager em;

	public BtpDemanda salvar(BtpDemanda btpDemanda) throws Exception
	{
		DemandaDAO dao = new DemandaDAO(em);
		return dao.salvar(btpDemanda);
	}

	public void excluir(BtpDemanda btpDemanda)
	{
		DemandaDAO dao = new DemandaDAO(em);
		dao.excluir(btpDemanda.getDemSeqDemanda());
	}

	public BtpDemanda consultarPorId(Long id)
	{
		DemandaDAO dao = new DemandaDAO(em);
		return dao.consultarPorId(id);
	}

	public List<BtpDemanda> listar()
	{
		DemandaDAO dao = new DemandaDAO(em);
		return dao.listar();
	}

	public List<BtpDemanda> listar(BtpVersao btpVersao)
	{
		DemandaDAO dao = new DemandaDAO(em);
		return dao.listar(btpVersao);
	}

}