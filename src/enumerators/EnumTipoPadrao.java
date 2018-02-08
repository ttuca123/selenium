package enumerators;

/**
 * 
 * @since modelo - 2014.
 */
public enum EnumTipoPadrao {
	ALTO(1, "ALTO"),

	MEDIO(2, "MÉDIO"),

	REGULAR(3, "REGULAR"),

	BASICO(4, "BÁSICO"),

	VAGO(5, "VAGO");

	private final Integer letra;

	private final String nomeAmigavel;

	EnumTipoPadrao(final Integer letra, final String nomeAmigavel) {
		this.letra = letra;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getLetra() {
		return letra;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public static EnumTipoPadrao valueOf(final Integer letra) {
		EnumTipoPadrao result = null;

		final EnumTipoPadrao[] values = EnumTipoPadrao.values();

		for (final EnumTipoPadrao enuTipoPagamento : values) {
			if (enuTipoPagamento.letra.equals(letra)) {
				result = enuTipoPagamento;
				break;
			}
		}
		return result;
	}

	public static EnumTipoPadrao valueOf(final int ordinal) {
		EnumTipoPadrao result = null;

		final EnumTipoPadrao[] values = EnumTipoPadrao.values();

		for (final EnumTipoPadrao enuTipoPagamento : values) {
			if (enuTipoPagamento.ordinal() == ordinal) {
				result = enuTipoPagamento;
				break;
			}
		}
		return result;
	}

	public int getOrdinal() {
		return ordinal();
	}

}
