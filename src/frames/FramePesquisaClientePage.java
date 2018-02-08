package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pages.PageBase;
import auxiliares.Atendimento;
import auxiliares.DriverUtils;

public class FramePesquisaClientePage extends PageBase
{

	@FindBy(how = How.ID, using = Atendimento.POPUP_PESQUISA_CLIENTE_INSCRICAO)
	public static WebElement inscricaoCliente;

	@FindBy(how = How.ID, using = Atendimento.POPUP_PESQUISA_CLIENTE_BTN_CONSULTAR)
	public static WebElement btnConsultar;

	@FindBy(how = How.ID, using = "tblDados:0")
	public static WebElement primeiraEmpresa;

	@FindBy(how = How.ID, using = Atendimento.POPUP_PESQUISA_CLIENTE_BTN_OK)
	private static WebElement btnFecharPesquisa;

	public FramePesquisaClientePage(WebDriver driver)
	{
		super(driver);
	}

	public static void consultarCliente(String inscricao)
	{

		DriverUtils.escrever(inscricaoCliente, inscricao);

		DriverUtils.clicar(btnConsultar);
		DriverUtils.esperarPorAjax();

		WebElement primeiroCliente = DriverUtils.getDriver().findElement(
				By.cssSelector("input[id^='tblDados:']"));

		DriverUtils.clicar(primeiroCliente);

		DriverUtils.clicar(btnFecharPesquisa);

		DriverUtils.esperarPorAjax();
	}

}
