package enumerators;

public enum EnumTipoDemanda
{
	NOVA_IMPLEMENTACAO(0, "NOVA IMPLEMENTAÇÃO","./images/td_new.png"),

	CORRECAO_ESPECIFICA(1, "CORREÇÃO ESPECÍFICA","./images/td_correcoes.png"),

	BUG(2, "BUG","./images/td_bug.jpg"),

	MELHORIA_PEFORMANCE(3, "MELHORIA DE PEFORMANCE","./images/td_performance.png"),
	
	MELHORIA_DESIGN(4, "MELHORIA DE DESIGN","./images/td_design.png");

	private Integer ordinal = 0;

	private final String nomeAmigavel;
	
	private final String imagem;

	EnumTipoDemanda(final Integer letra, final String nomeAmigavel, final String imagem)
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

	public static EnumTipoDemanda valueOf(final Integer letra)
	{
		EnumTipoDemanda result = null;

		final EnumTipoDemanda[] values = EnumTipoDemanda.values();

		for (final EnumTipoDemanda enumTipoDemanda : values)
		{
			if ( enumTipoDemanda.ordinal.equals(letra) )
			{
				result = enumTipoDemanda;
				break;
			}
		}
		return result;
	}

	public static EnumTipoDemanda valueOf(final int ordinal)
	{
		EnumTipoDemanda result = null;

		final EnumTipoDemanda[] values = EnumTipoDemanda.values();

		for (final EnumTipoDemanda enumTipoDemanda : values)
		{
			if ( enumTipoDemanda.ordinal() == ordinal )
			{
				result = enumTipoDemanda;
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
