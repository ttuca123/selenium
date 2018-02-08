package frames;

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
import auxiliares.DriverUtils;
import enumerators.EnumStatusSegundaVia;

public class FrameMovimentarSegundaVia extends PageBase
{

	@FindBy(how = How.ID, using = "cmdSalvar")
	public static WebElement btnSalvar;

	@FindBy(how = How.CSS, using = Atendimento.POPUP_INFORMACAO_BOTAO_FECHAR)
	public static WebElement popupInformacaoBotaoFechar;

	@FindBy(how = How.LINK_TEXT, using = "Selecionar Tudo")
	public static WebElement selecionarTudo;

	@FindBy(how = How.LINK_TEXT, using = "Selecionar Nenhum")
	public static WebElement selecionarNenhum;

	@FindBy(how = How.ID, using = "tblFaturas:0")
	public static WebElement optPrimeiraFatura;

	@FindBy(how = How.ID, using = "tblFaturas:cmdImprimir")
	public static WebElement btnImprimirSegundaVia;

	@FindBy(how = How.ID, using = "cmdConsultar")
	public static WebElement btnConsultarCarta;

	@FindBy(how = How.ID, using = "conSegundaViaTipoSegundaVia:_0")
	public static WebElement optIndividual;

	@FindBy(how = How.ID, using = "conSegundaViaTipoSegundaVia:_1")
	public static WebElement optAgrupada;

	@FindBy(how = How.ID, using = "conSegundaViaTipoSegundaVia:_2")
	public static WebElement optPaga;

	public FrameMovimentarSegundaVia(WebDriver driver)
	{

		super(driver);
	}

	public void emitirSegundaVia(EnumStatusSegundaVia statusSegundaVia)
	{

		switch (statusSegundaVia)
		{
			case PAGA:
				DriverUtils.clicar(optPaga);

				DriverUtils.clicar(btnConsultarCarta);

				DriverUtils.esperarPorAjax();

				DriverUtils.clicar(selecionarTudo);

				DriverUtils.delay(1000);

				break;
			case INDIVIDUAL:

				DriverUtils.clicar(optIndividual);

				DriverUtils.clicar(btnConsultarCarta);

				DriverUtils.esperarPorAjax();

				DriverUtils.delay(1000);

				DriverUtils.clicar(optPrimeiraFatura);

				break;

			case AGRUPADO:

				DriverUtils.clicar(optAgrupada);

				DriverUtils.clicar(btnConsultarCarta);

				DriverUtils.esperarPorAjax();

				DriverUtils.clicar(selecionarTudo);

				DriverUtils.delay(1000);

				break;

			default:
				break;
		}

		DriverUtils.clicar(btnImprimirSegundaVia);

		DriverUtils.esperarPorAjax();

		DriverUtils.delay(1000);

		concluirAtendimento();

	}

	private static void concluirAtendimento()
	{

		driver.switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(MenuPage.FRAME_PRINCIPAL_ACI)));

		DriverUtils.clicar(popupInformacaoBotaoFechar);

		DriverUtils.esperarPorAjax();

	}

	public static FrameMovimentarSegundaVia getFrameMovimentarSegundaVia()
	{

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt("_blank")));

		return PageFactory.initElements(driver, FrameMovimentarSegundaVia.class);

	}
}