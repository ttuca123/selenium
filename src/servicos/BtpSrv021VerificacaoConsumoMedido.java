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
import enumerators.EnumTipoMovimentacao;
import enumerators.EnumTipoPagamento;
import frames.FrameMovimentarFaturas;

public class BtpSrv021VerificacaoConsumoMedido extends ServicoPadrao
{
	String competencia;

	FrameMovimentarFaturas formMovimentarFaturas;

	@Override
	public void executarIntegracao(ServicoPadrao servicoPadrao) throws Exception
	{

		if ( servicoPadrao.isMovimentaFatura() )
		{

			AtendimentoPage.movimentarIntegracao();

			formMovimentarFaturas = FrameMovimentarFaturas
					.getFrameMovimentarFaturaPage();

			revisarDadosEpoca();
		}
	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{
		DriverUtils.escrever(ItemAtendimentoPage.cmbLeituraInformadaFiscal,
				LEITURA_MEDIDOR);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbVazamentoOculto, 1);

		preencheLaudo(servicoPadrao.getLaudo());

		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:
				servicoPadrao.getTiposPgtos().clear();

				servicoPadrao.getTiposPgtos().add(EnumTipoPagamento.SEM_CUSTO);

				break;

			default:
				break;
		}

	}

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{

		DriverUtils.iterarTelaPrincipal();

		DriverUtils.clicar(MenuPage.menu);

		DriverUtils.clicar(MenuPage.menuAtendimento);

		DriverUtils.clicar(MenuPage.menu);

	}

	private void revisarDadosEpoca() throws ClassNotFoundException, SQLException
	{
		String mes01 = "-25";
		String mes02 = "-24";

		competencia = DataUtil.getCompetenciaTarifaria(mes01, mes02);

		formMovimentarFaturas.movimentarFaturas(
				EnumTipoMovimentacao.COLOCAR_EM_REVISAO,
				EnumMotivoMovimentacao.ERRO_LEITURA, EnumTipoDadosFatura.EPOCA,
				competencia, EnumServico.VERIFICACAO_CONSUMO_MEDIDO, 0d, false);

	}

}
