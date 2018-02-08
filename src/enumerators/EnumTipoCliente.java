package enumerators;

/**
 * 
 * @author 210266
 *
 */
public enum EnumTipoCliente {

	ORGAO_PUBLICO(1, "ÓRGÃO PÚBLICO"),

	OUTROS(2, "OUTROS");

	/**
	 * Opção que será armazenada.
	 */
	private final Integer codigo;

	/**
	 * Nome amigável pro usuário
	 */
	private final String nomeAmigavel;

	EnumTipoCliente(final Integer codigo, final String nomeAmigavel) {
		this.codigo = codigo;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getCodigo() {

		return codigo;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public static EnumTipoCliente valueOf(final Integer codigo) {

		EnumTipoCliente result = null;

		final EnumTipoCliente[] values = EnumTipoCliente.values();

		for (final EnumTipoCliente enumAtributoEspecial : values) {

			if (enumAtributoEspecial.codigo.equals(codigo)) {
				result = enumAtributoEspecial;
				break;
			}

		}

		return result;
	}

}
