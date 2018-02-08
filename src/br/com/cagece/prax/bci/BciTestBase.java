package br.com.cagece.prax.bci;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javax.mail.MessagingException;

import modelo.ResultadoTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.bci.BciPageCadastro;
import pages.bci.BciUtils;
import anotations.CasoDeTeste;
import auxiliares.ConnectJDBC;
import auxiliares.DriverUtils;
import enumerators.EnumSistema;
import enumerators.EnumUsuario;
import excessoes.RegistrosInexistenteNaTeaException;

public class BciTestBase extends BciUtils
{

	public static String qtdPontosUtilizacao = "15";

	protected static final String MSG_SEM_ECONOMIAS = "Economia / Categoria: deve ser preenchida; com os campos: Tipo e Quantidade ; para efetuar o calculo do padrão imóvel.";

	protected static final String QTD_BANHEIROS = "2";

	public static final String MSG_SUCESSO = "Padrão do imóvel e consumo presumido calculados com sucesso.";

	protected static String casoTeste;

	public static Integer nrCasoTeste;

	protected String complemento;

	protected static boolean exigeBaixa;

	protected static boolean fecharDriver;

	public static BciPageCadastro bciPageCadastro;

	private Class<?> classe;

	public BciTestBase(Class<?> classe)
	{
		this.setClasse(classe);
	}

	public void configurar(Class<?> classe)
			throws RegistrosInexistenteNaTeaException, NoSuchMethodException,
			SecurityException, ClassNotFoundException, SQLException
	{

		resultado = new ResultadoTest(EnumSistema.PRAX);

		preparaClasse(classe);

	}

	private void preparaClasse(Class<?> classe) throws NoSuchMethodException,
			SecurityException
	{

		CasoDeTeste testCase = null;

		Method metodo = classe.getMethod("executar");

		for (Annotation anotacao : metodo.getDeclaredAnnotations())
		{

			if ( (classe.isAnnotationPresent(CasoDeTeste.class))
					&& (anotacao instanceof CasoDeTeste) )
			{
				testCase = (CasoDeTeste) anotacao;

				casoTeste = testCase.id();

				fecharDriver = testCase.fecharDriver();

				nrCasoTeste = Integer.parseInt(casoTeste.replace("CT", ""));

				casoTeste = testCase.id().concat("-").concat("CPI").concat("-")
						.concat(testCase.identificador());

				System.out.println(casoTeste);

				System.out.println(casoTeste.concat(" - ").concat(testCase.nome())
						.concat(" - ").concat(testCase.complemento()));

			}
		}
	}

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
	public void setUp() throws NoSuchMethodException, SecurityException,
			ClassNotFoundException, SQLException
	{

		preparaClasse(classe);

		resultado = new ResultadoTest(EnumSistema.PRAX);

		ConnectJDBC.gerarInscricaoBci();

		bciPageCadastro = new BciPageCadastro(DriverUtils.getDriver());

		bciPageCadastro.iniciarBci();

	}

	public Class<?> getClasse()
	{
		return classe;
	}

	public void setClasse(Class<?> classe)
	{
		this.classe = classe;
	}

	@Test
	public void executar() throws IOException,

	InterruptedException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException
	{
		Object obj = classe.newInstance();

		classe.getMethod("executarTeste").invoke(obj);

	}

	@AfterMethod
	public void finalizar() throws ClassNotFoundException, SQLException,
			IOException, MessagingException
	{

		ConnectJDBC.reportarResultado(resultado, casoTeste);

	}

}
