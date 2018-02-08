package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import auxiliares.DriverUtils;
import enumerators.EnumUsuario;

public abstract class PageBase
{

	private static EnumUsuario usuarioLogado;

	protected static WebDriver driver;

	public PageBase(WebDriver driver)
	{
		PageBase.driver = driver;
	}

	public String getTitle()
	{
		return driver.getTitle();
	}

	public static void setUsuarioLogado(EnumUsuario usuario)
	{
		usuarioLogado = usuario;
	}

	public static EnumUsuario getUsuarioLogado()
	{

		return usuarioLogado;
	}

	protected static void setTelaAtendimentoPage()
	{

		WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(MenuPage.FRAME_PRINCIPAL_ACI)));

	}

}
