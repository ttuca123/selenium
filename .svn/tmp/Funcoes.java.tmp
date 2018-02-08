package utils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.velocity.app.VelocityEngine;

import enumerators.EnumAtivoAfetado;

public class Funcoes
{

	public static void download(StringBuilder lista, String nomeArquivo)
			throws IOException
	{
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletResponse ec = (HttpServletResponse) fc.getExternalContext()
				.getResponse();
		ec.reset();
		ec.setContentType("text/plain");
		String nome = "attachment; filename=\"" + nomeArquivo + "\"";
		ec.setHeader("Content-Disposition", nome);

		OutputStream output = ec.getOutputStream();

		output.write(lista.toString().getBytes());

		output.flush();
		output.close();
		fc.responseComplete();
	}

	public static void enviarEmail(String versao, String sistema,
			String dataHoraInicio, String dataHoraFim, EnumAtivoAfetado ativoAfetado,
			String riscos, StringBuilder sgds, StringBuilder chamado)
	{
		VelocityEngine engine = new VelocityEngine();

		Properties props = new Properties();
		props.put("runtime.log.logsystem.class",
				"org.apache.velocity.runtime.log.SimpleLog4JLogSystem");
		props.put("runtime.log.logsystem.log4j.category", "velocity");
		props.put("runtime.log.logsystem.log4j.logger", "velocity");

		engine.init(props);

		Map<String, Object> parametros = new HashMap<String, Object>();

		parametros.put("versao", versao);
		parametros.put("sistema", sistema);
		parametros.put("dtaHoraInicio", dataHoraInicio);
		parametros.put("dataHoraFim", dataHoraFim);
		parametros.put("ativoAfetado", ativoAfetado.name());
		parametros.put("nomeAtivoAfetado", ativoAfetado.getNomeAtivo());
		parametros.put("riscos", riscos);
		parametros.put("sgds", sgds);
		parametros.put("chamado", chamado);

		String writer = VelocityUtils.getStringPorTemplate("", "chamadoMudanca.vm",
				parametros);

		HtmlEmail email = new HtmlEmail();

		email.setHostName("172.25.131.80");
		email.setCharset("UTF-8");
		try
		{
			email.addTo("otrs@cagece.com.br", "OTRS");
			email.addCc("getic.ser@cagece.com.br","GETIC SER");
			email.addCc("evandro.custodio@cagece.com.br", "EVANDRO CUSTODIO");
			email.addCc("artur.cavalcante@cagece.com.br", "ARTUR CAVALCANTE");
			email.setFrom("sistema@cagece.com.br", "PLATAFORMA DE TESTES");
			email.setSubject("[Solicitação de Mudança] - " + ativoAfetado);

			email.setHtmlMsg(writer.toString());
			email.send();
		}
		catch (EmailException e)
		{
			e.printStackTrace();
		}

	}
}
