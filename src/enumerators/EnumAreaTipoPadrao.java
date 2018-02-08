package enumerators;

/**
 * 
 * @since modelo - 2008.
 */
public enum EnumAreaTipoPadrao
{

	// Faixa 1-50
	BASICO(1, "50"),

	// Faixa 51-120
	REGULAR(2, "51"),

	// Faixa 121 - 200
	MEDIO(3, "200"),

	// Faixa 201 - 99999999
	ALTO(4, "201"),

	VAGO(5, "0");

	private final Integer codigo;

	private final String nomeAmigavel;

	EnumAreaTipoPadrao(final Integer letra, final String nomeAmigavel)
	{
		this.codigo = letra;
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

	public static EnumAreaTipoPadrao valueOf(final Integer letra)
	{
		EnumAreaTipoPadrao result = null;

		final EnumAreaTipoPadrao[] values = EnumAreaTipoPadrao.values();

		for (final EnumAreaTipoPadrao enuLocalEntregaFatura : values)
		{
			if ( enuLocalEntregaFatura.codigo.equals(letra) )
			{
				result = enuLocalEntregaFatura;
				break;
			}
		}
		return result;
	}

	public static EnumAreaTipoPadrao valueOf(final int ordinal)
	{
		EnumAreaTipoPadrao result = null;

		final EnumAreaTipoPadrao[] values = EnumAreaTipoPadrao.values();

		for (final EnumAreaTipoPadrao enuLocalEntregaFatura : values)
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
