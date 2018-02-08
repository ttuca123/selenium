package enumerators;

public enum EnumStatusVersao
{

	DESENVOLVIMENTO(0, "DESENVOLVIMENTO"),

	TESTES(1, "HOMOLOGAÇÃO"),

	PUBLICADA(2, "PUBLICADA"),

	REPUBLICADA(3, "REPUBLICADA"),

	SUSPENSA(4, "SUSPENSA"),
	
	AGUARDANDO_PUBLICACAO(5, "AGUARD. PUBLICAÇÃO");

	private Integer numero;

	private String valor;

	private EnumStatusVersao(Integer numero, String valor)
	{
		this.numero = numero;
		this.valor = valor;

	}

	public Integer getNumero()
	{
		return numero;
	}

	public void setNumero(Integer numero)
	{
		this.numero = numero;
	}

	public String getValor()
	{
		return valor;
	}

	public void setValor(String valor)
	{
		this.valor = valor;
	}
}
