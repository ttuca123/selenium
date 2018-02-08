package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;

public class BtpSrv005VerificacaoLigacaoAguaFaturadaNaoExecutada extends
		ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:
			{

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbSituacaoLigacaoAgua, 1);

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);
				break;
			}

			case 2:
			{

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbSituacaoLigacaoAgua, 2);

				DriverUtils.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);

				break;
			}
			default:
			{

			}
		}

		preencheLaudo(servicoPadrao.getLaudo());

	}
}