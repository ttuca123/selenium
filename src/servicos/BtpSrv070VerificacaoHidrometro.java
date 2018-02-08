package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import enumerators.EnumTipoPagamento;

public class BtpSrv070VerificacaoHidrometro extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		servicoPadrao.getTiposPgtos().clear();

		servicoPadrao.getTiposPgtos().add(EnumTipoPagamento.SEM_CUSTO);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);

		DriverUtils.escrever(ItemAtendimentoPage.cmbLacreLigacaoAgua,
				NUMERO_LACRE_LIGACAO);

		preencheLaudo(servicoPadrao.getLaudo());
	}
}