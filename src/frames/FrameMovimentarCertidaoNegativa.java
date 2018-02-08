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
import auxiliares.DataUtil;
import auxiliares.DriverUtils;
import auxiliares.Util;

/**
 * 
 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 27/10/2015 -
 *         13:41:00.
 *
 */
public class FrameMovimentarCertidaoNegativa extends PageBase
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

	@FindBy(how = How.ID, using = "txtCertidaoNomeColaborador")
	public static WebElement txtNomeColaborador;

	@FindBy(how = How.ID, using = "txtCertidaoCargo")
	public static WebElement txtCargo;

	@FindBy(how = How.ID, using = "cmdConsultarDebito")
	public static WebElement btnGerarCertidao;

	@FindBy(how = How.ID, using = "cmdConsultarDebito")
	public static WebElement btnConsultarCarta;

	@FindBy(how = How.ID, using = "cmdConfirmarImpressao")
	public static WebElement btnConfirmarImpressao;

	public FrameMovimentarCertidaoNegativa(WebDriver driver)
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

	public static void emitirCertidaoNegativa()

	{
		
		
		String competencia = DataUtil.getCompetenciaMesAnterior(false).toString();

		DriverUtils.escrever(txtCompetencia, competencia);

		DriverUtils.escrever(txtNomeColaborador,
				"Teste " + Util.gerarTextoAleatorio(30));

		DriverUtils.escrever(txtCargo, "Teste " + Util.gerarTextoAleatorio(10));

		DriverUtils.clicar(btnConsultarCarta);
		
		DriverUtils.delay(500);

		if(driver.findElements(By.id("cmdConfirmarImpressao")).size()>0){
			
			DriverUtils.clicar(btnConfirmarImpressao);

		}

		DriverUtils.delay(2000);
		
		concluirAtendimento();

	}

	public static FrameMovimentarCertidaoNegativa getFrameMovimentarCertidaoNegativa()

	{

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt("_blank")));

		return PageFactory.initElements(driver,
				FrameMovimentarCertidaoNegativa.class);

	}
}