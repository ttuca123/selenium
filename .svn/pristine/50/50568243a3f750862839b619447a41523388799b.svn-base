package servicos;

import org.junit.Assert;
import org.openqa.selenium.By;

import pages.ItemAtendimentoPage;
import pages.MenuPage;
import pages.validacao.ValidacaoAtendimento;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumAreaTipoPadrao;
import enumerators.EnumTipoConstrucao;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPadrao;
import enumerators.EnumTipoPagamento;
import enumerators.EnumTipoPiso;
import frames.FramePrincipalPage;

public class BtpSrv007VerificacaoDadosCadastrais extends ServicoPadrao
{

	private static String numEconomiaComercial = Util.gerarNumero(10).toString();

	private static String numEconomiaResidencial = Util.gerarNumero(10)
			.toString();

	private static String NUM_PONTOS_UTILIZACAO = "20";

	private static String AREA_CONSTRUIDA = Util
			.converterFormatoStringReal(EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

	private String MSG_VALIDACAO_SERVICO = "O serviço 007 não pode ser registrado para esse imóvel. Em seu lugar, registre o serviço 001 - REVISÃO DE DADOS CADASTRAIS.";

	@Override
	public void preValidar(ServicoPadrao servicoPadrao)
	{
		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:
			{
				Assert.assertTrue(FramePrincipalPage
						.mensagemExibida(MSG_VALIDACAO_SERVICO));

				servicoPadrao.setExecutarSolicitacao(false);

				break;
			}
			default:
			{

			}
		}

	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		preencherDadosBci();

		if ( servicoPadrao.getLaudo().equals(EnumTipoLaudo.PROCEDENTE) )
		{
			servicoPadrao.getTiposPgtos().clear();

			servicoPadrao.getTiposPgtos().add(EnumTipoPagamento.SEM_CUSTO);

		}

		preencheLaudo(servicoPadrao.getLaudo());

	}

	public void preencherDadosBci()
	{

		DriverUtils.limparCampo(ItemAtendimentoPage.txtAreaConstruida);

		DriverUtils
				.escrever(ItemAtendimentoPage.txtAreaConstruida, AREA_CONSTRUIDA);

		DriverUtils.clicar(ItemAtendimentoPage.optJardim);

		DriverUtils
				.getDriver()
				.findElement(
						By.id("frmCadastro:subFormBaixaItemAtendimento:subFrmBaixa:lstBtpCategoriaComercial:_1"))
				.click();

		DriverUtils
				.getDriver()
				.findElement(
						By.id("frmCadastro:subFormBaixaItemAtendimento:subFrmBaixa:lstBtpCategoriaResidencial:_2"))
				.click();

		DriverUtils
				.getDriver()
				.findElement(
						By.id("frmCadastro:subFormBaixaItemAtendimento:subFrmBaixa:numEconomiasComerciais"))
				.sendKeys(numEconomiaComercial);

		DriverUtils
				.getDriver()
				.findElement(
						By.id("frmCadastro:subFormBaixaItemAtendimento:subFrmBaixa:numEconomiasResidenciais"))
				.sendKeys(numEconomiaResidencial);

		DriverUtils.escrever(ItemAtendimentoPage.txtPontosUtilizacao,
				NUM_PONTOS_UTILIZACAO);

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbContrucaoImovel,
				EnumTipoConstrucao.MADEIRA_PURA.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbTipoPiso,
				EnumTipoPiso.PAVIFLEX.getNomeAmigavel());

	}

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{
		DriverUtils.iterarTelaPrincipal();

		DriverUtils.clicar(MenuPage.menu);

		DriverUtils.clicar(MenuPage.menuAtendimento);

		DriverUtils.clicar(MenuPage.menu);

		MenuPage.subMenuConsultarImovelBci();

		ValidacaoAtendimento.verificarPadraoInformado(EnumTipoPadrao.MEDIO,
				servicoPadrao.getInscOrigem());

	}
}
