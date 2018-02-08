package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frames.FrameCancelarAtendimento;
import auxiliares.DriverUtils;

public class PontoAtendimentoPage extends PageBase
{

	@FindBy(how = How.ID, using = "tblAtendimentosPendentes:0:btnCancelar")
	private WebElement btnCancelarAtendimento;

	@FindBy(how = How.XPATH, using = ".//*[@id='tblAtendimentosPendentes:0:conAtpOutServico']")
	private WebElement btnFinalizarAtendimento;

	@FindBy(how = How.ID, using = "tblDadosPontoAtend:1")
	private WebElement pontoAtendimento;

	@FindBy(how = How.ID, using = "tblDadosPontoAtend:9")
	private WebElement pontoAtendimentoInterno;

	@FindBy(how = How.ID, using = "tblAtendimentosPendentes:cmdIncluir")
	public WebElement btnNovoAtendimento;

	@FindBy(how = How.ID, using = "tblAtendimentosPendentes:0:btnConcluir")
	private WebElement btnFinalizarAtendimentoPendente;

	@FindBy(how = How.ID, using = "cmdConfirmarConcluir")
	private WebElement btnConfirmarConcluir;

	public PontoAtendimentoPage(WebDriver driver)
	{
		super(driver);
	}

	public void selecionarPontoAtendimento()
	{

		Actions duploClick = new Actions(driver);
		duploClick.doubleClick(pontoAtendimento).perform();
		DriverUtils.delay(1000);

	}

	private void cancelarAtendimentoPendente()
	{
		DriverUtils.delay(3000);

		if ( DriverUtils.getDriver()
				.findElements(By.id("tblAtendimentosPendentes:0:btnCancelar")).size() > 0 )
		{

			DriverUtils.clicar(btnCancelarAtendimento);

			DriverUtils.delay(3000);

			DriverUtils.trocarFrame("_blank");

			FrameCancelarAtendimento popupCancelarAtendimento = PageFactory
					.initElements(driver, FrameCancelarAtendimento.class);

			popupCancelarAtendimento.cancelarAtendimento();

			driver.switchTo().defaultContent();

			WebDriverWait wait = new WebDriverWait(driver, 15);

			wait.until(ExpectedConditions.refreshed(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(MenuPage.FRAME_PRINCIPAL_ACI)));

		}

	}

	public void verificarLogofAtendimento()
	{

		DriverUtils.esperarPorAjax();

		if ( DriverUtils.getDriver().findElements(By.id("tblDadosPontoAtend:1"))
				.size() > 0 )
		{

			selecionarPontoAtendimento();
		}
		cancelarAtendimentoPendente();

		DriverUtils.clicar(btnNovoAtendimento);

		DriverUtils.getDriver().switchTo().defaultContent();
		DriverUtils.getDriver().switchTo().frame(MenuPage.FRAME_PRINCIPAL_ACI);

	}

}
