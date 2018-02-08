package frames;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.MenuPage;
import pages.PageBase;
import auxiliares.Atendimento;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumTipoItem;
import enumerators.EnumTipoProduto;

/**
 * 
 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 27/10/2015 -
 *         13:41:30.
 *
 */
public class FrameMovimentarRecAntecipado extends PageBase
{

	@FindBy(how = How.ID, using = "cmdSalvar")
	public static WebElement btnSalvar;

	@FindBy(how = How.CSS, using = Atendimento.POPUP_INFORMACAO_BOTAO_FECHAR)
	public static WebElement popupInformacaoBotaoFechar;

	@FindBy(how = How.LINK_TEXT, using = "Selecionar Nenhum")
	public WebElement selecionarNenhum;

	@FindBy(how = How.ID, using = "cmdCalPreco")
	public static WebElement btnCalcularPreco;

	@FindBy(how = How.ID, using = "tblDois:0:conVolume")
	public static WebElement txtVolAgua;

	@FindBy(how = How.ID, using = "tblDois:1:conVolume")
	public static WebElement txtVolEsgoto;

	@FindBy(how = How.ID, using = "btnAdicionar")
	public static WebElement btnAdicionar;

	@FindBy(how = How.ID, using = "btnMarcarTodosLanc")
	public static WebElement btnMarcarTodosLanc;

	public FrameMovimentarRecAntecipado(WebDriver driver)
	{

		super(driver);
	}

	public String movimentarRecebimentoAntecipado(EnumTipoItem itemDevolucao)

	{

		String valorTotal = "";

		switch (itemDevolucao)
		{
			case AGUA:

				preencherProduto(EnumTipoProduto.AGUA);

				break;
			case ESGOTO:

				preencherProduto(EnumTipoProduto.ESGOTO);

				break;
			case AGUA_ESGOTO:

				preencherProduto(EnumTipoProduto.AGUA);

				preencherProduto(EnumTipoProduto.ESGOTO);

				break;
			case SERVICO:

				preencherServico();

				break;

			case AGUA_ESGOTO_SERVICO:

				preencherProduto(EnumTipoProduto.AGUA);

				preencherProduto(EnumTipoProduto.ESGOTO);

				preencherServico();

				break;

			case ESGOTO_SERVICO:

				preencherProduto(EnumTipoProduto.ESGOTO);

				preencherServico();

				break;
			case AGUA_SERVICO:

				preencherProduto(EnumTipoProduto.AGUA);

				preencherServico();

				break;

			default:
				break;
		}

		DriverUtils.clicar(btnCalcularPreco);

		DriverUtils.esperarPorAjax();

		DriverUtils.clicar(btnSalvar);

		DriverUtils.esperarPorAjax();

		List<String> mensagem = new ArrayList<String>();

		mensagem.add("Fatura gerado com sucesso!");

		Util.verificarMensagem(mensagem);

		WebElement txtValorTotal = driver.findElement(By
				.cssSelector("span[id*='fatVlrTotalFatura']"));

		valorTotal = txtValorTotal.getText().trim();

		concluirAtendimento();

		return valorTotal;

	}

	private static void isElementosProdutoPresente()
	{

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.withMessage("Elementos da tabela produto não encontrados");

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.id("pnlConteudoProduto"))));

	}

	private static void isElementosServicoPresente()
	{

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.withMessage("Elementos da tabela produto não encontrados");

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.id("pnlConteudoServico"))));

	}

	private static void preencherServico()
	{

		isElementosServicoPresente();

		DriverUtils.esperarPorAjax();

		DriverUtils.clicar(btnAdicionar);

		DriverUtils.esperarPorAjax();

		preencherLancamentoFatura();

	}

	private static void preencherProduto(EnumTipoProduto produto)
	{

		isElementosProdutoPresente();

		List<WebElement> listaProdutos = DriverUtils.getDriver().findElements(
				By.xpath(".//*[@id='tblDois']/table[2]/tbody/tr[*]/td[2]"));

		int i = 0;

		DriverUtils.esperarPorAjax();

		for (WebElement elemento : listaProdutos)
		{

			if ( produto.getNomeAmigavel().equals(elemento.getText()) )
			{

				DriverUtils.clicar(DriverUtils.getDriver().findElement(
						By.xpath(".//*[@id='tblDois:" + i + "']")));

				DriverUtils
						.escrever(
								DriverUtils.getDriver().findElement(
										By.xpath(".//*[@id='tblDois:" + i
												+ ":conVolume_mskinteiro']")), Util.gerarNumero(50)
										.toString());

			}
			i++;
		}

	}

	private void concluirAtendimento()
	{

		driver.switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(MenuPage.FRAME_PRINCIPAL_ACI)));

		DriverUtils.clicar(popupInformacaoBotaoFechar);

		DriverUtils.esperarPorAjax();

	}

	private static void preencherLancamentoFatura()
	{

		for (WebElement elemento : driver.findElements(By
				.cssSelector("select[id$='cbxNovoLançamentoFatura']")))
		{

			DriverUtils.selecionarComboPeloIndice(elemento, Util.gerarNumero(20));

		}
		
		DriverUtils.esperarPorAjax();

		for (WebElement elemento : driver.findElements(By
				.cssSelector("input[id$='txtCadVlrTotalLancamento_mskmoeda']")))
		{

			DriverUtils
					.escrever(elemento, Util.gerarNumero(60).toString() + Keys.TAB);

		}

		DriverUtils.delay(1000);

		DriverUtils.clicar(btnMarcarTodosLanc);

		DriverUtils.esperarPorAjax();

	}

}