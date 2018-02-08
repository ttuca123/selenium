package enumerators;


public enum EnumAtributoEspecial {

	JARDIM_OU_HORTA(1, "JARDIM OU HORTA"),

	FORRO(2, "FORRO"),

	GARAGEM(3, "GARAGEM, ABRIGO OU ÁREA PARA VEÍCULOS");

	/**
	 * Opção que será armazenada.
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
	EnumAtributoEspecial(final Integer codigo, final String nomeAmigavel)
	{
		this.codigo = codigo;
		this.nomeAmigavel = nomeAmigavel;
	}

	/**
	 * 
	 * @author Evandro Custodio[evandro.custodio@cagece.com.br] 14/10/2013 -
	 *         09:18:10.
	 * @return
	 */
	public Integer getCodigo()
	{
		return codigo;
	}

	/**
	 * 
	 * @author Evandro Custodio[evandro.custodio@cagece.com.br] 14/10/2013 -
	 *         09:18:32.
	 * @return
	 */
	public String getNomeAmigavel()
	{
		return nomeAmigavel;
	}

	/**
	 * 
	 * @author Evandro Custodio[evandro.custodio@cagece.com.br] 14/10/2013 -
	 *         09:18:51.
	 * @param codigo
	 * @return
	 */
	public static EnumAtributoEspecial valueOf(final Integer codigo)
	{

		EnumAtributoEspecial result = null;

		final EnumAtributoEspecial[] values = EnumAtributoEspecial.values();

		for (final EnumAtributoEspecial enumAtributoEspecial : values)
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
