package auxiliares;

public class CalculoParcelas
{

	protected Double vlrInicial;

	protected Double vlrFinal;

	protected Integer nrParcela;

	protected Double vlrEntrada;

	protected Double vlrMinParcela;

	protected Double vlrSaldo;

	private Double vlrCalcEntrada;

	private Double vlrCalcParcela;

	private Integer nrCalcParcela;

	private Double vlrBaseCalculo;

	public CalculoParcelas(Double vlrInicial, Double vlrFinal, Integer nrParcela,
			Double vlrMinParcela, Double vlrEntrada)
	{
		this.vlrInicial = vlrInicial;
		this.vlrFinal = vlrFinal;
		if ( vlrFinal > 0 && vlrFinal > vlrInicial )
		{
			vlrBaseCalculo = vlrFinal;
		}
		else if (vlrInicial>1) 
		{
			vlrBaseCalculo = vlrInicial;
		} else {
			vlrBaseCalculo = 100.00;
		}

		this.nrParcela = nrParcela;
		this.vlrMinParcela = vlrMinParcela;
		this.vlrEntrada = vlrEntrada;

		calcule();
	}

	private void calcule()
	{

		vlrCalcEntrada = vlrEntrada;
		if ( nrParcela > 1 )
		{
			nrCalcParcela = nrParcela - 1;
		}
		else
		{
			nrCalcParcela = nrParcela;
		}
		vlrSaldo = vlrBaseCalculo - vlrCalcEntrada;
		vlrCalcParcela = vlrSaldo / nrCalcParcela;

		if ( vlrCalcParcela < vlrMinParcela )
		{
			nrParcela--;
			calcule();
		}

	}

	public Double getVlrCalcEntrada()
	{
		return vlrCalcEntrada;
	}

	public void setVlrCalcEntrada(Double vlrCalcEntrada)
	{
		this.vlrCalcEntrada = vlrCalcEntrada;
	}

	public Integer getNrCalcParcela()
	{
		return nrCalcParcela;
	}

	public void setNrCalcParcela(Integer nrCalcParcela)
	{
		this.nrCalcParcela = nrCalcParcela;
	}

	public Double getVlrCalcParcela()
	{
		return vlrCalcParcela;
	}

	public void setVlrCalcParcela(Double vlrCalcParcela)
	{
		this.vlrCalcParcela = vlrCalcParcela;
	}

	public Double getVlrBaseCalculo()
	{
		return this.vlrBaseCalculo;
	}

}
