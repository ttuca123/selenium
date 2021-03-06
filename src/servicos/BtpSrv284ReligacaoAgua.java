package servicos;

import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import enumerators.EnumTipoLigacao;
import enumerators.EnumTipoProduto;
import frames.FramePrincipalPage;

public class BtpSrv284ReligacaoAgua extends ServicoPadrao
{
	@Override
	public void preencherDadosComplementares() throws Exception {
		
		
	
	}

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{
		FramePrincipalPage.acessarContrato(
				servicoPadrao.getInscOrigem().toString(),
				servicoPadrao.getQtdContratoOrigem());

		servicoPadrao.getValidacao().verificarSituacaoLigacao(
				EnumTipoLigacao.LIGADO, EnumTipoProduto.AGUA);

		servicoPadrao.getValidacao().verificarSituacaoLigacao(
				EnumTipoLigacao.LIGADO, EnumTipoProduto.ESGOTO);

	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico)
	{
		DriverUtils.selecionarComboPeloIndice(
				ItemAtendimentoPage.cmbLigacaoAguaReativar, 1);

		DriverUtils.escrever(ItemAtendimentoPage.txtNumeroLacreLigacao,
				NUMERO_LACRE_LIGACAO);

		DriverUtils.escrever(ItemAtendimentoPage.txtLeituraMedidorReativacao,
				LEITURA_MEDIDOR);
	}
}
