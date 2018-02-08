package servicos;

import java.sql.SQLException;

import pages.AtendimentoPage;
import pages.ItemAtendimentoPage;
import pages.MenuPage;
import auxiliares.DataUtil;
import auxiliares.DriverUtils;
import enumerators.EnumMotivoMovimentacao;
import enumerators.EnumServico;
import enumerators.EnumTipoDadosFatura;
import enumerators.EnumTipoLigacao;
import enumerators.EnumTipoMovimentacao;
import enumerators.EnumTipoProduto;
import frames.FrameMovimentarFaturas;
import frames.FramePrincipalPage;

public class BtpSrv137Refaturamento extends ServicoPadrao
{
	String competencia;

	FrameMovimentarFaturas formMovimentarFaturas;
	
	@Override
	public void preencherDadosComplementares() throws Exception
	{
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbEnviarFaturaEmail, 1);
	}

	@Override
	public void executarIntegracao(ServicoPadrao servicoPadrao) throws Exception
	{
		AtendimentoPage.movimentarIntegracao();

		formMovimentarFaturas = FrameMovimentarFaturas
				.getFrameMovimentarFaturaPage();

		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:

				retificarProdutoServicoDadosEpoca(servicoPadrao);

				break;
			case 2:

				alterarVencimentoDadosEpoca(servicoPadrao);

				break;
			case 3:

				alterarVencimentoDadosAtuais(servicoPadrao);

				break;
			case 4:

				revisarDadosAtuais(servicoPadrao);

				break;
			case 5:
				retificarProdutoServicoDadosAtuais(EnumMotivoMovimentacao.ERRO_LEITURA,
						servicoPadrao);
				break;
			case 6:

				revisarDadosEpoca(servicoPadrao);

				break;

			case 7:

				retirarRevisaoDadosAtuais(servicoPadrao);

				break;
			case 8:

				retirarRevisaoDadosEpoca(servicoPadrao);

				break;
			case 9:

				cancelarFatura(EnumTipoDadosFatura.EPOCA, servicoPadrao);

				break;
			case 10:

				cancelarFatura(EnumTipoDadosFatura.ATUAL, servicoPadrao);

				break;
			case 11:
				retificarProdutoServicoDadosAtuais(
						EnumMotivoMovimentacao.ERRO_DE_DIGITACAO, servicoPadrao);

				break;

			default:
				break;
		}

	}

	private void cancelarFatura(EnumTipoDadosFatura tipoDadosFatura,
			ServicoPadrao servicoPadrao) throws ClassNotFoundException, SQLException
	{
		formMovimentarFaturas.movimentarFaturas(EnumTipoMovimentacao.CANCELAR,
				EnumMotivoMovimentacao.ERRO_LEITURA, tipoDadosFatura, null,
				EnumServico.REFATURAMENTO, servicoPadrao.getValorServico(),
				servicoPadrao.isExecutarComAlcada());
	}

	private void alterarVencimentoDadosEpoca(ServicoPadrao servicoPadrao)
			throws ClassNotFoundException, SQLException
	{
		formMovimentarFaturas.movimentarFaturas(
				EnumTipoMovimentacao.ALTERAR_VENCIMENTO,
				EnumMotivoMovimentacao.ALTERACAO_DE_DATA_DE_VENCIMENTO,
				EnumTipoDadosFatura.EPOCA, null, EnumServico.REFATURAMENTO,
				servicoPadrao.getValorServico(), servicoPadrao.isExecutarComAlcada());

	}

	private void alterarVencimentoDadosAtuais(ServicoPadrao servicoPadrao)
			throws ClassNotFoundException, SQLException
	{
		formMovimentarFaturas.movimentarFaturas(
				EnumTipoMovimentacao.ALTERAR_VENCIMENTO,
				EnumMotivoMovimentacao.ALTERACAO_DE_DATA_DE_VENCIMENTO,
				EnumTipoDadosFatura.ATUAL, null, EnumServico.REFATURAMENTO,
				servicoPadrao.getValorServico(), servicoPadrao.isExecutarComAlcada());
	}

	private void revisarDadosEpoca(ServicoPadrao servicoPadrao)
			throws ClassNotFoundException, SQLException
	{
		String mes01 = "-25";
		String mes02 = "-24";

		competencia = DataUtil.getCompetenciaTarifaria(mes01, mes02);

		formMovimentarFaturas.movimentarFaturas(
				EnumTipoMovimentacao.COLOCAR_EM_REVISAO,
				EnumMotivoMovimentacao.ERRO_LEITURA, EnumTipoDadosFatura.EPOCA,
				competencia, EnumServico.REFATURAMENTO,
				servicoPadrao.getValorServico(), servicoPadrao.isExecutarComAlcada());

	}

	private void retirarRevisaoDadosEpoca(ServicoPadrao servicoPadrao)
			throws ClassNotFoundException, SQLException
	{
		String mes01 = "-25";
		String mes02 = "-24";

		competencia = DataUtil.getCompetenciaTarifaria(mes01, mes02);

		formMovimentarFaturas.movimentarFaturas(
				EnumTipoMovimentacao.TIRAR_DE_REVISAO,
				EnumMotivoMovimentacao.ERRO_LEITURA, EnumTipoDadosFatura.EPOCA,
				competencia, EnumServico.REFATURAMENTO,
				servicoPadrao.getValorServico(), servicoPadrao.isExecutarComAlcada());

	}

	private void retirarRevisaoDadosAtuais(ServicoPadrao servicoPadrao)
			throws ClassNotFoundException, SQLException
	{
		String mes01 = "-3";
		String mes02 = "-2";

		competencia = DataUtil.getCompetenciaTarifaria(mes01, mes02);

		formMovimentarFaturas.movimentarFaturas(
				EnumTipoMovimentacao.TIRAR_DE_REVISAO,
				EnumMotivoMovimentacao.ERRO_LEITURA, EnumTipoDadosFatura.ATUAL,
				competencia, EnumServico.REFATURAMENTO,
				servicoPadrao.getValorServico(), servicoPadrao.isExecutarComAlcada());

	}

	private void revisarDadosAtuais(ServicoPadrao servicoPadrao)
			throws ClassNotFoundException, SQLException
	{
		String mes01 = "-3";
		String mes02 = "-2";

		competencia = DataUtil.getCompetenciaTarifaria(mes01, mes02);

		formMovimentarFaturas.movimentarFaturas(
				EnumTipoMovimentacao.COLOCAR_EM_REVISAO,
				EnumMotivoMovimentacao.ERRO_LEITURA, EnumTipoDadosFatura.ATUAL,
				competencia, EnumServico.REFATURAMENTO,
				servicoPadrao.getValorServico(), servicoPadrao.isExecutarComAlcada());

	}

	private void retificarProdutoServicoDadosAtuais(
			EnumMotivoMovimentacao enumMotivoMovimentacao, ServicoPadrao servicoPadrao)
			throws ClassNotFoundException, SQLException
	{

		String mes01 = "-19";
		String mes02 = "-18";

		competencia = DataUtil.getCompetenciaTarifaria(mes01, mes02);

		formMovimentarFaturas.movimentarFaturas(EnumTipoMovimentacao.RETIFICAR,
				enumMotivoMovimentacao, EnumTipoDadosFatura.ATUAL, competencia,
				EnumServico.REFATURAMENTO, servicoPadrao.getValorServico(),
				servicoPadrao.isExecutarComAlcada());

	}

	private void retificarProdutoServicoDadosEpoca(ServicoPadrao servicoPadrao)
			throws ClassNotFoundException, SQLException
	{

		String mes01 = "-19";
		String mes02 = "-18";

		competencia = DataUtil.getCompetenciaTarifaria(mes01, mes02);

		formMovimentarFaturas.movimentarFaturas(EnumTipoMovimentacao.RETIFICAR,
				EnumMotivoMovimentacao.ERRO_LEITURA, EnumTipoDadosFatura.EPOCA,
				competencia, EnumServico.REFATURAMENTO,
				servicoPadrao.getValorServico(), servicoPadrao.isExecutarComAlcada());

	}

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{

		switch (servicoPadrao.getNrCasoTeste())
		{
			case 11:
			//	DriverUtils.iterarTelaPrincipal();

//				MenuPage.menuLiberacao();

				break;

			default:
				break;
		}

	}
}
