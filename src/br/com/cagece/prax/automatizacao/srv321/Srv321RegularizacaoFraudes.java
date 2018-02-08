package br.com.cagece.prax.automatizacao.srv321;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

/**
 * 
 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 27/09/2015 -
 *         13:59:38.
 *
 */
@CasoDeTesteServico(id = "CT01", servico = EnumServico.REGULARIZACAO_DE_FRAUDE, tipoPgto = EnumTipoPagamento.A_VISTA)
public class Srv321RegularizacaoFraudes extends ServiceTestBase
{

	public Srv321RegularizacaoFraudes()
	{
		super(Srv321RegularizacaoFraudes.class);
	}
}
