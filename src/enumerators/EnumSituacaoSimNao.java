package enumerators;

public enum EnumSituacaoSimNao
{
	NAO(0, "NAO", "./images/nao.png"),

	SIM(1, "SIM","./images/sim.png");

	private Integer ordinal = 0;

	private final String nomeAmigavel;
	
	private final String imagem;

	EnumSituacaoSimNao(final Integer letra, final String nomeAmigavel,final String imagem)
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

	public static EnumSituacaoSimNao valueOf(final Integer letra)
	{
		EnumSituacaoSimNao result = null;

		final EnumSituacaoSimNao[] values = EnumSituacaoSimNao.values();

		for (final EnumSituacaoSimNao enumSituacaoSimNao : values)
		{
			if ( enumSituacaoSimNao.ordinal.equals(letra) )
			{
				result = enumSituacaoSimNao;
				break;
			}
		}
		return result;
	}

	public static EnumSituacaoSimNao valueOf(final int ordinal)
	{
		EnumSituacaoSimNao result = null;

		final EnumSituacaoSimNao[] values = EnumSituacaoSimNao.values();

		for (final EnumSituacaoSimNao enumSituacaoSimNao : values)
		{
			if ( enumSituacaoSimNao.ordinal() == ordinal )
			{
				result = enumSituacaoSimNao;
				break;
			}
		}
		return result;
	}

	public int getOrdinal()
	{
		return ordinal();
	}
public String getImagem()
{
	return imagem;
}
}