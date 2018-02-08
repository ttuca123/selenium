package servicos;

import pages.AtendimentoPage;
import enumerators.EnumTipoItem;
import enumerators.EnumTipoModoDevolucao;
import frames.FrameMovimentarAvisoCredito;

public class BtpSrv313DevolucaoValores extends ServicoPadrao
{
	@Override
	public void executarIntegracao(ServicoPadrao servicoPadrao) throws Exception
	{

		AtendimentoPage.movimentarIntegracao();

		FrameMovimentarAvisoCredito frameMovimentarAvisoCredito = FrameMovimentarAvisoCredito
				.getFrameMovimentarAvisoCredito();

		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:
			{
				frameMovimentarAvisoCredito.movimentarAvisoCredito(
						EnumTipoItem.RECEBIMENTO_PENDENTE,
						EnumTipoModoDevolucao.EXCLUIR_RECEBIMENTO);
				break;
			}
			case 2:
			{
				frameMovimentarAvisoCredito.movimentarAvisoCredito(
						EnumTipoItem.RECEBIMENTO_PENDENTE,
						EnumTipoModoDevolucao.COMPENSACAO_DEBITO);
				break;
			}
			case 3:
			{
				frameMovimentarAvisoCredito.movimentarAvisoCredito(
						EnumTipoItem.RECEBIMENTO_PENDENTE,
						EnumTipoModoDevolucao.CREDITO_FINANCEIRO);
				break;
			}
			case 4:
			{
				frameMovimentarAvisoCredito.movimentarAvisoCredito(
						EnumTipoItem.RECEBIMENTO_PENDENTE,
						EnumTipoModoDevolucao.PAGAMENTO_CHEQUE);
				break;
			}
			default:
			{

			}
		}

	}

}
