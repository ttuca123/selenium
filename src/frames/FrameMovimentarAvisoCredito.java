package frames;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.MenuPage;
import pages.PageBase;
import auxiliares.Atendimento;
import auxiliares.DataUtil;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumSituacaoAnalise;
import enumerators.EnumTipoItem;
import enumerators.EnumTipoModoDevolucao;

public class FrameMovimentarAvisoCredito extends PageBase
{

	/********************** Constantes ***************************/

	private static final String AVISO_CANCELAMENTO = "Impossível continuar! O aviso de crédito do tipo CANCELAMENTO não poderá ser alterado via atendimento.";

	private static final String STA_INCLUIDO = "INCLUÍDO";

	private static final String STA_DEVOLVIDO = "DEVOLVIDO";

	private static final String DATA_ATUAL = DataUtil
			.converterDataFormatoddMMyyy(new Date());

	/***********************************************************/

	@FindBy(how = How.ID, using = "cmdSalvar")
	public static WebElement btnSalvar;

	@FindBy(how = How.CSS, using = Atendimento.POPUP_INFORMACAO_BOTAO_FECHAR)
	public static WebElement popupInformacaoBotaoFechar;

	@FindBy(how = How.LINK_TEXT, using = "Selecionar Tudo")
	public WebElement selecionarTudo;

	@FindBy(how = How.LINK_TEXT, using = "Selecionar Nenhum")
	public WebElement selecionarNenhum;

	@FindBy(how = How.ID, using = "btnIntegracao")
	public static WebElement btnAvisoCredito;

	@FindBy(how = How.ID, using = "cmdNovo")
	public static WebElement btnNovo;

	@FindBy(how = How.ID, using = "frmCadItemDevolucao:cadItemDevolucao")
	public static WebElement cmbItemDevolucao;

	@FindBy(how = How.ID, using = "frmCadModoDevolucao:cadModoDevolucao")
	public static WebElement cmbModoDevolucao;

	@FindBy(how = How.ID, using = "cmdInclusaoFaturaAvisoCredito")
	public static WebElement btnIncluirFaturaAvisoCredito;

	@FindBy(how = How.ID, using = "tblAcrFaturaLote:cmdObterAcrFatura")
	public static WebElement btnObterFatura;

	@FindBy(how = How.ID, using = "cmdConsultarAcrFatura")
	public static WebElement btnConsultarFatura;

	@FindBy(how = How.ID, using = "tblAcrRecebimentoLote:cmdObterAcrRecebimento")
	public static WebElement btnSelecionarRecPendente;

	@FindBy(how = How.ID, using = "tblDados:1")
	public static WebElement optPrimeiraFaturaAvisoCredito;

	@FindBy(how = How.ID, using = "cmdInclusaoRecebimentoPendenteAvisoCredito")
	public static WebElement btnRecPendente;

	@FindBy(how = How.ID, using = "cmdConsultarAcrRecebimento")
	public static WebElement btnConsultarRecPendente;

	@FindBy(how = How.ID, using = "tblAcrRecebimentoLote:cmdRetornarAcrRecebimento")
	public static WebElement btnVoltar;

	@FindBy(how = How.ID, using = "tblRecebimentoAvisoCredito:cmdOK")
	public static WebElement btnConfirmaRecebimentoPendente;

	@FindBy(how = How.ID, using = "cmdIncluir")
	public static WebElement btnSalvarTudo;

	@FindBy(how = How.ID, using = "tblFaturaAvisoCredito:cmdOK")
	public static WebElement btnConfirmaFaturaAvisoCredito;

	@FindBy(how = How.ID, using = "cmdFaturaAvisoCredito")
	public static WebElement btnPagarFaturas;

	@FindBy(how = How.ID, using = "cmdObterFaturaCompensar")
	public static WebElement btnObterFaturaCompensar;

	@FindBy(how = How.ID, using = "tblDados:cmdExcluir")
	public static WebElement btnExcluir;

	@FindBy(how = How.ID, using = "cmdSim")
	public static WebElement btnSim;

	@FindBy(how = How.ID, using = "tblDados:cmdAlterar")
	public static WebElement btnAlterar;

	@FindBy(how = How.ID, using = "cmdRetornarFaturaCompensar")
	public static WebElement btnVoltarFaturaCompensar;

	@FindBy(how = How.ID, using = "frmCadCodSituacaoAnalise:cadDatProcesso")
	public static WebElement cmbSituacaoAnalise;

	@FindBy(how = How.ID, using = "frmCadNumProcesso:cadNumProcesso")
	public static WebElement txtNumeroProcesso;

	@FindBy(how = How.ID, using = "frmCadDatProcesso:cadDatProcesso")
	public static WebElement txtDataProcesso;

	@FindBy(how = How.ID, using = "tblFaturaAvisoCredito:0")
	public static WebElement optPrimeiraFatura;

	@FindBy(how = How.XPATH, using = ".//*[@id='tblDados']/table/tbody/tr/td/table/tbody/tr[2]/td[14]")
	public static WebElement lblTipoStatus;

	@FindBy(how = How.XPATH, using = ".//*[@id='tblDados']/table/tbody/tr/td/table/tbody/tr[2]/td[11]")
	public static WebElement lblTipoDevolucao;

	@FindBy(how = How.XPATH, using = ".//*[@id='tblDados']/table/tbody/tr/td/table/tbody/tr[2]/td[15]")
	public static WebElement lblSituacaoAnalise;

	public FrameMovimentarAvisoCredito(WebDriver driver)
	{

		super(driver);
	}

	public void movimentarAvisoCredito(EnumTipoItem itemDevolucao,
			EnumTipoModoDevolucao tipoDevolucao) throws InterruptedException,
			IOException
	{

		DriverUtils.clicar(btnNovo);

		DriverUtils.esperarPorAjax();

		DriverUtils.selecionarComboPeloNome(cmbItemDevolucao,
				itemDevolucao.getNomeAmigavel());

		DriverUtils.esperarPorAjax();

		DriverUtils.selecionarComboPeloNome(cmbModoDevolucao,
				tipoDevolucao.getNomeAmigavel());

		DriverUtils.esperarPorAjax();

		switch (tipoDevolucao)
		{

			case EXCLUIR_RECEBIMENTO:

				getRecebimentoPendente();

				DriverUtils.clicar(btnSalvarTudo);

				DriverUtils.esperarPorAjax();

				Assert.assertEquals(lblTipoStatus.getText(), STA_INCLUIDO);

				for (WebElement elemento : driver.findElements(By
						.cssSelector("input[id^='tblDados:']")))
				{

					elemento.click();
					break;
				}

				DriverUtils.clicar(btnAlterar);

				DriverUtils.esperarPorAjax();

				List<String> mensagemRetorno = new ArrayList<String>();

				mensagemRetorno.add(AVISO_CANCELAMENTO);

				Util.verificarMensagem(mensagemRetorno);

				break;

			case COMPENSACAO_DEBITO:

				getRecebimentoPendente();

				DriverUtils.clicar(btnPagarFaturas);

				DriverUtils.esperarPorAjax();

				DriverUtils.clicar(btnObterFaturaCompensar);

				DriverUtils.esperarPorAjax();

				DriverUtils.avancarFrame();

				DriverUtils.clicar(btnConsultarFatura);

				DriverUtils.clicar(optPrimeiraFatura);

				DriverUtils.clicar(btnConfirmaFaturaAvisoCredito);

				DriverUtils.voltarFrame();

				DriverUtils.delay(2000);

				for (WebElement elemento : driver.findElements(By
						.cssSelector("input[id$='cadAflDatPagamento']")))
				{

					elemento.clear();
					elemento.sendKeys(DATA_ATUAL);

				}

				DriverUtils.clicar(selecionarTudo);

				DriverUtils.clicar(btnVoltarFaturaCompensar);

				DriverUtils.esperarPorAjax();

				DriverUtils.clicar(btnSalvarTudo);

				DriverUtils.esperarPorAjax();

				Assert.assertEquals(lblTipoStatus.getText(), STA_INCLUIDO);

				Assert.assertEquals(lblTipoDevolucao.getText(),
						tipoDevolucao.getNomeAmigavel());

				break;

			case CREDITO_FINANCEIRO:

				getRecebimentoPendente();

				DriverUtils.clicar(btnSalvarTudo);

				DriverUtils.esperarPorAjax();

				Assert.assertEquals(lblTipoStatus.getText(), STA_INCLUIDO);

				Assert.assertEquals(lblTipoDevolucao.getText(),
						tipoDevolucao.getNomeAmigavel());

				DriverUtils.clicar(optPrimeiraFaturaAvisoCredito);

				DriverUtils.clicar(btnAlterar);

				DriverUtils.esperarPorAjax();

				DriverUtils.selecionarComboPeloNome(cmbSituacaoAnalise,
						EnumSituacaoAnalise.PROCEDENTE.getNomeAmigavel());

				DriverUtils.clicar(btnSalvar);

				DriverUtils.esperarPorAjax();

				DriverUtils.delay(1000);

				Assert.assertEquals(lblTipoStatus.getText(), STA_DEVOLVIDO);

				Assert.assertEquals(lblSituacaoAnalise.getText(),
						EnumSituacaoAnalise.PROCEDENTE.getNomeAmigavel());

				Assert.assertEquals(lblTipoDevolucao.getText(),
						tipoDevolucao.getNomeAmigavel());

				break;
			case DEPOSITO_CONTA:
				// Depende do processamento em lote
				break;
			case ORDEM_PAGAMENTO:
				// Depende do processamento em lote

				break;
			case PAGAMENTO_CHEQUE:
				DriverUtils.delay(500);

				DriverUtils.escrever(txtNumeroProcesso, Util.gerarNumero(9999999)
						.toString());

				DriverUtils.escrever(txtDataProcesso,
						DataUtil.converterDataFormatoddMMyyy(new Date()));

				DriverUtils.esperarPorAjax();

				getRecebimentoPendente();

				DriverUtils.clicar(btnSalvarTudo);

				DriverUtils.esperarPorAjax();

				Assert.assertEquals(lblTipoStatus.getText(), STA_INCLUIDO);

				Assert.assertEquals(lblTipoDevolucao.getText(),
						tipoDevolucao.getNomeAmigavel());

				DriverUtils.clicar(optPrimeiraFaturaAvisoCredito);

				DriverUtils.clicar(btnAlterar);

				DriverUtils.esperarPorAjax();

				DriverUtils.selecionarComboPeloNome(cmbSituacaoAnalise,
						EnumSituacaoAnalise.PROCEDENTE.getNomeAmigavel());

				DriverUtils.clicar(btnSalvar);

				DriverUtils.esperarPorAjax();

				DriverUtils.delay(1000);

				Assert.assertEquals(lblTipoStatus.getText(), STA_DEVOLVIDO);

				Assert.assertEquals(lblSituacaoAnalise.getText(),
						EnumSituacaoAnalise.PROCEDENTE.getNomeAmigavel());

				Assert.assertEquals(lblTipoDevolucao.getText(),
						tipoDevolucao.getNomeAmigavel());

				break;

			default:
				break;

		}
		concluirAtendimento();

	}

	private void getRecebimentoPendente()
	{

		DriverUtils.clicar(btnRecPendente);

		DriverUtils.esperarPorAjax();

		DriverUtils.clicar(btnSelecionarRecPendente);

		DriverUtils.esperarPorAjax();

		DriverUtils.avancarFrame();

		DriverUtils.clicar(btnConsultarRecPendente);

		DriverUtils.clicar(selecionarTudo);

		DriverUtils.clicar(btnConfirmaRecebimentoPendente);

		DriverUtils.voltarFrame();

		DriverUtils.clicar(selecionarTudo);

		DriverUtils.clicar(btnVoltar);

		DriverUtils.esperarPorAjax();

	}

	public static void concluirAtendimento() throws InterruptedException
	{

		driver.switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(MenuPage.FRAME_PRINCIPAL_ACI)));

		DriverUtils.clicar(popupInformacaoBotaoFechar);

		DriverUtils.esperarPorAjax();

	}

	public static FrameMovimentarAvisoCredito getFrameMovimentarAvisoCredito()
			throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt("_blank")));

		DriverUtils.esperarPorAjax();

		return PageFactory.initElements(driver, FrameMovimentarAvisoCredito.class);

	}
}