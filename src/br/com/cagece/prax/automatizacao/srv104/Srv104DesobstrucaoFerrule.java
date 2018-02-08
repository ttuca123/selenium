package br.com.cagece.prax.automatizacao.srv104;

import enumerators.EnumServico;
import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;

@CasoDeTesteServico(id="CT01",servico=EnumServico.DESOBSTRUCAO_DE_FERRULE, executarBaixa=true)
public class Srv104DesobstrucaoFerrule extends ServiceTestBase {

	public Srv104DesobstrucaoFerrule() {
		
	   super(Srv104DesobstrucaoFerrule.class);
	}
	
}
