package servicos;

import pages.AtendimentoPage;
import frames.FrameMovimentarCartaAnuencia;

public class BtpSrv055EmissaoCartaAnuencia extends ServicoPadrao
{

	@Override
	public void executarIntegracao(ServicoPadrao servicoPadrao)
	{
		AtendimentoPage.movimentarIntegracao();

		FrameMovimentarCartaAnuencia frameMovimentarCartaAnuencia = FrameMovimentarCartaAnuencia
				.getFrameMovimentarCartaAnuencia();

		frameMovimentarCartaAnuencia.emitirCartaAnuencia(servicoPadrao
				.getInscOrigem());

	}

}
