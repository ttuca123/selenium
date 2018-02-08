package servicos;

import java.util.Date;

import pages.AtendimentoPage;
import pages.ItemAtendimentoPage;
import auxiliares.ConnectJDBC;
import auxiliares.DataUtil;
import auxiliares.DriverUtils;

public class BtpSrv288SubstituicaoHidrometroParaVerificacao extends
		ServicoPadrao
{

	@Override
	public void preencherDadosComplementares() throws Exception
	{

		String data = DataUtil.converterDataFormatoddMMyyy(DataUtil
				.adicionarDiasEmUmaData(new Date(), 1));

		DriverUtils.escrever(AtendimentoPage.txtDtPrevisao, data);

	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico) throws Exception
	{

		DriverUtils.escrever(ItemAtendimentoPage.dataRetiradaMedidor, DATA_ATUAL);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbInstalacaoSubstituir, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtLeituraMedidorRetirada,
				LEITURA_MEDIDOR);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.motivoRetiradaMedidor, 2);

		DriverUtils.escrever(ItemAtendimentoPage.cmbLacreLigacaoAgua,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroMedidor,
				ConnectJDBC.getConsulta(SQL_NUMERO_MEDIDOR, new ConnectJDBC().createConnectionPrax()));

	}
}
