package servicos;

import pages.AtendimentoPage;
import frames.FrameMovimentarCertidaoNegativa;

public class BtpSrv062EmissaoCertidaoNegativa extends ServicoPadrao
{

	@SuppressWarnings("static-access")
	@Override
	public void executarIntegracao()
	{
		AtendimentoPage.movimentarIntegracao();

		FrameMovimentarCertidaoNegativa frameMovimentarCertidaoNegativa = FrameMovimentarCertidaoNegativa
				.getFrameMovimentarCertidaoNegativa();

		frameMovimentarCertidaoNegativa.emitirCertidaoNegativa();
	}

}
