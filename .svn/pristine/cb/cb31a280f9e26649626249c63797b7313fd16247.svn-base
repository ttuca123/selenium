package servicos;

import java.util.ArrayList;
import java.util.List;

import pages.ItemAtendimentoPage;
import auxiliares.BaseVars;
import auxiliares.DriverUtils;
import auxiliares.Util;

public class BtpSrv312VencimentoOpcional extends ServicoPadrao
{
	@Override
	public void preencherDadosComplementares() throws Exception
	{
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbVencimentoOpcional, 1);
	}
	

	@Override
	public void confirmarAtendimento(ServicoPadrao servicoPadrao)
	{
		switch (servicoPadrao.getNrCasoTeste())
		{
			case 2:
			case 3:
			{
				List<String> mensagens = new ArrayList<String>();

				mensagens.add("Não foi possivel salvar o Item de Atendimento.");

				mensagens.add(BaseVars.MSG_VENC_OPC_ORGAO_PUBLICO);

				Util.verificarMensagem(mensagens);

				servicoPadrao.setExecutarSolicitacao(false);

				break;
			}
			default:
			{

			}
		}

	}
}
