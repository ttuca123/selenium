package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import enumerators.EnumTipoLigacao;
import enumerators.EnumTipoProduto;
import frames.FramePrincipalPage;

public class BtpSrv149AlteracaoLigacaoEsgoto extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:
			{
				DriverUtils.selecionarComboPeloNome(
						ItemAtendimentoPage.cmbEstadoLigacaoEsgoto,
						EnumTipoLigacao.LIGADO.getNomeAmigavel());
			}
				break;
			case 2:
			{
				DriverUtils.selecionarComboPeloNome(
						ItemAtendimentoPage.cmbEstadoLigacaoEsgoto,
						EnumTipoLigacao.CORTADO.getNomeAmigavel() + "/"
								+ EnumTipoLigacao.TAMPONADO.getNomeAmigavel());
			}
				break;
			case 3:
			{
				DriverUtils.selecionarComboPeloNome(
						ItemAtendimentoPage.cmbEstadoLigacaoEsgoto,
						EnumTipoLigacao.LIGADO_SEM_INTERLIGACAO.getNomeAmigavel());
			}
				break;
			case 4:
			{
				DriverUtils.selecionarComboPeloNome(
						ItemAtendimentoPage.cmbEstadoLigacaoEsgoto,
						EnumTipoLigacao.LIGADO_SEM_CONDICAO_SCI.getNomeAmigavel());

			}
				break;
			case 5:
			{
				DriverUtils.selecionarComboPeloNome(
						ItemAtendimentoPage.cmbEstadoLigacaoEsgoto,
						EnumTipoLigacao.ABASTECIDO_COLETADO.getNomeAmigavel());

			}
				break;

			default:
				break;
		}

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbDiametroLigacaoEsgoto, 1);

		if ( !DriverUtils
				.isComboVazia(ItemAtendimentoPage.cmbLigacaoEsgotoAtualizar) )
		{

			DriverUtils.selecionarComboPeloIndice(
					ItemAtendimentoPage.cmbLigacaoEsgotoAtualizar, 1);

		}

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMaterialLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProdutoNovaLigacaoEsgoto, 3);

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
			{

				servicoPadrao.getValidacao().verificarSituacaoLigacao(
						EnumTipoLigacao.LIGADO, EnumTipoProduto.ESGOTO);

			}
				break;
			case 2:
			{
				servicoPadrao.getValidacao().verificarSituacaoLigacao(
						EnumTipoLigacao.TAMPONADO, EnumTipoProduto.ESGOTO);
			}
				break;
			case 3:
			{
				servicoPadrao.getValidacao().verificarSituacaoLigacao(
						EnumTipoLigacao.LIGADO_SEM_INTERLIGACAO, EnumTipoProduto.ESGOTO);
			}
				break;
			case 4:
			{
				servicoPadrao.getValidacao().verificarSituacaoLigacao(
						EnumTipoLigacao.LIGADO_SEM_CONDICAO_SCI, EnumTipoProduto.ESGOTO);

			}
				break;
			case 5:
			{
				servicoPadrao.getValidacao().verificarSituacaoLigacao(
						EnumTipoLigacao.ABASTECIDO_COLETADO, EnumTipoProduto.ESGOTO);

			}
				break;

			default:
				break;
		}

	}

}
