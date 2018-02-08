package servicos;

import frames.FramePesquisaLogradouroPage;

public class BtpSrv233MedicaoVazaoRedeAgua extends ServicoPadrao
{

	@Override
	public void preencherDadosComplementares() throws Exception
	{
		FramePesquisaLogradouroPage.consultarEndereco();
	}

}
