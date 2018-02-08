package enumerators;

public enum EnumTipoExecucaoServico {

	IMOVEL(1, "IMOVEL"),

	CLIENTE(2, "CLIENTE"),

	LOGRADOURO(3, "LOGRADOURO");

	/**
	 * Opção que será armazenada.
	 */
	private final Integer codigo;

	/**
	 * Nome amigável pro usuário.
	 */
	private final String nomeAmigavel;

	EnumTipoExecucaoServico(final Integer codigo, final String nomeAmigavel) {
		this.codigo = codigo;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getCodigo() {

		return codigo;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public static EnumTipoExecucaoServico valueOf(final Integer codigo) {

		EnumTipoExecucaoServico result = null;

		final EnumTipoExecucaoServico[] values = EnumTipoExecucaoServico.values();

		for (final EnumTipoExecucaoServico enumTipoServico : values) {

			if (enumTipoServico.codigo.equals(codigo)) {
				result = enumTipoServico;
				break;
			}

		}

		return result;
	}

}
