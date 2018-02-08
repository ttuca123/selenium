package enumerators;

/**
 * 
 * @since modelo - 2008.
 */
public enum EnumLocalEntregaFatura {
	IMOVEL(1, "ENDEREÇO DO IMÓVEL"), 

	RESIDENCIA_CLIENTE(2, "ENDEREÇO RESIDENCIAL DO CLIENTE"),

	COMERCIAL_CLIENTE(3, "ENDEREÇO COMERCIAL DO CLIENTE"), 

	FATURA_CLIENTE(4, "ENDEREÇO ENTREGA FATURA DO CLIENTE"),

	GRUPO_RESPONSAVEL(5, "ENDEREÇO ENTREGA DO GRUPO DO RESPONSÁVEL");
	
	private final Integer letra;

	private final String nomeAmigavel;

	EnumLocalEntregaFatura(final Integer letra, final String nomeAmigavel) {
		this.letra = letra;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getLetra() {
		return letra;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public static EnumLocalEntregaFatura valueOf(final Integer letra) {
		EnumLocalEntregaFatura result = null;

		final EnumLocalEntregaFatura[] values = EnumLocalEntregaFatura.values();

		for (final EnumLocalEntregaFatura enuLocalEntregaFatura : values) {
			if (enuLocalEntregaFatura.letra.equals(letra)) {
				result = enuLocalEntregaFatura;
				break;
			}
		}
		return result;
	}

	public static EnumLocalEntregaFatura valueOf(final int ordinal) {
		EnumLocalEntregaFatura result = null;

		final EnumLocalEntregaFatura[] values = EnumLocalEntregaFatura.values();

		for (final EnumLocalEntregaFatura enuLocalEntregaFatura : values) {
			if (enuLocalEntregaFatura.ordinal() == ordinal) {
				result = enuLocalEntregaFatura;
				break;
			}
		}
		return result;
	}

	public Long getOrdinal() {
		return Long.valueOf(ordinal());
	}

}
