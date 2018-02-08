package frames;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.MenuPage;
import pages.PageBase;
import pages.validacao.ValidacaoAtendimento;
import auxiliares.Atendimento;
import auxiliares.DriverUtils;
import auxiliares.Util;

public class FrameTransferenciaDebitos extends PageBase
{

	private static final String MSG_TRANSFERENCIA_COM_SUCESSO = "Transferência executada com sucesso.";

	@FindBy(how = How.ID, using = "frmParametroConsultaCadastro:frm6:cbMotivoMovimentacao")
	public static WebElement selectMotivoMovimentacao;

	@FindBy(how = How.ID, using = "cmdSalvar")
	public static WebElement btnSalvar;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[2]")
	public static WebElement btnFechar;

	@FindBy(how = How.LINK_TEXT, using = "Selecionar Tudo")
	public WebElement selecionarTudo;

	@FindBy(how = How.LINK_TEXT, using = "Selecionar Nenhum")
	public WebElement selecionarNenhum;

	@FindBy(how = How.ID, using = "dadosConsulta:btpPesqContratoDestino")
	public WebElement pesquisaContratoDestino;

	@FindBy(how = How.ID, using = "conInsc_mskinteiro")
	public WebElement inscricao;

	@FindBy(how = How.ID, using = "btnConsultarContrato")
	public WebElement btnConsultarContrato;

	@FindBy(how = How.ID, using = "tblDados:1")
	public WebElement primeiroContrato;

	@FindBy(how = How.ID, using = "tblDados:btnOkContrato")
	public WebElement btnOkConsultarContrato;

	@FindBy(how = How.ID, using = "dadosConsulta:btnConsultarContratos")
	public WebElement btnConsultarContratos;

	@FindBy(how = How.ID, using = "dadosContrato:selectTrdCodTipoTranferencia")
	public WebElement optSelecionarContrato;

	@FindBy(how = How.ID, using = "tblContratosFaturadd0")
	public WebElement btnExibirContratos;

	@FindBy(how = How.ID, using = "cmdMarcarTodosFatura")
	public WebElement selecionarFaturas;

	

	@FindBy(how = How.ID, using = "tblContratosFatura:0:tabelaFatura:0")
	public WebElement primeiraFatura;

	@FindBy(how = How.CSS, using = Atendimento.POPUP_INFORMACAO_BOTAO_FECHAR)
	public static WebElement popupInformacaoBotaoFechar;

	@FindBy(how = How.ID, using = "tblContratosFatura:cadValorTotalFatura")
	public static WebElement lblTotalDebitoFatura;

	@FindBy(how = How.ID, using = "tblContratosLancamento:cadValorTotalLancamento")
	public static WebElement lblTotalDebitoLancamentoFuturo;

	@FindBy(how = How.ID, using = "cadValorTotalTransferencia") 
	public static WebElement lblTotalDebitoTransferencia;

	public FrameTransferenciaDebitos(WebDriver driver)
	{
		super(driver);
	}

	private void verificarFrameAtual()
	{

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.withMessage("Elemento no preenchimento do contrato não encontrado");

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
				.id("dadosConsulta:btpPesqContratoDestino")));

	}

	public void pesquisarContratoDestino(String inscDestino)

	{
		try
		{
			verificarFrameAtual();

		}
		catch (StaleElementReferenceException e)
		{

			verificarFrameAtual();
		}

		String tabelaContrato = ".//*[@id='tblDados']/table[2]/tbody/tr[*]/td[1]";

		DriverUtils.clicar(pesquisaContratoDestino);
		DriverUtils.esperarPorAjax();

		DriverUtils.avancarFrame();

		DriverUtils.escrever(inscricao, inscDestino);
		DriverUtils.clicar(btnConsultarContrato);
		DriverUtils.esperarPorAjax();

		int qtdContratos = DriverUtils.getDriver()
				.findElements(By.xpath(tabelaContrato)).size();

		DriverUtils.getDriver().findElement(By.id("tblDados:" + qtdContratos))
				.click();

		DriverUtils.clicar(btnOkConsultarContrato);

		DriverUtils.voltarFrame();

		DriverUtils.selecionarComboPeloIndice(optSelecionarContrato, 1);

		DriverUtils.clicar(btnConsultarContratos);

		DriverUtils.esperarPorAjax();

	}

	public void exibirContratos()
	{

		DriverUtils.clicar(btnExibirContratos);

		DriverUtils.esperarPorAjax();

	}

	public void transferirFaturasParcialmente(ValidacaoAtendimento validacao)
	{

		DriverUtils.clicar(selecionarFaturas);

		DriverUtils.esperarPorAjax();

		DriverUtils.clicar(primeiraFatura);

		DriverUtils.esperarPorAjax();

		transferirFaturas(validacao);

	}

	
	@SuppressWarnings("static-access")
	public void transferirFaturas(ValidacaoAtendimento validacao)
	{

		Double valorTotalTransferencia = verificarSomaFaturas();

		validacao.setTotalDebitoContratoOrigem(validacao
				.getTotalDebitoContratoOrigem() - valorTotalTransferencia);

		validacao.setTotalDebitoContratoDestino(valorTotalTransferencia);

		DriverUtils.clicar(btnSalvar);

		DriverUtils.esperarPorAjax();

		List<String> mensagem = new ArrayList<String>();

		mensagem.add(MSG_TRANSFERENCIA_COM_SUCESSO);

		Util.verificarMensagem(mensagem);

		DriverUtils.voltarFrame();

		getFramePrincipalPage().popupInformacaoBotaoFechar.click();

		DriverUtils.esperarPorAjax();

	}

	private Double verificarSomaFaturas()
	{

		DriverUtils.delay(1000);

		Double totalDebitoFatura = Util
				.converterFormatoRealDouble(lblTotalDebitoFatura.getText());

		/**
		 * Colocar uma validação para lançamento futuro.
		 * 
		 */
		Double totalDebitoLancamentoFuturo = 0.00;

		if ( driver.findElements(
				By.id("tblContratosLancamento:cadValorTotalLancamento"))
				.size() > 0 )
		{

			totalDebitoLancamentoFuturo = Util
					.converterFormatoRealDouble(lblTotalDebitoLancamentoFuturo.getText());
		}

		Double totalTranferir = totalDebitoFatura + totalDebitoLancamentoFuturo;

		org.junit.Assert.assertEquals(
				Util.converterFormatoDoubleReal(totalTranferir),
				lblTotalDebitoTransferencia.getText());

		return totalTranferir;

	}

	public FramePrincipalPage getFramePrincipalPage()
	{

		driver.switchTo().defaultContent();
		driver.switchTo().frame(MenuPage.FRAME_PRINCIPAL_ACI);

		return PageFactory.initElements(driver, FramePrincipalPage.class);
	}
}