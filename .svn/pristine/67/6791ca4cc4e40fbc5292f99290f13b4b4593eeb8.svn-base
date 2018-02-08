package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
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
import servicos.ServicoPadrao;
import auxiliares.Atendimento;
import auxiliares.DriverUtils;

/**
 * Sample page
 */
public class FramePrincipalPage extends PageBase
{
	static FramePrincipalPage framePrincipalpage;

	@FindBy(how = How.ID, using = "frmCenFaturas:setaBaixoFaturas")
	public static WebElement btnFecharFaturas;

	@FindBy(how = How.CLASS_NAME, using = "btnRefresh")
	public static WebElement btnRefresh;

	@FindBy(how = How.ID, using = Atendimento.REGISTRAR_ATENDIMENTO)
	public static WebElement btnRegistroAtendimento;

	@FindBy(how = How.ID, using = Atendimento.CONTRATO)
	public static WebElement btnContrato;

	@FindBy(how = How.ID, using = Atendimento.IMG_CONTRATO)
	public static WebElement btnImgContrato;

	@FindBy(how = How.ID, using = Atendimento.DESCRICAO_LAUDO_TECNICO)
	public static WebElement dscLaudoTecnico;

	@FindBy(how = How.ID, using = Atendimento.INSCRICAO)
	public static WebElement txtInscricao;

	@FindBy(how = How.ID, using = Atendimento.BTN_CONSULTAR_IMOVEL)
	public static WebElement btnConsultarImovel;

	@FindBy(how = How.ID, using = Atendimento.CPF)
	public static WebElement txtCpf;

	@FindBy(how = How.ID, using = Atendimento.BTN_CONSULTAR_LOGRADOURO)
	public static WebElement btnConsultarLogradouro;

	@FindBy(how = How.ID, using = Atendimento.LISTA_DE_CONTRATOS)
	public static WebElement listaContrato;

	@FindBy(how = How.ID, using = Atendimento.EMAIL_CHECK_NAO_QUIS_INFORMAR)
	public static WebElement checkEmailNaoQuisInformar;

	@FindBy(how = How.ID, using = Atendimento.EMAIL_BOTAO_CONTINUAR)
	public static WebElement emailBtnContinuar;

	@FindBy(how = How.ID, using = Atendimento.CODIGO_SERVICO)
	public static WebElement codigoServico;

	@FindBy(how = How.ID, using = Atendimento.BTN_INCLUIR_SERVICO)
	public static WebElement btnIncluirServico;

	@FindBy(how = How.ID, using = Atendimento.PRIMEIRO_SERVICO_DA_LISTA)
	public static WebElement primeiroDaLista;

	@FindBy(how = How.ID, using = Atendimento.SOLICITACAO_BOTAO_OK)
	public static WebElement btnSolicitacaoOk;

	@FindBy(how = How.CSS, using = Atendimento.POPUP_INFORMACAO_BOTAO_FECHAR)
	public static WebElement popupInformacaoBotaoFechar;

	@FindBy(how = How.ID, using = Atendimento.PAVIMENTO_RUA)
	public static WebElement pavimentoRua;

	@FindBy(how = How.ID, using = Atendimento.TIPO_RECLAMACAO_CRITICA)
	public static WebElement tipoReclamacaoElogioSugestaoCritica;

	@FindBy(how = How.ID, using = Atendimento.CAPACIDADE_MEDIDOR)
	public static WebElement capacidadeMedidor;

	@FindBy(how = How.ID, using = Atendimento.DIAMETRO_MEDIDOR)
	public static WebElement diametroMedidor;

	@FindBy(how = How.ID, using = Atendimento.DIAMETRO_MEDIDOR_ESGOTO)
	public static WebElement diametroMedidorEsgoto;

	@FindBy(how = How.ID, using = Atendimento.BTN_BUSCA_DATA_FINALIZACAO)
	public static WebElement btnBuscaDataFinalizacao;

	@FindBy(how = How.ID, using = Atendimento.BTN_PESQUISAR_CLIENTE)
	public static WebElement btnPesquisarCliente;

	@FindBy(how = How.XPATH, using = Atendimento.CAMPO_DEBITO)
	public static WebElement saldoDevedor;

	@FindBy(how = How.ID, using = Atendimento.BTN_FECHAR_TELA_MENSAGEM)
	public static WebElement btnFecharTelaMensagem;

	/** NEGOCIACAO */
	@FindBy(how = How.ID, using = Atendimento.FAIXA_VALOR_INICIO)
	public WebElement faixaValorInicio;

	@FindBy(how = How.ID, using = Atendimento.FAIXA_VALOR_FINAL)
	public WebElement faixaValorFinal;

	@FindBy(how = How.ID, using = Atendimento.VLR_MIN_PARCELA)
	public WebElement valorMinimoParcela;

	@FindBy(how = How.ID, using = Atendimento.QTD_MAX_PARCELAS)
	public WebElement qtdMaxParcela;

	@FindBy(how = How.ID, using = Atendimento.VLR_MIN_ENTRADA)
	public WebElement vlrMinEntrada;

	@FindBy(how = How.ID, using = Atendimento.SF_LANCAMENTOS_FUTUROS)
	public static WebElement lancamentosFuturos;

	@FindBy(how = How.LINK_TEXT, using = "TD")
	public WebElement btnTransfDebitoLog;

	@FindBy(how = How.ID, using = "frmCenFaturas:tblDadosFatura-nb__xc_c")
	public WebElement cmbPagFaturas;

	@FindBy(how = How.XPATH, using = ".//*[@id='pnlConteudoSituacaoFinanceira']/div/span/table/tbody/tr/td[6]/div/span[2]")
	public WebElement lblTotalDebito;

	@FindBy(how = How.ID, using = "valorDebito2")
	public WebElement lblValorDebito2;

	@FindBy(how = How.ID, using = "valorDebito1")
	public WebElement lblValorDebito1;

	@FindBy(how = How.ID, using = "subFormIncluirServico:txtCodigoServico_mskinteiro")
	public static WebElement txtCodigoServico;

	@FindBy(how = How.CLASS_NAME, using = "btnFecharClass")
	public static WebElement btnFechar;

	@FindBy(how = How.ID, using = "btnConsultarCliente")
	public static WebElement btnConsultarCliente;

	@FindBy(how = How.ID, using = "btnConsultarCliente")
	public static WebElement btnFecharConsultaCliente;

	@FindBy(how = How.ID, using = "tblDadosContratos:0")
	public static WebElement optContratoAtivo;

	public FramePesquisaClientePage getFramePesquisaClientePage()
	{
		return framePesquisaClientePage;
	}

	public FramePesquisaLogradouroPage getFramePesquisaLogradouroPage()
	{
		return framePesquisaLogradouroPage;
	}

	public static boolean mensagemExibida(String mensagem)

	{
		boolean retorno = false;

		DriverUtils.delay(1500);
		if ( DriverUtils.getDriver()
				.findElements(By.id("msgCentralizadorAtendimento")).size() > 0 )
		{

			WebElement pergunta = driver.findElement(By
					.id("msgCentralizadorAtendimento"));

			if ( pergunta.findElements(By.tagName("ol")).size() > 0 )
			{
				if ( pergunta.findElement(By.tagName("ol"))
						.findElements(By.tagName("li")).size() > 0 )
				{

					WebElement msg = pergunta.findElement(By.tagName("ol")).findElement(
							By.tagName("li"));

					retorno = msg.getText().trim().equals(mensagem);
				}
			}
		}

		return retorno;

	}

	private static FramePesquisaClientePage framePesquisaClientePage;

	private static FramePesquisaLogradouroPage framePesquisaLogradouroPage;

	public FramePrincipalPage(WebDriver webDriver)
	{
		super(webDriver);
	}

	public static boolean exigeConfirmacaoEmail()
	{
		boolean retorno = DriverUtils.getDriver()
				.findElements(ById.id(Atendimento.EMAIL)).size() > 0;
		return retorno;
	}

	public static void verificarAviso()
	{

		DriverUtils.delay(500);

		if ( DriverUtils.getDriver().findElements(By.name("_blank")).size() > 0 )
		{
			DriverUtils.clicar(popupInformacaoBotaoFechar);
		}

	}

	public void verificarDebito()
	{

		DriverUtils.delay(1000);
		if ( ExpectedConditions.invisibilityOfElementLocated(By.name("_blank")) == null )
		{
			DriverUtils.clicar(popupInformacaoBotaoFechar);
		}

	}

	public FramePesquisaClientePage getFramePesquisaCliente()

	{

		DriverUtils.clicar(btnPesquisarCliente);

		DriverUtils.esperarPorAjax();

		DriverUtils.avancarFrame();

		framePesquisaClientePage = PageFactory.initElements(
				DriverUtils.getDriver(), FramePesquisaClientePage.class);

		return framePesquisaClientePage;
	}

	public static FramePesquisaLogradouroPage getFramePesquisaLogradouro()

	{

		DriverUtils.clicar(btnConsultarLogradouro);

		DriverUtils.avancarFrame();

		framePesquisaLogradouroPage = PageFactory.initElements(
				DriverUtils.getDriver(), FramePesquisaLogradouroPage.class);

		DriverUtils.esperarPorAjax();

		return framePesquisaLogradouroPage;
	}

	public void solicitarServico(String servico)
	{

		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);

			wait.withMessage("Elementos da Solicitação do Serviço com Falha");

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By
					.id("subFormIncluirServico:tblDados222:0")));

			DriverUtils.limparCampo(codigoServico);

			DriverUtils.escrever(codigoServico, servico + Keys.TAB);

			DriverUtils.esperarPorAjax();

		}
		finally
		{

			DriverUtils.clicar(primeiroDaLista);

		}

		iniciarSolicitacao();

	}

	public void consultarImovel() throws InterruptedException
	{

		DriverUtils.clicar(btnConsultarImovel);
		DriverUtils.esperarPorAjax();
	}

	public void iniciarAtendimento()
	{

		DriverUtils.clicar(btnRegistroAtendimento);
		DriverUtils.esperarPorAjax();

		if ( exigeConfirmacaoEmail() )
		{

			DriverUtils.clicar(checkEmailNaoQuisInformar);

			DriverUtils.clicar(emailBtnContinuar);

		}

		DriverUtils.esperarPor(By.id(Atendimento.CODIGO_SERVICO));

	}

	public void iniciarSolicitacao()
	{

		DriverUtils.clicar(btnSolicitacaoOk);

		DriverUtils.esperarPorAjax();
		if ( exigeConfirmacaoEmail() )
		{

			DriverUtils.clicar(checkEmailNaoQuisInformar);

			DriverUtils.clicar(emailBtnContinuar);

			DriverUtils.clicar(primeiroDaLista);

			DriverUtils.clicar(btnSolicitacaoOk);

			DriverUtils.esperarPorAjax();
		}

	}

	public void informarDataSolicitacao() throws InterruptedException
	{

		DriverUtils.clicar(btnBuscaDataFinalizacao);
		DriverUtils.esperarPorAjax();

	}

	public static void preencherCpfCnpj(ServicoPadrao servico)
	{

		DriverUtils.limparCampo(txtCpf);
		DriverUtils.esperarPorAjax();

		DriverUtils.escrever(txtCpf, servico.getCpfCnpj() + Keys.TAB);

		DriverUtils.esperarPorAjax();

		if ( servico.getQtdContratoOrigem() > 1 )
		{
			selecionaClienteCpfCnpj();
		}

	}

	public static void preencherInscricao(String inscricao, int qtdContratos)
	{

		if ( !inscricao.equals("0") )
		{

			DriverUtils.limparCampo(txtInscricao);
			DriverUtils.esperarPorAjax();

			DriverUtils.escrever(txtInscricao, inscricao + Keys.TAB);
			DriverUtils.esperarPorAjax();

			if ( qtdContratos > 1 )
			{

				selecionaContrato();

			}
		}

	}

	public static void acessarContrato(String inscricao, int qtdClientes)
	{

		DriverUtils.iterarTelaPrincipal();

		MenuPage.atendimentoCentralizado();

		FramePrincipalPage.preencherInscricao(inscricao, qtdClientes);

		acessarContrato();

	}

	public static void acessarContrato()
	{

		DriverUtils.clicar(btnContrato);

		DriverUtils.esperarPorAjax();

	}

	public String getSaldoDevedor()
	{
		return saldoDevedor.getText();
	}

	public String getValorFatura()
	{
		String valor = DriverUtils.getDriver().findElement(By.id("tblDadosFatura"))
				.findElements(By.tagName("table")).get(1)
				.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"))
				.get(7).getText().substring(3);

		return valor;
	}

	public static void refresh()
	{

		DriverUtils.clicar(btnRefresh);
		DriverUtils.esperarPorAjax();

	}

	public static void selecionaContrato()
	{

		DriverUtils.clicar(optContratoAtivo);

		DriverUtils.esperarPorAjax();

		DriverUtils.clicar(btnFechar);

	}

	private static void selecionaClienteCpfCnpj()
	{

		DriverUtils.delay(1500);

		WebElement cliente = DriverUtils.getDriver().findElement(
				By.id(Atendimento.CLIENTE_ATIVO));

		DriverUtils.clicar(cliente);

		DriverUtils.esperarPorAjax();

		DriverUtils.clicar(btnFecharConsultaCliente);

	}

	public FrameTransferenciaDebitos getFrameTransferenciaDebito()

	{

		DriverUtils.avancarFrame();

		FrameTransferenciaDebitos frameTransferencia = PageFactory.initElements(
				DriverUtils.getDriver(), FrameTransferenciaDebitos.class);

		DriverUtils.esperarPorAjax();

		return frameTransferencia;

	}

	public FrameParcelamento getFrameParcelamento()
	{

		DriverUtils.avancarFrame();

		FrameParcelamento frameParcelamento = PageFactory.initElements(
				DriverUtils.getDriver(), FrameParcelamento.class);

		DriverUtils.esperarPorAjax();

		return frameParcelamento;

	}

	public static FrameMovimentarRecAntecipado getFrameMovimentarRecAntecipado()
	{

		DriverUtils.avancarFrame();

		DriverUtils.esperarPorAjax();

		FrameMovimentarRecAntecipado frameMovimentarRecAntecipado = PageFactory
				.initElements(driver, FrameMovimentarRecAntecipado.class);

		return frameMovimentarRecAntecipado;

	}

	public static void fecharPopup() throws InterruptedException
	{

		DriverUtils.clicar(popupInformacaoBotaoFechar);

	}

	public void consultarLogradouro() throws InterruptedException
	{

		DriverUtils.clicar(btnConsultarLogradouro);

	}

	public static void acessarLancamentosFuturos()
	{

		DriverUtils.clicar(lancamentosFuturos);

		DriverUtils.esperarPorAjax();

	}

}
