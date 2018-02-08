package auxiliares;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import modelo.ResultadoTest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class Util
{

	public static Integer gerarNumero(int param)
	{

		Random geraNumeros = new Random();
		Integer numero = geraNumeros.nextInt(param);

		if ( numero < 0 )
		{
			return (numero) * (-1);
		}
		else if ( numero.intValue() > 0 )
		{

			return numero;
		}
		else
		{
			return gerarNumero(param);
		}

	}

	public static String gerarTextoAleatorio(int tamanho)
	{
		StringBuilder texto = new StringBuilder();
		String textoAux = null;

		while (texto.toString().length() < tamanho)
		{

			UUID uuid = UUID.randomUUID();
			String myRandom = uuid.toString();
			texto.append(myRandom);
			if ( texto.toString().length() > tamanho )
			{

				textoAux = texto.toString().substring(0, tamanho);

				break;
			}

		}

		return textoAux.replace("-", "");

	}

	public static Double converterFormatoRealDouble(String valor)
	{

		return Double.parseDouble(valor.replaceAll("\\.", "").replace(",", ".")
				.replace("R$", ""));

	}

	public static String converterFormatoDoubleReal(Double valor)
	{

		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

		return numberFormat.format(valor);

	}

	public static String converterFormatoDoubleReal(String valor)
	{

		Double valorDouble = Double.parseDouble(valor.replaceAll("\\.", "")
				.replace(",", ".").replace("R$", ""));

		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

		return numberFormat.format(valorDouble);

	}

	public static String converterFormatoStringReal(String valor)
	{

		BigDecimal valorAtual = new BigDecimal(valor);

		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

		return numberFormat.format(valorAtual);
	}

	public static Double arredondar(Double valor)
	{

		BigDecimal valorEntrada = new BigDecimal(valor).setScale(2,
				RoundingMode.DOWN);

		return valorEntrada.doubleValue();
	}

	public static void enviarEmail(ResultadoTest testLink, String nomeCasoTeste)
	{

		SimpleEmail email = new SimpleEmail();

		try
		{
			email.setCharset("utf-8");
			email.setHostName("172.25.131.80");
			email.addTo("artur.cavalcante@cagece.com.br", "Artur");
			email.addCc("evandro.custodio@cagece.com.br", "Evandro");
			email.setAuthentication("sistema@cagece.com.br", "Cagece123");
			email.setSSLOnConnect(true);
			email.setSmtpPort(456);
			email.setFrom("sistema@cagece.com.br", "Selenium Tests");
			email.setSubject("[SELENIUM] Falha no Caso de Teste: " + nomeCasoTeste);
			email.setMsg(testLink.getObservacao());
			email.send();

		}
		catch (EmailException e)
		{
			e.printStackTrace();
		}
	}

	public static void verificarMensagem(List<String> mensagemRetorno)

	{

		DriverUtils.delay(1000);
		List<WebElement> mensagensP1 = DriverUtils.getDriver().findElements(
				By.className("af_messages"));

		for (WebElement mensagem : mensagensP1)
		{

			if ( mensagem.findElements(By.className("af_messages_body")).size() > 0 )
			{
				if ( mensagem.findElements(By.tagName("ol")).size() > 0 )
				{
					if ( mensagem.findElement(By.tagName("ol"))
							.findElements(By.tagName("li")).size() > 0 )
					{

						List<WebElement> msgs = mensagem.findElement(By.tagName("ol"))
								.findElements(By.tagName("li"));

						int i = 0;
						for (WebElement msg : msgs)
						{
							Assert.assertEquals(msg.getText().trim(),
									(mensagemRetorno.get(i)));
							i++;

						}

					}
				}
			}

		}

	}

	public static void verificarMensagem(String mensagemRetorno)

	{

		DriverUtils.delay(1000);
		List<WebElement> mensagensP1 = DriverUtils.getDriver().findElements(
				By.className("af_messages"));

		for (WebElement mensagem : mensagensP1)
		{

			if ( mensagem.findElements(By.className("af_messages_body")).size() > 0 )
			{
				if ( mensagem.findElements(By.tagName("ol")).size() > 0 )
				{
					if ( mensagem.findElement(By.tagName("ol"))
							.findElements(By.tagName("li")).size() > 0 )
					{

						List<WebElement> msgs = mensagem.findElement(By.tagName("ol"))
								.findElements(By.tagName("li"));

						boolean existe = false;
						for (WebElement msg : msgs)
						{
							if ( !existe )
							{
								existe = msg.getText().trim().equals(mensagemRetorno);
							}
						}
						Assert.assertTrue(existe);

					}
				}
			}

		}

	}

	/**
	 * 
	 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 22/12/2015 -
	 *         10:14:14.
	 * @param testLink
	 * @param nomeCasoTeste
	 * @throws IOException
	 * @throws MessagingException
	 * 
	 * 
	 */
	public static void enviarArquivoEmail(ResultadoTest testLink,
			String nomeCasoTeste) throws IOException, MessagingException
	{

		String host = "172.25.131.80";

		String from = "sistema@cagece.com.br";

		String emailPrincipal = "artur.cavalcante@cagece.com.br";

		String email2 = "evandro.custodio@cagece.com.br";

		Properties properties = System.getProperties();

		properties.setProperty("mail.smtp.host", host);

		Session session = Session.getDefaultInstance(properties);

		MimeMessage message = new MimeMessage(session);

		message.setFrom(new InternetAddress(from));

		message.addRecipient(Message.RecipientType.TO, new InternetAddress(
				emailPrincipal));

		message.addRecipient(Message.RecipientType.CC, new InternetAddress(email2));

		// Configura o cabeçario da mensagem
		message.setSubject("[SELENIUM] FALHA NO CASO DE TESTE: " + nomeCasoTeste);

		Multipart multiPart = new MimeMultipart();

		BodyPart messageBodyPart = new MimeBodyPart();

		// Configura o texto do corpo da mensagem
		messageBodyPart.setText(testLink.getObservacao());

		multiPart.addBodyPart(messageBodyPart);

		messageBodyPart = new MimeBodyPart();

		DriverUtils.delay(500);

		File scrFile = ((TakesScreenshot) DriverUtils.getDriver())
				.getScreenshotAs(OutputType.FILE);

		String fileName = "/opt/integracao/" + testLink.getProjeto().getId() + "/"
				+ nomeCasoTeste + ".png";

		FileUtils.copyFile(scrFile, new File(fileName));

		DataSource source = new FileDataSource(fileName);

		// Anexa o print do erro á mensagem
		messageBodyPart.setFileName(fileName);

		messageBodyPart.setDataHandler(new DataHandler(source));

		multiPart.addBodyPart(messageBodyPart);

		message.setContent(multiPart);

		Transport.send(message);

		System.out.println("Mensagem Enviada Com Sucesso!!!");
	}

}
