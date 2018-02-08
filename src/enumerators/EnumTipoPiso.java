package enumerators;

public enum EnumTipoPiso {

	ASSOALHO(14, "ASSOALHO"),

	BORRACHA(16, "BORRACHA"),

	CARPETE(13, "CARPETE"),

	CERAMICA_ESMALTADA(9, "CERAMICA ESMALTADA"),

	CERAMICA_SIMPLES(7, "CERAMICA SIMPLES"),

	CIMENTO_LISO(4, "CIMENTO LISO"),

	CIMENTO_MORTO(3, "CIMENTO MORTO"),

	GRANITO(11, "GRANITO"),

	INDUSTRIAL(17, "INDUSTRIAL"),

	LAJOTA(12, "LAJOTA"),

	MARMORE(10, "MARMORE"),

	MOSAICO(5, "MOSAICO"),

	NAO_SE_APLICA(19, "NAO SE APLICA"),

	PAVIFLEX(15, "PAVIFLEX"),

	PORCELANATO(18, "PORCELANATO"),

	SEM_CADASTRO(20, "SEM CADASTRO"),

	TACO_SIMPLES(6, "TACO SIMPLES"),

	TACO_SINTETICO(8, "TACO SINTETICO"),

	TERRA_BATIDA(1, "TERRA BATIDA"),

	TIJOLO_REJUNTADO(2, "TIJOLO REJUNTADO");

	/**
	 * Opção que sera armazenada.
	 */
	private final Integer codigo;

	/**
	 * Nome amigável pro usuário.
	 */
	private final String nomeAmigavel;

	/**
	 * 
	 * @author Evandro Custodio[evandro.custodio@cagece.com.br] 14/10/2013 -
	 *         09:16:46.
	 * @param letra
	 * @param nomeAmigavel
	 */
	EnumTipoPiso(final Integer codigo, final String nomeAmigavel) {
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
	public static EnumTipoPiso valueOf(final Integer codigo) {

		EnumTipoPiso result = null;

		final EnumTipoPiso[] values = EnumTipoPiso.values();

		for (final EnumTipoPiso enumAtributoEspecial : values) {

			if (enumAtributoEspecial.codigo.equals(codigo)) {
				result = enumAtributoEspecial;
				break;
			}

		}

		return result;
	}

}
