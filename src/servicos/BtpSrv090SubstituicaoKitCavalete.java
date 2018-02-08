package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;


public class BtpSrv090SubstituicaoKitCavalete extends ServicoPadrao {
	@Override
	public void preencherDadosBaixa(ServicoPadrao servico) {
		
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbInstalacaoAtualizar, 1);
		
		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);
		
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProtecaoMedidor, 1);
	}
}
