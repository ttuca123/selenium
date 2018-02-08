package enumerators;

public enum EnumTipoConstrucao {

	FERRO_ZINCO(6, "FERRO/ZINCO"),

	MADEIRA_CONGLOMERADO(4, "MADEIRA (CONGL)"),

	MADEIRA_PURA(5, "MADEIRA PURA"),

	NAO_SE_APLICA(7, "NAO SE APLICA"),

	SEM_CADASTRO(8, "SEM CADASTRO"),

	TAIPA(1, "TAIPA"),

	TIJOLO(2, "TIJOLO"),

	TIJOLO_CONCRETO(3, "TIJOLO E CONCRETO");

	/**
	 * Opção que será armazenada.
	 */
	private final Integer codigo;

	/**
	 *Nome amigável pro usuário
	 */
	private final String nomeAmigavel;

	/**
	 * 
	 * @author Evandro Custodio[evandro.custodio@cagece.com.br] 14/10/2013 -
	 *         09:16:46.
	 * @param letra
	 * @param nomeAmigavel
	 */
	EnumTipoConstrucao(final Integer codigo, final String nomeAmigavel) {
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
	public static EnumTipoConstrucao valueOf(final Integer codigo) {

		EnumTipoConstrucao result = null;

		final EnumTipoConstrucao[] values = EnumTipoConstrucao.values();

		for (final EnumTipoConstrucao enumAtributoEspecial : values) {

			if (enumAtributoEspecial.codigo.equals(codigo)) {
				result = enumAtributoEspecial;
				break;
			}

		}

		return result;
	}

}
