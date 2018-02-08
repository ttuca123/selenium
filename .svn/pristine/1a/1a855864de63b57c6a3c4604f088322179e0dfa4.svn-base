package pages.bci;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.MenuPage;
import pages.PageBase;
import servicos.ServicoPadrao;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumAreaTipoPadrao;
import enumerators.EnumTipoConstrucao;
import enumerators.EnumTipoEconomia;
import enumerators.EnumTipoPadrao;
import enumerators.EnumTipoPiso;

/**
 * 
 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 20/01/2016 -
 *         18:18:02.
 *
 */
public class BciPageConsultaImovel extends PageBase implements IBci
{

	private static final String MSG_SEM_ECONOMIAS = "Ao menos uma categoria deve ser informada para o imóvel.";

	public static String qtdPontosUtilizacao;

	@SuppressWarnings("static-access")
	public BciPageConsultaImovel(WebDriver webdriver)
	{
		super(driver);
		this.driver = webdriver;
	}

	@FindBy(how = How.ID, using = "subFormInscricao:conInscricao_mskinteiro")
	public static WebElement lblInscricao;

	@FindBy(how = How.ID, using = "cmdConsultar")
	public static WebElement btnConsultar;

	@FindBy(how = How.ID, using = "tblDados:cmdAlterar")
	public static WebElement btnAlterar;

	@FindBy(how = How.ID, using = "tblDados:1")
	public static WebElement optPrimeiraOpcao;

	@FindBy(how = How.ID, using = "subformPadrao:atributosEspeciais:_2")
	public static WebElement flgForro;

	@FindBy(how = How.ID, using = "subformPadrao:atributosEspeciais:_3")
	public static WebElement flgGaragem;

	@FindBy(how = How.ID, using = "subformPadrao:atributosEspeciais:_4")
	public static WebElement flgJardim;

	@FindBy(how = How.ID, using = "subformPadrao:cadAreaConstruida_mskinteiro")
	public static WebElement txtAreaConstruida;

	@FindBy(how = How.ID, using = "subformPadrao:cadPiscina_mskinteiro")
	public static WebElement txtPiscinaCpd;

	@FindBy(how = How.ID, using = "subformPadrao:cadPadraoImovel")
	public static WebElement txtPadraoImovel;

	@FindBy(how = How.ID, using = "subformPadrao:cadQtdBanheiro_mskinteiro")
	public static WebElement txtQtdBanheiro;

	@FindBy(how = How.ID, using = "subformPadrao:btnCalculaPadraoConsumoPresumido")
	public static WebElement btnCalcularPadrao;

	@FindBy(how = How.ID, using = "subformCategoriaPavimento:tblDados1:0")
	public static WebElement optEconomia1;

	@FindBy(how = How.ID, using = "subformCategoriaPavimento:tblDados1:0:itemCategoria")
	public static WebElement cmbCategoria1;

	@FindBy(how = How.ID, using = "subformCategoriaPavimento:tblDados1:1")
	public static WebElement optEconomia2;

	@FindBy(how = How.ID, using = "subformCategoriaPavimento:tblDados1:1:itemCategoria")
	public static WebElement cmbCategoria2;

	@FindBy(how = How.XPATH, using = ".//*[@id='abaPrincipal']/ul/li[4]")
	public static WebElement abaCaracteristicas;

	@FindBy(how = How.XPATH, using = ".//*[@id='abaPrincipal']/ul/li[3]")
	public static WebElement abaCategoria;

	@FindBy(how = How.ID, using = "subformCategoriaPavimento:tblDados1:cmdNovoCategoria")
	public static WebElement btnNovaCategoria;

	@FindBy(how = How.ID, using = "subformPadrao:cadTipoPiso")
	public static WebElement cmbTipoPiso;

	@FindBy(how = How.ID, using = "subformPadrao:cadTipoConstrucao")
	public static WebElement cmbTipoConstrucao;

	@FindBy(how = How.ID, using = "subformPadrao:cadPontosUtilizacao_mskinteiro")
	public static WebElement txtPontosUtilizacao;

	@FindBy(how = How.ID, using = "subformPadrao:cadFlgEstPrecariaDeteriorada")
	public static WebElement flgEstruturaPrecaria;

	@FindBy(how = How.ID, using = "subformPadrao:cadFlgPadraoImovelVago")
	public static WebElement flgPadraoVago;

	@FindBy(how = How.XPATH, using = ".//*[@id='tblDados']/table[2]/tbody/tr[3]/td[5]")
	public static WebElement lblTipoPadrao;

	@FindBy(how = How.ID, using = "cmdAlterar")
	public static WebElement btnSalvar;

	@FindBy(how = How.ID, using = "subformCategoriaPavimento:tblDados1:cmdExcluirCategoria")
	public static WebElement btnExcluir;

	@FindBy(how = How.ID, using = "subformCategoriaPavimento:tblDados1:0:qtdEco_mskinteiro")
	public static WebElement txtQtdEconomia1;

	@FindBy(how = How.ID, using = "subformCategoriaPavimento:tblDados1:1:qtdEco_mskinteiro")
	public static WebElement txtQtdEconomia2;

	private Map<EnumTipoEconomia, Boolean> tipoEconomias;

	public void consultarImovel(ServicoPadrao servico)
			throws InterruptedException
	{
		DriverUtils.delay(500);

		driver.switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(MenuPage.FRAME_PRINCIPAL_ACI)));

		DriverUtils.escrever(lblInscricao, servico.getInscOrigem().toString());

		DriverUtils.clicar(btnConsultar);

		DriverUtils.esperarPorAjax();

		alterarImovel();

		tipoEconomias = new HashMap<EnumTipoEconomia, Boolean>();

	}

	private static void alterarImovel()
	{

		DriverUtils.clicar(optPrimeiraOpcao);

		DriverUtils.clicar(btnAlterar);

		DriverUtils.esperarPorAjax();

	}

	@Override
	public void testDefinirPadraoVago()
	{

		DriverUtils.duploCliqueComAjax(abaCaracteristicas);

		if ( !flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtQtdBanheiro);
		DriverUtils.escrever(txtQtdBanheiro, QTD_BANHEIROS);

		DriverUtils.limparCampo(txtPontosUtilizacao);
		DriverUtils.escrever(txtPontosUtilizacao, "20");

		DriverUtils.clicar(btnSalvar);
		DriverUtils.esperarPorAjax();

		DriverUtils.delay(1000);

		Assert.assertEquals(EnumTipoPadrao.VAGO.getNomeAmigavel(), lblTipoPadrao
				.getText().trim());

	}

	@Override
	public void testDefinirSemEconomias()
	{

		tipoEconomias = new HashMap<EnumTipoEconomia, Boolean>();
		tipoEconomias.put(EnumTipoEconomia.NENHUM, true);

		DriverUtils.duploCliqueComAjax(abaCategoria);

		verificarEconomias();

		DriverUtils.duploCliqueComAjax(abaCaracteristicas);

		DriverUtils.limparCampo(txtQtdBanheiro);
		DriverUtils.escrever(txtQtdBanheiro, QTD_BANHEIROS);

		qtdPontosUtilizacao = "1";

		DriverUtils.limparCampo(txtPontosUtilizacao);
		DriverUtils.escrever(txtPontosUtilizacao, qtdPontosUtilizacao);

		DriverUtils.clicar(btnSalvar);
		DriverUtils.esperarPorAjax();

		List<String> mensagensRetorno = new ArrayList<String>();
		{
			mensagensRetorno.add(MSG_SEM_ECONOMIAS);
		}

		Util.verificarMensagem(mensagensRetorno);

	}

	@Override
	public void testDefinirComEmpateUmaEconomiaResidencial()
			throws InterruptedException
	{

		DriverUtils.duploCliqueComAjax(abaCategoria);

		tipoEconomias = new HashMap<EnumTipoEconomia, Boolean>();

		tipoEconomias.put(EnumTipoEconomia.RESIDENCIAL, false);

		verificarEconomias();

		incluirEconomia();

		qtdPontosUtilizacao = "1";

		driver.findElement(By.cssSelector("input[id$='qtdEco_mskinteiro']"))
				.clear();

		DriverUtils.esperarPorAjax();

		driver.findElement(By.cssSelector("input[id$='qtdEco_mskinteiro']"))
				.sendKeys(qtdPontosUtilizacao);

		DriverUtils.duploCliqueComAjax(abaCaracteristicas);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);

		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.TACO_SINTETICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TIJOLO_CONCRETO.getNomeAmigavel());

		if ( flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);

	}

	/**
	 * Básico x Regular x Alto
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Override
	public void testDefinirEmpateComTresPadroesBRADuasEconomiasRegular()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.COMERCIAL,
				EnumTipoEconomia.INDUSTRIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.ALTO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.INDUSTRIAL.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TIJOLO_CONCRETO.getNomeAmigavel());

		if ( flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.REGULAR);

	}

	/**
	 * Básico x Regular x Médio
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Override
	public void testDefinirEmpateComTresPadroesBRMDuasEconomiasRegular()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.INDUSTRIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.CERAMICA_SIMPLES.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TIJOLO.getNomeAmigavel());

		if ( flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( !flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.REGULAR);

	}

	/**
	 * Básico x Médio x Alto
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Override
	public void testDefinirEmpateComTresPadroesBMADuasEconomiasMedio()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.COMERCIAL,
				EnumTipoEconomia.RESIDENCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.BASICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.CERAMICA_ESMALTADA.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.MADEIRA_CONGLOMERADO.getNomeAmigavel());

		if ( !flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( !flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);

	}

	/**
	 * Regular x Médio x Alto
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Override
	public void testDefinirEmpateComTresPadroesRMADuasEconomiasMedio()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.COMERCIAL,
				EnumTipoEconomia.RESIDENCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.REGULAR.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.MOSAICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TIJOLO.getNomeAmigavel());

		if ( !flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( !flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( !flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);

	}

	/**
	 * Básico x Regular
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Override
	public void testDefinirEmpateComDoisPadroesBRDuasEconomias()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.COMERCIAL,
				EnumTipoEconomia.INDUSTRIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.TACO_SINTETICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TIJOLO_CONCRETO.getNomeAmigavel());

		if ( flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.REGULAR);

	}

	/**
	 * Básico x Médio
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Override
	public void testDefinirEmpateComDoisPadroesBMDuasEconomias()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.COMERCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.BASICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.PAVIFLEX.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.MADEIRA_PURA.getNomeAmigavel());

		if ( flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( !flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);

	}

	/**
	 * Básico x Alto
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Override
	public void testDefinirEmpateComDoisPadroesBADuasEconomias()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.PUBLICA,
				EnumTipoEconomia.INDUSTRIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.ALTO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.TERRA_BATIDA.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TAIPA.getNomeAmigavel());

		if ( flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( !flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( !flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.ALTO);

	}

	/**
	 * Regular x Médio
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Override
	public void testDefinirEmpateComDoisPadroesRMDuasEconomias()

	{

		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.INDUSTRIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.MOSAICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TIJOLO.getNomeAmigavel());

		if ( !flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( !flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);

	}

	/**
	 * Regular x Alto
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Override
	public void testDefinirEmpateComDoisPadroesRADuasEconomias()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.PUBLICA);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.ALTO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.MOSAICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TIJOLO.getNomeAmigavel());

		if ( !flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( !flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.ALTO);

	}

	/**
	 * Médio x Alto
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Override
	public void testDefinirEmpateComDoisPadroesMADuasEconomias()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.PUBLICA);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.BASICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.MOSAICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TIJOLO.getNomeAmigavel());

		if ( !flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( !flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( !flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.ALTO);

	}

	/**
	 * Regra 3: Imóvel com mais de uma economia residencial, estrutura precária e
	 * empatados
	 */

	/**
	 * Básico x Regular
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Override
	public void testDefinirEmpateComDoisPadroesBRDuasEconomiasPrecaria()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.COMERCIAL,
				EnumTipoEconomia.INDUSTRIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.TACO_SINTETICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TIJOLO_CONCRETO.getNomeAmigavel());

		if ( flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( !flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.BASICO);

	}

	/**
	 * Básico x Médio
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Override
	public void testDefinirEmpateComDoisPadroesBMDuasEconomiasPrecaria()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.COMERCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.TACO_SIMPLES.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TAIPA.getNomeAmigavel());

		if ( flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( !flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( !flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.REGULAR);

	}

	/**
	 * Básico x Alto
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Override
	public void testDefinirEmpateComDoisPadroesBADuasEconomiasPrecaria()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.PUBLICA,
				EnumTipoEconomia.INDUSTRIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.ALTO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.TACO_SINTETICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TAIPA.getNomeAmigavel());

		if ( flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( !flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( !flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.REGULAR);

	}

	/**
	 * Regular x Médio
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Override
	public void testDefinirEmpateComDoisPadroesRMDuasEconomiasPrecaria()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.INDUSTRIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.MOSAICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TIJOLO.getNomeAmigavel());

		if ( !flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( !flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( !flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.REGULAR);
	}

	/**
	 * Regular x Alto
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Override
	public void testDefinirEmpateComDoisPadroesRADuasEconomiasPrecaria()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.PUBLICA);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.ALTO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.MOSAICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TIJOLO.getNomeAmigavel());

		if ( !flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( !flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( !flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);

	}

	/**
	 * Médio x Alto
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Override
	public void testDefinirEmpateComDoisPadroesMADuasEconomiasPrecaria()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.PUBLICA);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		DriverUtils.limparCampo(txtAreaConstruida);
		DriverUtils.escrever(txtAreaConstruida,
				EnumAreaTipoPadrao.BASICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoPiso,
				EnumTipoPiso.MOSAICO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(cmbTipoConstrucao,
				EnumTipoConstrucao.TIJOLO.getNomeAmigavel());

		if ( !flgForro.isSelected() )
		{
			flgForro.click();
		}

		if ( !flgGaragem.isSelected() )
		{
			flgGaragem.click();
		}

		if ( !flgJardim.isSelected() )
		{
			flgJardim.click();
		}

		if ( !flgEstruturaPrecaria.isSelected() )
		{
			flgEstruturaPrecaria.click();
		}

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);
	}

	/**
	 * 
	 * @param economia1
	 * @param economia2
	 */

	@Override
	public void selecionarDuasEconomias(EnumTipoEconomia economia1,
			EnumTipoEconomia economia2)
	{

		tipoEconomias.put(economia1, false);
		System.out.println("oi");
		tipoEconomias.put(economia2, false);

		DriverUtils.duploCliqueComAjax(abaCategoria);

		verificarEconomias();

		incluirEconomia();

		definirPontosUtilizacao();

		DriverUtils.duploCliqueComAjax(abaCaracteristicas);

		DriverUtils.esperarPorAjax();
	}

	private static Integer verificarQtdSubEconomias(EnumTipoEconomia economia)
	{
		Integer qtdSubEconomia = 0;

		switch (economia)
		{

			case COMERCIAL:

				do
				{
					qtdSubEconomia = Util.gerarNumero(15);
				}
				while (qtdSubEconomia == 0);

				break;

			case INDUSTRIAL:

				do
				{
					qtdSubEconomia = Util.gerarNumero(15);
				}
				while (qtdSubEconomia == 0);

				break;

			case PUBLICA:

				do
				{
					qtdSubEconomia = Util.gerarNumero(14);
				}
				while (qtdSubEconomia == 0);

				break;

			case RESIDENCIAL:

				do
				{
					qtdSubEconomia = Util.gerarNumero(5);
				}
				while (qtdSubEconomia == 0);

				break;

			default:
				break;
		}

		return qtdSubEconomia;

	}

	@Override
	public void finalizarCalculoPadrao(EnumTipoPadrao tipoPadrao)
	{

		DriverUtils.limparCampo(txtQtdBanheiro);
		DriverUtils.escrever(txtQtdBanheiro, QTD_BANHEIROS);

		DriverUtils.limparCampo(txtPontosUtilizacao);
		DriverUtils.escrever(txtPontosUtilizacao, qtdPontosUtilizacao);

		DriverUtils.clicar(btnCalcularPadrao);
		DriverUtils.esperarPorAjax();
		List<String> mensagemRetorno = new ArrayList<String>();

		mensagemRetorno.add(MSG_SUCESSO);

		Util.verificarMensagem(mensagemRetorno);

		Assert.assertEquals(tipoPadrao.getNomeAmigavel(),
				txtPadraoImovel.getAttribute("value"));

		DriverUtils.clicar(btnSalvar);
		DriverUtils.esperarPorAjax();

		DriverUtils.delay(1000);

		Assert.assertEquals(tipoPadrao.getNomeAmigavel(), lblTipoPadrao.getText()
				.trim());

	}

	private static void definirPontosUtilizacao()
	{
		DriverUtils.delay(1500);

		Integer qtdPontos = 0;

		for (WebElement elemento : driver.findElements(By
				.cssSelector("input[id$=':qtdEco_mskinteiro']")))
		{

			qtdPontos = Integer.parseInt(elemento.getAttribute("value")) + qtdPontos;

		}
		qtdPontosUtilizacao = qtdPontos.toString();
	}

	private void verificarEconomias()
	{

		WebElement tabela = driver.findElement(By
				.id("subformCategoriaPavimento:tblDados1"));

		List<WebElement> linhas = tabela.findElements(By
				.cssSelector(".destaqueLinha"));

		for (int i = 0; i < linhas.size(); i++)
		{

			EnumTipoEconomia tipoEconomia;

			if ( DriverUtils.getValor(
					driver.findElement(By.cssSelector("select[id$='" + i
							+ ":itemCategoria']"))).isEmpty() )
			{
				tipoEconomia = EnumTipoEconomia.NENHUM;

			}
			else
			{

				tipoEconomia = EnumTipoEconomia.valueOf(Integer.parseInt(DriverUtils
						.getValor(driver.findElement(By.cssSelector("select[id$='" + i
								+ ":itemCategoria']")))));

			}

			if ( tipoEconomias.containsKey(tipoEconomia) )
			{

				tipoEconomias.put(EnumTipoEconomia.valueOf(Integer
						.parseInt((DriverUtils.getValor(driver.findElement(By
								.cssSelector("select[id$='" + i + ":itemCategoria']")))))),
						true);

			}
			else
			{

				for (Map.Entry<EnumTipoEconomia, Boolean> elemento : tipoEconomias
						.entrySet())
				{

					if ( !elemento.getValue()
							&& !elemento.equals(EnumTipoEconomia.NENHUM) )
					{

						DriverUtils
								.selecionarComboPeloNome(driver.findElement(By
										.cssSelector("select[id$='" + i + ":itemCategoria']")),
										elemento.getKey().getTipoEconomia());

						DriverUtils.selecionarComboPeloValor(
								driver.findElement(By.cssSelector("select[id$='" + i
										+ ":cadCategoria']")),
								verificarQtdSubEconomias(elemento.getKey()));

						driver.findElement(
								By.cssSelector("input[id$='" + i + ":qtdEco_mskinteiro']"))
								.clear();

						DriverUtils.esperarPorAjax();

						driver.findElement(
								By.cssSelector("input[id$='" + i + ":qtdEco_mskinteiro']"))
								.sendKeys("1");

						elemento.setValue(true);

						break;
					}
				}

			}
		}

	}

	private void incluirEconomia()
	{

		excluirEconomia();

		int i = driver.findElements(By.cssSelector("select[id$=':itemCategoria']"))
				.size() - 1;

		for (Map.Entry<EnumTipoEconomia, Boolean> elemento : tipoEconomias
				.entrySet())
		{

			if ( elemento.getValue() == false )
			{
				
				if(driver.findElements(By.cssSelector("select[id$='" + i
						+ ":itemCategoria']")).size()==0){
				
				DriverUtils.duploCliqueComAjax(btnNovaCategoria);

				DriverUtils.delay(1000);
				}

				if ( !DriverUtils.getValorCombo(
						driver.findElement(By.cssSelector("select[id$='" + i
								+ ":itemCategoria']"))).equals(
						elemento.getKey().getTipoEconomia()) )
				{

					WebElement itemCategoria = driver.findElement(By
							.cssSelector("select[id$='" + i + ":itemCategoria']"));

					DriverUtils.selecionarComboPeloNome(itemCategoria, elemento.getKey()
							.getTipoEconomia());

					DriverUtils.selecionarComboPeloValor(
							driver.findElement(By.cssSelector("select[id$='" + i
									+ ":cadCategoria']")),
							verificarQtdSubEconomias(elemento.getKey()));

					DriverUtils.esperarPorAjax();

					DriverUtils.delay(500);

					driver.findElement(
							By.cssSelector("input[id$='" + i + ":qtdEco_mskinteiro']"))
							.clear();

					DriverUtils.esperarPorAjax();

					driver.findElement(
							By.cssSelector("input[id$='" + i + ":qtdEco_mskinteiro']"))
							.sendKeys("1");

					elemento.setValue(true);
				}
			}
			i++;
		}

	}

	private String excluirEconomia()
	{

		int i = 0;

		if ( driver.findElements(By.cssSelector("select[id$='itemCategoria']"))
				.size() > 0 )
		{
			WebElement tabela = driver.findElement(By
					.id("subformCategoriaPavimento:tblDados1"));

			List<WebElement> linhas = tabela.findElements(By
					.cssSelector(".destaqueLinha"));

			for (WebElement coluna : linhas)
			{

				EnumTipoEconomia tipoEconomia;

				if ( DriverUtils.getValor(
						driver.findElement(By.cssSelector("select[id$='" + i
								+ ":itemCategoria']"))).isEmpty() )
				{
					tipoEconomia = EnumTipoEconomia.NENHUM;

				}
				else
				{

					tipoEconomia = EnumTipoEconomia.valueOf(Integer.parseInt(DriverUtils
							.getValor(driver.findElement(By.cssSelector("select[id$='" + i
									+ ":itemCategoria']")))));

				}

				if ( !tipoEconomias.containsKey(tipoEconomia) )
				{

					coluna.findElement(
							By.cssSelector("input[id^='subformCategoriaPavimento:tblDados1:"
									+ i + "']")).click();

					DriverUtils.clicar(btnExcluir);

					DriverUtils.esperarPorAjax();

					return excluirEconomia();
				}

				i++;
			}
		}
		return null;
	}

}