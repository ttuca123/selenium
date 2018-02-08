package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv269AlteracaoHidrometroInstalado extends ServicoPadrao{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico) {

		
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbInstalacaoAtualizar, 1);
		
		DriverUtils.escrever(
				ItemAtendimentoPage.leituraMedidorInstalacao, LEITURA_MEDIDOR);
		
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.localInstalacaoMedidor, 2);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.protecaoMedidor, 1);
		

	}
	
}
