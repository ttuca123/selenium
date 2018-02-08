package enumerators;

/**
 * 
 * @author 210266
 *
 */
public enum EnumTipoParcelamento {

	SEM_JUROS(1, "SEM JUROS"), 
		
	COM_JUROS(2, "COM JUROS");

	/**
	 * Opção que sera armazenada.
	 */
	private final Integer codigo;

	/**
	 * Nome amigável pro usuário.
	 */
	private final String nomeAmigavel;

	EnumTipoParcelamento(final Integer codigo, final String nomeAmigavel) {
		this.codigo = codigo;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getCodigo() {

		return codigo;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public static EnumTipoParcelamento valueOf(final Integer codigo) {

		EnumTipoParcelamento result = null;

		final EnumTipoParcelamento[] values = EnumTipoParcelamento.values();

		for (final EnumTipoParcelamento enumAtributoEspecial : values) {

			if (enumAtributoEspecial.codigo.equals(codigo)) {
				result = enumAtributoEspecial;
				break;
			}

		}

		return result;
	}

}
