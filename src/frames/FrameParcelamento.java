package frames;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.MenuPage;
import pages.PageBase;
import auxiliares.Atendimento;
import auxiliares.DriverUtils;
import auxiliares.NumberUtilsIntegracao;
import auxiliares.Util;
import enumerators.EnumCasasDecimais;
import enumerators.EnumTipoCliente;
import enumerators.EnumTipoModoParcelamento;
import enumerators.EnumTipoPadrao;
import enumerators.EnumTipoParcelamento;
/**
 * 
 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 27/10/2015 -
 *         13:39:25.
 *
 */
public class FrameParcelamento extends PageBase
{

	/**************************** CONSTANTES *****************************************/

	private static final String NR_IDENTIDADE = "2015118654937";

	private static final String NR_CPF = "09298860382";

	private static final String MSG_PARCELAMENTO_SUCESSO = "Parcelamento efetuado com sucesso.";

	/*******************************************************************************/

	@FindBy(how = How.ID, using = "btnConsultarFaturas")
	public static WebElement btnConsultarFaturas;

	@FindBy(how = How.ID, using = "frmParametroConsultaCadastro:frm6:cbMotivoMovimentacao")
	public static WebElement selectMotivoMovimentacao;

	@FindBy(how = How.ID, using = "frmParametroConsultaCadastro:frm5:radioMovimentar")
	public static WebElement selectTipoMovimentacao;

	@FindBy(how = How.ID, using = "subFrmConteudoFatura:subFormTabFatura:frmCadFatura:")
	public static WebElement fatura;

	@FindBy(how = How.ID, using = "cmdSalvar")
	public static WebElement btnSalvar;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[2]")
	public static WebElement btnFechar;

	@FindBy(how = How.LINK_TEXT, using = "Selecionar Tudo")
	public WebElement selecionarTudo;

	@FindBy(how = How.LINK_TEXT, using = "Selecionar Nenhum")
	public WebElement selecionarNenhum;

	@FindBy(how = How.ID, using = "subFrmConteudoFatura:subFormTabFatura:frmCadFatura:0:tblPopProdFatura:btnExcluirProduto")
	public WebElement btnExcluirProduto;

	@FindBy(how = How.ID, using = "subFrmConteudoFatura:subFormTabFatura:frmCadFatura:0:tblPopServFatura:btnExcluirServico")
	public WebElement btnExcluirServico;

	@FindBy(how = How.ID, using = "frmParametroConsultaCadastro:frm3:competenciaInicial_mskcompetencia")
	public WebElement cptInicial;

	@FindBy(how = How.ID, using = "frmParametroConsultaCadastro:frm3:competenciaFinal_mskcompetencia")
	public WebElement cptFinal;

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

	@FindBy(how = How.XPATH, using = ".//*[@id='tabPaneParcelamento']/ul/li[3]")
	public static WebElement abaTipoParcelamento;

	@FindBy(how = How.ID, using = "tblcadTipoParcelamento:1")
	public static WebElement optParcelamentoSemEntrada;

	@FindBy(how = How.ID, using = "cmdSimular")
	public static WebElement btnSimular;

	@FindBy(how = How.ID, using = "cmdConfirmarSalvar")
	public static WebElement btnConfirmarSalvar;

	@FindBy(how = How.ID, using = "txtCadQuantidadeParcelas_mskinteiro")
	public static WebElement txtQtdParcelas;

	@FindBy(how = How.ID, using = "txtCadVlrEntrada_mskmoeda")
	public static WebElement txtCadValorEntrada;

	@FindBy(how = How.XPATH, using = ".//*[@id='tabPaneParcelamento']/ul/li[5]")
	public static WebElement abaParcelamento;

	@FindBy(how = How.XPATH, using = ".//*[@id='tabPaneParcelamento']/ul/li[4]")
	public static WebElement abaRepresentante;

	@FindBy(how = How.ID, using = "txtCadGpaNomRepresentante")
	public static WebElement txtRepresentante;

	@FindBy(how = How.ID, using = "txtCadGpaNumRgRepresentante")
	public static WebElement txtIdentidade;

	@FindBy(how = How.ID, using = "txtCadGpaNumCpfRepresentante_mskcpf")
	public static WebElement txtCpfRepresentante;

	@FindBy(how = How.ID, using = "txtCadVlrFaturas")
	public static WebElement lblValorFatura;

	@FindBy(how = How.ID, using = "txtCadGpaVlrParcela")
	public static WebElement lblValorParcela;

	@FindBy(how = How.ID, using = "txtCadGpaVlrUltimaParcela")
	public static WebElement lblValorUltimaParcela;

	@FindBy(how = How.ID, using = "txtCadVlrLancamentos")
	public static WebElement lblValorLancamentoFuturo;

	@FindBy(how = How.ID, using = "txtCadGpaVlrJuros")
	public static WebElement lblValorJurosMora;

	@FindBy(how = How.ID, using = "txtCadGpaVlrMulta")
	public static WebElement lblValorMulta;

	@FindBy(how = How.ID, using = "txtCadGpaVlrParcelamento")
	public static WebElement lblValorParcelar;

	@FindBy(how = How.ID, using = "txtCadGpaVlrParcelado")
	public static WebElement lblValorTotalParcelamento;

	@FindBy(how = How.ID, using = "cmdLiberar")
	public static WebElement btnLiberar;

	public FrameParcelamento(WebDriver driver)
	{
		super(driver);
	}

	public FramePrincipalPage getFramePrincipalPage()
	{

		driver.switchTo().defaultContent();
		driver.switchTo().frame(MenuPage.FRAME_PRINCIPAL_ACI);

		return PageFactory.initElements(driver, FramePrincipalPage.class);
	}

	public void selecionarTipoParcelamento(
			EnumTipoModoParcelamento tipoModoParcelamento,
			EnumTipoParcelamento tipoParcelamento, EnumTipoCliente enumTipoCLiente)
	{
		DriverUtils.esperarPorAjax();

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.withMessage("Elementos da tabela fatura não encontrados");

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.id("tblCadFatAberto"))));

		String padrao = null;

		DriverUtils.duploClique(abaTipoParcelamento);

		DriverUtils.delay(500);
		int i = 2;

		for (WebElement lblModoParcelamento : DriverUtils
				.getDriver()
				.findElements(
						By.xpath(".//*[@id='tblcadTipoParcelamento']/table[2]/tbody/tr[*]/td[4]")))
		{

			if ( lblModoParcelamento.getText().trim()
					.equals(tipoModoParcelamento.getNomeAmigavel()) )
			{
				padrao = driver.findElement(
						By.xpath(".//*[@id='tblcadTipoParcelamento']/table[2]/tbody/tr["
								+ i + "]/td[5]")).getText();

				driver.findElement(By.id("tblcadTipoParcelamento:" + (i - 2))).click();

				break;
			}
			i++;
		}

		executarParcelamento(padrao, tipoModoParcelamento, enumTipoCLiente,
				tipoParcelamento);
	}

	private void executarParcelamento(String padrao,
			EnumTipoModoParcelamento tipoModoParcelamento,
			EnumTipoCliente enumTipoCliente, EnumTipoParcelamento enumTipoParcelamento)
	{
		DriverUtils.delay(500);

		DriverUtils.clicar(abaParcelamento);

		Integer qtdParcelas = null;

		switch (enumTipoCliente)
		{
		/*
		 * Ainda não foi implementado as regras para órgão público. ORGAO_PUBLICO:
		 * 
		 * switch (enumTipoParcelamento) { case LIMITE:
		 * 
		 * switch (tipoModoParcelamento) {
		 * 
		 * case SEM_ENTRADA:
		 * 
		 * qtdParcelas = 4; executarParcelamentoNormal(qtdParcelas);
		 * 
		 * break; case COM_ENTRADA:
		 * 
		 * qtdParcelas = 6;
		 * 
		 * // String valorRealCobrar = ; // // //
		 * DriverUtils.limparCampo(txtCadValorEntrada); //
		 * DriverUtils.escrever(txtCadValorEntrada, // valorRealCobrar);
		 * 
		 * executarParcelamentoNormal(qtdParcelas);
		 * 
		 * Double valorTotal = Util.converterNumeroReal(lblValorFatura .getText());
		 * valorTotal = (valorTotal * 0.018) + valorTotal;
		 * 
		 * Assert.assertEquals( valorTotal.toString(), Util.converterNumeroReal(
		 * lblValorTotalParcelamento.toString()) .toString());
		 * 
		 * break;
		 * 
		 * case SEGUNDO_PARCELAMENTO:
		 * 
		 * break; case TERCEIRO_PARCELAMENTO:
		 * 
		 * break;
		 * 
		 * }
		 * 
		 * break; case ACIMA_LIMITE:
		 * 
		 * switch (tipoModoParcelamento) {
		 * 
		 * case SEM_ENTRADA: qtdParcelas = 6;
		 * executarParcelamentoComAutorizacao(qtdParcelas); break; case COM_ENTRADA:
		 * 
		 * break;
		 * 
		 * case SEGUNDO_PARCELAMENTO:
		 * 
		 * break; case TERCEIRO_PARCELAMENTO:
		 * 
		 * break;
		 * 
		 * } default: break; } break;
		 */
			case OUTROS:

				if ( padrao.equals(EnumTipoPadrao.ALTO.getNomeAmigavel()) )
				{
					switch (enumTipoParcelamento)
					{
						case SEM_JUROS:

							switch (tipoModoParcelamento)
							{

								case SEM_ENTRADA:

									qtdParcelas = 4;

									calcularParcelamento(qtdParcelas);

									buildParcelamento(qtdParcelas);

									break;
								case COM_ENTRADA:

									calcularParcelamento(5, 0.201);

									break;

								case SEGUNDO_PARCELAMENTO:

									calcularParcelamento(5, 0.301);

									break;
								case TERCEIRO_PARCELAMENTO:

									calcularParcelamento(5, 0.401);

									break;

							}

							break;
						case COM_JUROS:

							switch (tipoModoParcelamento)
							{

								case SEM_ENTRADA:

									qtdParcelas = 4;
									calcularParcelamento(qtdParcelas);

									buildParcelamento(qtdParcelas);
									break;
								case COM_ENTRADA:

									calcularParcelamento(12, 0.201);

									break;

								case SEGUNDO_PARCELAMENTO:

									calcularParcelamento(12, 0.301);

									break;
								case TERCEIRO_PARCELAMENTO:

									calcularParcelamento(12, 0.401);

									break;

							}
						default:
							break;
					}
					break;
				}
				else if ( padrao.equals(EnumTipoPadrao.MEDIO.getNomeAmigavel()) )
				{
					switch (enumTipoParcelamento)
					{
						case SEM_JUROS:

							switch (tipoModoParcelamento)
							{

								case SEM_ENTRADA:
									qtdParcelas = 4;

									calcularParcelamento(qtdParcelas);

									buildParcelamento(qtdParcelas);

									break;
								case COM_ENTRADA:

									calcularParcelamento(5, 0.151);

									break;

								case SEGUNDO_PARCELAMENTO:

									calcularParcelamento(5, 0.251);

									break;
								case TERCEIRO_PARCELAMENTO:

									calcularParcelamento(5, 0.351);

									break;

							}

							break;
						case COM_JUROS:

							switch (tipoModoParcelamento)
							{

								case SEM_ENTRADA:

									qtdParcelas = 4;
									calcularParcelamento(qtdParcelas);
									buildParcelamento(qtdParcelas);

									break;
								case COM_ENTRADA:

									calcularParcelamento(18, 0.151);

									break;

								case SEGUNDO_PARCELAMENTO:

									calcularParcelamento(18, 0.251);

									break;
								case TERCEIRO_PARCELAMENTO:

									calcularParcelamento(18, 0.351);

									break;

							}
						default:
							break;
					}
				}
				else if ( padrao.equals(EnumTipoPadrao.REGULAR.getNomeAmigavel()) )
				{
					switch (enumTipoParcelamento)
					{
						case SEM_JUROS:

							switch (tipoModoParcelamento)
							{

								case SEM_ENTRADA:
									qtdParcelas = 4;
									calcularParcelamento(qtdParcelas);
									buildParcelamento(qtdParcelas);

									break;
								case COM_ENTRADA:

									calcularParcelamento(5, 0.101);

									break;

								case SEGUNDO_PARCELAMENTO:

									calcularParcelamento(5, 0.201);

									break;
								case TERCEIRO_PARCELAMENTO:

									calcularParcelamento(5, 0.301);

									break;

							}

							break;
						case COM_JUROS:

							switch (tipoModoParcelamento)
							{

								case SEM_ENTRADA:

									qtdParcelas = 6;
									calcularParcelamento(qtdParcelas);
									buildParcelamento(qtdParcelas);

									break;
								case COM_ENTRADA:

									calcularParcelamento(24, 0.151);

									break;

								case SEGUNDO_PARCELAMENTO:

									calcularParcelamento(24, 0.201);

									break;
								case TERCEIRO_PARCELAMENTO:

									calcularParcelamento(24, 0.301);

									break;

							}
						default:
							break;
					}
				}
				else if ( padrao.equals(EnumTipoPadrao.BASICO.getNomeAmigavel()) )
				{
					switch (enumTipoParcelamento)
					{
						case SEM_JUROS:

							switch (tipoModoParcelamento)
							{

								case SEM_ENTRADA:
									qtdParcelas = 4;
									calcularParcelamento(qtdParcelas);
									buildParcelamento(qtdParcelas);

									break;
								case COM_ENTRADA:

									calcularParcelamento(5, 0.051);

									break;

								case SEGUNDO_PARCELAMENTO:

									calcularParcelamento(5, 0.151);

									break;
								case TERCEIRO_PARCELAMENTO:

									calcularParcelamento(5, 0.251);

									break;

							}

							break;
						case COM_JUROS:

							switch (tipoModoParcelamento)
							{

								case SEM_ENTRADA:

									qtdParcelas = 10;
									calcularParcelamento(qtdParcelas);
									buildParcelamento(qtdParcelas);

									break;
								case COM_ENTRADA:

									calcularParcelamento(36, 0.051);

									break;

								case SEGUNDO_PARCELAMENTO:

									calcularParcelamento(36, 0.151);

									break;
								case TERCEIRO_PARCELAMENTO:

									calcularParcelamento(36, 0.251);

									break;

							}
						default:
							break;
					}
				}
				else if ( padrao.equals(EnumTipoPadrao.VAGO.getNomeAmigavel()) )
				{
					switch (enumTipoParcelamento)
					{
						case SEM_JUROS:

							switch (tipoModoParcelamento)
							{

								case SEM_ENTRADA:
									qtdParcelas = 4;
									calcularParcelamento(qtdParcelas);
									buildParcelamento(qtdParcelas);

									break;
								case COM_ENTRADA:

									calcularParcelamento(5, 0.056);

									break;

								case SEGUNDO_PARCELAMENTO:

									calcularParcelamento(5, 0.151);

									break;
								case TERCEIRO_PARCELAMENTO:

									calcularParcelamento(5, 0.251);

									break;

							}

							break;
						case COM_JUROS:

							switch (tipoModoParcelamento)
							{

								case SEM_ENTRADA:
									qtdParcelas = 4;
									calcularParcelamento(qtdParcelas);
									buildParcelamento(qtdParcelas);

									break;
								case COM_ENTRADA:

									calcularParcelamento(5, 0.056);

									break;

								case SEGUNDO_PARCELAMENTO:

									calcularParcelamento(5, 0.151);

									break;
								case TERCEIRO_PARCELAMENTO:

									calcularParcelamento(5, 0.251);

									break;

							}
						default:
							break;
					}
				}
			default:
				break;

		}

		salvarParcelamento();

	}

	private void calcularParcelamento(Integer qtdParcelas)
	{

		DriverUtils.limparCampo(txtQtdParcelas);
		DriverUtils.escrever(txtQtdParcelas, qtdParcelas.toString());

		preencherDadosRepresentante();

		DriverUtils.clicar(btnSimular);
		DriverUtils.esperarPorAjax();

	}

	private void calcularParcelamento(Integer qtdParcelas, Double percentualMinimo)
	{

		calcularParcelamento(qtdParcelas);

		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

		Double valorEntrada = Util.converterFormatoRealDouble(lblValorParcelar
				.getText()) * percentualMinimo;

		DriverUtils.limparCampo(txtCadValorEntrada);
		DriverUtils.escrever(txtCadValorEntrada, numberFormat.format(valorEntrada));

		DriverUtils.clicar(btnSimular);
		DriverUtils.esperarPorAjax();

		buildParcelamento(qtdParcelas);

		Double valorParcelar = Util.converterFormatoRealDouble(lblValorFatura
				.getText())
				+ Util.converterFormatoRealDouble(lblValorLancamentoFuturo.getText())
				+ Util.converterFormatoRealDouble(lblValorMulta.getText())
				+ Util.converterFormatoRealDouble(lblValorJurosMora.getText());

		Double valorTotalParcelamento = NumberUtilsIntegracao.truncarValor(
				Util.converterFormatoRealDouble(lblValorParcela.getText())
						* (qtdParcelas - 1)
						+ Util.converterFormatoRealDouble(lblValorUltimaParcela.getText()),
				EnumCasasDecimais.QUATRO_CASAS_DECIMAIS);

		Assert.assertEquals(
				"R$ " + NumberUtilsIntegracao.valorFormatado(valorParcelar),
				lblValorParcelar.getText());

		Assert.assertEquals(
				"R$ " + NumberUtilsIntegracao.valorFormatado(valorTotalParcelamento),
				lblValorTotalParcelamento.getText());

	}

	private String buildParcelamento(Integer qtdParcelas)
	{
		StringBuilder parcelamento = new StringBuilder();

		if ( !txtCadValorEntrada.getAttribute("value").equals("0,00") )
		{
			parcelamento.append("ENTRADA: ");
			parcelamento.append("R$ " + txtCadValorEntrada.getAttribute("value"));
			parcelamento.append(" + ");

		}
		parcelamento.append(qtdParcelas.toString() + " X "
				+ lblValorParcela.getText() + " (ÚLT. PARC. "
				+ lblValorUltimaParcela.getText() + ")");

		return parcelamento.toString();

	}

	private void preencherDadosRepresentante()
	{

		DriverUtils.clicar(abaRepresentante);

		DriverUtils.limparCampo(txtRepresentante);
		DriverUtils.escrever(txtRepresentante,
				"Teste " + Util.gerarTextoAleatorio(20));

		if ( driver.findElements(By.id("txtCadGpaNumRgRepresentante")).size() > 0 )
		{
			DriverUtils.limparCampo(txtIdentidade);
			DriverUtils.escrever(txtIdentidade, NR_IDENTIDADE);

		}

		DriverUtils.limparCampo(txtCpfRepresentante);
		DriverUtils.escrever(txtCpfRepresentante, NR_CPF);

	}

	private void salvarParcelamento()
	{

		DriverUtils.clicar(btnSalvar);
		DriverUtils.esperarPorAjax();

		DriverUtils.clicar(btnConfirmarSalvar);

		DriverUtils.esperarPorAjax();

		List<String> mensagens = new ArrayList<String>();
		mensagens.add(MSG_PARCELAMENTO_SUCESSO);
		Util.verificarMensagem(mensagens);

		getFramePrincipalPage();
		DriverUtils.clicar(popupInformacaoBotaoFechar);

	}

}