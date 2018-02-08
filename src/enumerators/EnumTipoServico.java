package enumerators;

public enum EnumTipoServico
{

	SIMPLES("SIMPLES"), 
	CASADO("CASADO"), 
	INTEGRADO("INTEGRADO");

	private String valor;

	private EnumTipoServico(String valor)
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
