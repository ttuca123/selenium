package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import auxiliares.Util;

public class BtpSrv339RevisaoCalculoTarifaDeContigencia extends ServicoPadrao
{

	@Override
	public void preencherDadosComplementares() throws Exception
	{
		DriverUtils.escrever(ItemAtendimentoPage.txtNrProtocolo,
				Util.gerarNumero(9999999).toString());
	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{
		preencheLaudo(servicoPadrao.getLaudo());
	}

}
