package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import auxiliares.Util;

public class BtpSrv272OutrasReclamacoesElogiosSugestoes extends ServicoPadrao
{
	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao) throws Exception
	{
		DriverUtils.escrever(ItemAtendimentoPage.txtMensagemAtendimentoVirtual,
				Util.gerarTextoAleatorio(100));
		
	}
	
	@Override
	public void preencherDadosComplementares() throws Exception
	{
		DriverUtils.clicar(ItemAtendimentoPage.chkOpcaoRelacamacao);
	}
	
}
