package br.com.cagece.prax.automatizacao.srv337;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.INTERVENCAO_ASFALTICA, executarBaixa = true)
public class Srv337IntervencaoAsfaltica extends ServiceTestBase
{
	public Srv337IntervencaoAsfaltica()
	{
		super(Srv337IntervencaoAsfaltica.class);
	}

}
