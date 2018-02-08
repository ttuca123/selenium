package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv335VisitaPreventivaGrandesConsumidores extends ServicoPadrao {

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao) {
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbVazamentoOculto, 1);

		preencheLaudo(servicoPadrao.getLaudo());
	}
}
