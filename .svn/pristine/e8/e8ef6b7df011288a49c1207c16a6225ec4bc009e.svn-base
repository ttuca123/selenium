package bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.BtpModulo;
import modelo.BtpSistema;
import dao.ModuloDAO;
import ejb.ModuloRemote;

@Stateless
public class SrvModulo implements ModuloRemote
{
	@PersistenceContext(unitName = "upTestes")
	private EntityManager em;

	public BtpModulo salvar(BtpModulo btpModulo) throws Exception
	{
		ModuloDAO dao = new ModuloDAO(em);
		return dao.salvar(btpModulo);
	}

	public void excluir(BtpModulo btpModulo)
	{
		ModuloDAO dao = new ModuloDAO(em);
		dao.excluir(btpModulo.getModSeqModulo());
	}

	public BtpModulo consultarPorId(Long id)
	{
		ModuloDAO dao = new ModuloDAO(em);
		return dao.consultarPorId(id);
	}

	public List<BtpModulo> listar(BtpSistema btpSistema)
	{
		ModuloDAO dao = new ModuloDAO(em);
		return dao.listar(btpSistema);
	}

}