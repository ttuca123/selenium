package servicos;


public class BtpSrv022VerificacaoValoresLancadosNaFatura extends ServicoPadrao {
	
	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao) {
		
		preencheLaudo(servicoPadrao.getLaudo());

	}
}
