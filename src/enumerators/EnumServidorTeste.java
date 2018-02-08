package enumerators;

public enum EnumServidorTeste
{

	LOCAL(1, "LOCAL", "http://172.25.131.47:8080/prax/",
			"http://localhost:8888/wd/hub/"),

	DESENVOLVIMENTO_72(2, "DESENVOLVIMENTO - 72",
			"https://srvapptstprax.int.cagece.com.br",
			"http://localhost:4444/wd/hub/"),

	DESENVOLVIMENTO_47(2, "DESENVOLVIMENTO - 47",
			"http://172.25.131.47:8080/prax/",
			"http://localhost:4444/wd/hub/"),

	TESTE_72(3, "TESTES - 72", "https://srvapptstprax.int.cagece.com.br",
			"http://172.25.131.72:8888/wd/hub/"),

	TESTE_47(3, "TESTES - 47", "https://srvapptstprax.int.cagece.com.br",
			"http://172.25.131.47:8888/wd/hub/");

	private final Integer letra;

	private final String nomeAmigavel;

	private final String url;

	private final String grid;

	EnumServidorTeste(final Integer letra, final String nomeAmigavel,
			final String url, final String grid)
	{
		this.letra = letra;
		this.nomeAmigavel = nomeAmigavel;
		this.url = url;
		this.grid = grid;
	}

	public Integer getLetra()
	{
		return letra;
	}

	public String getNomeAmigavel()
	{
		return nomeAmigavel;
	}

	public String getGrid()
	{
		return grid;
	}

	public static EnumServidorTeste valueOf(final Integer letra)
	{
		EnumServidorTeste result = null;

		final EnumServidorTeste[] values = EnumServidorTeste.values();

		for (final EnumServidorTeste enumServidorTeste : values)
		{
			if ( enumServidorTeste.letra.equals(letra) )
			{
				result = enumServidorTeste;
				break;
			}
		}
		return result;
	}

	public static EnumServidorTeste valueOf(final int ordinal)
	{
		EnumServidorTeste result = null;

		final EnumServidorTeste[] values = EnumServidorTeste.values();

		for (final EnumServidorTeste enumServidorTeste : values)
		{
			if ( enumServidorTeste.ordinal() == ordinal )
			{
				result = enumServidorTeste;
				break;
			}
		}
		return result;
	}

	public Long getOrdinal()
	{
		return Long.valueOf(ordinal());
	}

	public String getUrl()
	{
		return url;
	}
}
