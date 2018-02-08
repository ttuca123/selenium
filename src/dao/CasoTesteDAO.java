package dao;

import javax.persistence.EntityManager;

import modelo.BtpCasoTeste;
import modelo.BtpVersao;

/**
 * Classe utilizada para realizar as operações com o bando de dados.
 */	

public class CasoTesteDAO
{
	private EntityManager entityManager;

	public CasoTesteDAO(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	/**
	 * Método para salvar ou atualizar o casoTeste.
	 * 
	 * @param casoTeste
	 * @return
	 * @throws java.lang.Exception
	 */
	public BtpCasoTeste salvar(BtpCasoTeste casoTeste) throws Exception
	{
		if ( casoTeste.getCatSeqCasoTeste() == null )
		{
			this.entityManager.persist(casoTeste);
		}
		else
		{
			if ( entityManager.find(BtpCasoTeste.class, casoTeste.getCatSeqCasoTeste()) == null )
			{
				throw new Exception("Caso de Teste nao existe!");
			}
			return entityManager.merge(casoTeste);
		}
		return casoTeste;
	}

	/**
	 * Método que exclui a casoTeste do banco de dados.
	 * 
	 * @param id
	 */
	public void excluir(Long id)
	{
		BtpCasoTeste casoTeste = entityManager.find(BtpCasoTeste.class, id);
		entityManager.remove(casoTeste);
	}

	/**
	 * Consulta a casoTeste por ID.
	 * 
	 * @param id
	 * @return
	 */
	public BtpCasoTeste consultarPorId(Long id)
	{
		return entityManager.find(BtpCasoTeste.class, id);
	}
}