package modelo;

import java.io.Serializable;
import java.text.NumberFormat;

import javax.persistence.Entity;

public class EstatisticaVO implements Serializable
{

	/**
	 * @author Evandro Custódio Gonçalves[evandro.custodio@cagece.com.br]
	 *         05/11/2015 - 11:30:06.
	 */
	private static final long serialVersionUID = 1L;

	private String descricao;

	private double percentual;

	private Integer total;

	public EstatisticaVO(String descricao, Integer total, double percentual)
	{
		super();
		this.descricao = descricao;
		this.percentual = percentual;
		this.total = total;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public String getPercentual()
	{
				return NumberFormat.getPercentInstance().format(percentual);		
	}

	public void setPercentual(double percentual)
	{
		this.percentual = percentual;
	}

	public Integer getTotal()
	{
		return total;
	}

	public void setTotal(Integer total)
	{
		this.total = total;
	}

}
