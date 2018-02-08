package enumerators;

/**
 * 
 * @since modelo - 2014.
 * @author Tuca
 */
public enum EnumTipoItem {
	AGUA(1, "ÁGUA"), 

	ESGOTO(2, "ESGOTO"),

	AGUA_ESGOTO(3, "ÁGUA E ESGOTO"),

	AGUA_ESGOTO_SERVICO(4, "ÁGUA, ESGOTO E SERVIÇO"),

	SERVICO(5, "SERVIÇO"), 
	
	AGUA_SERVICO(6, "ÁGUA E SERVIÇO"),	

	ESGOTO_SERVICO(7, "ESGOTO E SERVIÇO"),

	RECEBIMENTO_PENDENTE(8, "RECEBIMENTO PENDENTE");

	private final Integer codigo;

	private final String nomeAmigavel;

	EnumTipoItem(final Integer letra, final String nomeAmigavel) {
		this.codigo = letra;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getLetra() {
		return codigo;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public static EnumTipoItem valueOf(final Integer letra) {
		EnumTipoItem result = null;

		final EnumTipoItem[] values = EnumTipoItem.values();

		for (final EnumTipoItem enuTipoPagamento : values) {
			if (enuTipoPagamento.codigo.equals(letra)) {
				result = enuTipoPagamento;
				break;
			}
		}
		return result;
	}

	public static EnumTipoItem valueOf(final int ordinal) {
		EnumTipoItem result = null;

		final EnumTipoItem[] values = EnumTipoItem.values();

		for (final EnumTipoItem enuTipoPagamento : values) {
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
