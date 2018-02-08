package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv076ReclamacaoFaltaDagua extends ServicoPadrao {

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao) {
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);

		preencheLaudo(servicoPadrao.getLaudo());

	}

}
