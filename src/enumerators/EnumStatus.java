package enumerators;

public enum EnumStatus
{

	OK("OK"), NAO_IMPLEMENTADO("NÃO IMPLEMENTADO");

	private String valor;

	private EnumStatus(String valor)
	{
		this.valor = valor;

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
