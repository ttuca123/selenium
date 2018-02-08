package service;

import java.util.ArrayList;
import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import modelo.ErrosVO;
import modelo.PizzaVO;
import ejb.ServicoRemote;

@Path("/message")
@Produces(MediaType.APPLICATION_JSON)
public class MessageRestService
{
	private ServicoRemote srvServico;

	@GET
	public Response printMessage() throws Exception

	{
		Context ctx = new InitialContext();
		srvServico = (ServicoRemote) ctx
				.lookup("java:global/plataforma/SrvServico!ejb.ServicoRemote");

		ArrayList<ErrosVO> erro = (ArrayList<ErrosVO>) srvServico
				.listaEstatisticaErros();
		ArrayList<PizzaVO> pizza = new ArrayList<PizzaVO>();
		
		for (ErrosVO errosVO : erro)
		{
			PizzaVO p = new PizzaVO();

			p.setLabel(errosVO.getCodigo().getNomeAmigavel());
			p.setValue(errosVO.getQuantidade());
			Random gerador = new Random();

			Integer numero = gerador.nextInt(erro.size());
			p.setIndice(numero);
			pizza.add(p);
		}

		return Response.ok(pizza).build();

	}

}