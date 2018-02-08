package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv004VerificacaoLigacaoAguaExecutadaNaoFaturada extends
		ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.diametroLigacaoAgua, 1);
		
		
		preencheLaudo(servicoPadrao.getLaudo());
	}
}
