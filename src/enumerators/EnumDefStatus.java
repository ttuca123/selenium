package enumerators;

public enum EnumDefStatus
{
	NOVO(0, "NOVO", "./images/EnumDefStatus0.png"),

	ADMITIDO(1, "ADMITIDO", "./images/EnumDefStatus1.png"),

	ATRIBUIDO(2, "ATRIBUIDO", "./images/EnumDefStatus2.png"),

	REABERTO(3, "REABERTO", "./images/EnumDefStatus3.png"),

	RESOLVIDO(4, "RESOLVIDO", "./images/EnumDefStatus4.png"),

	FECHADO(5, "FECHADO", "./images/EnumDefStatus5.png");

	private Integer codigo;

	private String descricao;

	private String icone;

	private EnumDefStatus(Integer codigo, String descricao, String icone)
	{
		this.codigo = codigo;
		this.descricao = descricao;
		this.icone = icone;
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

	public String getIcone()
	{
		return icone;
	}

	public void setIcone(String icone)
	{
		this.icone = icone;
	}
}
