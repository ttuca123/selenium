package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv106RealizacaoDescargaRedeAgua extends ServicoPadrao {

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico) {

		DriverUtils.escrever(ItemAtendimentoPage.txtDuracaoConsertoVazamento,
				DURACAO_CONSERTO);

		DriverUtils.escrever(ItemAtendimentoPage.txtPressao, DURACAO_CONSERTO);

	}
}
