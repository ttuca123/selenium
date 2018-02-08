package pages.bci;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import modelo.ResultadoTest;

import org.junit.ComparisonFailure;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import pages.AcessoPage;
import pages.AtendimentoPage;
import pages.MenuPage;
import anotations.CasoDeTeste;
import auxiliares.ConnectJDBC;
import auxiliares.DriverUtils;
import auxiliares.EnumTelaBci;
import enumerators.EnumSistema;
import enumerators.EnumTipoErro;
import frames.FramePrincipalPage;

public class BciUtils
{
	public static Class<?> classe;

	public static ResultadoTest resultado;

	protected static AcessoPage acessoPage;

	public static AtendimentoPage atendimentoPage;

	public static String casoTeste;

	public static FramePrincipalPage framePrincipal;

	public static MenuPage menuPage;

	public static void inicializarPages()
	{

		acessoPage = PageFactory.initElements(DriverUtils.getDriver(),
				AcessoPage.class);
		
		framePrincipal = PageFactory.initElements(DriverUtils.getDriver(),
				FramePrincipalPage.class);

		atendimentoPage = PageFactory.initElements(DriverUtils.getDriver(),
				AtendimentoPage.class);

	}

	@AfterMethod
	public void reportarResultadoTestes(ITestResult resultadoTest)
			throws ClassNotFoundException, SQLException
	{
		resultado = new ResultadoTest(EnumSistema.PRAX);

		if ( resultadoTest.getStatus() == ITestResult.FAILURE )
		{

			System.out.println(resultadoTest.getThrowable().getCause());

			if ( resultadoTest.getThrowable().getClass()
					.equals(ScreenshotException.class)
					|| resultadoTest.getThrowable().getClass()
							.equals(NoSuchElementException.class) )
			{
				resultado.setTipoErro(EnumTipoErro.LOCATION);
			}
			else if ( resultadoTest.getThrowable().getClass()
					.equals(ComparisonFailure.class) )
			{
				resultado.setTipoErro(EnumTipoErro.REGRA_NEGOCIO);
			}
			else if ( resultadoTest.getThrowable().getClass()
					.equals(TimeoutException.class) )
			{

				resultado.setTipoErro(EnumTipoErro.TIMEOUT);
			}

			resultado.setObservacao(resultadoTest.getThrowable().getCause()
					.getMessage());
		}

		CasoDeTeste testCase = null;

		for (Method metodo : classe.getDeclaredMethods())
		{

			for (Annotation anotacao : metodo.getDeclaredAnnotations())
			{

				if ( (metodo.isAnnotationPresent(CasoDeTeste.class))
						&& (anotacao instanceof CasoDeTeste)
						&& metodo.getName().equals(
								resultadoTest.getMethod().getMethodName()) )
				{
					testCase = (CasoDeTeste) anotacao;

					String tela = "";
					if ( testCase.tela().equals(EnumTelaBci.CADASTRO) )
					{
						tela = "-CPI-CAD";
					}
					else if ( testCase.tela().equals(EnumTelaBci.CONSULTA) )
					{
						tela = "-CPI-CON";
					}
					else if ( testCase.tela().equals(EnumTelaBci.RECADASTRO) )
					{
						tela = "-CPI-REC";
					}
					casoTeste = testCase.id().concat(tela);

					System.out.println(casoTeste + " - " + testCase.nome());
				}
			}
		}
		ConnectJDBC.reportarResultado(resultado, casoTeste);

		if ( testCase.tela().equals(EnumTelaBci.CONSULTA) )
		{
			iterarTelaPrincipal();
		}
	}

	public static void iterarTelaPrincipal()
	{
		Set<String> windowId = DriverUtils.getDriver().getWindowHandles();
		Iterator<String> iterator = windowId.iterator();

		@SuppressWarnings("unused")
		String principal = iterator.next();
		String prax = iterator.next();

		DriverUtils.getDriver().switchTo().window(prax);

		DriverUtils.getDriver().switchTo().defaultContent();
	}

}
