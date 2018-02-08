package servicos;


public class BtpSrv001RevisaoDadosCadastrais extends ServicoPadrao
{
	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{
		preencheLaudo(servicoPadrao.getLaudo());

	}

}
