package servicos;

import frames.FramePesquisaLogradouroPage;

public class BtpSrv105DesobstrucaoRedeAgua extends ServicoPadrao
{

	@Override
	public void preencherDadosComplementares() throws Exception
	{
		FramePesquisaLogradouroPage.consultarEndereco();
	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico)
	{

		preencheLaudo(servico.getLaudo());
	}
}