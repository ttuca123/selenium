package servicos;

import pages.AtendimentoPage;
import pages.validacao.ValidacaoAtendimento;
import auxiliares.ServiceTestBase;
import frames.FrameTransferenciaDebitos;

public class BtpSrv290TransferenciaDebito extends ServicoPadrao
{

	@Override
	public void preAtendimento(ServicoPadrao servicoPadrao)
	{
		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:
			case 2:

				servicoPadrao.getValidacao().setTotalDebitoContratoOrigem(
						AtendimentoPage.verificarDebitoContrato(servicoPadrao
								.getInscOrigem().toString(), servicoPadrao.getQtdContratoOrigem()));

				servicoPadrao.getValidacao().setTotalDebitoContratoDestino(
						AtendimentoPage.verificarDebitoContrato(servicoPadrao
								.getInscDestino().toString(), servicoPadrao
								.getQtdContratosDestino()));

				break;

			default:
				break;
		}
	}

	@Override
	public void executarIntegracao(ServicoPadrao servicoPadrao)
	{

		AtendimentoPage.movimentarIntegracao();

		FrameTransferenciaDebitos formMovimentarFaturas = ServiceTestBase.framePrincipal
				.getFrameTransferenciaDebito();
		
		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:
				formMovimentarFaturas.pesquisarContratoDestino(servicoPadrao
						.getInscDestino().toString());

				formMovimentarFaturas.exibirContratos();

				formMovimentarFaturas.transferirFaturasParcialmente(servicoPadrao
						.getValidacao());

				break;
				
			case 2:
				
				formMovimentarFaturas.pesquisarContratoDestino(servicoPadrao
						.getInscDestino().toString());

				formMovimentarFaturas.exibirContratos();				
								
				formMovimentarFaturas.transferirFaturas(servicoPadrao
						.getValidacao());

				break;

			case 3:

				formMovimentarFaturas.pesquisarContratoDestino(servicoPadrao
						.getInscOrigem().toString());

				ValidacaoAtendimento.validarTransferenciaMesmoContrato();

				servicoPadrao.setExecutarSolicitacao(false);

				break;

			default:
				break;
		}

	}

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{

		servicoPadrao.getValidacao().verificarTransferenciaDebito(servicoPadrao);

	}
}
