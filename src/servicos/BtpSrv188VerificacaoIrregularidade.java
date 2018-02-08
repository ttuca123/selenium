package servicos;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.ItemAtendimentoPage;
import pages.MenuPage;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumFlags;
import enumerators.EnumTipoLaudo;

public class BtpSrv188VerificacaoIrregularidade extends ServicoPadrao
{

	private static final String NOME_FISCAL = Util.gerarTextoAleatorio(50);

	private String multa = null;

	private EnumFlags economiaDiferente;

	private EnumFlags baixaRenda;
	
	private EnumFlags isNegociadoCampanha;

	private int situacaoLigacaoAguaAtualizar;

	private EnumFlags qtdEconomiasDiferentes;

	private EnumFlags heReincidente;

	private EnumFlags situacaoLigacaoDiferente;

	private WebElement tipoIrregularidade;

	private WebElement numeroEconomia;

	private WebElement optCatDiferente;

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		isNegociadoCampanha = EnumFlags.NAO;
		
		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:

				economiaDiferente = EnumFlags.SIM;

				baixaRenda = EnumFlags.NAO;

				situacaoLigacaoAguaAtualizar = 1;

				situacaoLigacaoDiferente = EnumFlags.NAO;

				heReincidente = EnumFlags.NAO;

				qtdEconomiasDiferentes = EnumFlags.NAO;

				tipoIrregularidade = ItemAtendimentoPage.optAutenticacaoAdulterada;

				numeroEconomia = ItemAtendimentoPage.txtNumEconomiasComerciais;

				break;
			case 2:

				economiaDiferente = EnumFlags.SIM;

				baixaRenda = EnumFlags.SIM;

				situacaoLigacaoAguaAtualizar = 1;

				situacaoLigacaoDiferente = EnumFlags.NAO;

				heReincidente = EnumFlags.NAO;

				qtdEconomiasDiferentes = EnumFlags.NAO;

				tipoIrregularidade = ItemAtendimentoPage.optMedidorDesconectado;

				numeroEconomia = ItemAtendimentoPage.txtNumEconomiasResidenciais;

				break;
			case 3:

				tipoIrregularidade = ItemAtendimentoPage.optByPass;

				economiaDiferente = EnumFlags.SIM;

				baixaRenda = EnumFlags.SIM;

				situacaoLigacaoAguaAtualizar = 1;

				situacaoLigacaoDiferente = EnumFlags.SIM;

				heReincidente = EnumFlags.NAO;

				qtdEconomiasDiferentes = EnumFlags.NAO;

				numeroEconomia = ItemAtendimentoPage.txtNumEconomiasResidenciais;

				break;

			case 4:
			case 10:

				tipoIrregularidade = ItemAtendimentoPage.optViolacaoMedidor;

				economiaDiferente = EnumFlags.NAO;

				baixaRenda = EnumFlags.NAO;

				situacaoLigacaoAguaAtualizar = 1;

				situacaoLigacaoDiferente = EnumFlags.NAO;

				heReincidente = EnumFlags.NAO;

				qtdEconomiasDiferentes = EnumFlags.NAO;

				break;
			case 5:

				tipoIrregularidade = ItemAtendimentoPage.optViolacaoLacreMedidor;

				economiaDiferente = EnumFlags.NAO;

				baixaRenda = EnumFlags.NAO;

				situacaoLigacaoAguaAtualizar = 1;

				situacaoLigacaoDiferente = EnumFlags.NAO;

				heReincidente = EnumFlags.NAO;

				qtdEconomiasDiferentes = EnumFlags.NAO;

				break;

			case 6:

				tipoIrregularidade = ItemAtendimentoPage.optLigClandestina;

				economiaDiferente = EnumFlags.NAO;

				baixaRenda = EnumFlags.SIM;

				situacaoLigacaoAguaAtualizar = 1;

				situacaoLigacaoDiferente = EnumFlags.NAO;

				heReincidente = EnumFlags.NAO; 

				qtdEconomiasDiferentes = EnumFlags.NAO;

				break;
			case 7:
				
				tipoIrregularidade = ItemAtendimentoPage.optLancPluvialEsgoto;

				economiaDiferente = EnumFlags.NAO;

				baixaRenda = EnumFlags.NAO;

				situacaoLigacaoAguaAtualizar = 1;

				situacaoLigacaoDiferente = EnumFlags.NAO;

				heReincidente = EnumFlags.NAO;

				qtdEconomiasDiferentes = EnumFlags.NAO;

				break;

			case 8:

				tipoIrregularidade = ItemAtendimentoPage.optDerivacaoPredialEsgoto;

				economiaDiferente = EnumFlags.NAO;

				baixaRenda = EnumFlags.NAO;

				situacaoLigacaoAguaAtualizar = 1;

				situacaoLigacaoDiferente = EnumFlags.NAO;

				heReincidente = EnumFlags.NAO;

				qtdEconomiasDiferentes = EnumFlags.NAO;

				break;

			case 9:

				tipoIrregularidade = ItemAtendimentoPage.optByPass;

				economiaDiferente = EnumFlags.NAO;

				baixaRenda = EnumFlags.NAO;

				situacaoLigacaoAguaAtualizar = 1;

				situacaoLigacaoDiferente = EnumFlags.NAO;

				heReincidente = EnumFlags.SIM;

				qtdEconomiasDiferentes = EnumFlags.NAO;

				break;

			default:
				break;

		}
		
		

		gerarTermoOcorrencia(servicoPadrao.getLaudo());

		preencheLaudo(servicoPadrao.getLaudo());
	}

	private void gerarTermoOcorrencia(EnumTipoLaudo tipoLaudo)
	{

		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbNegociadoCampanha,
				isNegociadoCampanha.getNomeAmigavel());		
		
		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbClassificacaoEconomiaDiferente,
				economiaDiferente.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbClassificacaoBaixaRendaIndevida,
				baixaRenda.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbExisteTermoOcorrencia,
				heReincidente.getNomeAmigavel());

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar,
				situacaoLigacaoAguaAtualizar);

		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbQtdEconomiasDiferentes,
				qtdEconomiasDiferentes.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbClienteReincidente,
				heReincidente.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbSituacaoLigacaoDiferente,
				situacaoLigacaoDiferente.getNomeAmigavel());

		if ( optCatDiferente != null )
		{

			DriverUtils.clicar(optCatDiferente);

		}

		if ( qtdEconomiasDiferentes.equals(EnumFlags.SIM) )
		{
			DriverUtils.limparCampo(numeroEconomia);

			DriverUtils.escrever(numeroEconomia, "1");

		}

		if ( tipoLaudo.equals(EnumTipoLaudo.PROCEDENTE) )
		{

			DriverUtils.clicar(tipoIrregularidade);

			DriverUtils.clicar(ItemAtendimentoPage.btnGerarTermoOcorrencia);

			DriverUtils.avancarFrame();

			DriverUtils.esperarPorAjax();

			DriverUtils.escrever(ItemAtendimentoPage.txtDetalharIrregularidade,
					"PROCEDENTE " + Util.gerarTextoAleatorio(10));

			DriverUtils.escrever(ItemAtendimentoPage.txtNomeFiscal, NOME_FISCAL);

			DriverUtils.escrever(ItemAtendimentoPage.txtNumeroTermoOcorrencia,
					NUMERO_TERMO_OCORRENCIA + Util.gerarNumero(100));

			multa = ItemAtendimentoPage.lblTermoTotalMulta.getText();

			finalizarVerificacaoIrregularidade();

		}

	}

	private void finalizarVerificacaoIrregularidade()
	{

		DriverUtils.clicar(ItemAtendimentoPage.btnSalvar);

		DriverUtils.getDriver().switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(MenuPage.FRAME_PRINCIPAL_ACI)));

		DriverUtils.esperarPorAjax();

		Assert.assertEquals(multa,
				ItemAtendimentoPage.txtValorMultaTotal.getAttribute("value"));

	}

}
