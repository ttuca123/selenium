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

@CasoDeTesteServico(id = "CT01", servico = EnumServico.LIGACAO_ESGOTO_PARCERIA, enumTipoServico = EnumTipoExecucaoServico.IMOVEL, tipoPgto = EnumTipoPagamento.A_VISTA, executarBaixa = true)
public class Srv052LigacaoEsgotoRamalParceriaVista extends ServiceTestBase
{

	public Srv052LigacaoEsgotoRamalParceriaVista()
	{
		super(Srv052LigacaoEsgotoRamalParceriaVista.class);
	}
}
