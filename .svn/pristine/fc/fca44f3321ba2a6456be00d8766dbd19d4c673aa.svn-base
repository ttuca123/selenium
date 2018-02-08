package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import enumerators.EnumTipoLigacao;
import enumerators.EnumTipoProduto;
import frames.FramePrincipalPage;

public class BtpSrv012CortePorInfracao extends ServicoPadrao
{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao)
	{

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaCortar, 1);

		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbMotivoAguaCorte, 1);
	}

	@Override
	public void verificar(ServicoPadrao servicoPadrao)
	{
		

		FramePrincipalPage.acessarContrato(
				servicoPadrao.getInscOrigem().toString(),
				servicoPadrao.getQtdContratoOrigem());

		servicoPadrao.getValidacao().verificarSituacaoLigacao(
				EnumTipoLigacao.CORTADO, EnumTipoProduto.AGUA);
	}

}
