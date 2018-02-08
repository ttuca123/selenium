package enumerators;

/**
 * 
 * @since modelo - 2014.
 * @author Tuca
 */
public enum EnumSituacaoAnalise {
	ANALISE (1, "ANÁLISE"),

	IMPROCEDENTE (2, "IMPROCEDENTE"),

	PROCEDENTE (3, "PROCEDENTE");

	
	private final Integer codigo;

	private final String nomeAmigavel;

	EnumSituacaoAnalise(final Integer letra, final String nomeAmigavel) {
		this.codigo = letra;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getLetra() {
		return codigo;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public static EnumSituacaoAnalise valueOf(final Integer letra) {
		EnumSituacaoAnalise result = null;

		final EnumSituacaoAnalise[] values = EnumSituacaoAnalise.values();

		for (final EnumSituacaoAnalise enuTipoPagamento : values) {
			if (enuTipoPagamento.codigo.equals(letra)) {
				result = enuTipoPagamento;
				break;
			}
		}
		return result;
	}

	public static EnumSituacaoAnalise valueOf(final int ordinal) {
		EnumSituacaoAnalise result = null;

		final EnumSituacaoAnalise[] values = EnumSituacaoAnalise.values();

		for (final EnumSituacaoAnalise enuTipoPagamento : values) {
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
