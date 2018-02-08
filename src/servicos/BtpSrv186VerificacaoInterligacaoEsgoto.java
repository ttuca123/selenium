package servicos;

import pages.ItemAtendimentoPage;
import pages.validacao.ValidacaoAtendimento;
import auxiliares.DriverUtils;
import enumerators.EnumSituacaoRede;
import enumerators.EnumTipoLigacao;
import enumerators.EnumTipoProduto;
import frames.FramePrincipalPage;

public class BtpSrv186VerificacaoInterligacaoEsgoto extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:

			{
				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbEstadoLigacaoEsgoto, 6);
			}
				break;
			case 2:

			{
				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbEstadoLigacaoEsgoto, 1);

				break;
			}
			default:
			{

			}
				break;

		}

		if ( !DriverUtils
				.isComboVazia(ItemAtendimentoPage.cmbLigacaoEsgotoAtualizar) )
		{

			DriverUtils.selecionarComboPeloIndice(
					ItemAtendimentoPage.cmbLigacaoEsgotoAtualizar, 1);
		}

		preencheLaudo(servicoPadrao.getLaudo());

	}

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{
		FramePrincipalPage.acessarContrato(
				servicoPadrao.getInscOrigem().toString(),
				servicoPadrao.getQtdContratoOrigem());

		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:

				servicoPadrao.getValidacao().verificarSituacaoLigacao(
						EnumTipoLigacao.ABASTECIDO_COLETADO, EnumTipoProduto.ESGOTO);

				break;
			case 2:

				ValidacaoAtendimento.verificarSituacaoRede(EnumSituacaoRede.FACTIVEL,
						EnumTipoProduto.ESGOTO);

				break;

			case 3:

				ValidacaoAtendimento.verificarSituacaoRede(EnumSituacaoRede.POTENCIAL,
						EnumTipoProduto.ESGOTO);

				break;

			default:
				break;
		}

	}

}
