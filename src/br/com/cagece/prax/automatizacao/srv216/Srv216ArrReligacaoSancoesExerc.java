package br.com.cagece.prax.automatizacao.srv216;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
/**
 * 
 * @author 403724
 *
 */

@CasoDeTesteServico(id = "CT01", servico = EnumServico.ARR_RELIGACAO_SANCOES_EXERC, executarBaixa = true)
public class Srv216ArrReligacaoSancoesExerc extends ServiceTestBase
{

	public Srv216ArrReligacaoSancoesExerc()
	{
		super(Srv216ArrReligacaoSancoesExerc.class);
	}

}
