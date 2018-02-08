package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv190LigacaoEsgotoFinancCagece extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico)
	{
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbDiametroLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbEstadoLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProdutoNovaLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMaterialLigacaoEsgoto, 1);
	}
}
