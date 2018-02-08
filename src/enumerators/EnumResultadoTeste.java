package enumerators;

public enum EnumResultadoTeste
{

	FALHA(0, "FALHA",EnumTipoExecucao.FALHOU),
	
	SUCESSO(1, "SUCESSO", EnumTipoExecucao.NENHUM),
	
	NAO_EXECUTADO(2, "NAO EXECUTADO", EnumTipoExecucao.NAO_EXECUTADO);

	private Integer id;

	private String valor;

	private EnumTipoExecucao tipoexec;

	private EnumResultadoTeste(Integer id, String valor, EnumTipoExecucao tipoexec)
	{
		this.id = id;
		this.valor = valor;
		this.tipoexec = tipoexec;

	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getValor()
	{
		return valor;
	}

	public void setValor(String valor)
	{
		this.valor = valor;
	}

	public EnumTipoExecucao getTipoexec()
	{
		return tipoexec;
	}

	public void setTipoexec(EnumTipoExecucao tipoexec)
	{
		this.tipoexec = tipoexec;
	}
}
