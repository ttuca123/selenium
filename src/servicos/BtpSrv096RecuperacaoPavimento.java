package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv096RecuperacaoPavimento extends ServicoPadrao {

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao) {

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbPavimentoRecuperado, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbRecuperacao, 1);

		DriverUtils.clicar(ItemAtendimentoPage.optPavimentoAsfalto);

		preencheLaudo(servicoPadrao.getLaudo());

	}
}
