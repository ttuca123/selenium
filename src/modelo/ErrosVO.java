package modelo;

import java.io.Serializable;

import enumerators.EnumTipoErro;

public class ErrosVO implements Serializable
{

	private static final long serialVersionUID = 1L;

	private EnumTipoErro codigo;

	private Integer quantidade;

	public ErrosVO(EnumTipoErro codigo, Integer quantidade)
	{
		this.codigo = codigo;
		this.quantidade = quantidade;
	}

	public EnumTipoErro getCodigo()
	{
		return codigo;
	}

	public Integer getQuantidade()
	{
		return quantidade;
	}

	public void setCodigo(EnumTipoErro codigo)
	{
		this.codigo = codigo;
	}

	public void setQuantidade(Integer quantidade)
	{
		this.quantidade = quantidade;
	}
}
