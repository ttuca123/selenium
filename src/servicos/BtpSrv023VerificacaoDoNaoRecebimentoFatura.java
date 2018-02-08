package servicos;


public class BtpSrv023VerificacaoDoNaoRecebimentoFatura extends ServicoPadrao {
	
	

	
	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao) {
		
		preencheLaudo(servicoPadrao.getLaudo());

	}
}
