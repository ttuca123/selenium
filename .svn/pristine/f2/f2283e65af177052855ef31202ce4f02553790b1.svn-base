package enumerators;

/**
 * 
 * @since modelo - 2014.
 * @author Tuca
 */
public enum EnumSituacaoRede {
	
	ATIVA (1, "ATIVA"),

	POTENCIAL (2, "POTENCIAL"),

	FACTIVEL (3, "FACTÍVEL");

	
	private final Integer codigo;

	private final String nomeAmigavel;

	EnumSituacaoRede(final Integer letra, final String nomeAmigavel) {
		this.codigo = letra;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getLetra() {
		return codigo;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public static EnumSituacaoRede valueOf(final Integer letra) {
		EnumSituacaoRede result = null;

		final EnumSituacaoRede[] values = EnumSituacaoRede.values();

		for (final EnumSituacaoRede enuTipoPagamento : values) {
			if (enuTipoPagamento.codigo.equals(letra)) {
				result = enuTipoPagamento;
				break;
			}
		}
		return result;
	}

	public static EnumSituacaoRede valueOf(final int ordinal) {
		EnumSituacaoRede result = null;

		final EnumSituacaoRede[] values = EnumSituacaoRede.values();

		for (final EnumSituacaoRede enuTipoPagamento : values) {
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
