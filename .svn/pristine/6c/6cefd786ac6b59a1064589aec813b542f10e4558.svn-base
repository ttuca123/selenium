package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import auxiliares.BaseVars;
import auxiliares.DriverUtils;
import auxiliares.ServiceTestBase;

/**
 * Sample page
 */
public class AcessoPage extends PageBase
{

	@FindBy(how = How.ID, using = "entradaSistema")
	@CacheLookup
	public static WebElement linkLogin;

	@FindBy(how = How.ID, using = "autUsuario_minusculo")
	@CacheLookup
	public static WebElement usuario;

	@FindBy(how = How.ID, using = "autSenha_minusculo")
	@CacheLookup
	public static WebElement senha;

	@FindBy(how = How.ID, using = "cmdEntrar")
	@CacheLookup
	public static WebElement btnEntrar;

	@FindBy(how = How.ID, using = "tblDados:0:cmdEntrar")
	@CacheLookup
	public static WebElement sistemaPrax;

	@SuppressWarnings("static-access")
	public AcessoPage(WebDriver webDriver)
	{
		super(webDriver);
		this.driver = webDriver;
	}

	public static MenuPage logar()
	{

		ServiceTestBase.inicializarPages();

		if ( DriverUtils.getDriver().getCurrentUrl().equals("about:blank") )
		{

			DriverUtils.getDriver().get(BaseVars.servidor.getUrl());

			DriverUtils.clicar(linkLogin);

			Set<String> windowId = DriverUtils.getDriver().getWindowHandles();
			Iterator<String> iterator = windowId.iterator();

			@SuppressWarnings("unused")
			String principal = iterator.next();
			String prax = iterator.next();

			DriverUtils.getDriver().switchTo().window(prax);

			DriverUtils.getDriver().manage().window().maximize();

			DriverUtils.delay(500);
			DriverUtils.escrever(usuario, getUsuarioLogado().getUsuario());
			DriverUtils.escrever(senha, getUsuarioLogado().getSenha());
			DriverUtils.clicar(btnEntrar);
			DriverUtils.clicar(sistemaPrax);
			DriverUtils.delay(1000);
		}
		else
		{

			DriverUtils.iterarTelaPrincipal();

			if ( DriverUtils.getDriver()
					.findElements(By.xpath(".//*[@id='geral']/div[1]/div[2]/b")).size() > 0
					&& !AcessoPage
							.getUsuarioLogado()
							.name()
							.equals(
									DriverUtils
											.getDriver()
											.findElement(
													By.xpath(".//*[@id='geral']/div[1]/div[2]/b"))
											.getText()) )
			{

				DriverUtils.fecharDriver();

				return logar();

			}

		}

		return PageFactory.initElements(driver, MenuPage.class);

	}
}
