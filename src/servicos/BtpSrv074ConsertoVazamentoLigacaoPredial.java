package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv074ConsertoVazamentoLigacaoPredial extends ServicoPadrao {

	@Override
	public void preencherDadosComplementares() throws Exception {

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.optPavimentoCalcada2, 1);
	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao) {
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.diametroLigacaoAgua, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtDuracaoConsertoVazamento,
				DURACAO_CONSERTO);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.ligacaoAguaAtualizar, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.localVazamento, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMaterialLigacaoAgua, 1);


		DriverUtils.escrever(ItemAtendimentoPage.lacreLigacaoAgua, NUMERO_LACRE_LIGACAO);

		preencheLaudo(servicoPadrao.getLaudo());

	}
}
