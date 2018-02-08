package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv266InstalacaoSistemaAlternativoMedicao extends ServicoPadrao{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico) {
	
		
		DriverUtils.escrever(ItemAtendimentoPage.leituraInformadaFiscal, LEITURA_MEDIDOR);
	
		DriverUtils.selecionarComboPeloIndice(ItemAtendimentoPage.ligacaoAguaAtualizar, 1);
		
		DriverUtils.selecionarComboPeloIndice(ItemAtendimentoPage.selectLimitadorConsumo, 1);
	
		
	}
}
