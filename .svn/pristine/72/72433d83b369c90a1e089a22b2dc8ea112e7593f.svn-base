package enumerators;

/**
 * Enum que contém as Situações da Ligação.
 * 
 * Nome do Arquivo: EnuSituacaoLigacao.
 * 
 * @author Claudomiro Costa Sampaio[claudomiro@cagece.com.br] -
 *         $05/03/2008:10:39:18$
 * 
 * @since modelo - 2008.
 */
public enum EnumTipoLigacao
{

	LIGADO(1, "ATIVA"),

	CORTADO(2, "CORTADA"),

	SUPRIMIDO(3, "SUPRIMIDA"),

	LIGACAO_SEM_FATURAMENTO(4, "LIGAÇÃO SEM FATURAMENTO"),

	LIGADO_SEM_INTERLIGACAO(5, "LIGADO SEM INTERLIGAÇÃO"),

	SUSPENSO(7, "SUSPENSO(A)"),

	LIGADO_SEM_CONDICAO_SCI(8, "LIGADO SEM CONDIÇÃO DE INTERLIGAÇÃO"),

	ABASTECIDO_COLETADO(9, "FATURADO(A) POR OUTRO IMÓVEL"),

	TAMPONADO(10, "TAMPONADO");

	private final Integer codigo;

	private final String nomeAmigavel;

	/**
	 * 
	 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 03/09/2015 -
	 *         10:21:42.
	 * @param codigo
	 * @param nomeAmigavel
	 */
	EnumTipoLigacao(final Integer codigo, final String nomeAmigavel)
	{
		this.codigo = codigo;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getCodigo()
	{
		return codigo;
	}

	public String getNomeAmigavel()
	{
		return nomeAmigavel;
	}

	public static EnumTipoLigacao valueOf(final Integer codigo)
	{
		EnumTipoLigacao result = null;
		if ( codigo != null )
		{
			final EnumTipoLigacao[] values = EnumTipoLigacao.values();

			// faz uma busca comparando os enums com a codigo indicada.
			for (final EnumTipoLigacao enuSituacaoLigacao : values)
			{
				// se combina a codigo informada com a codigo do Enum, entao retorna o
				// enum.
				if ( enuSituacaoLigacao.codigo.equals(codigo) )
				{
					result = enuSituacaoLigacao;
					break;
				}
			}
		}
		return result;
	}

	public String getDescricao()
	{
		return getNomeAmigavel();
	}

}
