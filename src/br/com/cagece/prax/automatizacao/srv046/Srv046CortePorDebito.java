package br.com.cagece.prax.automatizacao.srv046;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
/**
 * 
 * @author 403724
 *
 */
@CasoDeTesteServico(id = "CT01", servico = EnumServico.CORTE_POR_DEBITO, executarBaixa = true)
public class Srv046CortePorDebito extends ServiceTestBase
{

	public Srv046CortePorDebito()
	{
		super(Srv046CortePorDebito.class);
	}
}
