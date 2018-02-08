package br.com.cagece.prax.automatizacao.srv257;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.PARCELAMENTO_DE_DEBITO, complemento = "COM ENTRADA E SEM JUROS")
public class Srv257PrimeiroParcelamentoDebitoComEntradaSemJuros extends
		ServiceTestBase
{

	public Srv257PrimeiroParcelamentoDebitoComEntradaSemJuros()
	{

		super(Srv257PrimeiroParcelamentoDebitoComEntradaSemJuros.class);
	}

}
