package servicos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumFlags;
import enumerators.EnumTipoLigacao;
import enumerators.EnumTipoProduto;
import frames.FramePrincipalPage;

public class BtpSrv013SupressaoRamalPredial extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaSuprimir, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMotivoLigacaoAguaSuprimir, 1);

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
	public void preencherDadosComplementares() throws Exception
	{

		DriverUtils.delay(500);
		if ( DriverUtils.getDriver()
				.findElements(By.id("frmCadastro:frmMedidor1:pavimentoRua")).size() > 0 )
		{
			if ( DriverUtils.getDriver()
					.findElement(By.id("frmCadastro:frmMedidor1:pavimentoRua"))
					.isEnabled() )
			{
				DriverUtils.selecionarComboPeloIndice(FramePrincipalPage.pavimentoRua,
						2);
				DriverUtils.esperarPorAjax();
			}

		}
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
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{
		FramePrincipalPage.acessarContrato(
				servicoPadrao.getInscOrigem().toString(),
				servicoPadrao.getQtdContratoOrigem());

		servicoPadrao.getValidacao().verificarSituacaoLigacao(
				EnumTipoLigacao.SUPRIMIDO, EnumTipoProduto.AGUA);
	}

}
