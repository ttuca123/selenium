package servicos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumFlags;
import enumerators.EnumTipoLaudo;

public class BtpSrv077DesobstrucaoRedeEsgoto extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico)
	{

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				EnumTipoLaudo.PROCEDENTE.getNomeAmigavel());

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);

		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbRecuperacaoPasseio,
				EnumFlags.SIM.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbRecuperacaoPavimento,
				EnumFlags.SIM.getNomeAmigavel());

		DriverUtils.selecionarComboPeloIndice(ItemAtendimentoPage.cmbTipoPavimento,
				Util.gerarNumero(12));

	}

	@Override
	public void executarIntegracao()
	{

		confirmarAdvertencia();
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
