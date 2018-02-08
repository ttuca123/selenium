package frames;

import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import auxiliares.ConnectJDBC;
import auxiliares.DataUtil;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumMotivoMovimentacao;
import enumerators.EnumParametroGeral;
import enumerators.EnumServico;
import enumerators.EnumTipoDadosFatura;
import enumerators.EnumTipoMovimentacao;

public class FrameMovimentarFaturas extends PageBase
{

	/************ CONSTANTES DE MENSAGENS *************************/

	private static final String MSG_DATA_VENCIMENTO_MENOR_DIA_ATUAL = "Certifique-se que a data de vencimento permanecerá menor que a data do dia ou se a mesma deverá ser alterada.";

	private static final String MSG_PROCESSAMENTO_CONCLUIDO = "Processamento da movimentação de faturas, concluído com sucesso.";

	/**************************************************************/

	@FindBy(how = How.ID, using = "btnConsultarFaturas")
	public static WebElement btnConsultarFaturas;

	@FindBy(how = How.ID, using = "frmMotivoMovimentacao:cbMotivoMovimentacao")
	public static WebElement selectMotivoMovimentacao;

	@FindBy(how = How.ID, using = "frmMovimentarFatura:radioMovimentar")
	public static WebElement selectTipoMovimentacao;

	@FindBy(how = How.ID, using = "subFrmConteudoFatura:subFormTabFatura:frmCadFatura:")
	public static WebElement fatura;

	@FindBy(how = How.ID, using = "cmdSalvar")
	public static WebElement btnSalvar;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[2]")
	public static WebElement btnFechar;

	@FindBy(how = How.ID, using = "subFrmConteudoFatura:subFormTabFatura:frmCadFatura:0:datVencimento_mskdatabaixa")
	public static WebElement dtVencimentoFatura;

	@FindBy(how = How.ID, using = "cmdCalcularPreco")
	public static WebElement btnCalcularPreco;

	@FindBy(how = How.ID, using = "radioDado")
	public static WebElement dados;

	@FindBy(how = How.LINK_TEXT, using = "Selecionar Tudo")
	public static WebElement selecionarTudo;

	@FindBy(how = How.LINK_TEXT, using = "Selecionar Nenhum")
	public static WebElement selecionarNenhum;

	@FindBy(how = How.ID, using = "subFrmConteudoFatura:subFormTabFatura:frmCadFatura:0:tblPopProdFatura:btnExcluirProduto")
	public WebElement btnExcluirProduto;

	@FindBy(how = How.ID, using = "subFrmConteudoFatura:subFormTabFatura:frmCadFatura:0:tblPopServFatura:btnExcluirServico")
	public WebElement btnExcluirServico;

	@FindBy(how = How.ID, using = "competenciaInicial_mskcompetencia")
	public static WebElement cptInicial;

	@FindBy(how = How.ID, using = "competenciaFinal_mskcompetencia")
	public static WebElement cptFinal;

	@FindBy(how = How.ID, using = "dadosConsulta:btpPesqContratoDestino")
	public WebElement pesquisaContratoDestino;

	@FindBy(how = How.ID, using = "conInsc_mskinteiro")
	public WebElement inscricao;

	@FindBy(how = How.ID, using = "btnConsultarContrato")
	public WebElement btnConsultarContrato;

	@FindBy(how = How.ID, using = "subFrmConteudoFatura:subFormTabFatura:frmCadFatura:0")
	public static WebElement primeiraFatura;

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

	private static int qtdLinhas;

	@FindBy(how = How.ID, using = "subFrmConteudoFatura:subFormTabFatura:frmCadFatura:0:cadEconomiaCom")
	public static WebElement txtEconomiaComercial;

	@FindBy(how = How.ID, using = "subFrmConteudoFatura:subFormTabFatura:frmCadFatura:0:tblPopServFatura:0:alteraServico")
	public static WebElement btnHabilitarValorServico;

	@FindBy(how = How.ID, using = "subFrmConteudoFatura:subFormTabFatura:frmCadFatura:0:tblPopServFatura:0:valor_mskmoeda")
	public static WebElement txtValorServico;

	@FindBy(how = How.ID, using = "subFrmConteudoFatura:subFormTabFatura:frmCadFatura:0:tblPopServFatura:0")
	public static WebElement optPrimeiroServico;

	@FindBy(how = How.CSS, using = Atendimento.POPUP_INFORMACAO_BOTAO_FECHAR)
	public static WebElement popupInformacaoBotaoFechar;

	public FrameMovimentarFaturas(WebDriver driver)
	{
		super(driver);
	}

	public static FrameMovimentarFaturas getFrameMovimentarFaturaPage()

	{

		DriverUtils.avancarFrame();

		FrameMovimentarFaturas frameMovimentarFaturas = PageFactory.initElements(
				DriverUtils.getDriver(), FrameMovimentarFaturas.class);

		return frameMovimentarFaturas;
	}

	private void selecionarUltimaFatura()
	{

		qtdLinhas = DriverUtils
				.getDriver()
				.findElements(
						By.xpath(".//*[@id='subFrmConteudoFatura:subFormTabFatura:frmCadFatura']/table[2]/tbody/tr[*]/td[1]"))
				.size() - 1;

		DriverUtils
				.clicar(DriverUtils
						.getDriver()
						.findElement(
								By.xpath(".//*[@id='subFrmConteudoFatura:subFormTabFatura:frmCadFatura:"
										+ (qtdLinhas) + "']")));

		DriverUtils.esperarPorAjax();

	}

	private static void isElementosTabelaPresentes()
	{

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.withMessage("Elementos da tabela de fatura não encontrados");

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
				.id("pnlConteudoFatura")));

	}

	public void movimentarFaturas(EnumTipoMovimentacao tipoMovimentacao,
			EnumMotivoMovimentacao enumMotivoMovimentacao,
			EnumTipoDadosFatura tipoDadosFatura, String competencia,
			EnumServico servico, double valor, boolean executarComAlcada)
			throws ClassNotFoundException, SQLException
	{

		isElementosTabelaPresentes();

		DriverUtils.selecionarComboPeloIndice(selectMotivoMovimentacao,
				enumMotivoMovimentacao.getCodigo());

		DriverUtils.selecionarComboPeloNome(dados,
				tipoDadosFatura.getNomeAmigavel());

		switch (servico)
		{
			case REFATURAMENTO:

				if ( selectTipoMovimentacao.isEnabled() )
				{
					DriverUtils.selecionarComboPeloIndice(selectTipoMovimentacao,
							tipoMovimentacao.getCodigo());

					DriverUtils.esperarPorAjax();
				}

				break;

			default:

				DriverUtils.selecionarComboPeloIndice(selectTipoMovimentacao, 1);

				DriverUtils.esperarPorAjax();
				break;

		}

		pesquisarCompetencia(competencia);

		switch (tipoMovimentacao)
		{

			case ALTERAR_VENCIMENTO:

				DriverUtils.clicar(primeiraFatura);

				alterarVencimento(DataUtil.getDataAtualSemHHMMSS());

				break;
			case RETIFICAR:

				selecionarUltimaFatura();

				if ( !executarComAlcada )
				{

					DriverUtils.buscarElementoClicavel(DriverUtils.getDriver()
							.findElement(
									By.id("subFrmConteudoFatura:subFormTabFatura:frmCadFatura:"
											+ qtdLinhas + ":cadEconomiaRes_mskinteiro")));

					DriverUtils.buscarElementoClicavel(DriverUtils.getDriver()
							.findElement(
									By.id("subFrmConteudoFatura:subFormTabFatura:frmCadFatura:"
											+ qtdLinhas + ":cadEconomiaCom_mskinteiro")));

					WebElement econResid = DriverUtils.getDriver().findElement(
							By.id("subFrmConteudoFatura:subFormTabFatura:frmCadFatura:"
									+ qtdLinhas + ":cadEconomiaRes_mskinteiro"));

					WebElement econComerc = DriverUtils.getDriver().findElement(
							By.id("subFrmConteudoFatura:subFormTabFatura:frmCadFatura:"
									+ qtdLinhas + ":cadEconomiaCom_mskinteiro"));

					DriverUtils.limparCampo(econResid);

					DriverUtils.escrever(econResid, Util.gerarNumero(4).toString());

					DriverUtils.limparCampo(econComerc);

					DriverUtils.escrever(econComerc, Util.gerarNumero(4).toString());

				}

				detalharCompetenciaFatura();

				if ( !executarComAlcada )
				{
					calcularProdutoFaturado();
				}

				calcularServicoFaturado(valor);

				alterarVencimento(DataUtil.getDataAtualSemHHMMSS());

				DriverUtils.duploCliqueComAjax(btnCalcularPreco);

				break;
			default:

				selecionarUltimaFatura();
				break;
		}

		salvar();

	}

	private static void pesquisarCompetencia(String competencia)

	{

		if ( competencia != null )
		{
			String anoCompetenciaInicial = competencia.substring(0, 4);
			String mesCompetenciaInicial = competencia.substring(4, 6);

			DriverUtils.escrever(cptInicial, mesCompetenciaInicial
					+ anoCompetenciaInicial);

			DriverUtils.escrever(cptFinal, mesCompetenciaInicial
					+ anoCompetenciaInicial);

		}

		DriverUtils.clicar(btnConsultarFaturas);

		DriverUtils.esperarPorAjax();

		DriverUtils.delay(1000);

	}

	private static void detalharCompetenciaFatura()
	{

		WebElement btnDetalharCompetencia = DriverUtils.getDriver().findElement(
				By.id("subFrmConteudoFatura:subFormTabFatura:frmCadFaturadd"
						+ qtdLinhas));

		DriverUtils.clicar(btnDetalharCompetencia);

	}

	private static void calcularProdutoFaturado()
	{

		if ( driver.findElements(
				By.id("subFrmConteudoFatura:subFormTabFatura:frmCadFatura:" + qtdLinhas
						+ ":tblPopProdFatura:0")).size() > 0 )
		{

			WebElement volumeFaturado = DriverUtils.getDriver().findElement(
					By.id("subFrmConteudoFatura:subFormTabFatura:frmCadFatura:"
							+ qtdLinhas + ":tblPopProdFatura:0:percentualValor_mskmoeda"));

			DriverUtils
					.getDriver()
					.findElement(
							By.id("subFrmConteudoFatura:subFormTabFatura:frmCadFatura:"
									+ qtdLinhas + ":tblPopProdFatura:0")).click();

			DriverUtils.delay(1000);

			DriverUtils.limparCampo(volumeFaturado);

			DriverUtils.esperarPorAjax();

			DriverUtils.escrever(volumeFaturado, Util.gerarNumero(20).toString());

			DriverUtils.delay(2000);
		}

	}

	private static void calcularServicoFaturado(Double valor)
	{
		int i = 0;

		do
		{

			DriverUtils.clicar(btnHabilitarValorServico);

			DriverUtils.esperarPorAjax();

			i++;

		}
		while (!txtValorServico.isEnabled() && i < 2);

		String valorServico = txtValorServico.getAttribute("value");

		DriverUtils.limparCampo(txtValorServico);

		DriverUtils.esperarPorAjax();

		if ( valor == 0 )
		{
			DriverUtils.escrever(txtValorServico, Util.gerarNumero(90).toString()
					+ Keys.TAB);
		}
		else
		{

			valor += Util.converterFormatoRealDouble(valorServico);

			DriverUtils.escrever(txtValorServico, valor.toString() + Keys.TAB);
		}

		DriverUtils.esperarPorAjax();

		DriverUtils.clicar(optPrimeiroServico);

		DriverUtils.delay(2000);

	}

	private static String alterarVencimento(Date dataInicial)
	{

		Date dataModificada = DataUtil.adicionarDiasEmUmaData(dataInicial, 1);

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(dataModificada);

		if ( DataUtil.isSabadoOuDomingo(gc) )
		{

			return alterarVencimento(dataModificada);

		}
		else
		{
			DriverUtils.delay(1000);

			DriverUtils.limparCampo(dtVencimentoFatura);

			DriverUtils.escrever(dtVencimentoFatura,
					DataUtil.converterDataFormatoddMMyyy(dataModificada));

			return null;

		}

	}

	private static void salvar() throws ClassNotFoundException, SQLException
	{

		DriverUtils.clicar(btnSalvar);
		DriverUtils.esperarPorAjax();

		Util.verificarMensagem(MSG_DATA_VENCIMENTO_MENOR_DIA_ATUAL);

		if ( !ConnectJDBC
				.getParametroGeral(EnumParametroGeral.VERIFICAR_ALCADA_REFATURAMENTO) )
		{

			Util.verificarMensagem(MSG_PROCESSAMENTO_CONCLUIDO);

		}

		concluirAtendimento();

	}

	private static void concluirAtendimento()
	{

		driver.switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(MenuPage.FRAME_PRINCIPAL_ACI)));

		DriverUtils.clicar(popupInformacaoBotaoFechar);

		DriverUtils.esperarPorAjax();

	}
}