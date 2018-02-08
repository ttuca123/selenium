package servicos;

import pages.AtendimentoPage;
import enumerators.EnumStatusSegundaVia;
import frames.FrameMovimentarSegundaVia;

public class BtpSrv061EmissaoSegundaVia extends ServicoPadrao
{

	@Override
	public void executarIntegracao(ServicoPadrao servicoPadrao)
	{
		AtendimentoPage.movimentarIntegracao();

		FrameMovimentarSegundaVia frameMovimentarSegundaVia = FrameMovimentarSegundaVia
				.getFrameMovimentarSegundaVia();

		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:
				frameMovimentarSegundaVia
						.emitirSegundaVia(EnumStatusSegundaVia.INDIVIDUAL);
				break;
			case 2:
				frameMovimentarSegundaVia
						.emitirSegundaVia(EnumStatusSegundaVia.AGRUPADO);

				break;

			case 3:
				frameMovimentarSegundaVia.emitirSegundaVia(EnumStatusSegundaVia.PAGA);
				break;

			default:
				break;
		}

	}

}
