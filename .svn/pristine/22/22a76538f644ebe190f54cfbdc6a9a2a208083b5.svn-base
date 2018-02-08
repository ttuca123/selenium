package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv267RetiradaSistemaAlternativoMedicao extends ServicoPadrao{

	
	
	@Override
	public void preencherDadosBaixa(ServicoPadrao servico) {
		
		DriverUtils.escrever(ItemAtendimentoPage.cmbLeituraInformadaFiscal,
				LEITURA_MEDIDOR);
		
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);
		
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.selectLimitadorConsumo, 1);
}
}