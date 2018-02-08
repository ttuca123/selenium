package enumerators;

public enum EnumSistema
{

	PRAX(1, "Sistema Comercial PRAX", "prax"),

	BCI_MOBILE(7, "BCI Mobile", "bcimobile"),

	OS_MOBILE(8, "OS Mobile", "osmobile"),

	PRAX_IMEDIATO(3, "PRAX-Imediato Mobile", "imediato"),

	PRAX_WEBSERVICE(2, "PRAX-Webservice", "praxwebservice"),

	PRAX_WS_IMEDIATO(4, "PRAX-WS-Imediato", "praxwsimediato"),

	PRAX_WS_AUTENTICACAO(5, "PRAX-WS-Autenticacao", "praxwsautenticacao"),

	ANDROID_TOOLS(6, "Android Tools", "androidtools");

	private final Integer codigo;

	private final String nomeAmigavel;

	private final String sigla;

	/**
	 * 
	 * @author Evandro Custodio[evandro.custodio@cagece.com.br] 14/10/2013 -
	 *         09:16:46.
	 * @param letra
	 * @param nomeAmigavel
	 */
	EnumSistema(final Integer codigo, final String nomeAmigavel,
			final String sigla)
	{
		this.codigo = codigo;
		this.nomeAmigavel = nomeAmigavel;
		this.sigla = sigla;
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
	public static EnumSistema valueOf(final Integer codigo)
	{

		EnumSistema result = null;

		final EnumSistema[] values = EnumSistema.values();

		for (final EnumSistema sistema : values)
		{

			if ( sistema.codigo.equals(codigo) )
			{
				result = sistema;
				break;
			}

		}

		return result;
	}

	public String getSigla()
	{
		return sigla;
	}

}
