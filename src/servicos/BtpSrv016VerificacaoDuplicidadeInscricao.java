package servicos;

public class BtpSrv016VerificacaoDuplicidadeInscricao extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		preencheLaudo(servicoPadrao.getLaudo());

	}
}
