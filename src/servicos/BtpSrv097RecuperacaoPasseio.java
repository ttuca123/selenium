package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv097RecuperacaoPasseio extends ServicoPadrao {

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao) {
		
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbRecuperacao, 1);
		
		

		preencheLaudo(servicoPadrao.getLaudo());

	}
}
