package servicos;

import enumerators.EnumTipoLigacao;
import enumerators.EnumTipoProduto;
import frames.FramePrincipalPage;

public class BtpSrv152TamponamentoParaLigacaoTamponada extends ServicoPadrao
{

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{

		FramePrincipalPage.acessarContrato(
				servicoPadrao.getInscOrigem().toString(),
				servicoPadrao.getQtdContratoOrigem());

		servicoPadrao.getValidacao().verificarSituacaoLigacao(
				EnumTipoLigacao.TAMPONADO, EnumTipoProduto.ESGOTO);
	}
}
