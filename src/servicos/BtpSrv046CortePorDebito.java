package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import enumerators.EnumTipoLigacao;
import enumerators.EnumTipoProduto;
import frames.FramePrincipalPage;

public class BtpSrv046CortePorDebito extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaCortar, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMotivoAguaCorte, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);
	}

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{
		FramePrincipalPage.acessarContrato(
				servicoPadrao.getInscOrigem().toString(),
				servicoPadrao.getQtdContratoOrigem());

		servicoPadrao.getValidacao().verificarSituacaoLigacao(
				EnumTipoLigacao.CORTADO, EnumTipoProduto.AGUA);
	}

}