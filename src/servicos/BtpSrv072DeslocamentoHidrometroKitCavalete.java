package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv072DeslocamentoHidrometroKitCavalete extends ServicoPadrao {

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico) {

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbInstalacaoAtualizar, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLocalInstalacaoMedidor, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProtecaoMedidor, 1);
	}
}
