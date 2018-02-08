package enumerators;

/**
 * 
 * @author 210266
 *
 */
public enum EnumTipoProduto
{

	AGUA(1, "AGUA"),

	ESGOTO(2, "ESGOTO NORMAL"),

	ESGOTO_CONDOMINIAL(3, "ESGOTO CONDOMINIAL FRENTE DE LOTE")

	;

	/**
	 * Opção que será armazenada.
	 */
	private final Integer codigo;

	/**
	 * Nome amigavel pro usuário.
	 */
	private final String nomeAmigavel;

	EnumTipoProduto(final Integer codigo, final String nomeAmigavel)
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

	public static EnumTipoProduto valueOfNomeAmigavel(String nomeAmigavel)
	{
		EnumTipoProduto result = null;

		final EnumTipoProduto[] values = EnumTipoProduto.values();

		for (EnumTipoProduto enumAtributoEspecial : values)
		{
			if ( enumAtributoEspecial.getNomeAmigavel().equals(nomeAmigavel) )
			{

				result = enumAtributoEspecial;
				break;

			}

		}

		return result;
	}

	public static EnumTipoProduto valueOf(final Integer codigo)
	{

		EnumTipoProduto result = null;

		final EnumTipoProduto[] values = EnumTipoProduto.values();

		for (final EnumTipoProduto enumAtributoEspecial : values)
		{

			if ( enumAtributoEspecial.codigo.equals(codigo) )
			{
				result = enumAtributoEspecial;
				break;
			}

		}

		return result;
	}

}
