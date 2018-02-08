package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import auxiliares.Util;

public class BtpSrv191InterligacaoEsgotoFinanciamentoCagece extends
		ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico)
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbEstadoLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoEsgotoAtualizar, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbDiametroLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMaterialLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProdutoNovaLigacaoEsgoto, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtVolumeReal,
				Util.converterFormatoDoubleReal(Util.gerarNumero(100) * 1.00));

	}
}
