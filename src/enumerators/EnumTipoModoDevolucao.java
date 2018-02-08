package enumerators;

/**
 * 
 * @since modelo - 2014.
 * @author Tuca
 */
public enum EnumTipoModoDevolucao {
	CREDITO_FINANCEIRO(1, "CRÉDITO FINANCEIRO"),

	COMPENSACAO_DEBITO(2, "COMPENSAÇÃO DE DÉBITO"),

	DEPOSITO_CONTA(3, "DEPÓSITO EM CONTA CORRENTE/POUPANÇA"), 

	ORDEM_PAGAMENTO(4, "ORDEM DE PAGAMENTO"),

	PAGAMENTO_CHEQUE(5, "PAGAMENTO EM CHEQUE"),

	EXCLUIR_RECEBIMENTO(6, "EXCLUIR RECEBIMENTO");

	private final Integer codigo;

	private final String nomeAmigavel;

	EnumTipoModoDevolucao(final Integer letra, final String nomeAmigavel) {
		this.codigo = letra;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getLetra() {
		return codigo;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public static EnumTipoModoDevolucao valueOf(final Integer letra) {
		EnumTipoModoDevolucao result = null;

		final EnumTipoModoDevolucao[] values = EnumTipoModoDevolucao.values();

		for (final EnumTipoModoDevolucao enuTipoPagamento : values) {
			if (enuTipoPagamento.codigo.equals(letra)) {
				result = enuTipoPagamento;
				break;
			}
		}
		return result;
	}

	public static EnumTipoModoDevolucao valueOf(final int ordinal) {
		EnumTipoModoDevolucao result = null;

		final EnumTipoModoDevolucao[] values = EnumTipoModoDevolucao.values();

		for (final EnumTipoModoDevolucao enuTipoPagamento : values) {
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
