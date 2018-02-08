package enumerators;

public enum EnumDefCategoria
{
	ANALISE_CODIGO(0, "ANÁLISE DE CÓDIGO"),

	FUNCIONAL(1, "FUNCIONAL"),

	INTERFACE(2, "INTERFACE"),

	REGRA_NEGOCIO(3, "REGRA DE NEGÓCIO"),

	USUABILIDADE(4, "USUABILIDADE");

	private Integer codigo;

	private String descricao;

	private EnumDefCategoria(Integer codigo, String descricao)
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
