package enumerators;

/**
 * 
 * @author 210266
 *
 */
public enum EnumTipoModoParcelamento {

	SEM_ENTRADA(1, "SEM ENTRADA"),

	COM_ENTRADA(2, "COM ENTRADA"),

	SEGUNDO_PARCELAMENTO(3, "SEGUNDO PARCELAMENTO"),

	TERCEIRO_PARCELAMENTO(4, "TERCEIRO PARCELAMENTO")

	;

	/**
	 * Opção que será armazenada.
	 */
	private final Integer codigo;

	/**
	 * Nome amigável pro usuário
	 */
	private final String nomeAmigavel;

	/**
	 * 
	 * @author Evandro Custodio[evandro.custodio@cagece.com.br] 14/10/2013 -
	 *         09:16:46.
	 * @param letra
	 * @param nomeAmigavel
	 */
	EnumTipoModoParcelamento(final Integer codigo, final String nomeAmigavel) {
		this.codigo = codigo;
		this.nomeAmigavel = nomeAmigavel;
	}

	/**
	 * 
	 * @author Evandro Custodio[evandro.custodio@cagece.com.br] 14/10/2013 -
	 *         09:18:10.
	 * @return
	 */
	public Integer getCodigo() {

		return codigo;
	}

	/**
	 * 
	 * @author Evandro Custodio[evandro.custodio@cagece.com.br] 14/10/2013 -
	 *         09:18:32.
	 * @return
	 */
	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	/**
	 * 
	 * @author Evandro Custodio[evandro.custodio@cagece.com.br] 14/10/2013 -
	 *         09:18:51.
	 * @param codigo
	 * @return
	 */
	public static EnumTipoModoParcelamento valueOf(final Integer codigo) {

		EnumTipoModoParcelamento result = null;

		final EnumTipoModoParcelamento[] values = EnumTipoModoParcelamento
				.values();

		for (final EnumTipoModoParcelamento enumAtributoEspecial : values) {

			if (enumAtributoEspecial.codigo.equals(codigo)) {
				result = enumAtributoEspecial;
				break;
			}

		}

		return result;
	}

}
