package servicos;

import pages.AtendimentoPage;
import enumerators.EnumTipoItem;
import frames.FrameMovimentarRecAntecipado;
import frames.FramePrincipalPage;

public class BtpSrv167RecebimentoAntecipado extends ServicoPadrao
{
	String competencia;

	FrameMovimentarRecAntecipado frameMovimentarRecAntecipado;

	@Override
	public void executarIntegracao(ServicoPadrao servicoPadrao)
	{
		AtendimentoPage.movimentarIntegracao();

		frameMovimentarRecAntecipado = FramePrincipalPage
				.getFrameMovimentarRecAntecipado();

		EnumTipoItem tipoItem = null;

		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:

				tipoItem = EnumTipoItem.AGUA;

				break;
			case 2:

				tipoItem = EnumTipoItem.ESGOTO;

				break;
			case 3:

				tipoItem = EnumTipoItem.AGUA_ESGOTO;

				break;
			case 4:

				tipoItem = EnumTipoItem.SERVICO;

				break;
			case 5:

				tipoItem = EnumTipoItem.AGUA_ESGOTO_SERVICO;

				break;
			case 6:

				tipoItem = EnumTipoItem.ESGOTO_SERVICO;

				break;
			case 7:

				tipoItem = EnumTipoItem.AGUA_SERVICO;

				break;

			default:
				break;
		}

		servicoPadrao.getValidacao().setCredito(
				frameMovimentarRecAntecipado.movimentarRecebimentoAntecipado(tipoItem));

	}

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{
		servicoPadrao.getValidacao().validarAvisoCreditoFinanceiro(
				servicoPadrao.getValidacao().getCredito());

	}

}
