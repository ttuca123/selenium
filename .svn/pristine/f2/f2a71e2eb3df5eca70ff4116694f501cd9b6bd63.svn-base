package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoLigacao;
import enumerators.EnumTipoProduto;
import frames.FramePrincipalPage;

public class BtpSrv015ConfirmacaoExecucaoCorte extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico)
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbDiametroLigacaoAgua, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);

		switch (servico.getNrCasoTeste())
		{
			case 1:

				DriverUtils.selecionarComboPeloNome(
						ItemAtendimentoPage.cmbSituacaoLigacaoAgua,
						EnumTipoLigacao.LIGADO.getNomeAmigavel());

				break;
			case 2:
				// Cortado
				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbSituacaoLigacaoAgua, 2);

				break;

			default:
				break;
		}

		DriverUtils.escrever(ItemAtendimentoPage.cmbLacreLigacaoAgua,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.escrever(ItemAtendimentoPage.cmbLeituraInformadaFiscal,
				LEITURA_MEDIDOR);

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				EnumTipoLaudo.PROCEDENTE.getNomeAmigavel());

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);

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
						EnumTipoLigacao.LIGADO, EnumTipoProduto.AGUA);

				break;

			case 2:

				servicoPadrao.getValidacao().verificarSituacaoLigacao(
						EnumTipoLigacao.CORTADO, EnumTipoProduto.AGUA);

				break;

			default:
				break;
		}
	}

}
