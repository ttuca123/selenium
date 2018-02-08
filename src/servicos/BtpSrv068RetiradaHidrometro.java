package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv068RetiradaHidrometro extends ServicoPadrao {

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao) {

		DriverUtils.escrever(ItemAtendimentoPage.txtDataRetiradaMedidor,
				DATA_ATUAL);

		DriverUtils.escrever(ItemAtendimentoPage.txtLeituraMedidorRetirada,
				LEITURA_MEDIDOR);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbInstalacaoAtualizar, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMotivoRetiradaMedidor, 1);

	}

}
