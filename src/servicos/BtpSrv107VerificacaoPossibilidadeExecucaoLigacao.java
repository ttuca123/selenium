package servicos;

import frames.FramePesquisaLogradouroPage;

public class BtpSrv107VerificacaoPossibilidadeExecucaoLigacao extends
		ServicoPadrao
{

	@Override
	public void preencherDadosComplementares() throws Exception
	{

		FramePesquisaLogradouroPage.consultarEndereco();

	};

}
