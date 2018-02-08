package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import enumerators.EnumFlags;

public class BtpSrv295VerificacaoConsumoElevado extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:
			{

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbConsumoReal, EnumFlags.SIM.getCodigo());

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbDesperdicio, EnumFlags.SIM.getCodigo());

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbDistribConsumo, EnumFlags.SIM.getCodigo());

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbErroLeitura, EnumFlags.SIM.getCodigo());

				DriverUtils.escrever(ItemAtendimentoPage.cmbLeituraInformadaFiscal,
						LEITURA_MEDIDOR);

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbTestouVazamentoOculto,
						EnumFlags.SIM.getCodigo());

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbVazamentoOculto, EnumFlags.SIM.getCodigo());

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbVazamentoVisivel, EnumFlags.SIM.getCodigo());

				break;
			}
			case 2:
			{

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbConsumoReal, EnumFlags.SIM.getCodigo());

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbDesperdicio, EnumFlags.NAO.getCodigo());

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbDistribConsumo, EnumFlags.NAO.getCodigo());

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbErroLeitura, EnumFlags.NAO.getCodigo());

				DriverUtils.escrever(ItemAtendimentoPage.cmbLeituraInformadaFiscal,
						LEITURA_MEDIDOR);

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbTestouVazamentoOculto,
						EnumFlags.NAO.getCodigo());

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbVazamentoOculto, EnumFlags.NAO.getCodigo());

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbVazamentoVisivel, EnumFlags.NAO.getCodigo());

				break;
			}
			default:
			{

			}
		}

		preencheLaudo(servicoPadrao.getLaudo());
	}

}
