package servicos;

import pages.AtendimentoPage;
import auxiliares.ServiceTestBase;
import enumerators.EnumTipoCliente;
import enumerators.EnumTipoModoParcelamento;
import enumerators.EnumTipoParcelamento;
import frames.FrameParcelamento;

public class BtpSrv257TransferenciaDebito extends ServicoPadrao
{

	@Override
	public void executarIntegracao(ServicoPadrao servicoPadrao)
	{

		AtendimentoPage.movimentarIntegracao();

		FrameParcelamento formMovimentarFaturas = ServiceTestBase.framePrincipal
				.getFrameParcelamento();

		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:

				formMovimentarFaturas.selecionarTipoParcelamento(
						EnumTipoModoParcelamento.SEM_ENTRADA,
						EnumTipoParcelamento.SEM_JUROS, EnumTipoCliente.OUTROS);

				break;

			case 2:

				formMovimentarFaturas.selecionarTipoParcelamento(
						EnumTipoModoParcelamento.COM_ENTRADA,
						EnumTipoParcelamento.SEM_JUROS, EnumTipoCliente.OUTROS);

				break;

			case 3:
				formMovimentarFaturas.selecionarTipoParcelamento(
						EnumTipoModoParcelamento.SEGUNDO_PARCELAMENTO,
						EnumTipoParcelamento.SEM_JUROS, EnumTipoCliente.OUTROS);

				break;
			case 4:
				formMovimentarFaturas.selecionarTipoParcelamento(
						EnumTipoModoParcelamento.TERCEIRO_PARCELAMENTO,
						EnumTipoParcelamento.SEM_JUROS, EnumTipoCliente.OUTROS);

				break;
			case 5:

				formMovimentarFaturas.selecionarTipoParcelamento(
						EnumTipoModoParcelamento.SEM_ENTRADA,
						EnumTipoParcelamento.COM_JUROS, EnumTipoCliente.OUTROS);

				break;

			case 6:

				formMovimentarFaturas.selecionarTipoParcelamento(
						EnumTipoModoParcelamento.COM_ENTRADA,
						EnumTipoParcelamento.COM_JUROS, EnumTipoCliente.OUTROS);

				break;

			case 7:

				formMovimentarFaturas.selecionarTipoParcelamento(
						EnumTipoModoParcelamento.SEGUNDO_PARCELAMENTO,
						EnumTipoParcelamento.COM_JUROS, EnumTipoCliente.OUTROS);

				break;

			default:
				break;
		}

	}

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{

		servicoPadrao.getValidacao().validarParcelamento(
				servicoPadrao.getValidacao().getParcelamento());

	}
}
