package enumerators;

public enum EnumTipoServicoSolicitado
{

	CADASTRO(1, "Cadastro"),

	CADASTRO_AGUA(2, "Cadastro Ligação Água"),

	CADASTRO_AGUA_ESGOTO(3, "Cadastro Ligação de Água e Esgoto"),

	CADASTRO_LIGAÇÃO_ESGOTO(4, "Cadastro Ligação Esgoto");

	private final Integer letra;

	private final String nomeAmigavel;

	EnumTipoServicoSolicitado(final Integer letra, final String nomeAmigavel)
	{
		this.letra = letra;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getLetra()
	{
		return letra;
	}

	public String getNomeAmigavel()
	{
		return nomeAmigavel;
	}

	public static EnumTipoServicoSolicitado valueOf(final Integer letra)
	{
		EnumTipoServicoSolicitado result = null;

		final EnumTipoServicoSolicitado[] values = EnumTipoServicoSolicitado
				.values();

		for (final EnumTipoServicoSolicitado enuTipoLaudo : values)
		{
			if ( enuTipoLaudo.letra.equals(letra) )
			{
				result = enuTipoLaudo;
				break;
			}
		}
		return result;
	}

	public static EnumTipoServicoSolicitado valueOf(final int ordinal)
	{
		EnumTipoServicoSolicitado result = null;

		final EnumTipoServicoSolicitado[] values = EnumTipoServicoSolicitado
				.values();

		for (final EnumTipoServicoSolicitado enuTipoLaudo : values)
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

}
