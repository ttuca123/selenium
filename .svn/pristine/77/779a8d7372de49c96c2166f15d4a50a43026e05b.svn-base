package bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.BtpDefeito;
import modelo.BtpVersao;
import dao.DefeitoDAO;
import ejb.DefeitoRemote;

@Stateless
public class SrvDefeito implements DefeitoRemote
{
	@PersistenceContext(unitName = "upTestes")
	private EntityManager em;

	public BtpDefeito salvar(BtpDefeito btpDefeito) throws Exception
	{
		DefeitoDAO dao = new DefeitoDAO(em);
		return dao.salvar(btpDefeito);
	}

	public void excluir(BtpDefeito btpDefeito)
	{
		DefeitoDAO dao = new DefeitoDAO(em);
		dao.excluir(btpDefeito.getDefSeqDefeito());
	}

	public BtpDefeito consultarPorId(Long id)
	{
		DefeitoDAO dao = new DefeitoDAO(em);
		return dao.consultarPorId(id);
	}

	public List<BtpDefeito> listar(BtpVersao btpVersao)
	{
		DefeitoDAO dao = new DefeitoDAO(em);
		return dao.listar(btpVersao);
	}

}