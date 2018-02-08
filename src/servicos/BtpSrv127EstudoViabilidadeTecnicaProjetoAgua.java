package servicos;

import pages.AtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv127EstudoViabilidadeTecnicaProjetoAgua extends ServicoPadrao
{

	@Override
	public void preencherDadosComplementares()
	{
		DriverUtils.escrever(AtendimentoPage.txtNumeroProtocolo, NUMERO_PROTOCOLO);

	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		preencheLaudo(servicoPadrao.getLaudo());

	}
}