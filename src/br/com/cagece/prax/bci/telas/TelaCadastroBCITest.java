package br.com.cagece.prax.bci.telas;

import java.io.IOException;
import java.sql.SQLException;

import modelo.ResultadoTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.bci.BciPageCadastro;
import pages.bci.BciUtils;
import anotations.CasoDeTeste;
import auxiliares.ConnectJDBC;
import auxiliares.DriverUtils;
import auxiliares.EnumTelaBci;
import enumerators.EnumSistema;
import enumerators.EnumUsuario;

/**
 * @author 210266 - Artur
 */
public class TelaCadastroBCITest extends BciUtils
{

	public TelaCadastroBCITest()
	{
		classe = TelaCadastroBCITest.class;
	}

	BciPageCadastro bciPageCadastro;

	@SuppressWarnings("static-access")
	@BeforeClass
	public static void setUpClass() throws Exception
	{

		inicializarPages();

		acessoPage.setUsuarioLogado(EnumUsuario.ADMINISTRADOR);

		menuPage = acessoPage.logar();

		PageFactory.initElements(DriverUtils.getDriver(), BciPageCadastro.class);

		menuPage.subMenuCadastrarBci();
	}

	@BeforeMethod
	public void setUp() throws ClassNotFoundException, SQLException
	{

		resultado = new ResultadoTest(EnumSistema.PRAX);

		ConnectJDBC.gerarInscricaoBci();

		bciPageCadastro = new BciPageCadastro(DriverUtils.getDriver());

		bciPageCadastro.iniciarBci();

	}

	@Test
	@CasoDeTeste(id = "CT20", tela = EnumTelaBci.CADASTRO, nome = "VERIFICAR PADRAO VAGO")
	public void testDefinirPadraoVago() throws IOException, InterruptedException
	{
		bciPageCadastro.testDefinirPadraoVago();
	}

	@Test
	@CasoDeTeste(id = "CT21", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO SEM ECONOMIAS - CADASTRO")
	public void testPadraoImovelSemEconomias() throws InterruptedException
	{
		bciPageCadastro.testDefinirSemEconomias();
	}

	/**
	 * Regra 1: Imóvel com 1 economia residencial e empatados.
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 *
	 */

	@Test
	@CasoDeTeste(id = "CT22", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO SEM ECONOMIAS - CADASTRO")
	public void testDefinirComEmpateUmaEconomiaResidencial()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirComEmpateUmaEconomiaResidencial();
	}

	@Test
	@CasoDeTeste(id = "CT23", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM TRES PADRÕES BRA DUAS ECONOMIAS REGULAR - CADASTRO")
	public void testDefinirEmpateComTresPadroesBRADuasEconomiasRegular()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComTresPadroesBRADuasEconomiasRegular();
	}

	@Test
	@CasoDeTeste(id = "CT24", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM TRES PADRÕES BRM DUAS ECONOMIAS REGULAR - CADASTRO")
	public void testDefinirEmpateComTresPadroesBRMDuasEconomiasRegular()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComTresPadroesBRMDuasEconomiasRegular();
	}

	@Test
	@CasoDeTeste(id = "CT25", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM TRES PADRÕES BMA DUAS ECONOMIAS MEDIO - CADASTRO")
	public void testDefinirEmpateComTresPadroesBMADuasEconomiasMedio()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComTresPadroesBMADuasEconomiasMedio();
	}

	@Test
	@CasoDeTeste(id = "CT26", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM TRES PADRÕES RMA DUAS ECONOMIAS MEDIO - CADASTRO")
	public void testDefinirEmpateComTresPadroesRMADuasEconomiasMedio()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComTresPadroesRMADuasEconomiasMedio();
	}

	/**
	 * Regra 2: Imóvel com mais de uma economia residencial, estrutura não
	 * precária e empatados apenas de 2 padrões.
	 */
	/**
	 * Obs1: o cálculo do padrão testado será calculado de acordo com os
	 * parametros passados nas listas por faixa área coberta, padrões tipo piso,
	 * padrões tipo construção e atributos especiais. Obs2: na geração dos
	 * empates, deve-se procurar selecionar código que deixem nítido esse empate,
	 * como por exemplo Básico, Básico, Médio, Médio.
	 */

	@Test
	@CasoDeTeste(id = "CT27", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES BR DUAS ECONOMIAS RESIDENCIAL MEDIO- CADASTRO")
	public void testDefinirEmpateComDoisPadroesBRDuasEconomiasResidencialMedio()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComDoisPadroesBRDuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT28", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES BM DUAS ECONOMIAS BASICO MEDIO - CADASTRO")
	public void testDefinirEmpateComDoisPadroesBMDuasEconomiasBasicoMedio()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComDoisPadroesBMDuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT29", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES BA DUAS ECONOMIAS BASICO ALTO - CADASTRO")
	public void testDefinirEmpateComDoisPadroesBADuasEconomiasBasicoAlto()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComDoisPadroesBADuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT30", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES RM DUAS ECONOMIAS REGULAR MEDIO - CADASTRO")
	public void testDefinirEmpateComDoisPadroesRMDuasEconomiasRegularMedio()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComDoisPadroesRMDuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT31", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES RA DUAS ECONOMIAS REGULAR ALTO - CADASTRO")
	public void testDefinirEmpateComDoisPadroesRADuasEconomiasRegularAlto()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComDoisPadroesRADuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT32", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES RA DUAS ECONOMIAS MEDIO ALTO - CADASTRO")
	public void testDefinirEmpateComDoisPadroesMADuasEconomiasMedioAlto()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComDoisPadroesMADuasEconomias();
	}

	/**
	 * Regra 3: Imóvel com mais de uma economia , estrutura precária e empatados
	 */
	@Test
	@CasoDeTeste(id = "CT33", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES BR DUAS ECONOMIAS PRECARIA - CADASTRO")
	public void testDefinirEmpateComDoisPadroesBRDuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComDoisPadroesBRDuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT34", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES BM DUAS ECONOMIAS PRECARIA - CADASTRO")
	public void testDefinirEmpateComDoisPadroesBMDuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComDoisPadroesBMDuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT35", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES BA DUAS ECONOMIAS PRECARIA - CADASTRO")
	public void testDefinirEmpateComDoisPadroesBADuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComDoisPadroesBADuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT36", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES RM DUAS ECONOMIAS PRECARIA - CADASTRO")
	public void testDefinirEmpateComDoisPadroesRMDuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComDoisPadroesRMDuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT37", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES RA DUAS ECONOMIAS PRECARIA - CADASTRO")
	public void testDefinirEmpateComDoisPadroesRADuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComDoisPadroesRADuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT38", tela = EnumTelaBci.CADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES MA DUAS ECONOMIAS PRECARIA - CADASTRO")
	public void testDefinirEmpateComDoisPadroesMADuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageCadastro.testDefinirEmpateComDoisPadroesMADuasEconomiasPrecaria();
	}

	@AfterClass
	public static void tearDownClass() throws Exception
	{

		DriverUtils.fecharDriver();
	}

}
