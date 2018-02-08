package servicos;

import java.util.HashMap;
import java.util.Map;

import enumerators.EnumFlags;
import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import auxiliares.Util;

public class BtpSrv112SupressaoLigacaoCortada extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico)
	{

		DriverUtils.escrever(ItemAtendimentoPage.dataRetiradaMedidor, DATA_ATUAL);
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.ligacaoAguaSuprimir, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.motivoRetiradaMedidor, 1);

		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbRecuperacaoPasseio,
				EnumFlags.SIM.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbRecuperacaoPavimento,
				EnumFlags.SIM.getNomeAmigavel());

		DriverUtils.selecionarComboPeloIndice(ItemAtendimentoPage.cmbTipoPavimento,
				Util.gerarNumero(12));

	}

	public void validarRegistroBaixa(ServicoPadrao servico)
	{
		Map<String, Boolean> servicos = new HashMap<String, Boolean>();

		String lblRecuperacaoPavimento = "096 - RECUPERACAO DO PAVIMENTO";

		String lblRecuperacaoPasseio = "097 - RECUPERACAO DO PASSEIO";

		servicos.put(lblRecuperacaoPavimento, Boolean.FALSE);
		servicos.put(lblRecuperacaoPasseio, Boolean.FALSE);

		verificarGeracaoServicos(servicos);

	}

}
