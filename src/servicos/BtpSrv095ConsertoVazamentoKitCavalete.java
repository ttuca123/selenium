package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import enumerators.EnumTipoLaudo;

public class BtpSrv095ConsertoVazamentoKitCavalete extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbDiametroLigacaoAgua, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtDuracaoConsertoVazamento,
				DURACAO_CONSERTO);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);

		DriverUtils
				.selecionarComboPeloIndice(ItemAtendimentoPage.localVazamento, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMaterialLigacaoAgua, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				EnumTipoLaudo.PROCEDENTE.getNomeAmigavel());

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);
	};

}
