package br.com.cagece.prax.bci;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AcessoPage;
import pages.AtendimentoPage;
import pages.MenuPage;
import pages.bci.BciPageCadastro;
import auxiliares.DriverUtils;
import enumerators.EnumUsuario;
import frames.FramePrincipalPage;

/**
 * @author 210266 - Artur
 */
public class PublicacaoTest
{

	protected static AcessoPage acessoPage;

	public static AtendimentoPage atendimentoPage;

	public static FramePrincipalPage framePrincipal;

	public static MenuPage menuPage;

	@SuppressWarnings("static-access")
	@BeforeClass
	public static void setUpClass() throws Exception
	{

		acessoPage = PageFactory.initElements(DriverUtils.getDriver(),
				AcessoPage.class);
		framePrincipal = PageFactory.initElements(DriverUtils.getDriver(),
				FramePrincipalPage.class);

		atendimentoPage = PageFactory.initElements(DriverUtils.getDriver(),
				AtendimentoPage.class);

		acessoPage.setUsuarioLogado(EnumUsuario.ADMINISTRADOR);

		menuPage = acessoPage.logar();

		PageFactory.initElements(DriverUtils.getDriver(), BciPageCadastro.class);

		menuPage.atendimentoCentralizado();

	}

	@AfterClass
	public static void tearDownClass() throws Exception
	{

		DriverUtils.fecharDriver();
	}

}
