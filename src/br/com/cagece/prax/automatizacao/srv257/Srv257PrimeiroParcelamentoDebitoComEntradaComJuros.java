package br.com.cagece.prax.automatizacao.srv257;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT06", servico = EnumServico.PARCELAMENTO_DE_DEBITO, complemento = "COM ENTRADA E COM JUROS")
public class Srv257PrimeiroParcelamentoDebitoComEntradaComJuros extends
		ServiceTestBase
{

	public Srv257PrimeiroParcelamentoDebitoComEntradaComJuros()
	{

		super(Srv257PrimeiroParcelamentoDebitoComEntradaComJuros.class);
	}

}
