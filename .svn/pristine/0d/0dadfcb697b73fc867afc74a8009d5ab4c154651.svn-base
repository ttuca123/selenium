package enumerators;

public enum EnumAtivoAfetado
{
	SRVORAPRAX1(0, "SRVORAPRAX1", "PRAX LOJA"),

	SRVAPPPRAX4(1, "SRVAPPPRAX4","PRAX PROCESSO"),
	
	SRVAPP02(1, "SRVAPP02","ATENDIMENTO VIRTUAL");

	private Integer ordinal = 0;

	private final String nomeAmigavel;
	
	private final String nomeAtivo;

	EnumAtivoAfetado(final Integer letra, final String nomeAmigavel,String nomeAtivo)
	{
		this.ordinal = letra;
		this.nomeAmigavel = nomeAmigavel;
		this.nomeAtivo = nomeAtivo;
	}

	public Integer getLetra()
	{

		return ordinal;
	}

	public String getNomeAmigavel()
	{
		return nomeAmigavel;
	}
	
	public String getNomeAtivo()
	{
		return nomeAtivo;
	}

	public static EnumAtivoAfetado valueOf(final Integer letra)
	{
		EnumAtivoAfetado result = null;

		final EnumAtivoAfetado[] values = EnumAtivoAfetado.values();

		for (final EnumAtivoAfetado enumAtivoAfetado : values)
		{
			if ( enumAtivoAfetado.ordinal.equals(letra) )
			{
				result = enumAtivoAfetado;
				break;
			}
		}
		return result;
	}

	public static EnumAtivoAfetado valueOf(final int ordinal)
	{
		EnumAtivoAfetado result = null;

		final EnumAtivoAfetado[] values = EnumAtivoAfetado.values();

		for (final EnumAtivoAfetado enumAtivoAfetado : values)
		{
			if ( enumAtivoAfetado.ordinal() == ordinal )
			{
				result = enumAtivoAfetado;
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