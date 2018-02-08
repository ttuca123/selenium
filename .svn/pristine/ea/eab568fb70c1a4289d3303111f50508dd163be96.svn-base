package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import auxiliares.DriverUtils;

/**
 * Sample page
 */
public class PopupCancelarAtendimentoPage extends PageBase
{

	@FindBy(how = How.ID, using = "selCancelarAtendimento2")
	private WebElement motivo;

	@FindBy(how = How.ID, using = "txtCancelarAtendimento1_mskacento")
	private WebElement justificativa;

	@FindBy(how = How.ID, using = "btnSalvar")
	private WebElement btnSalvar;

	public PopupCancelarAtendimentoPage(WebDriver webDriver)
	{
		super(webDriver);
	}

	public void cancelarAtendimento()
	{

		Select selMotivo = new Select(motivo);
		selMotivo.selectByVisibleText("OUTROS");

		justificativa.sendKeys("CANCELANDO ATENDIMENTO");

		DriverUtils.clicar(btnSalvar);

		DriverUtils.delay(1000);

	}

}
