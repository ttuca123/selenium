package enumerators;

/**
 * 
 * @author 210266
 *
 */
public enum EnumFlags {

	SIM(1, "SIM"),

	NAO(2, "NÃO")

	;

	/**
	 * Opção que será armazenada.
	 */
	private final Integer codigo;

	/**
	 * Nome amigavel pro usuário.
	 */
	private final String nomeAmigavel;

	EnumFlags(final Integer codigo, final String nomeAmigavel) {
		this.codigo = codigo;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getCodigo() {

		return codigo;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public static EnumFlags valueOf(final Integer codigo) {

		EnumFlags result = null;

		final EnumFlags[] values = EnumFlags.values();

		for (final EnumFlags enumAtributoEspecial : values) {

			if (enumAtributoEspecial.codigo.equals(codigo)) {
				result = enumAtributoEspecial;
				break;
			}

		}

		return result;
	}

}
