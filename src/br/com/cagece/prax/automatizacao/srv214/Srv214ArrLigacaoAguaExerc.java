package br.com.cagece.prax.automatizacao.srv214;

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
@CasoDeTesteServico(id = "CT01", servico = EnumServico.ARR_LIGACAO_AGUA_EXERC, executarBaixa = true)
public class Srv214ArrLigacaoAguaExerc extends ServiceTestBase
{

	public Srv214ArrLigacaoAguaExerc()
	{
		super(Srv214ArrLigacaoAguaExerc.class);
	}

}
