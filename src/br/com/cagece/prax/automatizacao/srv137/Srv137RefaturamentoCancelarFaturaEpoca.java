package br.com.cagece.prax.automatizacao.srv137;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT09", servico = EnumServico.REFATURAMENTO, complemento = "CANCELAR FATURA ÉPOCA")
public class Srv137RefaturamentoCancelarFaturaEpoca extends ServiceTestBase {

	public Srv137RefaturamentoCancelarFaturaEpoca() {

		super(Srv137RefaturamentoCancelarFaturaEpoca.class);
	}

}
