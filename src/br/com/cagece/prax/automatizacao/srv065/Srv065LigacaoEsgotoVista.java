package br.com.cagece.prax.automatizacao.srv065;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
import enumerators.EnumTipoExecucaoServico;

/**
 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 15/09/2015 -
 *         16:15:06.
 */

@CasoDeTesteServico(id = "CT01", servico = EnumServico.LIGACAO_ESGOTO, enumTipoServico = EnumTipoExecucaoServico.IMOVEL, tipoPgto = EnumTipoPagamento.A_VISTA, executarBaixa = true)
public class Srv065LigacaoEsgotoVista extends
		ServiceTestBase
{

	public Srv065LigacaoEsgotoVista()
	{
		super(Srv065LigacaoEsgotoVista.class);
	}
}
