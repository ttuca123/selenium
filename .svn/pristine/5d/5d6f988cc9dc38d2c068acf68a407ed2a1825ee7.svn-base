package enumerators;

/**
 * 
 * @since modelo - 2014.
 */

public enum EnumTipoPagamento
{

	A_VISTA(1, "PAGAMENTO Á VISTA"),

	PARCELADO_SEM_ENTRADA(2, "PAGAMENTO PARCELADO SEM ENTRADA"),

	PARCELADO_COM_ENTRADA(3, "PAGAMENTO PARCELADO COM ENTRADA"),

	SEM_ONUS(4, "PAGAMENTO SEM ONUS"),

	SEM_CUSTO(5, "PAGAMENTO SEM CUSTO"), 
	
	A_VISTA_PARCELADO(6,
			"PAGAMENTO Á VISTA (PARCELA ÚNICA)");

	private final Integer letra;

	private final String nomeAmigavel;

	EnumTipoPagamento(final Integer letra, final String nomeAmigavel)
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

	public static EnumTipoPagamento valueOf(final Integer letra)
	{
		EnumTipoPagamento result = null;

		final EnumTipoPagamento[] values = EnumTipoPagamento.values();

		for (final EnumTipoPagamento enuTipoPagamento : values)
		{
			if ( enuTipoPagamento.letra.equals(letra) )
			{
				result = enuTipoPagamento;
				break;
			}
		}
		return result;
	}

	public static EnumTipoPagamento valueOf(final int ordinal)
	{
		EnumTipoPagamento result = null;

		final EnumTipoPagamento[] values = EnumTipoPagamento.values();

		for (final EnumTipoPagamento enuTipoPagamento : values)
		{
			if ( enuTipoPagamento.ordinal() == ordinal )
			{
				result = enuTipoPagamento;
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
