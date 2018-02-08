package servicos;

public class BtpSrv115RecuperacaoCaixaInspecao extends ServicoPadrao {

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao) {
		
		preencheLaudo(servicoPadrao.getLaudo());
	}
}
