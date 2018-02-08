package enumerators;

public enum EnumTipoErro
{
	SEM_ERRO(0, "SUCESSO"),

	TEA(1, "DADOS"),

	TIMEOUT(2, "TIMEOUT"),

	REGRA_NEGOCIO(3, "TESTES"),

	TESTLINK(4, "TESTLINK"),

	LOCATION(5, "ELEMENTO"),

	MYSQL(6, "MYSQL"),

	NAO_DEFINIDO(7, "INDEFINIDO");

	private Integer ordinal = 0;

	private final String nomeAmigavel;

	EnumTipoErro(final Integer letra, final String nomeAmigavel)
	{
		this.ordinal = letra;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getLetra()
	{

		return ordinal;
	}

	public String getNomeAmigavel()
	{
		return nomeAmigavel;
	}

	public static EnumTipoErro valueOf(final Integer letra)
	{
		EnumTipoErro result = null;

		final EnumTipoErro[] values = EnumTipoErro.values();

		for (final EnumTipoErro enuTipoLaudo : values)
		{
			if ( enuTipoLaudo.ordinal.equals(letra) )
			{
				result = enuTipoLaudo;
				break;
			}
		}
		return result;
	}

	public static EnumTipoErro valueOf(final int ordinal)
	{
		EnumTipoErro result = null;

		final EnumTipoErro[] values = EnumTipoErro.values();

		for (final EnumTipoErro enuTipoLaudo : values)
		{
			if ( enuTipoLaudo.ordinal() == ordinal )
			{
				result = enuTipoLaudo;
				break;
			}
		}
		return result;
	}

	public int getOrdinal()
	{
		return ordinal();
	}

}
