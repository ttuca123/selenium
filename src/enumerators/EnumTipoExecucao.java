package enumerators;

public enum EnumTipoExecucao
{

	TODOS(0, "TODOS"),

	NAO_EXECUTADO(1, "NAO EXECUTADOS"),

	FALHOU(2, "COM FALHAS"),

	NENHUM(3, "NENHUM");

	private Integer numero;

	private String valor;

	private EnumTipoExecucao(Integer numero, String valor)
	{
		this.numero = numero;
		this.valor = valor;

	}

	public static EnumTipoExecucao valueOf(final Integer codigo)
	{

		EnumTipoExecucao result = null;

		final EnumTipoExecucao[] values = EnumTipoExecucao.values();

		for (final EnumTipoExecucao enumTipoExecucao : values)
		{

			if ( enumTipoExecucao.numero.equals(codigo) )
			{
				result = enumTipoExecucao;
				break;
			}

		}

		return result;
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
