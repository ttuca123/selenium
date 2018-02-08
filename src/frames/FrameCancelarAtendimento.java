package frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import pages.PageBase;
import auxiliares.DriverUtils;

/**
 * Sample page
 */
public class FrameCancelarAtendimento extends PageBase
{

	@FindBy(how = How.ID, using = "selCancelarAtendimento2")
	private WebElement motivo;

	@FindBy(how = How.ID, using = "txtCancelarAtendimento1_mskacento")
	private WebElement justificativa;

	@FindBy(how = How.ID, using = "btnSalvar")
	private WebElement btnSalvar;

	public FrameCancelarAtendimento(WebDriver webDriver)
	{
		super(webDriver);
	}

	public void cancelarAtendimento()
	{

		Select selMotivo = new Select(motivo);
		selMotivo.selectByVisibleText("OUTROS");
		
		DriverUtils.escrever(justificativa, "CANCELANDO ATENDIMENTO");		

		DriverUtils.clicar(btnSalvar);



	}

}
