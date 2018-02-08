package auxiliares;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.MenuPage;

public class DriverUtils
{

	private static WebDriver driver;

	public static WebDriver getDriver()
	{

		try
		{
			if ( driver == null )
			{

				DesiredCapabilities dc = new DesiredCapabilities();
				FirefoxProfile fp = new FirefoxProfile();

				dc.setCapability(FirefoxDriver.PROFILE, fp);
				dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());

				dc.setPlatform(Platform.valueOf("LINUX"));

				//Configuração do proxy para a nova instância do firefox
				
				fp.setPreference("network.proxy.type", 1);
				
				fp.setPreference("network.proxy.http", "localhost");

				fp.setPreference("network.proxy.http", "127.0.0.1");

				fp.setPreference("network.proxy.http", "*.int.cagece.com.br");

				fp.setPreference("network.proxy.http", "172.16.0.0/12");

				fp.setPreference("network.proxy.http", "*.cagece.com.br");

				RemoteWebDriver tmpRemoteWebDriver = new RemoteWebDriver(new URL(
						BaseVars.servidor.getGrid()), dc);

				driver = tmpRemoteWebDriver;

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return driver;

	}

	public static void fecharDriver()
	{

		if ( driver != null )
		{
			driver.quit();
			driver = null;
		}

	}

	public static void escrever(WebElement elemento, String texto)
	{

		buscarElementoPresente(elemento);
		elemento.sendKeys(texto);

	}

	public static String clicarMenu(WebElement menu1, String menu2)
	{

		if ( menu2 != null && driver.findElements(By.linkText(menu2)).size() == 0 )
		{
			clicar(menu1);

			return clicarMenu(driver.findElement(By.linkText(menu2)), null);
		}
		return null;
	}

	public static void clicar(WebElement elemento)
	{
		buscarElementoPresente(elemento);

		buscarElementoClicavel(elemento);

		elemento.click();

	}

	public static void limparCampo(WebElement elemento)
	{

		buscarElementoPresente(elemento);
		elemento.clear();
		delay(200);

	}

	public static void duploClique(WebElement elemento)
	{
		buscarElementoClicavel(elemento);

		elemento.click();

		elemento.click();
	}

	public static void duploCliqueComAjax(WebElement elemento)
	{

		buscarElementoClicavel(elemento);

		elemento.click();

		esperarPorAjax();

		elemento.click();

	}

	public static void esperarPorAjax()
	{

		try
		{

			delay(700);

			WebDriverWait wait = new WebDriverWait(driver, 480);

			wait.withMessage("Tempo para aguardar o ajax esgotado.");

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.id("loaderMessage")));

			delay(600);

		}
		catch (StaleElementReferenceException e)
		{

			delay(600);

			WebDriverWait wait = new WebDriverWait(driver, 480);

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.id("loaderMessage")));

			delay(500);
		}

	}

	public static void esperarPor(By by)

	{

		try
		{
			int qtdEspera = 0;

			do
			{
				Thread.sleep(100);
				if ( qtdEspera > 30 )
				{
					break;
				}
				qtdEspera++;
			}
			while (getDriver().findElements(by).size() == 0);
		}
		catch (InterruptedException e)
		{

			e.printStackTrace();
		}
	}

	public static void buscarElementoPresente(WebElement locator)
	{

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.withMessage("Elemento " + locator + " não encontrado");

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.visibilityOf(locator)));

		wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(locator)));

	}

	public static void buscarElementoClicavel(WebElement locator)
	{

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.withMessage("Elemento " + locator + " não clicável");

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.elementToBeClickable(locator)));

	}

	public static void selecionarComboPeloValor(WebElement elemento, Integer valor)
	{
		buscarElementoPresente(elemento);

		buscarElementoClicavel(elemento);

		Select select = new Select(elemento);

		select.selectByValue(valor.toString());

		esperarPorAjax();

	}

	public static void selecionarComboPeloNome(WebElement elemento, String texto)
	{
		buscarElementoPresente(elemento);

		buscarElementoClicavel(elemento);

		Select select = new Select(elemento);

		select.selectByVisibleText(texto);

		esperarPorAjax();

	}

	public static void selecionarComboPeloIndice(WebElement elemento, int indice)
	{

		buscarElementoClicavel(elemento);

		Select select = new Select(elemento);
		select.selectByIndex(indice);

		esperarPorAjax();

	}

	public static String getValor(WebElement elemento)
	{

		Select select = new Select(elemento);

		return select.getFirstSelectedOption().getAttribute("value");
	}

	public static String getValorCombo(WebElement elemento)
	{

		Select select = new Select(elemento);

		return select.getFirstSelectedOption().getText();
	}

	public static boolean isComboVazia(WebElement elemento)
	{

		Select select = new Select(elemento);

		return (select.getOptions().size() > 1 ? false : true);

	}

	public static void delay(long time)
	{

		try
		{
			Thread.sleep(time);
		}
		catch (InterruptedException e)
		{

			e.printStackTrace();
		}

	}

	/********************************* Métodos específicos para manipular frames e pages ************************/

	public static void iterarTelaPrincipal()
	{
		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> iterator = windowId.iterator();

		@SuppressWarnings("unused")
		String principal = iterator.next();
		String prax = iterator.next();

		driver.switchTo().window(prax);

		driver.switchTo().defaultContent();

	}

	public static void voltarFrame()
	{

		driver.switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(MenuPage.FRAME_PRINCIPAL_ACI)));

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt("_blank")));

	}

	public static void avancarFrame()
	{

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt("_blank")));

	}

	public static void trocarFrame(String frame)
	{

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(frame)));

	}

	public static void getTelaAtual()
	{
		DriverUtils.delay(500);

		driver.switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(MenuPage.FRAME_PRINCIPAL_ACI)));
	}
}
