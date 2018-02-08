package servicos;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import pages.AtendimentoPage;
import pages.ItemAtendimentoPage;
import auxiliares.ConnectJDBC;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumFlags;
import frames.FramePrincipalPage;

public class BtpSrv262LigacaoAguaInstHidrometro extends ServicoPadrao
{

	@Override
	public void preencherDadosComplementares()
	{

		DriverUtils.selecionarComboPeloIndice(FramePrincipalPage.capacidadeMedidor,
				8);

		DriverUtils
				.selecionarComboPeloIndice(FramePrincipalPage.diametroMedidor, 2);
		DriverUtils.esperarPorAjax();

	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico)
			throws ClassNotFoundException, SQLException
	{
		servico.setNrMedidorAtual(ConnectJDBC.getConsulta(SQL_NUMERO_MEDIDOR,
				new ConnectJDBC().createConnectionPrax()));

		DriverUtils.escrever(ItemAtendimentoPage.txtDataInstalacaoMedidor,
				DATA_ATUAL);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroMedidor,
				servico.getNrMedidorAtual());

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbDiametroLigacaoAgua, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtLeituraMedidorInstalacao,
				LEITURA_MEDIDOR);

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

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{

		AtendimentoPage.exibirDadosdoContrato();

		servicoPadrao.getValidacao().verificarInstalacaoHidrometro(
				servicoPadrao.getNrMedidorAtual());

	}
}
