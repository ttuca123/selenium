package bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelo.BtpCasoTeste;
import dao.CasoTesteDAO;
import ejb.CasoTesteRemote;

/**
 * EJB de Caso de Teste com a lógica de negocio.
 */
@Stateless
public class SrvCasoTeste implements CasoTesteRemote
{
	@PersistenceContext(unitName = "upTestes")
	private EntityManager em;

	public BtpCasoTeste salvar(BtpCasoTeste casoTeste) throws Exception
	{
		CasoTesteDAO dao = new CasoTesteDAO(em);
		return dao.salvar(casoTeste);
	}

	public void excluir(BtpCasoTeste casoTeste)
	{
		CasoTesteDAO dao = new CasoTesteDAO(em);
		dao.excluir(casoTeste.getCatSeqCasoTeste());
	}

	public BtpCasoTeste consultarPorId(Long id)
	{
		CasoTesteDAO dao = new CasoTesteDAO(em);
		return dao.consultarPorId(id);
	}

}