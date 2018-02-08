package modelo;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;

import org.testng.Assert;

import servicos.ServicoPadrao;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
import auxiliares.ConnectJDBC;
import auxiliares.ITestlink;
import auxiliares.Util;
import enumerators.EnumSistema;
import enumerators.EnumTipoErro;

public class ResultadoTest
{

	private BtpProjeto projeto;

	private EnumTipoErro tipoErro;

	public TestLinkAPIClient testlinkAPIClient;

	private String descricao = "Teste automatizado realizados com sucesso!";

	private String resultado = TestLinkAPIResults.TEST_PASSED;

	private String observacao;

	public ResultadoTest(EnumSistema sistema) throws ClassNotFoundException,
			SQLException
	{
		projeto = ConnectJDBC.getProjeto(sistema);
		tipoErro = EnumTipoErro.SEM_ERRO;

	}

	public BtpProjeto getProjeto()
	{
		return projeto;
	}

	public void setProjeto(BtpProjeto projeto)
	{
		this.projeto = projeto;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public String getResultado()
	{
		return resultado;
	}

	private void setResultado(String resultado)
	{
		this.resultado = resultado;
	}

	public String getObservacao()
	{
		return observacao;
	}

	public EnumTipoErro getTipoErro()
	{
		if ( tipoErro == null )
		{

			tipoErro = EnumTipoErro.SEM_ERRO;

		}
		return tipoErro;
	}

	public void setTipoErro(EnumTipoErro tipoErro)
	{
		this.tipoErro = tipoErro;

	}

	public void setObservacao(String observacao)
	{
		this.observacao = observacao;
	}

	public void falhar(Throwable ex, EnumTipoErro tipoErro)
	{

		setResultado(TestLinkAPIResults.TEST_FAILED);
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("TIPO DE ERRO: \n" + tipoErro.getNomeAmigavel());
		mensagem.append("\n DESCRIÇÃO DO ERRO/FALHA: \n " + ex.getMessage());
		setObservacao(mensagem.toString());
	}

	public void preencherErro(Throwable e, EnumTipoErro tipoErro)
	{

		setTipoErro(tipoErro);

		falhar(e, tipoErro);

	}

	public void reportarResultadoTestLink(ServicoPadrao servico)
			throws IOException, MessagingException, ClassNotFoundException,
			SQLException

	{

		try
		{
			getTestlinkAPIClient().reportTestCaseResult(getProjeto().getNome(),
					getProjeto().getPlano(), servico.getCasoTeste(),
					getProjeto().getBuild(), getObservacao(), getResultado());
		}
		catch (TestLinkAPIException e)
		{
			preencherErro(e, EnumTipoErro.TESTLINK);

			ConnectJDBC.atualizarTeaTestesAutomatizados(getProjeto(), servico);

			ConnectJDBC.reportarResultado(this, servico.getCasoTeste());

			Util.enviarArquivoEmail(this, servico.getCasoTeste());

			Assert.fail(this.getTipoErro().getNomeAmigavel());

		}

	}

	private TestLinkAPIClient getTestlinkAPIClient()
	{

		if ( testlinkAPIClient == null )
		{

			testlinkAPIClient = new TestLinkAPIClient(ITestlink.DEVKEY, ITestlink.URL);

		}

		return testlinkAPIClient;

	}

}
