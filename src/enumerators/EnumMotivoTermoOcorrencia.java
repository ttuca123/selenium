package enumerators;

public enum EnumMotivoTermoOcorrencia {
	RELIGADO_CLANDESTINO(1, "Religado Clandestino"),

	LIGACAO_CLANDESTINA_SUPRIMIDA(2, "Ligação Clandestina para Suprimida"),

	LIGACAO_CLANDESTINA_POTENCIAL(3, "Ligação Clandestina para Potencial"),

	LIGACAO_CLANDESTINA_FACTIVEL(4, "Ligação Clandestina para Factível"),

	MEDIDOR_VIOLADO(5, "Medidor Violado"),

	MEDIDOR_INVERTIDO(6, "Medidor Invertido"),

	MEDIDOR_DESAPARECIDO(7, "Medidor Desaparecido"),

	MEDIDOR_DANIFICADO(8, "Medidor Danificado"),

	BY_PASS(9, "By Pass"),

	DESTAMPONAMENTO(10, "Destamponamento"),

	INTERVENCAO_REDE_AGUA(11, "Intervenção na Rede de Água"),

	DERIVACAO_OUTRO_IMOVEL(12, "Derivação para Outro Imóvel"),

	AUTENTICACAO_ADULTERADA(13, "Autenticação Adulterada");

	private Integer codigo;

	private String nomeAmigavel;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(final Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public void setNomeAmigavel(final String nomeAmigavel) {
		this.nomeAmigavel = nomeAmigavel;
	}

	EnumMotivoTermoOcorrencia(final Integer codigo, final String nomeAmigavel) {
		this.codigo = codigo;
		this.nomeAmigavel = nomeAmigavel;
	}

	public static EnumMotivoTermoOcorrencia valueOf(final Integer codigo) {
		if (codigo != null) {
			for (final EnumMotivoTermoOcorrencia enumMotivoTermoOcorrencia : EnumMotivoTermoOcorrencia
					.values()) {
				if (codigo.compareTo(enumMotivoTermoOcorrencia.getCodigo()) == 0) {
					return enumMotivoTermoOcorrencia;
				}
			}
		}
		return null;
	}

}
