package servicos;

import frames.FramePesquisaLogradouroPage;

public class BtpSrv327ServicosLaboratoriaisAgua extends ServicoPadrao
{

	@Override
	public void preencherDadosComplementares() throws Exception
	{
		FramePesquisaLogradouroPage.consultarEndereco();
	}

}
