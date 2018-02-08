package servicos;

import java.util.HashMap;
import java.util.Map;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumFlags;

public class BtpSrv075ConsertoVazamentoRede extends ServicoPadrao
{

	@Override
	public void executarIntegracao()
	{

		confirmarAdvertencia();

	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbDiametroLigacaoVazamento, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtDuracaoConsertoVazamento,
				DURACAO_CONSERTO);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMaterialLigacaoVazamento, 1);

		DriverUtils.selecionarComboPeloIndice(ItemAtendimentoPage.cmbTipoVazamento,
				1);

		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:

				DriverUtils.selecionarComboPeloNome(
						ItemAtendimentoPage.cmbRecuperacaoPasseio,
						EnumFlags.SIM.getNomeAmigavel());

				DriverUtils.selecionarComboPeloNome(
						ItemAtendimentoPage.cmbRecuperacaoPavimento,
						EnumFlags.SIM.getNomeAmigavel());

				break;

			case 2:
			case 3:

				DriverUtils.selecionarComboPeloNome(
						ItemAtendimentoPage.cmbRecuperacaoPasseio,
						EnumFlags.NAO.getNomeAmigavel());

				DriverUtils.selecionarComboPeloNome(
						ItemAtendimentoPage.cmbRecuperacaoPavimento,
						EnumFlags.NAO.getNomeAmigavel());

				break;

			default:
				break;
		}

		DriverUtils.selecionarComboPeloIndice(ItemAtendimentoPage.cmbTipoPavimento,
				Util.gerarNumero(12));

		preencheLaudo(servicoPadrao.getLaudo());

	}

	public void validarRegistroBaixa(ServicoPadrao servico)
	{
		Map<String, Boolean> servicos = new HashMap<String, Boolean>();

		String lblRecuperacaoPavimento = "096 - RECUPERACAO DO PAVIMENTO";

		String lblRecuperacaoPasseio = "097 - RECUPERACAO DO PASSEIO";

		servicos.put(lblRecuperacaoPavimento, Boolean.FALSE);
		servicos.put(lblRecuperacaoPasseio, Boolean.FALSE);

		switch (servico.getNrCasoTeste())
		{
			case 1:

				verificarGeracaoServicos(servicos);

				break;

			default:
				break;

		}
	}
}
