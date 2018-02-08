package br.com.cagece.prax.bci.telas;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.bci.BciPageRecadastro;
import pages.bci.BciUtils;
import servicos.ServicoPadrao;
import anotations.CasoDeTeste;
import auxiliares.ConnectJDBC;
import auxiliares.DriverUtils;
import auxiliares.EnumTelaBci;
import enumerators.EnumUsuario;

/**
 * @author 210266 - Artur
 */
public class TelaRecadastroBCITest extends BciUtils
{

	public TelaRecadastroBCITest()
	{
		classe = TelaRecadastroBCITest.class;
	}


	BciPageRecadastro bciPageRecadastro;

	@SuppressWarnings("static-access")
	@BeforeClass
	public static void setUpClass()
	{

		inicializarPages();

		acessoPage.setUsuarioLogado(EnumUsuario.ADMINISTRADOR);

		menuPage = acessoPage.logar();

		PageFactory.initElements(DriverUtils.getDriver(), BciPageRecadastro.class);

		menuPage.subMenuRecadastrarBci();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException, NumberFormatException,
			ClassNotFoundException, SQLException
	{

		bciPageRecadastro = new BciPageRecadastro(DriverUtils.getDriver());

		ServicoPadrao servicoPadrao = new ServicoPadrao();
		servicoPadrao.setInscOrigem(ConnectJDBC.gerarInscricaoBci());

		bciPageRecadastro.iniciarBci(servicoPadrao);

	}

	@Test
	@CasoDeTeste(id = "CT39", tela = EnumTelaBci.RECADASTRO, nome = "VERIFICAR PADRAO VAGO")
	public void testDefinirPadraoVago() throws IOException, InterruptedException
	{
		bciPageRecadastro.testDefinirPadraoVago();
	}

	@Test
	@CasoDeTeste(id = "CT40", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO SEM ECONOMIAS - RECADASTRO")
	public void testPadraoImovelSemEconomias() throws InterruptedException
	{
		bciPageRecadastro.testDefinirSemEconomias();
	}

	/**
	 * Regra 1: Imóvel com 1 economia residencial e empatados.
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 *
	 */

	@Test
	@CasoDeTeste(id = "CT41", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO SEM ECONOMIAS - RECADASTRO")
	public void testDefinirComEmpateUmaEconomiaResidencial()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirComEmpateUmaEconomiaResidencial();
	}

	@Test
	@CasoDeTeste(id = "CT42", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM TRES PADRÕES BRA DUAS ECONOMIAS REGULAR - RECADASTRO")
	public void testDefinirEmpateComTresPadroesBRADuasEconomiasRegular()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComTresPadroesBRADuasEconomiasRegular();
	}

	@Test
	@CasoDeTeste(id = "CT43", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM TRES PADRÕES BRM DUAS ECONOMIAS REGULAR - RECADASTRO")
	public void testDefinirEmpateComTresPadroesBRMDuasEconomiasRegular()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComTresPadroesBRMDuasEconomiasRegular();
	}

	@Test
	@CasoDeTeste(id = "CT44", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM TRES PADRÕES BMA DUAS ECONOMIAS MEDIO - RECADASTRO")
	public void testDefinirEmpateComTresPadroesBMADuasEconomiasMedio()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComTresPadroesBMADuasEconomiasMedio();
	}

	@Test
	@CasoDeTeste(id = "CT45", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM TRES PADRÕES RMA DUAS ECONOMIAS MEDIO - RECADASTRO")
	public void testDefinirEmpateComTresPadroesRMADuasEconomiasMedio()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComTresPadroesRMADuasEconomiasMedio();
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
	@CasoDeTeste(id = "CT46", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES BR DUAS ECONOMIAS RESIDENCIAL MEDIO- RECADASTRO")
	public void testDefinirEmpateComDoisPadroesBRDuasEconomiasResidencialMedio()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComDoisPadroesBRDuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT47", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES BM DUAS ECONOMIAS BASICO MEDIO - RECADASTRO")
	public void testDefinirEmpateComDoisPadroesBMDuasEconomiasBasicoMedio()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComDoisPadroesBMDuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT48", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES BA DUAS ECONOMIAS BASICO ALTO - RECADASTRO")
	public void testDefinirEmpateComDoisPadroesBADuasEconomiasBasicoAlto()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComDoisPadroesBADuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT49", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES RM DUAS ECONOMIAS REGULAR MEDIO - RECADASTRO")
	public void testDefinirEmpateComDoisPadroesRMDuasEconomiasRegularMedio()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComDoisPadroesRMDuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT50", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES RA DUAS ECONOMIAS REGULAR ALTO - RECADASTRO")
	public void testDefinirEmpateComDoisPadroesRADuasEconomiasRegularAlto()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComDoisPadroesRADuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT51", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES RA DUAS ECONOMIAS MEDIO ALTO - RECADASTRO")
	public void testDefinirEmpateComDoisPadroesMADuasEconomiasMedioAlto()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComDoisPadroesMADuasEconomias();
	}

	/**
	 * Regra 3: Imóvel com mais de uma economia , estrutura precária e empatados
	 */
	@Test
	@CasoDeTeste(id = "CT52", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES BR DUAS ECONOMIAS PRECARIA - RECADASTRO")
	public void testDefinirEmpateComDoisPadroesBRDuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComDoisPadroesBRDuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT53", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES BM DUAS ECONOMIAS PRECARIA - RECADASTRO")
	public void testDefinirEmpateComDoisPadroesBMDuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComDoisPadroesBMDuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT54", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES BA DUAS ECONOMIAS PRECARIA - RECADASTRO")
	public void testDefinirEmpateComDoisPadroesBADuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComDoisPadroesBADuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT55", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES RM DUAS ECONOMIAS PRECARIA - RECADASTRO")
	public void testDefinirEmpateComDoisPadroesRMDuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComDoisPadroesRMDuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT56", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES RA DUAS ECONOMIAS PRECARIA - RECADASTRO")
	public void testDefinirEmpateComDoisPadroesRADuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComDoisPadroesRADuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT57", tela = EnumTelaBci.RECADASTRO, nome = "CALCULO PADRAO COM DOIS PADRÕES MA DUAS ECONOMIAS PRECARIA - RECADASTRO")
	public void testDefinirEmpateComDoisPadroesMADuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageRecadastro.testDefinirEmpateComDoisPadroesMADuasEconomiasPrecaria();
	}

	@AfterClass
	public static void tearDownClass()
	{

		DriverUtils.fecharDriver();
	}

}
