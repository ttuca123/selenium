package service;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import modelo.BtpSistema;
import modelo.BtpVersao;
import ejb.SistemaRemote;
import ejb.VersaoRemote;

@Path("/enviarmd5")
@Produces(MediaType.APPLICATION_JSON)
public class UpdateMd5RestService
{
	private SistemaRemote srvSistema;

	private VersaoRemote srvVersao;

	@GET
	@Path("/{parSistema}/{parVersao}/{parMd5}")
	public Response receber(@PathParam("parSistema") Long sistema,
			@PathParam("parVersao") String versao, @PathParam("parMd5") String md5)
			throws Exception

	{
		Context ctx = new InitialContext();

		srvVersao = (VersaoRemote) ctx
				.lookup("java:global/plataforma/SrvVersao!ejb.VersaoRemote");

		srvSistema = (SistemaRemote) ctx
				.lookup("java:global/plataforma/SrvSistema!ejb.SistemaRemote");

		BtpSistema btpSistema = srvSistema.consultarPorId(sistema);

		List<BtpVersao> lstBtpVersao = srvVersao.listar(btpSistema, null);
		BtpVersao btpVersao = new BtpVersao();
		for(BtpVersao tmpBtpVersao:lstBtpVersao) {
			if (tmpBtpVersao.getVerIdVersao().equals(sistema)) {
				btpVersao = tmpBtpVersao;						
			}
		}

		return Response.ok(btpVersao.getVerDscMd5()).build();

	}

}