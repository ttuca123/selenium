package servicos;

import java.util.HashMap;
import java.util.Map;

import pages.ItemAtendimentoPage;
import auxiliares.ConnectJDBC;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumFlags;
import enumerators.EnumTipoLigacao;
import enumerators.EnumTipoProduto;
import frames.FramePrincipalPage;

public class BtpSrv260LigacaoAguaInstHidrometroSuprimida extends ServicoPadrao
{

	@Override
	public void preValidar(ServicoPadrao servicoPadrao)
	{
		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:
				org.junit.Assert
						.assertTrue(FramePrincipalPage
								.mensagemExibida("Existe multa por infração ainda não negociada para a inscrição: "
										+ servicoPadrao.getInscOrigem().toString()));

				servicoPadrao.setExecutarSolicitacao(false);

				break;

			default:
				break;
		}

	}

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{

		DriverUtils.clicar(FramePrincipalPage.btnContrato);

		DriverUtils.esperarPorAjax();

		servicoPadrao.getValidacao().verificarSituacaoLigacao(
				EnumTipoLigacao.LIGADO, EnumTipoProduto.AGUA);

	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao) throws Exception
	{
		DriverUtils.escrever(ItemAtendimentoPage.txtDataInstalacaoMedidor,
				DATA_ATUAL);

		DriverUtils.escrever(
				ItemAtendimentoPage.txtNumeroMedidor,
				ConnectJDBC.getConsulta(SQL_NUMERO_MEDIDOR,
						new ConnectJDBC().createConnectionPrax()));

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbDiametroLigacaoAgua, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLocalInstalacaoMedidor, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMaterialLigacaoAgua, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacaoNova,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.clicar(ItemAtendimentoPage.optPavimentoCalcada);

		DriverUtils.clicar(ItemAtendimentoPage.optPavimentoAsfalto);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProdutoNovaLigacaoAgua, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProtecaoMedidor, 1);

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
