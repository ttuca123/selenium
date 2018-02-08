package servicos;

import java.util.List;

import pages.AtendimentoPage;
import pages.ItemAtendimentoPage;
import auxiliares.ConnectJDBC;
import auxiliares.DriverUtils;
import enumerators.EnumTipoServicoSolicitado;
import frames.FramePesquisaLogradouroPage;

public class BtpSrv011CadastramentoImovel extends ServicoPadrao
{

	@Override
	public void preencherDadosComplementares(ServicoPadrao servico)
	{

		FramePesquisaLogradouroPage.consultarEndereco();

		AtendimentoPage.preencherNumeroImovel();

		switch (servico.getNrCasoTeste())
		{
			case 1:

				AtendimentoPage
						.preencherServicoSolicitado(EnumTipoServicoSolicitado.CADASTRO);

				break;
			case 2:
				AtendimentoPage
						.preencherServicoSolicitado(EnumTipoServicoSolicitado.CADASTRO_AGUA);
				break;
			case 3:
				AtendimentoPage
						.preencherServicoSolicitado(EnumTipoServicoSolicitado.CADASTRO_AGUA_ESGOTO);
				break;
			case 4:
				AtendimentoPage
						.preencherServicoSolicitado(EnumTipoServicoSolicitado.CADASTRO_LIGAÇÃO_ESGOTO);
				break;

			default:
				break;
		}

	}

	@Override
	public void executarIntegracao()
	{

		AtendimentoPage.aceitarDebitosAdvertencia();

	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao) throws Exception
	{

		List<String> inscricoes = ConnectJDBC.gerarInscricao(servicoPadrao);

		servicoPadrao.setInscOrigem(inscricoes.get(0));

		servicoPadrao.setQtdContratoOrigem(ConnectJDBC
				.verificarQtdContratos(inscricoes.get(0).toString()));

		DriverUtils.escrever(ItemAtendimentoPage.txtNovaInscricao, servicoPadrao
				.getInscOrigem().toString());

		preencheLaudo(servicoPadrao.getLaudo());

	}
}
