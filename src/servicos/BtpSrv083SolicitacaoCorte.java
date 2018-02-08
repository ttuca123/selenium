package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import enumerators.EnumTipoLigacao;
import enumerators.EnumTipoProduto;
import frames.FramePrincipalPage;

public class BtpSrv083SolicitacaoCorte extends ServicoPadrao
{

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{
		FramePrincipalPage.acessarContrato(servicoPadrao.getInscOrigem().toString(), servicoPadrao.getQtdContratoOrigem());

		servicoPadrao.getValidacao().verificarSituacaoLigacao(
				EnumTipoLigacao.CORTADO, EnumTipoProduto.AGUA);

		servicoPadrao.getValidacao().verificarSituacaoLigacao(
				EnumTipoLigacao.SUSPENSO, EnumTipoProduto.ESGOTO);

	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico)
	{
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaCortar, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMotivoAguaCorte, 1);

	}

}
