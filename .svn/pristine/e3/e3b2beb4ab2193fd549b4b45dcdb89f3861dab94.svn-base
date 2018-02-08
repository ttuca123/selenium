package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import enumerators.EnumTipoLaudo;

public class BtpSrv018ReativacaoFaturamentoEsgoto extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbDiametroLigacaoAgua, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbSituacaoLigacaoAgua, 1);

		DriverUtils.escrever(ItemAtendimentoPage.cmbLacreLigacaoAgua,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.escrever(ItemAtendimentoPage.cmbLeituraInformadaFiscal,
				LEITURA_MEDIDOR);

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				EnumTipoLaudo.PROCEDENTE.getNomeAmigavel());

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);

	}

}
