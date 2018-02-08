package pages;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import auxiliares.ConnectJDBC;
import auxiliares.DataUtil;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumFlags;

public class DadosBaixa
{

	public static final String CMB_RECUPERACAO_PAVIMENTO = "frmCadastro:subFormBaixaItemAtendimento:subFrmBaixa:enumRecuperarPavimento";

	public static final String CMB_TIPO_PAVIMENTO = "frmCadastro:subFormBaixaItemAtendimento:subFrmBaixa:btpPavimentoRecuperar";

	public static final String CMB_RECUPERACAO_PASSEIO = "frmCadastro:subFormBaixaItemAtendimento:subFrmBaixa:enumRecuperarPasseio";

	private final static String SQL_NUMERO_MEDIDOR = "SELECT MED_NUM_MEDIDOR || MED_NUM_SEQ_MEDIDOR FROM MED_MEDIDOR WHERE MED_STA_MEDIDOR=2 AND ROWNUM=1";

	public static final String DESCRICAO = "Descrição: "
			+ Util.gerarTextoAleatorio(20);

	public static final String NUMERO_LACRE_LIGACAO = Util.gerarNumero(99999)
			.toString();

	public static final String LEITURA_MEDIDOR = Util.gerarNumero(99999)
			.toString();

	private static final String DATA_ATUAL = DataUtil
			.converterDataFormatoddMMyyy(new Date());

	public static final String PROCEDENTE = "PROCEDENTE";

	public static final String IMPROCEDENTE = "IMPROCEDENTE";

	@SuppressWarnings("unused")
	private static final String DURACAO_CONSERTO = "1:00";

	private static final String NUMERO_TERMO_OCORRENCIA = Util.gerarNumero(
			9999999).toString();

	private static final String NOME_FISCAL = Util.gerarTextoAleatorio(50);

	// Serviço 07
	public static void verificarDadosCadastrais()
	{
		// JUnitTestBase.tiposPgtos.get(0). EnumTipoPagamento.SEM_CUSTO;

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				PROCEDENTE);

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);

	}

	// Serviço 07 Improcedente
	public static void verificarDadosCadastraisImprocedente()
	{

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				IMPROCEDENTE);

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);

	}

	// 83
	public static void realizarCorte()
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaCortar, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMotivoAguaCorte, 1);

	}

	// Serviço 13
	public static void suprimirRamalPredial()
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaSuprimir, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMotivoLigacaoAguaSuprimir, 1);

	}

	// Serviço 15
	public static void confirmarExecucaoCorte()
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbDiametroLigacaoAgua, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbSituacaoLigacaoAgua, 1);

		DriverUtils.escrever(ItemAtendimentoPage.cmbLacreLigacaoAgua,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.escrever(ItemAtendimentoPage.cmbLeituraInformadaFiscal,
				LEITURA_MEDIDOR);

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				PROCEDENTE);

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);

	}

	// Serviço 17
	public static void suspenderFaturamentoEsgoto()
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoEsgotoSuspender, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMotivoLigacaoEsgotoSuspender, 1);

	}

	// Serviço 68
	public static void retirarHidrometro()
	{

		DriverUtils
				.escrever(ItemAtendimentoPage.txtDataRetiradaMedidor, DATA_ATUAL);

		DriverUtils.escrever(ItemAtendimentoPage.txtLeituraMedidorRetirada,
				LEITURA_MEDIDOR);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbInstalacaoAtualizar, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMotivoRetiradaMedidor, 1);

	}

	// Serviço 69
	public static void instalarHidrometro() throws ClassNotFoundException,
			SQLException
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLocalInstalacaoMedidor, 1);

		DriverUtils.escrever(ItemAtendimentoPage.cmbLacreLigacaoAgua,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.escrever(ItemAtendimentoPage.txtDataInstalacaoMedidor,
				DATA_ATUAL);

		DriverUtils.escrever(ItemAtendimentoPage.txtLeituraMedidorInstalacao,
				LEITURA_MEDIDOR);

		DriverUtils.escrever(
				ItemAtendimentoPage.txtNumeroMedidor,
				ConnectJDBC.getConsulta(SQL_NUMERO_MEDIDOR,
						new ConnectJDBC().createConnectionPrax()));

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProtecaoMedidor, 1);

	}

	// Serviço 71
	public static void substituirHidrometro() throws ClassNotFoundException,
			SQLException
	{

		DriverUtils
				.escrever(ItemAtendimentoPage.txtDataRetiradaMedidor, DATA_ATUAL);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMotivoRetiradaMedidor, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoSubstituir, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.escrever(ItemAtendimentoPage.txtLeituraMedidorRetirada,
				LEITURA_MEDIDOR);

		DriverUtils.escrever(
				ItemAtendimentoPage.txtNumeroMedidor,
				ConnectJDBC.getConsulta(SQL_NUMERO_MEDIDOR,
						new ConnectJDBC().createConnectionPrax()));

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLocalInstalacaoMedidor, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProtecaoMedidor, 1);

	}

	// Serviço 72
	public static void deslocarHidrometro()
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbInstalacaoAtualizar, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLocalInstalacaoMedidor, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProtecaoMedidor, 1);

	}

	// Serviço 76
	public static void reclamarFaltaDaguaImovel()
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				PROCEDENTE);

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);
	}

	// Serviço 77
	public static void desobstruirRedeEsgoto()
	{

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				PROCEDENTE);

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);

	}

	// Serviço 84
	public static void religarAgua()
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaReativar, 1);

	}

	// Serviço 86
	public static void consertarCaixaHidrometro()
	{
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);
	}

	// Serviço 96
	public static void recuperarPavimento()
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbPavimentoRecuperado, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbRecuperacaoPavimento, 1);

		DriverUtils.clicar(ItemAtendimentoPage.optPavimentoAsfalto);

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				PROCEDENTE);

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);

	}

	// Serviço 97
	public static void recuperarPasseio()
	{
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbRecuperacaoPavimento, 1);

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				PROCEDENTE);

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);
	}

	// Serviço 100
	public static void substituirLigacaoAguaComAlteracaoHidrometro()
			throws ClassNotFoundException, SQLException
	{

		DriverUtils
				.escrever(ItemAtendimentoPage.txtDataRetiradaMedidor, DATA_ATUAL);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMaterialLigacaoAgua, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbDiametroLigacaoAgua, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMotivoRetiradaMedidor, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbInstalacaoSubstituir, 1);

		DriverUtils.escrever(ItemAtendimentoPage.cmbLacreLigacaoAgua,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.escrever(ItemAtendimentoPage.txtLeituraMedidorRetirada,
				LEITURA_MEDIDOR);

		DriverUtils.escrever(
				ItemAtendimentoPage.txtNumeroMedidor,
				ConnectJDBC.getConsulta(SQL_NUMERO_MEDIDOR,
						new ConnectJDBC().createConnectionPrax()));

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLocalInstalacaoMedidor, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProtecaoMedidor, 1);

	}

	// Serviço 111
	public static void selarHidrometro()
	{
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);
	}

	// Serviço 115
	public static void recuperarCaixaInspecaoDanificada()
	{
		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				PROCEDENTE);

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);
	}

	// Serviço 134
	public static void sondarCampoRedeEsgoto()
	{
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbSituacaoRedeEsgoto, 1);
	}

	// Serviço 186
	public static void verificarInterligacaoEsgoto()
	{
		if ( DriverUtils
				.isComboVazia(ItemAtendimentoPage.cmbLigacaoEsgotoAtualizar) )
		{

			DriverUtils.selecionarComboPeloIndice(
					ItemAtendimentoPage.cmbLigacaoEsgotoAtualizar, 1);

		}

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				PROCEDENTE);

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, PROCEDENTE);

	}

	// Serviço 188 CT01
	public static void verificarIrregularidadeLigacao()

	{
		String multa;

		gerarTermoOcorrencia(EnumFlags.NAO);

		multa = ItemAtendimentoPage.lblTermoTotalMulta.getText();

		finalizarVerificacaoIrregularidade(multa);
	}

	// Serviço 188 CT02
	public static void verificarIrregularidadeLigacaoReincidente(String inscricao)
			throws ClassNotFoundException, SQLException

	{
		String multa = ConnectJDBC.buscarValorMulta(inscricao);

		gerarTermoOcorrencia(EnumFlags.SIM);

		multa = ItemAtendimentoPage.lblTermoTotalMulta.getText();

		finalizarVerificacaoIrregularidade(multa);

	}

	// Serviço 190
	public static void ligarEsgotoFinanciamentoCagece()
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbDiametroLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbEstadoLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProdutoNovaLigacaoEsgoto, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMaterialLigacaoEsgoto, 1);

	}

	// Serviço 260
	public static void ligarAguaInstalacaoHidrometroSuprimida()
			throws ClassNotFoundException, SQLException
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

	}

	// Serviço 262
	public static void ligarAguaInstalacaoHidrometro()
			throws ClassNotFoundException, SQLException
	{

		DriverUtils.escrever(ItemAtendimentoPage.txtDataInstalacaoMedidor,
				DATA_ATUAL);

		DriverUtils.escrever(
				ItemAtendimentoPage.txtNumeroMedidor,
				ConnectJDBC.getConsulta(SQL_NUMERO_MEDIDOR,
						new ConnectJDBC().createConnectionPrax()));

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

	}

	// Serviço 278

	public static void substituirHidrometroRoubado()
			throws ClassNotFoundException, SQLException
	{
		DriverUtils
				.escrever(ItemAtendimentoPage.txtDataRetiradaMedidor, DATA_ATUAL);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMotivoRetiradaMedidor, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbInstalacaoSubstituir, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.escrever(ItemAtendimentoPage.txtLeituraMedidorRetirada,
				LEITURA_MEDIDOR);

		DriverUtils.escrever(
				ItemAtendimentoPage.txtNumeroMedidor,
				ConnectJDBC.getConsulta(SQL_NUMERO_MEDIDOR,
						new ConnectJDBC().createConnectionPrax()));

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLocalInstalacaoMedidor, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbProtecaoMedidor, 1);

	}

	// Serviço 284
	public static void religarAguaUrgente()
	{
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaReativar, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.escrever(ItemAtendimentoPage.txtLeituraMedidorReativacao,
				LEITURA_MEDIDOR);

	}

	// Serviço 303
	public static void verificarBaixaPressao()
	{

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);
		DriverUtils.clicar(ItemAtendimentoPage.optPavimentoCalcada);

		DriverUtils.clicar(ItemAtendimentoPage.optPavimentoAsfalto);

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				PROCEDENTE);
		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);

	}

	// Serviço 334 e 335
	public static void analisarGrandesClientesConsumidores()

	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbVazamentoOculto, 1);

		DriverUtils.selecionarComboPeloNome(ItemAtendimentoPage.cmbResultadoLaudo,
				PROCEDENTE);

		DriverUtils.escrever(ItemAtendimentoPage.txtDescricaoLaudo, DESCRICAO);
	}

	private static void gerarTermoOcorrencia(EnumFlags heReincidente)
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbClassificacaoEconomiaDiferente,
				EnumFlags.NAO.getCodigo());

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbClassificacaoBaixaRendaIndevida,
				EnumFlags.NAO.getCodigo());

		DriverUtils
				.selecionarComboPeloIndice(
						ItemAtendimentoPage.cmbExisteTermoOcorrencia,
						EnumFlags.NAO.getCodigo());

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaAtualizar, 1);

		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbQtdEconomiasDiferentes,
				EnumFlags.NAO.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbClienteReincidente,
				heReincidente.getNomeAmigavel());

		DriverUtils.selecionarComboPeloNome(
				ItemAtendimentoPage.cmbSituacaoLigacaoDiferente,
				EnumFlags.NAO.getNomeAmigavel());

		DriverUtils.clicar(ItemAtendimentoPage.optLigClandestina);

		DriverUtils.clicar(ItemAtendimentoPage.btnGerarTermoOcorrencia);

		DriverUtils.avancarFrame();

		DriverUtils.escrever(ItemAtendimentoPage.txtDetalharIrregularidade,
				PROCEDENTE);

		DriverUtils.escrever(ItemAtendimentoPage.txtNomeFiscal, NOME_FISCAL);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroTermoOcorrencia,
				NUMERO_TERMO_OCORRENCIA + Util.gerarNumero(100));

	}

	private static void finalizarVerificacaoIrregularidade(String multa)
	{

		DriverUtils.clicar(ItemAtendimentoPage.btnSalvar);

		DriverUtils.getDriver().switchTo().defaultContent();

		WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), 15);

		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(MenuPage.FRAME_PRINCIPAL_ACI)));

		DriverUtils.esperarPorAjax();

		Assert.assertEquals(multa,
				ItemAtendimentoPage.txtValorMultaTotal.getAttribute("value"));

	}

}
