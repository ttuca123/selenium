package servicos;

import java.util.HashMap;
import java.util.Map;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumFlags;
import enumerators.EnumTipoLigacao;
import enumerators.EnumTipoProduto;
import frames.FramePrincipalPage;

public class BtpSrv065LigacaoEsgoto extends ServicoPadrao
{

	@Override
	public void preencherDadosComplementares()
	{
		DriverUtils.selecionarComboPeloIndice(FramePrincipalPage.capacidadeMedidor,
				8);
		DriverUtils
				.selecionarComboPeloIndice(FramePrincipalPage.diametroMedidor, 2);
		DriverUtils.esperarPorAjax();

		DriverUtils.selecionarComboPeloIndice(
				FramePrincipalPage.diametroMedidorEsgoto, 2);
		DriverUtils.esperarPorAjax();

	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico)
	{		
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbDiametroLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMaterialLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbEstadoLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProdutoNovaLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoEsgotoAtualizar, 1);

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

	@Override
	public void verificar(ServicoPadrao servicoPadrao)
	{

		FramePrincipalPage.acessarContrato(
				servicoPadrao.getInscOrigem().toString(),
				servicoPadrao.getQtdContratoOrigem());

		servicoPadrao.getValidacao().verificarSituacaoLigacao(
				EnumTipoLigacao.LIGADO, EnumTipoProduto.ESGOTO_CONDOMINIAL);
	}

}
