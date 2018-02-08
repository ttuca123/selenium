package br.com.cagece.prax.automatizacao.srv257;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT03", servico = EnumServico.PARCELAMENTO_DE_DEBITO, complemento = "SEGUNDO COM ENTRADA E SEM JUROS")
public class Srv257SegundoParcelamentoDebitoComEntradaSemJuros extends
		ServiceTestBase
{

	public Srv257SegundoParcelamentoDebitoComEntradaSemJuros()
	{

		super(Srv257SegundoParcelamentoDebitoComEntradaSemJuros.class);
	}

}
