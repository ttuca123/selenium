package br.com.cagece.prax.automatizacao.srv257;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT07", servico = EnumServico.PARCELAMENTO_DE_DEBITO, complemento = "SEGUNDO COM ENTRADA E COM JUROS")
public class Srv257SegundoParcelamentoDebitoComEntradaComJuros extends
		ServiceTestBase
{

	public Srv257SegundoParcelamentoDebitoComEntradaComJuros()
	{

		super(Srv257SegundoParcelamentoDebitoComEntradaComJuros.class);
	}

}
