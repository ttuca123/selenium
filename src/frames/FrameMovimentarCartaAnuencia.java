package frames;

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
import auxiliares.BaseVars;
import auxiliares.DriverUtils;
import auxiliares.ServiceTestBase;
import auxiliares.Util;

/**
 * 
 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 27/10/2015 -
 *         13:40:14.
 *
 */
public class FrameMovimentarCartaAnuencia extends PageBase
{

	@FindBy(how = How.ID, using = "cmdSalvar")
	public static WebElement btnSalvar;

	@FindBy(how = How.CSS, using = Atendimento.POPUP_INFORMACAO_BOTAO_FECHAR)
	public static WebElement popupInformacaoBotaoFechar;

	@FindBy(how = How.LINK_TEXT, using = "Selecionar Tudo")
	public WebElement selecionarTudo;

	@FindBy(how = How.LINK_TEXT, using = "Selecionar Nenhum")
	public WebElement selecionarNenhum;

	@FindBy(how = How.ID, using = "competencia_mskcompetencia")
	public static WebElement txtCompetencia;

	@FindBy(how = How.ID, using = "txtNomeSupervisorAnuencia")
	public static WebElement txtNomeColaborador;

	@FindBy(how = How.ID, using = "txtCargoAnuencia")
	public static WebElement txtCargo;

	@FindBy(how = How.ID, using = "cmdConsultarDebito")
	public static WebElement btnGerarCertidao;

	@FindBy(how = How.ID, using = "cmdConsultarCarta")
	public static WebElement btnConsultarCarta;

	@FindBy(how = How.ID, using = "cmdPopupContrato")
	public static WebElement btnPopupContrato;

	@FindBy(how = How.ID, using = "btnConsultarContrato")
	public static WebElement btnConsultarContrato;

	@FindBy(how = How.ID, using = "conInsc_mskinteiro")
	public static WebElement txtInscricao;

	@FindBy(how = How.ID, using = "tblDados:btnOkContrato")
	public static WebElement btnOkContrato;

	public FrameMovimentarCartaAnuencia(WebDriver driver)
	{

		super(driver);
	}

	public static void concluirAtendimento()
	{

		driver.switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(MenuPage.FRAME_PRINCIPAL_ACI)));

		DriverUtils.clicar(popupInformacaoBotaoFechar);

		DriverUtils.esperarPorAjax();

	}

	public void emitirCartaAnuencia(String inscricao)
	{

		DriverUtils.clicar(btnPopupContrato);

		consultarContrato(inscricao);

		DriverUtils.escrever(txtNomeColaborador,
				"Teste " + Util.gerarTextoAleatorio(30));

		DriverUtils.escrever(txtCargo, "Teste " + Util.gerarTextoAleatorio(10));

		DriverUtils.clicar(btnConsultarCarta);

		DriverUtils.delay(2000);

		concluirAtendimento();

	}

	private static void consultarContrato(String inscricao)
	{
		DriverUtils.avancarFrame();

		DriverUtils.escrever(txtInscricao, inscricao);

		DriverUtils.clicar(btnConsultarContrato);

		DriverUtils.esperarPorAjax();

		DriverUtils.clicar(btnConsultarContrato);

		DriverUtils.esperarPorAjax();

		Integer qtdContratos = DriverUtils
				.getDriver()
				.findElements(
						By.xpath(".//*[@id='tblDados']/table[2]/tbody/tr[*]/td[*]")).size();

		DriverUtils.getDriver().findElement(By.id("tblDados:" + qtdContratos))
				.click();

		DriverUtils.clicar(btnOkContrato);

		DriverUtils.voltarFrame();

		DriverUtils.delay(500);

	}

	public static FrameMovimentarCartaAnuencia getFrameMovimentarCartaAnuencia()

	{

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt("_blank")));

		return PageFactory.initElements(driver, FrameMovimentarCartaAnuencia.class);

	}
}