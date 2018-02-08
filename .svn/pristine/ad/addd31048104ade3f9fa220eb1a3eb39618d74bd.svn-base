package frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import pages.PageBase;
import auxiliares.DriverUtils;
import auxiliares.ServiceTestBase;
import auxiliares.Util;

public class FramePesquisaLogradouroPage extends PageBase
{

	@FindBy(how = How.ID, using = "logDscLogradouro_mskconsulta")
	private static WebElement dscLogradouro;

	@FindBy(how = How.ID, using = "cmdConsultar")
	private static WebElement btnConsultar;

	@FindBy(how = How.ID, using = "tblDadosdd0")
	private static WebElement primeiraRua;

	@FindBy(how = How.ID, using = "tblDados:1:tblDados:0")
	private static WebElement primeiroEndereco;

	@FindBy(how = How.ID, using = "tblDados:1:tblDados:btnOkLogradouro")
	private static WebElement btnFecharPesquisa;

	@FindBy(how = How.ID, using = "frmCadastro:frmLogradouro:btnConsultarLogradouro")
	private static WebElement btnConsultarLogradouro;

	public FramePesquisaLogradouroPage(WebDriver driver)
	{
		super(driver);
	}

	@SuppressWarnings("static-access")
	public static void consultarEndereco()
	{

		FramePesquisaLogradouroPage framePesquisaLogradouro = ServiceTestBase.framePrincipal
				.getFramePesquisaLogradouro();

		framePesquisaLogradouro.consultarLogradouro();

		DriverUtils.clicar(primeiraRua);

		DriverUtils.clicar(primeiroEndereco);

		DriverUtils.esperarPorAjax();

		DriverUtils.clicar(btnFecharPesquisa);

		ServiceTestBase.framePrincipal.setTelaAtendimentoPage();

		DriverUtils.esperarPorAjax();

	}

	/**
	 * Consulta pela sua Aleatória
	 * 
	 * @throws InterruptedException
	 */
	public void consultarLogradouro()
	{

		String[] lista = { "MARIA", "ANTONIO", "FCO", "SANTANA", "ALBUQUERQUE" };

		String pesquisa = lista[Util.gerarNumero(4)];

		DriverUtils.escrever(dscLogradouro, pesquisa);

		DriverUtils.clicar(btnConsultar);

		DriverUtils.esperarPorAjax();

	}

	/**
	 * Consulta pela Rua informada
	 * 
	 * @param pesquisa
	 * @throws InterruptedException
	 */
	public void consultarLogradouro(String pesquisa) throws InterruptedException
	{
		DriverUtils.escrever(dscLogradouro, pesquisa);
		DriverUtils.clicar(btnConsultar);
		DriverUtils.esperarPorAjax();
	}

	// public void encerrarPesquisaLogradouro()
	// {
	//
	// DriverUtils.clicar(btnFecharPesquisa);
	//
	//
	// }

	// public void selecionarPrimeiraEndereco()
	// {
	//
	// DriverUtils.clicar(primeiroEndereco);
	// DriverUtils.esperarPorAjax();
	// }
}