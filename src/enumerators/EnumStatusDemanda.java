package enumerators;

public enum EnumStatusDemanda
{
	NAO_TESTADA(0, "Aguardando ...","./images/wait.png"),
	
	PASSOU(1, "Aprovada","./images/passed.png"),

	FALHOU(2, "Reprovada","./images/fail.png"),

	IGNORADA(3, "Ignorada","./images/ignored.png"),

	BLOQUEADA(4, "Bloqueada","./images/blocked.png");

	private Integer ordinal = 0;

	private final String nomeAmigavel;
	
	private String imagem;


	EnumStatusDemanda(final Integer letra, final String nomeAmigavel, String imagem)
	{
		this.ordinal = letra;
		this.nomeAmigavel = nomeAmigavel;
		
		this.imagem = imagem;

	}

	public Integer getLetra()
	{

		return ordinal;
	}

	public String getNomeAmigavel()
	{
		return nomeAmigavel;
	}
	
	public String getImagem()
	{
		return imagem;
	}

	public void setImagem(String imagem)
	{
		this.imagem = imagem;
	}


	public static EnumStatusDemanda valueOf(final Integer letra)
	{
		EnumStatusDemanda result = null;

		final EnumStatusDemanda[] values = EnumStatusDemanda.values();

		for (final EnumStatusDemanda enumStatusDemanda : values)
		{
			if ( enumStatusDemanda.ordinal.equals(letra) )
			{
				result = enumStatusDemanda;
				break;
			}
		}
		return result;
	}

	public static EnumStatusDemanda valueOf(final int ordinal)
	{
		EnumStatusDemanda result = null;

		final EnumStatusDemanda[] values = EnumStatusDemanda.values();

		for (final EnumStatusDemanda enumStatusDemanda : values)
		{
			if ( enumStatusDemanda.ordinal() == ordinal )
			{
				result = enumStatusDemanda;
				break;
			}
		}
		return result;
	}

	public int getOrdinal()
	{
		return ordinal();
	}

}
