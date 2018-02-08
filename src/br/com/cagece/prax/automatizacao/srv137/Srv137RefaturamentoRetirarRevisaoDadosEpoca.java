	package br.com.cagece.prax.automatizacao.srv137;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT08", servico = EnumServico.REFATURAMENTO, complemento = "EPOCA RETIRAR DE REVISÃO")
public class Srv137RefaturamentoRetirarRevisaoDadosEpoca extends ServiceTestBase {

	public Srv137RefaturamentoRetirarRevisaoDadosEpoca() {

		super(Srv137RefaturamentoRetirarRevisaoDadosEpoca.class);
	}

}
