package br.com.cagece.prax.automatizacao.srv111;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.SELAGEM_DE_HIDROMETRO, executarBaixa = true)
public class Srv111SelagemHidrometro extends ServiceTestBase
{

	public Srv111SelagemHidrometro()
	{

		super(Srv111SelagemHidrometro.class);
	}

}
