package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import auxiliares.DriverUtils;
import enumerators.EnumUsuario;

/**
 * Sample page
 */
public class MenuPage extends PageBase
{

	/** OPÇÕES NO MENU */

	private static final String MENU = "imgBtnMenuSistemas";

	private static final String SUBMENU_ATENDIMENTO = "Atendimento";

	private static final String SUBMENU_IMOVEL = "Imóvel";

	private static final String SUBMENU_BCI = "Boletim de cadastro de imóveis - bci";

	private static final String SUBMENU_RECADASTRO_BCI = "Recadastro do bci (pré-impresso)";

	private static final String SUBMENU_CADASTRO = "Cadastro";

	private static final String SUBMENU_CONSULTAR_IMOVEL = "Consultar imóvel";

	private static final String SUBMENU_SOLICITACAO = "Solicitação";

	private static final String SUBMENU_ATENDIMENTO_CENTRALIZADO_INTERNO = "Atendimento centralizado interno";

	private static final String SUBMENU_ATENDIMENTO_CENTRALIZADO = "Atendimento centralizado";
	
	private static final String MENU_ALCADA = "Alçada";

	private static final String SUBMENU_LIBERACAO = "Liberação";

	private static final String BTNLOGOFF = "tblAtendimentosPendentes:btnLogOffPonto";

	private static final String SUBMENU_ITEM_ATENDIMENTO = "Consultar item atendimento";

	private static final String PROBLEMA_ATENDIMENTO_CENTRAL = "Problema na inicialização do atendimento centralizado";
	
	

	/** FRAME PRINCIPAL */

	public static final String FRAME_PRINCIPAL_ACI = AcessoPage
			.getUsuarioLogado().getUsuario().equals(EnumUsuario.ADMINISTRADOR)
			|| getUsuarioLogado().getUsuario().equals(
					EnumUsuario.ATENDIMENTO_CENTRALIZADO_INTERNO)
			|| getUsuarioLogado().getUsuario().equals(
					EnumUsuario.UNIDADE_DE_NEGOCIO_INTERNA) ? "corpo" : "iCorpo";

	@FindBy(how = How.ID, using = MENU)
	@CacheLookup
	public static WebElement menu;

	@FindBy(how = How.LINK_TEXT, using = SUBMENU_ATENDIMENTO)
	@CacheLookup
	public static WebElement menuAtendimento;

	@FindBy(how = How.LINK_TEXT, using = SUBMENU_CADASTRO)
	@CacheLookup
	public static WebElement menuCadastro;
	
	@FindBy(how = How.LINK_TEXT, using = MENU_ALCADA)
	@CacheLookup
	public static WebElement menuAlcada;
	
	@FindBy(how = How.LINK_TEXT, using = SUBMENU_LIBERACAO)
	@CacheLookup
	public static WebElement subMenuLiberacao;

	@FindBy(how = How.LINK_TEXT, using = SUBMENU_IMOVEL)
	@CacheLookup
	public static WebElement subMenuImovel;

	@FindBy(how = How.LINK_TEXT, using = SUBMENU_CONSULTAR_IMOVEL)
	@CacheLookup
	public static WebElement subMenuConsultarImovel;

	@FindBy(how = How.LINK_TEXT, using = SUBMENU_BCI)
	@CacheLookup
	public static WebElement subMenuCadastroBci;

	@FindBy(how = How.LINK_TEXT, using = SUBMENU_RECADASTRO_BCI)
	@CacheLookup
	public static WebElement subMenuRecadastroBci;

	@FindBy(how = How.LINK_TEXT, using = "Lote")
	@CacheLookup
	public static WebElement subMenuLoteBci;

	@FindBy(how = How.LINK_TEXT, using = MenuPage.SUBMENU_SOLICITACAO)
	@CacheLookup
	public static WebElement menuSolicitacao;

	@FindBy(how = How.LINK_TEXT, using = SUBMENU_ITEM_ATENDIMENTO)
	@CacheLookup
	public static WebElement menuItemAtendimento;

	@FindBy(how = How.LINK_TEXT, using = MenuPage.SUBMENU_ATENDIMENTO_CENTRALIZADO_INTERNO)
	@CacheLookup
	public static WebElement menuAtendimentoCentralizadoInterno;

	@FindBy(how = How.LINK_TEXT, using = MenuPage.SUBMENU_ATENDIMENTO_CENTRALIZADO)
	@CacheLookup
	public static WebElement menuAtendimentoCentralizado;

	@FindBy(how = How.ID, using = MenuPage.BTNLOGOFF)
	@CacheLookup
	public static WebElement btnlogof;

	@FindBy(how = How.ID, using = "tblDadosAtPrincipal:goBtnAtendimentoCaminhoInterno")
	@CacheLookup
	public static WebElement btnAtendimentoCaminhoInterno;

	@SuppressWarnings("static-access")
	public MenuPage(WebDriver webDriver)
	{
		super(webDriver);
		this.driver = webDriver;
	}

	public static void atendimentoCentralizado()
	{
		PontoAtendimentoPage pontoAtendimentoPage = null;

		DriverUtils.clicar(menu);

		DriverUtils.clicarMenu(menuAtendimento, MenuPage.SUBMENU_SOLICITACAO);

		if ( getUsuarioLogado().equals(EnumUsuario.ADMINISTRADOR)
				|| getUsuarioLogado().equals(EnumUsuario.UNIDADE_DE_NEGOCIO_INTERNA)
				|| getUsuarioLogado().equals(
						EnumUsuario.ATENDIMENTO_CENTRALIZADO_INTERNO) )
		{

			DriverUtils.clicarMenu(menuSolicitacao,
					MenuPage.SUBMENU_ATENDIMENTO_CENTRALIZADO_INTERNO);

			DriverUtils.clicar(menuAtendimentoCentralizadoInterno);

			DriverUtils.trocarFrame(FRAME_PRINCIPAL_ACI);

		}
		else
		{

			pontoAtendimentoPage = PageFactory.initElements(driver,
					PontoAtendimentoPage.class);

			DriverUtils.clicarMenu(menuSolicitacao,
					MenuPage.SUBMENU_ATENDIMENTO_CENTRALIZADO);

			DriverUtils.clicar(menuAtendimentoCentralizado);

			DriverUtils.trocarFrame(FRAME_PRINCIPAL_ACI);

			pontoAtendimentoPage.verificarLogofAtendimento();

		}

	}

	public static void menuLiberacao()
	{

		DriverUtils.clicar(menu);

		DriverUtils.clicarMenu(menuAlcada, MENU_ALCADA);

		DriverUtils.clicarMenu(subMenuLiberacao, SUBMENU_LIBERACAO);
		
		DriverUtils.delay(700);

	}
	
	public static void subMenuConsultarImovelBci()
	{

		DriverUtils.clicar(menu);

		DriverUtils.clicarMenu(menuCadastro, SUBMENU_IMOVEL);

		DriverUtils.clicarMenu(subMenuImovel, SUBMENU_CONSULTAR_IMOVEL);

		DriverUtils.clicar(subMenuConsultarImovel);

	}

	public static void subMenuCadastrarBci()
	{

		DriverUtils.clicar(menu);

		DriverUtils.clicarMenu(menuCadastro, SUBMENU_IMOVEL);

		DriverUtils.clicarMenu(subMenuImovel,
				"Boletim de cadastro de imóveis - bci");

		DriverUtils.clicar(subMenuCadastroBci);

	}

	public static void subMenuRecadastrarBci()
	{

		DriverUtils.clicar(menu);

		DriverUtils.clicarMenu(menuCadastro, SUBMENU_IMOVEL);

		DriverUtils.clicarMenu(subMenuImovel, "Recadastro do bci (pré-impresso)");

		DriverUtils.clicar(subMenuRecadastroBci);

	}

	public static void subMenuLoteBci()
	{

		DriverUtils.clicar(menu);

		DriverUtils.clicarMenu(menuCadastro, "Bci");

		DriverUtils.clicar(subMenuLoteBci);

	}

	public static void itemAtendimento()
	{

		DriverUtils.iterarTelaPrincipal();

		DriverUtils.clicar(menu);

		DriverUtils.clicarMenu(menuAtendimento, MenuPage.SUBMENU_SOLICITACAO);

		DriverUtils.clicarMenu(menuSolicitacao, "Consultar item atendimento");

		DriverUtils.clicar(menuItemAtendimento);

		driver.switchTo().frame(FRAME_PRINCIPAL_ACI);
	}

}
