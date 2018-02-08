package modelo;

import java.io.Serializable;
import java.text.NumberFormat;

import javax.persistence.Entity;

public class TesteNaoExecutadoVO implements Serializable
{

	/**
	 * @author Evandro Custódio Gonçalves[evandro.custodio@cagece.com.br]
	 *         05/11/2015 - 11:30:06.
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String descricao;

	public TesteNaoExecutadoVO(String id, String descricao)
	{
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
}
