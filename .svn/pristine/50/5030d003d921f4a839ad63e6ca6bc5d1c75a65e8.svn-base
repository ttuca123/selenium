package enumerators;

public enum EnumTipoEconomia
{
	COMERCIAL(1, "COMERCIAL", "4722"),

	INDUSTRIAL(2, "INDUSTRIAL", "4120"),

	PUBLICA(3, "PÚBLICA", "8411"),

	RESIDENCIAL(4, "RESIDENCIAL", "8112"),

	NENHUM(5, "NENHUM", "0000");

	private final Integer codigo;

	private final String nomeAmigavel;

	private final String tipoEconomia;

	EnumTipoEconomia(final Integer letra, String tipoEconomia, String nomeAmigavel)
	{
		this.codigo = letra;
		this.tipoEconomia = tipoEconomia;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getCodigo()
	{
		return codigo;
	}

	public String getNomeAmigavel()
	{
		return nomeAmigavel;
	}

	public String getTipoEconomia()
	{

		return tipoEconomia;
	}

	public static EnumTipoEconomia valueOf(final Integer letra)
	{
		EnumTipoEconomia result = null;

		final EnumTipoEconomia[] values = EnumTipoEconomia.values();

		for (final EnumTipoEconomia enuLocalEntregaFatura : values)
		{
			if ( enuLocalEntregaFatura.codigo.equals(letra) )
			{
				result = enuLocalEntregaFatura;
				break;
			}
		}
		return result;
	}

	public static EnumTipoEconomia valueOf(final int ordinal)
	{
		EnumTipoEconomia result = null;

		final EnumTipoEconomia[] values = EnumTipoEconomia.values();

		for (final EnumTipoEconomia enuLocalEntregaFatura : values)
		{
			if ( enuLocalEntregaFatura.ordinal() == ordinal )
			{
				result = enuLocalEntregaFatura;
				break;
			}
		}
		return result;
	}

	public Long getOrdinal()
	{
		return Long.valueOf(ordinal());
	}

}
