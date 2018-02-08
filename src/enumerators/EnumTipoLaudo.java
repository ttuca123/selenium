package enumerators;

public enum EnumTipoLaudo
{

	PROCEDENTE(1, "PROCEDENTE"),

	IMPROCEDENTE(2, "IMPROCEDENTE"),

	INDIFERENTE (3, "INDIFERENTE");

	private final Integer letra;

	private final String nomeAmigavel;

	
	EnumTipoLaudo(final Integer letra, final String nomeAmigavel)
	{
		this.letra = letra;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getLetra()
	{
		return letra;
	}

	public String getNomeAmigavel()
	{
		return nomeAmigavel;
	}

	public static EnumTipoLaudo valueOf(final Integer letra)
	{
		EnumTipoLaudo result = null;

		final EnumTipoLaudo[] values = EnumTipoLaudo.values();

		for (final EnumTipoLaudo enuTipoLaudo : values)
		{
			if ( enuTipoLaudo.letra.equals(letra) )
			{
				result = enuTipoLaudo;
				break;
			}
		}
		return result;
	}

	public static EnumTipoLaudo valueOf(final int ordinal)
	{
		EnumTipoLaudo result = null;

		final EnumTipoLaudo[] values = EnumTipoLaudo.values();

		for (final EnumTipoLaudo enuTipoLaudo : values)
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
