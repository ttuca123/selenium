package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.ConnectJDBC;
import auxiliares.DriverUtils;

public class BtpSrv071SubstituicaoHidrometro extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao) throws Exception
	{
		DriverUtils
				.escrever(ItemAtendimentoPage.txtDataRetiradaMedidor, DATA_ATUAL);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMotivoRetiradaMedidor, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoSubstituir, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.escrever(ItemAtendimentoPage.txtLeituraMedidorRetirada,
				LEITURA_MEDIDOR);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroMedidor,
				ConnectJDBC.getConsulta(SQL_NUMERO_MEDIDOR, new ConnectJDBC().createConnectionPrax()));

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLocalInstalacaoMedidor, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProtecaoMedidor, 1);
	}

}
