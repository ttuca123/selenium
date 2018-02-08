package bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.BtpSistema;
import dao.SistemaDAO;
import ejb.SistemaRemote;

/**
 * EJB de Caso de Teste com a lógica de negocio.
 */
@Stateless
public class SrvSistema implements SistemaRemote
{
	@PersistenceContext(unitName = "upTestes")
	private EntityManager em;

	public BtpSistema salvar(BtpSistema versao) throws Exception
	{
		SistemaDAO dao = new SistemaDAO(em);
		return dao.salvar(versao);
	}

	public void excluir(BtpSistema versao)
	{
		SistemaDAO dao = new SistemaDAO(em);
		dao.excluir(versao.getSisSeqSistema());
	}

	public BtpSistema consultarPorId(Long id)
	{
		SistemaDAO dao = new SistemaDAO(em);
		return dao.consultarPorId(id);
	}

	public List<BtpSistema> listar()
	{
		SistemaDAO dao = new SistemaDAO(em);
		return dao.listar();
	}

}