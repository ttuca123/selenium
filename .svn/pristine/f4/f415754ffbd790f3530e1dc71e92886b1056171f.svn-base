package enumerators;

/**
 * 
 * @since modelo - 2008.
 */
public enum EnuLocalEntregaFatura {

	IMOVEL(1, "ENDEREÇO DO IMÓVEL"), 

	RESIDENCIA_CLIENTE(2, "ENDEREÇO RESIDENCIAL DO CLIENTE"), 

	COMERCIAL_CLIENTE(3, "ENDEREÇO COMERCIAL DO CLIENTE"), 

	FATURA_CLIENTE(4, "ENDEREÇO ENTREGA FATURA DO CLIENTE"), 

	GRUPO_RESPONSAVEL(5, "ENDEREÇO ENTREGA DO GRUPO DO RESPONSÁVEL"); 

	private final Integer letra;

	private final String nomeAmigavel;

	EnuLocalEntregaFatura(final Integer letra, final String nomeAmigavel) {
		this.letra = letra;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getLetra() {
		return letra;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public static EnuLocalEntregaFatura valueOf(final Integer letra) {
		EnuLocalEntregaFatura result = null;

		final EnuLocalEntregaFatura[] values = EnuLocalEntregaFatura.values();

		for (final EnuLocalEntregaFatura enuLocalEntregaFatura : values) {
			if (enuLocalEntregaFatura.letra.equals(letra)) {
				result = enuLocalEntregaFatura;
				break;
			}
		}
		return result;
	}

	public static EnuLocalEntregaFatura valueOf(final int ordinal) {
		EnuLocalEntregaFatura result = null;

		final EnuLocalEntregaFatura[] values = EnuLocalEntregaFatura.values();

		for (final EnuLocalEntregaFatura enuLocalEntregaFatura : values) {
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
