package br.com.cagece.prax.automatizacao.srv179;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
/**
 * 
 * @author 403724
 *
 */
/**
 * 
 * @author 403724
 *
 */
@CasoDeTesteServico(id = "CT01", servico = EnumServico.FINANCIAMENTO_BANHEIRO, executarBaixa = true)
public class Srv179FinanciamentoDeBanheiro extends ServiceTestBase
{

	public Srv179FinanciamentoDeBanheiro()
	{
		super(Srv179FinanciamentoDeBanheiro.class);
	}

}
