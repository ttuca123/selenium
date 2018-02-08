package br.com.cagece.prax.bci.telas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AcessoPage;
import pages.bci.BciPageConsultaImovel;
import pages.bci.BciUtils;
import servicos.ServicoPadrao;
import anotations.CasoDeTeste;
import auxiliares.ConnectJDBC;
import auxiliares.DriverUtils;
import auxiliares.EnumTelaBci;
import enumerators.EnumUsuario;

/**
 * Testes do Cálculo do Padrão de imóvel
 * 
 * @author 210266 - Artur
 */
public class TelaConsultaImovelTest extends BciUtils
{

	public TelaConsultaImovelTest()
	{
		classe = TelaConsultaImovelTest.class;
	}

	private static BciPageConsultaImovel bciPageConsulta;

	@BeforeClass
	public static void setUpClass() throws Exception
	{

		inicializarPages();

		AcessoPage.setUsuarioLogado(EnumUsuario.ADMINISTRADOR);

		menuPage = AcessoPage.logar();

		PageFactory.initElements(DriverUtils.getDriver(),
				BciPageConsultaImovel.class);

	}

	@SuppressWarnings("static-access")
	@BeforeMethod
	public void setUp() throws InterruptedException, NumberFormatException,
			ClassNotFoundException, SQLException
	{
		menuPage.subMenuConsultarImovelBci();

		bciPageConsulta = new BciPageConsultaImovel(DriverUtils.getDriver());

		ServicoPadrao servicoPadrao = new ServicoPadrao();

		servicoPadrao.setInscOrigem(ConnectJDBC.gerarInscricaoBci());

		bciPageConsulta.consultarImovel(servicoPadrao);
	}

	@Test
	@CasoDeTeste(id = "CT01", tela = EnumTelaBci.CONSULTA, nome = "VERIFICAR PADRAO VAGO")
	public void testDefinirPadraoVago() throws IOException, InterruptedException
	{
		bciPageConsulta.testDefinirPadraoVago();
	}

	@Test
	@CasoDeTeste(id = "CT02", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO SEM ECONOMIAS - CONSULTA")
	public void testPadraoImovelSemEconomias() throws InterruptedException
	{
		bciPageConsulta.testDefinirSemEconomias();
	}

	/**
	 * Regra 1: Imóvel com 1 economia residencial e empatados.
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 *
	 */

	@Test
	@CasoDeTeste(id = "CT03", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO SEM ECONOMIAS - CONSULTA")
	public void testDefinirComEmpateUmaEconomiaResidencial()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirComEmpateUmaEconomiaResidencial();
	}

	@Test
	@CasoDeTeste(id = "CT04", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM TRES PADRÕES BRA DUAS ECONOMIAS REGULAR - CONSULTA")
	public void testDefinirEmpateComTresPadroesBRADuasEconomiasRegular()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComTresPadroesBRADuasEconomiasRegular();
	}

	@Test
	@CasoDeTeste(id = "CT05", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM TRES PADRÕES BRM DUAS ECONOMIAS REGULAR - CONSULTA")
	public void testDefinirEmpateComTresPadroesBRMDuasEconomiasRegular()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComTresPadroesBRMDuasEconomiasRegular();
	}

	@Test
	@CasoDeTeste(id = "CT06", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM TRES PADRÕES BMA DUAS ECONOMIAS MEDIO - CONSULTA")
	public void testDefinirEmpateComTresPadroesBMADuasEconomiasMedio()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComTresPadroesBMADuasEconomiasMedio();
	}

	@Test
	@CasoDeTeste(id = "CT07", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM TRES PADRÕES RMA DUAS ECONOMIAS MEDIO - CONSULTA")
	public void testDefinirEmpateComTresPadroesRMADuasEconomiasMedio()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComTresPadroesRMADuasEconomiasMedio();
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
	@CasoDeTeste(id = "CT08", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM DOIS PADRÕES BR DUAS ECONOMIAS RESIDENCIAL MEDIO- CONSULTA")
	public void testDefinirEmpateComDoisPadroesBRDuasEconomiasResidencialMedio()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComDoisPadroesBRDuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT09", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM DOIS PADRÕES BM DUAS ECONOMIAS BASICO MEDIO - CONSULTA")
	public void testDefinirEmpateComDoisPadroesBMDuasEconomiasBasicoMedio()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComDoisPadroesBMDuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT10", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM DOIS PADRÕES BA DUAS ECONOMIAS BASICO ALTO - CONSULTA")
	public void testDefinirEmpateComDoisPadroesBADuasEconomiasBasicoAlto()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComDoisPadroesBADuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT11", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM DOIS PADRÕES RM DUAS ECONOMIAS REGULAR MEDIO - CONSULTA")
	public void testDefinirEmpateComDoisPadroesRMDuasEconomiasRegularMedio()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComDoisPadroesRMDuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT12", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM DOIS PADRÕES RA DUAS ECONOMIAS REGULAR ALTO - CONSULTA")
	public void testDefinirEmpateComDoisPadroesRADuasEconomiasRegularAlto()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComDoisPadroesRADuasEconomias();
	}

	@Test
	@CasoDeTeste(id = "CT13", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM DOIS PADRÕES RA DUAS ECONOMIAS MEDIO ALTO - CONSULTA")
	public void testDefinirEmpateComDoisPadroesMADuasEconomiasMedioAlto()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComDoisPadroesMADuasEconomias();
	}

	/**
	 * Regra 3: Imóvel com mais de uma economia , estrutura precária e empatados
	 */
	@Test
	@CasoDeTeste(id = "CT14", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM DOIS PADRÕES BR DUAS ECONOMIAS PRECARIA - CONSULTA")
	public void testDefinirEmpateComDoisPadroesBRDuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComDoisPadroesBRDuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT15", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM DOIS PADRÕES BM DUAS ECONOMIAS PRECARIA - CONSULTA")
	public void testDefinirEmpateComDoisPadroesBMDuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComDoisPadroesBMDuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT16", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM DOIS PADRÕES BA DUAS ECONOMIAS PRECARIA - CONSULTA")
	public void testDefinirEmpateComDoisPadroesBADuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComDoisPadroesBADuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT17", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM DOIS PADRÕES RM DUAS ECONOMIAS PRECARIA - CONSULTA")
	public void testDefinirEmpateComDoisPadroesRMDuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComDoisPadroesRMDuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT18", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM DOIS PADRÕES RA DUAS ECONOMIAS PRECARIA - CONSULTA")
	public void testDefinirEmpateComDoisPadroesRADuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComDoisPadroesRADuasEconomiasPrecaria();
	}

	@Test
	@CasoDeTeste(id = "CT19", tela = EnumTelaBci.CONSULTA, nome = "CALCULO PADRAO COM DOIS PADRÕES MA DUAS ECONOMIAS PRECARIA - CONSULTA")
	public void testDefinirEmpateComDoisPadroesMADuasEconomiasPrecaria()
			throws InterruptedException
	{
		bciPageConsulta.testDefinirEmpateComDoisPadroesMADuasEconomiasPrecaria();
	}

	@AfterClass
	public static void tearDownClass() throws Exception
	{

		DriverUtils.fecharDriver();
	}

}
