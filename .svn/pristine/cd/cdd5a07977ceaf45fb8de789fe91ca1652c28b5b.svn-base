package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.ConnectJDBC;
import auxiliares.DriverUtils;

public class BtpSrv069InstalacaoHidrometro extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico) throws Exception
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLocalInstalacaoMedidor, 1);

		DriverUtils.escrever(ItemAtendimentoPage.cmbLacreLigacaoAgua,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.escrever(ItemAtendimentoPage.txtDataInstalacaoMedidor,
				DATA_ATUAL);

		DriverUtils.escrever(ItemAtendimentoPage.txtLeituraMedidorInstalacao,
				LEITURA_MEDIDOR);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroMedidor,
				ConnectJDBC.getConsulta(SQL_NUMERO_MEDIDOR, new ConnectJDBC().createConnectionPrax()));

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProtecaoMedidor, 1);

	}
}
