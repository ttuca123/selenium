package br.com.cagece.prax.automatizacao.srv052;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
import enumerators.EnumTipoExecucaoServico;

/**
 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 15/09/2015 -
 *         16:15:06.
 */

@CasoDeTesteServico(id = "CT02", servico = EnumServico.LIGACAO_ESGOTO_PARCERIA, enumTipoServico = EnumTipoExecucaoServico.IMOVEL, tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, executarBaixa = true)
public class Srv052LigacaoEsgotoRamalParceriaParceladoSemEntrada extends
		ServiceTestBase
{

	public Srv052LigacaoEsgotoRamalParceriaParceladoSemEntrada()
	{
		super(Srv052LigacaoEsgotoRamalParceriaParceladoSemEntrada.class);
	}
}
