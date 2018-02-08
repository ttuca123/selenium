package servicos;

import frames.FramePesquisaLogradouroPage;

public class BtpSrv328ServicosLaboratoriaisEsgoto extends ServicoPadrao
{

	@Override
	public void preencherDadosComplementares() throws Exception
	{
		FramePesquisaLogradouroPage.consultarEndereco();
	}
}
