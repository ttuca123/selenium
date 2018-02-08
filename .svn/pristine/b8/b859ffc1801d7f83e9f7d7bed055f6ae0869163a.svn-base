package enumerators;

/**
 * 
 * @author 210266
 *
 */
public enum EnumStatusSegundaVia {

	PAGA(1, "PAGA"),

	AGRUPADO(2, "AGRUPADO"),

	INDIVIDUAL(3, "INDIVIDUAL");

	/**
	 * Opção que será armazenada.
	 */
	private final Integer codigo;

	/**
	 * Nome amigável pro usuário.
	 */
	private final String nomeAmigavel;

	EnumStatusSegundaVia(final Integer codigo, final String nomeAmigavel) {
		this.codigo = codigo;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getCodigo() {

		return codigo;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public static EnumStatusSegundaVia valueOf(final Integer codigo) {

		EnumStatusSegundaVia result = null;

		final EnumStatusSegundaVia[] values = EnumStatusSegundaVia.values();

		for (final EnumStatusSegundaVia enumAtributoEspecial : values) {

			if (enumAtributoEspecial.codigo.equals(codigo)) {
				result = enumAtributoEspecial;
				break;
			}

		}

		return result;
	}

}
