package bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.BtpSistema;
import modelo.BtpVersao;
import dao.VersaoDAO;
import ejb.VersaoRemote;
import enumerators.EnumStatusVersao;

/**
 * EJB de Caso de Teste com a lógica de negocio.
 */
@Stateless
public class SrvVersao implements VersaoRemote
{
	@PersistenceContext(unitName = "upTestes")
	private EntityManager em;

	public BtpVersao salvar(BtpVersao versao) throws Exception
	{
		VersaoDAO dao = new VersaoDAO(em);
		return dao.salvar(versao);
	}

	public void excluir(BtpVersao versao)
	{
		VersaoDAO dao = new VersaoDAO(em);
		dao.excluir(versao.getId());
	}

	public BtpVersao consultarPorId(Long id)
	{
		VersaoDAO dao = new VersaoDAO(em);
		return dao.consultarPorId(id);
	}

	public List<BtpVersao> listar(BtpSistema btpSistema,
			EnumStatusVersao enumStatusVersao)
	{
		VersaoDAO dao = new VersaoDAO(em);
		return dao.listar(btpSistema, enumStatusVersao);
	}

	public List<BtpVersao> listar(EnumStatusVersao enumStatusVersao)
	{
		VersaoDAO dao = new VersaoDAO(em);
		return dao.listar(enumStatusVersao);
	}
}