package enumerators;

public enum EnumTipoPublicacao
{
	APK(0, "APK", "./images/f_apk.png"),

	APKLIB(1, "APKLIB", "./images/f_apklib.png"),

	WAR(2, "WAR", "./images/f_war.png"),

	EAR(3, "EAR", "./images/f_ear.png"),

	JAR(4, "JAR", "./images/f_jar.png"),
	
	JS(5, "JS", "./images/f_js.png");

	private Integer ordinal = 0;

	private final String nomeAmigavel;

	private final String imagem;

	EnumTipoPublicacao(final Integer letra, final String nomeAmigavel,
			final String imagem)
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

	public static EnumTipoPublicacao valueOf(final Integer letra)
	{
		EnumTipoPublicacao result = null;

		final EnumTipoPublicacao[] values = EnumTipoPublicacao.values();

		for (final EnumTipoPublicacao enuTipoLaudo : values)
		{
			if ( enuTipoLaudo.ordinal.equals(letra) )
			{
				result = enuTipoLaudo;
				break;
			}
		}
		return result;
	}

	public static EnumTipoPublicacao valueOf(final int ordinal)
	{
		EnumTipoPublicacao result = null;

		final EnumTipoPublicacao[] values = EnumTipoPublicacao.values();

		for (final EnumTipoPublicacao enuTipoLaudo : values)
		{
			if ( enuTipoLaudo.ordinal() == ordinal )
			{
				result = enuTipoLaudo;
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
