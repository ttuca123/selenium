package modelo;

import java.io.Serializable;

public class PizzaVO implements Serializable
{

	private static final long serialVersionUID = 1L;

	private String label;

	private Integer value;
	
	private Integer indice;

	public PizzaVO()
	{
	}

	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public Integer getValue()
	{
		return value;
	}

	public void setValue(Integer value)
	{
		this.value = value;
	}
	
	public Integer getIndice()
	{
		return indice;
	}
	
	public void setIndice(Integer ind)
	{
		indice = ind;
	}
}
