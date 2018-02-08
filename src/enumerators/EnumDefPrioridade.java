package enumerators;

public enum EnumDefPrioridade
{
	NENHUMA(0, "NENHUMA"),

	BAIXA(1, "BAIXA"),

	NORMAL(2, "NORMAL"),

	ALTA(3, "ALTA"),

	URGENTE(4, "URGENTE"),
	
	IMEDIATO(5, "IMEDIATO");

	private Integer codigo;

	private String descricao;

	private EnumDefPrioridade(Integer codigo, String descricao)
	{
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo()
	{
		return codigo;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
}
