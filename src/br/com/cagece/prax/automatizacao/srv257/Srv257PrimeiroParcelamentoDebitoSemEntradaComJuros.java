package br.com.cagece.prax.automatizacao.srv257;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT05", servico = EnumServico.PARCELAMENTO_DE_DEBITO, complemento = "SEM ENTRADA E COM JUROS")
public class Srv257PrimeiroParcelamentoDebitoSemEntradaComJuros extends
		ServiceTestBase
{

	public Srv257PrimeiroParcelamentoDebitoSemEntradaComJuros()
	{

		super(Srv257PrimeiroParcelamentoDebitoSemEntradaComJuros.class);
	}

}
