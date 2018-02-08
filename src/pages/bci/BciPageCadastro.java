package pages.bci;

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
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumAreaTipoPadrao;
import enumerators.EnumTipoConstrucao;
import enumerators.EnumTipoEconomia;
import enumerators.EnumTipoPadrao;
import enumerators.EnumTipoPiso;

public class BciPageCadastro extends PageBase implements IBci
{

	public static String qtdPontosUtilizacao = "15";

	private static final String MSG_SEM_ECONOMIAS = "Economia / Categoria: deve ser preenchida; com os campos: Tipo e Quantidade ; para efetuar o calculo do padrão imóvel.";

	@SuppressWarnings("static-access")
	public BciPageCadastro(WebDriver webDriver)
	{
		super(driver);
		this.driver = webDriver;
	}

	@FindBy(how = How.ID, using = "frmIncricao:imoInc_mskinteiro")
	public static WebElement txtInscricao;

	@FindBy(how = How.ID, using = "Cliente1:codLocal_mskinteiro")
	public static WebElement txtLocal;

	@FindBy(how = How.ID, using = "Cliente1:codSetor_mskinteiro")
	public static WebElement txtSetor;

	@FindBy(how = How.ID, using = "Imovel5:tipoConstrucao_mskinteiro")
	public static WebElement txtTipoConstrucao;

	@FindBy(how = How.ID, using = "Imovel5:tipoPiso_mskinteiro")
	public static WebElement txtTipoPiso;

	@FindBy(how = How.ID, using = "Imovel5:areaCoberta_mskinteiro")
	public static WebElement txtAreaConstruida;

	@FindBy(how = How.ID, using = "Imovel5:cadPadraoImvelVago")
	public static WebElement flgPadraoVago;

	@FindBy(how = How.ID, using = "Imovel5:flgEstPrecariaDeteriorada")
	public static WebElement flgEstruturaPrecaria;

	@FindBy(how = How.ID, using = "Imovel5:subFormBanheiro:cadQtdBanheiro_mskinteiro")
	public static WebElement txtQtdBanheiro;

	@FindBy(how = How.ID, using = "Imovel5:subFormBanheiro:pontosUtilizacao_mskinteiro")
	public static WebElement txtPontosUtilizacao;

	@FindBy(how = How.ID, using = "Imovel5:atributosEspeciais:_0")
	public static WebElement flgForro;

	@FindBy(how = How.ID, using = "Imovel5:atributosEspeciais:_1")
	public static WebElement flgGaragem;

	@FindBy(how = How.ID, using = "Imovel5:atributosEspeciais:_2")
	public static WebElement flgJardim;

	@FindBy(how = How.ID, using = "Imovel5:btnCalcularPadrao")
	public static WebElement btnCalcularPadrao;

	@FindBy(how = How.ID, using = "Imovel5:nomePadrao")
	public static WebElement lblPadrao;

	@FindBy(how = How.ID, using = "conCodigo_mskinteiro")
	public static WebElement txtCodigoCategoria;

	@FindBy(how = How.ID, using = "frmConBci:frmIncricao:InscricaoImo_mskinteiro")
	public static WebElement txtInscImovel;

	@FindBy(how = How.ID, using = "frmConBci:cmdConsultaBci")
	public static WebElement btnConsultarImovel;

	@FindBy(how = How.ID, using = "Imovel5:tblCategoriaImovel:btnNovaCategoria")
	public static WebElement btnNovaCategoria;

	@FindBy(how = How.ID, using = "Imovel5:tblCategoriaImovel:btnExcluiCategoria")
	public static WebElement btnExcluirCategoria;

	@FindBy(how = How.ID, using = "cmdConsultarCategoria")
	public static WebElement btnConsultarCategoria;

	@FindBy(how = How.ID, using = "tblDados:1")
	public static WebElement optCategoria;

	@FindBy(how = How.ID, using = "tblDados:cmdCadCategoriaSalvar")
	public static WebElement btnCategoriaSalvar;

	private Map<EnumTipoEconomia, Boolean> tipoEconomias;

	public void iniciarBci()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("corpo");

	}

	@Override
	public void testDefinirPadraoVago()
	{

		if ( !flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}
		if ( flgEstruturaPrecaria.isSelected() )
		{
			DriverUtils.clicar(flgEstruturaPrecaria);
			DriverUtils.esperarPorAjax();
		}

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

		finalizarCalculoPadrao(EnumTipoPadrao.VAGO);

		Assert.assertEquals("0", txtAreaConstruida.getAttribute("value"));

	}

	@Override
	public void testDefinirSemEconomias()
	{
		excluirTodasEconomias();

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			DriverUtils.clicar(flgEstruturaPrecaria);
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.REGULAR.getNomeAmigavel());

		txtTipoConstrucao.clear();
		txtTipoConstrucao.sendKeys(EnumTipoConstrucao.TIJOLO_CONCRETO.getCodigo()
				.toString());

		txtTipoPiso.clear();
		txtTipoPiso
				.sendKeys(EnumTipoPiso.CERAMICA_ESMALTADA.getCodigo().toString());

		txtQtdBanheiro.clear();
		txtQtdBanheiro.sendKeys(QTD_BANHEIROS);

		txtPontosUtilizacao.clear();
		txtPontosUtilizacao.sendKeys(qtdPontosUtilizacao);

		DriverUtils.clicar(btnCalcularPadrao);
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
		tipoEconomias = new HashMap<EnumTipoEconomia, Boolean>();

		tipoEconomias.put(EnumTipoEconomia.RESIDENCIAL, false);

		verificarEconomias();

		incluirEconomia(tipoEconomias);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			DriverUtils.clicar(flgEstruturaPrecaria);
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		txtTipoConstrucao.clear();
		txtTipoConstrucao.sendKeys(EnumTipoConstrucao.TIJOLO_CONCRETO.getCodigo()
				.toString());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.TACO_SINTETICO.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);

	}

	@Override
	public void testDefinirEmpateComTresPadroesBRADuasEconomiasRegular()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.COMERCIAL,
				EnumTipoEconomia.RESIDENCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		if ( flgEstruturaPrecaria.isSelected() )
		{
			DriverUtils.clicar(flgEstruturaPrecaria);
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.ALTO.getNomeAmigavel());

		txtTipoConstrucao.clear();
		txtTipoConstrucao.sendKeys(EnumTipoConstrucao.TIJOLO_CONCRETO.getCodigo()
				.toString());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.INDUSTRIAL.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.REGULAR);

	}

	@Override
	public void testDefinirEmpateComTresPadroesBRMDuasEconomiasRegular()
			throws InterruptedException

	{
		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.COMERCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		txtTipoConstrucao.clear();
		txtTipoConstrucao
				.sendKeys(EnumTipoConstrucao.TIJOLO.getCodigo().toString());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.CERAMICA_SIMPLES.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.REGULAR);

	}

	@Override
	public void testDefinirEmpateComTresPadroesBMADuasEconomiasMedio()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.INDUSTRIAL);

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.BASICO.getNomeAmigavel());

		txtTipoConstrucao.clear();
		txtTipoConstrucao.sendKeys(EnumTipoConstrucao.MADEIRA_CONGLOMERADO
				.getCodigo().toString());

		txtTipoPiso.clear();
		txtTipoPiso
				.sendKeys(EnumTipoPiso.CERAMICA_ESMALTADA.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);

	}

	@Override
	public void testDefinirEmpateComTresPadroesRMADuasEconomiasMedio()
			throws InterruptedException
	{
		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.PUBLICA);

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

		if ( flgPadraoVago.isSelected() )
		{
			flgPadraoVago.click();
			DriverUtils.esperarPorAjax();
		}

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.REGULAR.getNomeAmigavel());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.MOSAICO.getCodigo().toString());

		txtTipoConstrucao.clear();
		txtTipoConstrucao
				.sendKeys(EnumTipoConstrucao.TIJOLO.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);

	}

	@Override
	public void testDefinirEmpateComDoisPadroesBRDuasEconomias()
			throws InterruptedException
	{
		selecionarDuasEconomias(EnumTipoEconomia.COMERCIAL,
				EnumTipoEconomia.INDUSTRIAL);

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

		if ( flgPadraoVago.isSelected() )
		{
			flgPadraoVago.click();
			DriverUtils.esperarPorAjax();
		}

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.TACO_SINTETICO.getCodigo().toString());

		txtTipoConstrucao.clear();
		txtTipoConstrucao.sendKeys(EnumTipoConstrucao.TIJOLO_CONCRETO.getCodigo()
				.toString());

		finalizarCalculoPadrao(EnumTipoPadrao.REGULAR);

	}

	@Override
	public void testDefinirEmpateComDoisPadroesBMDuasEconomias()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.COMERCIAL,
				EnumTipoEconomia.PUBLICA);

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

		if ( flgPadraoVago.isSelected() )
		{
			flgPadraoVago.click();
			DriverUtils.esperarPorAjax();
		}

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.BASICO.getNomeAmigavel());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.PAVIFLEX.getCodigo().toString());

		txtTipoConstrucao.clear();
		txtTipoConstrucao.sendKeys(EnumTipoConstrucao.MADEIRA_PURA.getCodigo()
				.toString());

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);

	}

	@Override
	public void testDefinirEmpateComDoisPadroesBADuasEconomias()
			throws InterruptedException
	{
		selecionarDuasEconomias(EnumTipoEconomia.INDUSTRIAL,
				EnumTipoEconomia.PUBLICA);

		if ( flgPadraoVago.isSelected() )
		{
			flgPadraoVago.click();
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.ALTO.getNomeAmigavel());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.TERRA_BATIDA.getCodigo().toString());

		txtTipoConstrucao.clear();
		txtTipoConstrucao.sendKeys(EnumTipoConstrucao.TAIPA.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.ALTO);

	}

	@Override
	public void testDefinirEmpateComDoisPadroesRMDuasEconomias()
			throws InterruptedException
	{
		selecionarDuasEconomias(EnumTipoEconomia.COMERCIAL,
				EnumTipoEconomia.PUBLICA);

		if ( flgPadraoVago.isSelected() )
		{
			flgPadraoVago.click();
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.MOSAICO.getCodigo().toString());

		txtTipoConstrucao.clear();
		txtTipoConstrucao
				.sendKeys(EnumTipoConstrucao.TIJOLO.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);

	}

	@Override
	public void testDefinirEmpateComDoisPadroesRADuasEconomias()
			throws InterruptedException
	{

		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.COMERCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			flgPadraoVago.click();
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.ALTO.getNomeAmigavel());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.MOSAICO.getCodigo().toString());

		txtTipoConstrucao.clear();
		txtTipoConstrucao
				.sendKeys(EnumTipoConstrucao.TIJOLO.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.ALTO);

	}

	@Override
	public void testDefinirEmpateComDoisPadroesMADuasEconomias()
			throws InterruptedException
	{
		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.COMERCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			flgPadraoVago.click();
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.BASICO.getNomeAmigavel());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.MOSAICO.getCodigo().toString());

		txtTipoConstrucao.clear();
		txtTipoConstrucao
				.sendKeys(EnumTipoConstrucao.TIJOLO.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.ALTO);

	}

	@Override
	public void testDefinirEmpateComDoisPadroesBRDuasEconomiasPrecaria()
			throws InterruptedException
	{
		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.COMERCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			flgPadraoVago.click();
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.TACO_SINTETICO.getCodigo().toString());

		txtTipoConstrucao.clear();
		txtTipoConstrucao.sendKeys(EnumTipoConstrucao.TIJOLO_CONCRETO.getCodigo()
				.toString());

		finalizarCalculoPadrao(EnumTipoPadrao.BASICO);

	}

	@Override
	public void testDefinirEmpateComDoisPadroesBMDuasEconomiasPrecaria()
			throws InterruptedException
	{
		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.COMERCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			flgPadraoVago.click();
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.TACO_SIMPLES.getCodigo().toString());

		txtTipoConstrucao.clear();
		txtTipoConstrucao.sendKeys(EnumTipoConstrucao.TAIPA.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.REGULAR);

	}

	@Override
	public void testDefinirEmpateComDoisPadroesBADuasEconomiasPrecaria()
			throws InterruptedException
	{
		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.COMERCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			flgPadraoVago.click();
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.ALTO.getNomeAmigavel());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.TACO_SINTETICO.getCodigo().toString());

		txtTipoConstrucao.clear();
		txtTipoConstrucao.sendKeys(EnumTipoConstrucao.TAIPA.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.REGULAR);

	}

	@Override
	public void testDefinirEmpateComDoisPadroesRMDuasEconomiasPrecaria()
			throws InterruptedException
	{
		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.COMERCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			flgPadraoVago.click();
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.MEDIO.getNomeAmigavel());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.MOSAICO.getCodigo().toString());

		txtTipoConstrucao.clear();
		txtTipoConstrucao
				.sendKeys(EnumTipoConstrucao.TIJOLO.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.REGULAR);

	}

	@Override
	public void testDefinirEmpateComDoisPadroesRADuasEconomiasPrecaria()
			throws InterruptedException
	{
		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.COMERCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			flgPadraoVago.click();
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.ALTO.getNomeAmigavel());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.MOSAICO.getCodigo().toString());

		txtTipoConstrucao.clear();
		txtTipoConstrucao
				.sendKeys(EnumTipoConstrucao.TIJOLO.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);

	}

	@Override
	public void testDefinirEmpateComDoisPadroesMADuasEconomiasPrecaria()
			throws InterruptedException
	{
		selecionarDuasEconomias(EnumTipoEconomia.RESIDENCIAL,
				EnumTipoEconomia.COMERCIAL);

		if ( flgPadraoVago.isSelected() )
		{
			flgPadraoVago.click();
			DriverUtils.esperarPorAjax();
		}

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

		txtAreaConstruida.clear();
		txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.BASICO.getNomeAmigavel());

		txtTipoPiso.clear();
		txtTipoPiso.sendKeys(EnumTipoPiso.MOSAICO.getCodigo().toString());

		txtTipoConstrucao.clear();
		txtTipoConstrucao
				.sendKeys(EnumTipoConstrucao.TIJOLO.getCodigo().toString());

		finalizarCalculoPadrao(EnumTipoPadrao.MEDIO);

	}

	public void finalizarCalculoPadrao(EnumTipoPadrao tipoPadrao)
	{

		txtQtdBanheiro.clear();
		txtQtdBanheiro.sendKeys(QTD_BANHEIROS);

		txtPontosUtilizacao.clear();
		txtPontosUtilizacao.sendKeys(qtdPontosUtilizacao);

		DriverUtils.clicar(btnCalcularPadrao);
		DriverUtils.esperarPorAjax();

		Assert.assertEquals(tipoPadrao.getNomeAmigavel(),
				lblPadrao.getAttribute("value"));

	}

	public void selecionarDuasEconomias(EnumTipoEconomia economia1,
			EnumTipoEconomia economia2)
	{

		tipoEconomias = new HashMap<EnumTipoEconomia, Boolean>();

		tipoEconomias.put(economia1, false);
		tipoEconomias.put(economia2, false);

		verificarEconomias();

		incluirEconomia(tipoEconomias);
	}

	private void verificarEconomias()
	{

		int size = driver
				.findElements(
						By.xpath(".//*[@id='Imovel5:tblCategoriaImovel']/table/tbody/tr[2]/td/table/tbody/tr[*]/td[3]"))
				.size();

		int i = 0;

		List<WebElement> economiasExcluir = null;
		List<WebElement> economias;

		if ( size > 0 && tipoEconomias != null )
		{
			economias = driver.findElements(By
					.cssSelector("span[id$=':tipoCategoria']"));

			economiasExcluir = new ArrayList<WebElement>();

			for (WebElement lblEconomia : economias)
			{

				if ( tipoEconomias
						.containsKey(EnumTipoEconomia.valueOf(SpecialCharFilter
								.removeSpecialChar(lblEconomia.getText()))) )
				{

					tipoEconomias.put(EnumTipoEconomia.valueOf(SpecialCharFilter
							.removeSpecialChar(lblEconomia.getText())), true);
				}
				else
				{

					economiasExcluir.add(driver.findElement(By
							.id("Imovel5:tblCategoriaImovel:" + i)));

				}
				i++;
			}

			excluirEconomia(economiasExcluir);
		}

	}

	private void incluirEconomia(Map<EnumTipoEconomia, Boolean> tipoEconomias)
	{

		for (Map.Entry<EnumTipoEconomia, Boolean> elemento : tipoEconomias
				.entrySet())
		{

			if ( elemento.getValue() == false )
			{

				DriverUtils.clicar(btnNovaCategoria);

				DriverUtils.avancarFrame();

				DriverUtils.escrever(txtCodigoCategoria, elemento.getKey()
						.getNomeAmigavel());

				DriverUtils.clicar(btnConsultarCategoria);

				DriverUtils.delay(500);

				DriverUtils.clicar(optCategoria);

				DriverUtils.clicar(btnCategoriaSalvar);

				driver.switchTo().defaultContent();

				WebDriverWait wait = new WebDriverWait(driver, 15);

				wait.until(ExpectedConditions.refreshed(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt(MenuPage.FRAME_PRINCIPAL_ACI)));

				DriverUtils.esperarPorAjax();

				DriverUtils.delay(1000);

				for (WebElement tipoCategoria : driver.findElements(By
						.cssSelector("input[id*=':imbQtdEconomia']")))
				{

					if ( tipoCategoria.getAttribute("value").isEmpty() )
					{

						tipoCategoria.sendKeys("1");

						elemento.setValue(true);
					}

				}

			}

		}

	}

	public void excluirTodasEconomias()
	{

		tipoEconomias = new HashMap<EnumTipoEconomia, Boolean>();
		tipoEconomias.put(EnumTipoEconomia.NENHUM, true);

		verificarEconomias();

	}

	private void excluirEconomia(List<WebElement> elementos)
	{

		if ( elementos.size() > 0 )
		{
			for (WebElement elemento : elementos)
			{

				DriverUtils.clicar(elemento);

			}
			DriverUtils.clicar(btnExcluirCategoria);

			DriverUtils.esperarPorAjax();
		}
	}

}