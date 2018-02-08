package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv303VerificacaoBaixaPressao extends ServicoPadrao {

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico) {

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);
		DriverUtils.clicar(ItemAtendimentoPage.optPavimentoCalcada);

		DriverUtils.clicar(ItemAtendimentoPage.optPavimentoAsfalto);

		preencheLaudo(servico.getLaudo());
	}
}
