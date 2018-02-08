package pages;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pages.validacao.ValidacaoAtendimento;
import servicos.ServicoPadrao;
import auxiliares.Atendimento;
import auxiliares.CalculoParcelas;
import auxiliares.DriverUtils;
import auxiliares.NumberUtilsIntegracao;
import auxiliares.ServiceTestBase;
import auxiliares.Util;
import enumerators.EnumLocalEntregaFatura;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
import enumerators.EnumTipoServicoSolicitado;
import frames.FramePesquisaClientePage;
import frames.FramePrincipalPage;

public class AtendimentoPage extends PageBase
{

	public AtendimentoPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/***************** CONSTANTES ********************/

	public static final String DESCRICAO_SERVICO = " DESCRIÇÃO DO SERVIÇO "
			+ Util.gerarTextoAleatorio(20);

	public static final String SOLICITANTE_SERVICO = " SOLICITANTE DO SERVIÇO "
			+ Util.gerarTextoAleatorio(15);

	private static final String MSG_ITEM_SERVICO_GRAVADO_SUCESSO = "Item de solicitação de serviço gravado com sucesso.";

	private static final String STA_PENDENTE_EXECUCAO = "PENDENTE DE EXECUÇÃO";

	private static final String OPT_CANCELAMENTO = "TROTE";

	private static final String MSG_TELA_ADVERTENCIA = "Existem faturas em aberto associadas ao item de atendimento cancelado.";

	/***************************************************/

	/** OPCOES --------------------------------------------------- */

	@FindBy(how = How.ID, using = Atendimento.SITUACAO_FINANCEIRA)
	public static WebElement btnSituacaoFinanceira;

	@FindBy(how = How.ID, using = "frmCadastro:valorRealCobrar_mskmoeda")
	public static WebElement lblValorRealCobrar;

	@FindBy(how = How.ID, using = "frmCadastro:frmLogradouro:numImovelSolicitante")
	public static WebElement txtNrImovel;

	@FindBy(how = How.ID, using = "frmCadastro:frmLogradouro:btnAddComplemento")
	public static WebElement btnAddComplemento;

	/** OPCÃO CONTRATO --------------------------------------------- */
	@FindBy(how = How.ID, using = Atendimento.CONTRATO)
	public static WebElement btnContrato;

	@FindBy(how = How.ID, using = Atendimento.SF_LANCAMENTOS_FUTUROS)
	public static WebElement lancamentosFuturo;

	@FindBy(how = How.ID, using = "tblDadosFatura")
	public static WebElement tblDadosFatura;

	// @FindBy(how = How.CSS, using = Atendimento.BTN_CONSULTAR_ATENDIMENTO)
	// public static WebElement btnConsultarAtendimento;

	@FindBy(how = How.ID, using = Atendimento.TIPO_STATUS_ATENDIMENTO)
	public static WebElement optConsultarAtendimento;

	@FindBy(how = How.ID, using = Atendimento.CODIGO_SERVICO_CENTRALIZADO)
	public static WebElement servicoCentralizado;

	@FindBy(how = How.ID, using = Atendimento.TIPO_CANCELAMENTO)
	private static WebElement cmbCancelarAtendimento;

	@FindBy(how = How.ID, using = "selectTipoMotivo")
	private static WebElement cmbMotivoCancelamento;

	@FindBy(how = How.ID, using = Atendimento.NUMERO_OS)
	private static WebElement osVinculada;

	@FindBy(how = How.ID, using = "frmCadBaixa:frmDadosBaixa:vlrMultaIrregularidade_mskmoeda")
	public static WebElement lblMultaInfracao;

	@FindBy(how = How.ID, using = "btnTransferenciaDebitoCredito")
	public static WebElement btnTransferenciaDebitoCredito;

	@FindBy(how = How.ID, using = Atendimento.CMB_SERVICO_SOLICITADO)
	public static WebElement cmbServicoSolicitado;

	@FindBy(how = How.ID, using = Atendimento.BTN_SIM_ADVERTENCIA)
	public static WebElement btnSimAdvertencia;

	/** ---------------------------------------------------------- */

	@FindBy(how = How.ID, using = Atendimento.BTN_SALVAR)
	public static WebElement btnSalvar;

	@FindBy(how = How.ID, using = "btnIntegracao")
	private static WebElement btnIntegracao;

	@FindBy(how = How.ID, using = "btnNaoFinalizarAtendimento")
	private static WebElement btnFinalizarAtendimento;

	@FindBy(how = How.ID, using = "frmCadBaixa:subFormDadosNovoContrato:formDadosNovoContrato:localEntregaFatura")
	public static WebElement selectLocalEntrega;

	@FindBy(how = How.ID, using = "frmCadBaixa:frmDadosBaixa:btpVencimentoOpcional")
	public static WebElement selectVencimentoOpcional;

	@FindBy(how = How.ID, using = "outTxtResAtdCliNumCpfCnpj")
	public static WebElement nrAtendimento;

	/* BOTÕES DO GRUPOS DE INFORMAÇÕES */
	@FindBy(how = How.ID, using = "btnFecharContrato")
	public static WebElement btnFecharContrato;

	@FindBy(how = How.ID, using = "btnFecharCliente")
	public static WebElement btnFecharCliente;

	/* DADOS DO IMOVEL */
	@FindBy(how = How.ID, using = "btnFecharImovel")
	public static WebElement btnFecharImovel;

	@FindBy(how = How.ID, using = "tblListaLigacaoImoveldd1")
	public static WebElement ligacaoEsgoto;

	@FindBy(how = How.ID, using = "outTxtResAtdAteSeqAtendimento")
	public static WebElement idAtendimento;

	@FindBy(how = How.ID, using = "selCancelarAtendimento2")
	private static WebElement motivoCancelamento;

	@FindBy(how = How.ID, using = Atendimento.CONSULTAR_ITEM_ATENDIMENTO)
	private static WebElement consultarItemAtendimento;

	@FindBy(how = How.ID, using = "tblDadosIta:0:btnCancelarItemAtendimento")
	private static WebElement cancelarItemAtendimento;

	@FindBy(how = How.XPATH, using = ".//*[@id='pnlConteudoSituacaoFinanceira']/div/span/table/tbody/tr/td[3]/div/span[2]")
	public static WebElement lblTotalDebito;

	@FindBy(how = How.XPATH, using = ".//*[@id='pnlConteudoSituacaoFinanceira']/div/span/table/tbody/tr/td[4]/div/span[2]")
	public static WebElement lblLancamentoFuturo;

	@FindBy(how = How.ID, using = Atendimento.VLR_MIN_PARCELA)
	public static WebElement lblVlrMinParcela;

	@FindBy(how = How.ID, using = "frmCadastro:valorParcela_mskmoeda")
	public static WebElement lblVlrParcela;

	@FindBy(how = How.ID, using = "frmCadastro:residuoUltimaParcela_mskmoeda")
	public static WebElement lblResiduoUltimaParcela;

	@FindBy(how = How.ID, using = "btnRefresh")
	public static WebElement btnRefresh;

	@FindBy(how = How.ID, using = Atendimento.DESCRICAO_SERVICO)
	public static WebElement txtDescricaoServico;

	@FindBy(how = How.ID, using = Atendimento.SOLICITANTE)
	public static WebElement txtSolicitante;

	@FindBy(how = How.ID, using = Atendimento.VALOR_COBRAR)
	public static WebElement txtValorCobrar;

	@FindBy(how = How.ID, using = Atendimento.VALOR_ENTRADA)
	public static WebElement txtValorEntrada;

	@FindBy(how = How.ID, using = Atendimento.QTD_PARCELA)
	public static WebElement qtdParcela;

	@FindBy(how = How.ID, using = "frmCadastro:registrarSemOnus")
	public static WebElement optSemOnus;

	@FindBy(how = How.XPATH, using = ".//*[@id='tblDadosAtPrincipal']/table[2]/tbody/tr[2]/td[1]")
	public static WebElement lblCodigoServico;

	@FindBy(how = How.XPATH, using = ".//*[@id='tblDadosAtPrincipal']/table[2]/tbody/tr[3]/td[1]")
	public static WebElement lblCodigoServico2;

	@FindBy(how = How.ID, using = "selectTipoMotivo")
	public static WebElement cmbTipoMotivo;

	@FindBy(how = How.ID, using = Atendimento.SELECT_CARRO)
	public static WebElement selectCarro;

	@FindBy(how = How.ID, using = Atendimento.TXT_NUMERO_PROTOCOLO)
	public static WebElement txtNumeroProtocolo;

	@FindBy(how = How.ID, using = Atendimento.TXT_VOLUME)
	public static WebElement txtVolume;

	@FindBy(how = How.ID, using = Atendimento.PAVIMENTO_RUA)
	public static WebElement pavimentoRua;

	@FindBy(how = How.XPATH, using = ".//*[@id='tblDados']/table[2]/tbody/tr[3]/td[5]")
	public static WebElement lblTipoPadrao;

	@FindBy(how = How.ID, using = "subFormInscricao:conInscricao_mskinteiro")
	public static WebElement lblInscricao;

	@FindBy(how = How.ID, using = "cmdConsultar")
	public static WebElement btnConsultar;

	@FindBy(how = How.ID, using = Atendimento.TXT_DT_PREVISAO)
	public static WebElement txtDtPrevisao;

	@FindBy(how = How.ID, using = "btnConsultarAtendimento")
	public static WebElement btnConsultarAtendimento;

	@FindBy(how = How.ID, using = "_btnConsultarAtendimento")
	public static WebElement imgConsultarAtendimento;

	@SuppressWarnings("static-access")
	public static Double verificarDebitoContrato(String inscricao, int qtdContrato)

	{

		ServiceTestBase.framePrincipal.preencherInscricao(inscricao, qtdContrato);

		AtendimentoPage.exibirSituacaoFinanceira();

		Double total = Util.converterFormatoRealDouble(lblTotalDebito.getText())
				+ Util.converterFormatoRealDouble(lblLancamentoFuturo.getText());

		return total;

	}

	public void finalizarSolicitacaoServico(ServicoPadrao servico)
	{

		DriverUtils.clicar(btnSalvar);

		DriverUtils.esperarPorAjax();

		naoRegistrarMaisAtendimento(servico);

	}

	@SuppressWarnings("static-access")
	public void confirmarServicoCasado(EnumTipoPagamento tipoPgto,
			ValidacaoAtendimento validacao)
	{

		DriverUtils.clicar(ServiceTestBase.framePrincipal.btnFecharTelaMensagem);

		executarTipoPagamento(tipoPgto, validacao);

		DriverUtils.clicar(btnSalvar);

		DriverUtils.esperarPorAjax();

	}

	public void concluirAtendimento(boolean finalizar)
	{
		if ( finalizar )
		{

			DriverUtils.clicar(btnSalvar);
		}

	}

	public void naoRegistrarMaisAtendimento(ServicoPadrao servico)
	{

		DriverUtils.clicar(btnFinalizarAtendimento);

		DriverUtils.esperarPorAjax();

		servico.setNrAtendimento(idAtendimento.getText());

		ArrayList<Integer> servs = new ArrayList<Integer>();

		for (WebElement elemento : DriverUtils.getDriver().findElements(
				By.xpath(".//*[@id='tblDadosAtPrincipal']/table[2]/tbody/tr[*]/td[1]")))
		{
			servs.add(Integer.parseInt(elemento.getText()));
		}

		Assert.assertTrue(servs.contains(servico.getServicos().get(0).getCodigo()));

		if ( servico.getServicos().size() > 1 )
		{
			Assert.assertTrue(servs
					.contains(servico.getServicos().get(1).getCodigo()));
		}

	}

	public static void selecionarLocalEntrega(
			EnumLocalEntregaFatura localEntregaFatura) throws InterruptedException
	{
		DriverUtils.selecionarComboPeloValor(selectLocalEntrega,
				localEntregaFatura.ordinal());
	}

	public void selecionarVencimentoOpcional() throws InterruptedException
	{
		DriverUtils.selecionarComboPeloIndice(selectVencimentoOpcional,
				Util.gerarNumero(4));
	}

	public static void exibirSituacaoFinanceira()
	{

		DriverUtils.clicar(btnSituacaoFinanceira);

		DriverUtils.esperarPorAjax();

	}

	public static void exibirDadosdoContrato() throws InterruptedException
	{
		DriverUtils.clicar(btnContrato);

		DriverUtils.esperarPorAjax();

	}

	public static void movimentarIntegracao()
	{

		DriverUtils.clicar(btnIntegracao);

		DriverUtils.esperarPorAjax();

	}

	public void exibirDadosImovel()
	{

		DriverUtils.clicar(btnFecharContrato);
		DriverUtils.clicar(btnFecharCliente);

	}

	public void executarTipoPagamento(EnumTipoPagamento tipoPgto,
			ValidacaoAtendimento validacao)
	{

		String valorEspecie;

		String maxParcelas;

		Integer maximoParcelas;

		FramePrincipalPage framePrincipal = PageFactory.initElements(
				DriverUtils.getDriver(), FramePrincipalPage.class);

		DriverUtils.escrever(txtDescricaoServico, DESCRICAO_SERVICO);

		DriverUtils.escrever(txtSolicitante, SOLICITANTE_SERVICO);

		switch (tipoPgto)
		{

			case A_VISTA:
			{

				if ( DriverUtils
						.getDriver()
						.findElements(
								By.id("frmCadBaixa:frmDadosBaixa:vlrMultaIrregularidade_mskmoeda"))
						.size() > 0 )
				{
					valorEspecie = lblMultaInfracao.getAttribute("value");

				}
				else
				{
					valorEspecie = Util
							.converterFormatoDoubleReal(framePrincipal.faixaValorInicio
									.getText());

				}

				DriverUtils.limparCampo(txtValorCobrar);

				DriverUtils.limparCampo(txtValorEntrada);

				DriverUtils.escrever(txtValorCobrar, Keys.BACK_SPACE + valorEspecie);

				DriverUtils.escrever(txtValorEntrada, Keys.BACK_SPACE + valorEspecie);

				Double valorCobrado = Util.converterFormatoRealDouble(valorEspecie)
						+ validacao.getValorPgtoVista();

				validacao.setValorPgtoVista(valorCobrado);

				break;
			}

			case PARCELADO_COM_ENTRADA:
			{

				if ( DriverUtils
						.getDriver()
						.findElements(
								By.id("frmCadBaixa:frmDadosBaixa:vlrMultaIrregularidade_mskmoeda"))
						.size() > 0 )
				{
					valorEspecie = lblMultaInfracao.getAttribute("value");
				}
				else
				{
					valorEspecie = Util.converterFormatoRealDouble(
							framePrincipal.faixaValorInicio.getText()).toString();

				}

				maxParcelas = framePrincipal.qtdMaxParcela.getText();

				Double entradaDouble = 0.0;

				DriverUtils.limparCampo(txtValorCobrar);

				DriverUtils.limparCampo(txtValorEntrada);

				DriverUtils.limparCampo(qtdParcela);

				entradaDouble = Util
						.arredondar(((Double.parseDouble(valorEspecie)) / Double
								.parseDouble(maxParcelas)));

				DriverUtils.escrever(txtValorEntrada,
						Keys.BACK_SPACE + Util.converterFormatoDoubleReal(entradaDouble));

				DriverUtils.escrever(
						txtValorCobrar,
						Keys.BACK_SPACE
								+ Util.converterFormatoDoubleReal(Double
										.parseDouble(valorEspecie)));

				maxParcelas = auxCalculoParceladoComEntrada(entradaDouble,
						Integer.parseInt(maxParcelas) - 1);

				Double valorCobrado = entradaDouble + validacao.getValorPgtoVista();

				validacao.setValorRealCobrar(valorCobrado);

				Double pgtoPrazo = NumberUtilsIntegracao.truncarValor((Integer
						.parseInt(maxParcelas) * Util
						.converterFormatoRealDouble(lblVlrParcela.getAttribute("value")))
						+ Util.converterFormatoRealDouble(lblResiduoUltimaParcela
								.getAttribute("value")));

				validacao.setValorPgtoPrazo(pgtoPrazo);

				break;
			}

			case PARCELADO_SEM_ENTRADA:

				Double ini = Double.parseDouble(framePrincipal.faixaValorInicio
						.getText().replaceAll("\\.", "").replace(",", "."));
				Double fim = Double.parseDouble(framePrincipal.faixaValorFinal
						.getText().replaceAll("\\.", "").replace(",", "."));
				Integer par = Integer.parseInt(framePrincipal.qtdMaxParcela.getText());
				Double minPar = Double.parseDouble(framePrincipal.valorMinimoParcela
						.getText().replaceAll("\\.", "").replace(",", "."));

				CalculoParcelas calculo = new CalculoParcelas(ini, fim, par, minPar,
						0.0);

				maxParcelas = framePrincipal.qtdMaxParcela.getText();

				DriverUtils.limparCampo(txtValorCobrar);

				DriverUtils.limparCampo(qtdParcela);

				DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");

				DriverUtils.escrever(
						txtValorCobrar,
						Keys.BACK_SPACE
								+ df2.format(calculo.getVlrBaseCalculo()).toString()
										.replace(".", ""));

				maximoParcelas = Integer.parseInt(maxParcelas);

				DriverUtils.escrever(qtdParcela, calculo.getNrCalcParcela().toString()
						+ Keys.TAB);

				validacao.setValorPgtoPrazo(Double.parseDouble(lblValorRealCobrar
						.getAttribute("value").replaceAll("\\.", "").replace(",", "."))
						+ validacao.getValorPgtoPrazo());

				break;

			case A_VISTA_PARCELADO:

				valorEspecie = framePrincipal.faixaValorInicio.getText();

				maxParcelas = "1";

				DriverUtils.limparCampo(txtValorCobrar);

				DriverUtils.limparCampo(qtdParcela);

				DriverUtils.escrever(txtValorCobrar, Keys.BACK_SPACE + valorEspecie);

				DriverUtils.escrever(qtdParcela, maxParcelas + Keys.TAB);

				validacao.setValorPgtoPrazo(Double.parseDouble(lblValorRealCobrar
						.getAttribute("value").replaceAll("\\.", "").replace(",", "."))
						+ validacao.getValorPgtoPrazo());
				break;

			case SEM_ONUS:

				if ( !optSemOnus.isSelected() )
				{

					DriverUtils.clicar(optSemOnus);

				}
				break;

			case SEM_CUSTO:

				break;

		}

	}

	private static String auxCalculoParceladoComEntrada(Double valorEntrada,
			Integer quantidade)
	{

		DriverUtils.escrever(qtdParcela, quantidade.toString() + Keys.TAB);

		DriverUtils.delay(1000);

		if ( quantidade > 1 )
		{
			Double vlrMinParcela = Util.converterFormatoRealDouble(lblVlrMinParcela
					.getText());

			Double vlrParcela = Util.converterFormatoRealDouble(lblVlrParcela
					.getAttribute("value"));

			if ( vlrParcela >= vlrMinParcela )
			{

				return quantidade.toString();
			}
			else
			{

				qtdParcela.clear();

				return auxCalculoParceladoComEntrada(valorEntrada, --quantidade);
			}

		}
		else
		{

			return "1";
		}

	}

	public void informarServico(String servico)
	{

		FramePrincipalPage framePrincipal = ServiceTestBase.framePrincipal;

		framePrincipal.solicitarServico(servico);
	}

	public void cancelarServicosPendentes(List<EnumServico> servicos)

	{
		for (EnumServico servico : servicos)
		{

			excluirServico(servico.getCodigo().toString());

		}

		if ( FramePrincipalPage.mensagemExibida(MSG_TELA_ADVERTENCIA) )
		{

			DriverUtils.clicar(ServiceTestBase.framePrincipal.btnFecharTelaMensagem);

		}
	}

	// @SuppressWarnings("static-access")
	// private static void cancelarServicosPendentes(List<EnumServico> servicos)
	//
	// {
	// for (EnumServico servico : servicos)
	// {
	//
	// excluirServico(servico.getCodigo().toString());
	//
	// }
	//
	// if ( FramePrincipalPage.mensagemExibida(MSG_TELA_ADVERTENCIA) )
	// {
	//
	// DriverUtils.clicar(ServiceTestBase.framePrincipal.btnFecharTelaMensagem);
	//
	// }
	// }

	private static void excluirServico(String servico)
	{

		if ( DriverUtils.getDriver().findElement(By.id("btnConsultarAtendimento"))
				.isDisplayed() )
		{

			DriverUtils.clicar(btnConsultarAtendimento);

		}
		else
		{

			DriverUtils.clicar(imgConsultarAtendimento);

		}

		DriverUtils.esperarPorAjax();

		DriverUtils.selecionarComboPeloNome(optConsultarAtendimento,
				STA_PENDENTE_EXECUCAO);

		DriverUtils.limparCampo(servicoCentralizado);

		DriverUtils.escrever(servicoCentralizado, servico);

		DriverUtils.clicar(consultarItemAtendimento);

		DriverUtils.esperarPorAjax();

		if ( DriverUtils.getDriver()
				.findElements(By.id("tblDadosIta:0:btnCancelarItemAtendimento")).size() > 0 )
		{

			DriverUtils.clicar(cancelarItemAtendimento);

			DriverUtils.esperarPorAjax();

			DriverUtils.delay(1000);

			DriverUtils.getDriver().switchTo().frame(0);

			DriverUtils.selecionarComboPeloNome(cmbCancelarAtendimento,
					OPT_CANCELAMENTO);

			DriverUtils.clicar(btnSalvar);

			DriverUtils.esperarPorAjax();

			DriverUtils.delay(2000);

			DriverUtils.getTelaAtual();

		}

	}

	public static void preencherNumeroImovel()
	{

		DriverUtils.escrever(txtNrImovel, Util.gerarNumero(99999).toString());

		DriverUtils.clicar(btnAddComplemento);

		DriverUtils.esperarPorAjax();
	}

	public static void pesquisarCliente(String inscDestino)
			throws InterruptedException
	{

		FramePesquisaClientePage framePesquisaCliente = ServiceTestBase.framePrincipal
				.getFramePesquisaCliente();

		framePesquisaCliente.consultarCliente(inscDestino);

		setTelaAtendimentoPage();

	}

	public static void preencherServicoSolicitado(
			EnumTipoServicoSolicitado tipoServico)
	{

		DriverUtils.selecionarComboPeloNome(cmbServicoSolicitado,
				tipoServico.getNomeAmigavel());

		DriverUtils.esperarPorAjax();

	}

	public static void aceitarDebitosAdvertencia()
	{

		DriverUtils.clicar(btnSimAdvertencia);

		DriverUtils.esperarPorAjax();
	}

}
