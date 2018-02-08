package frames;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pages.PageBase;
import auxiliares.DriverUtils;
import auxiliares.Util;

/**
 * 
 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 27/10/2015 - 13:39:54.
 *
 */
public class FrameGerarTermoOcorrencia extends PageBase
{

	private static final String NUMERO_TERMO = Util.gerarNumero(999999)
			.toString();

	@FindBy(how = How.ID, using = "frm1:txtNumeroTermo_mskInteiro")
	public static WebElement txtNumeroTermo;

	public FrameGerarTermoOcorrencia(WebDriver driver)
	{

		super(driver);
	}

	public void movimentarTermoOcorrencia() throws InterruptedException,
			IOException
	{

		DriverUtils.escrever(txtNumeroTermo, NUMERO_TERMO);

	}

}