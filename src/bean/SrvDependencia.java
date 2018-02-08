package bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.BtpDependencia;
import modelo.BtpVersao;
import dao.DependenciaDAO;
import ejb.DependenciaRemote;

@Stateless
public class SrvDependencia implements DependenciaRemote
{
	@PersistenceContext(unitName = "upTestes")
	private EntityManager em;

	public BtpDependencia salvar(BtpDependencia btpDependencia) throws Exception
	{
		DependenciaDAO dao = new DependenciaDAO(em);
		return dao.salvar(btpDependencia);
	}

	public void excluir(BtpDependencia btpDependencia)
	{
		DependenciaDAO dao = new DependenciaDAO(em);
		dao.excluir(btpDependencia.getVedSeqVersaoDependencia());
	}

	public BtpDependencia consultarPorId(Long id)
	{
		DependenciaDAO dao = new DependenciaDAO(em);
		return dao.consultarPorId(id);
	}

	public List<BtpDependencia> listar(BtpVersao btpVersao)
	{
		DependenciaDAO dao = new DependenciaDAO(em);
		return dao.listar(btpVersao);
	}

}