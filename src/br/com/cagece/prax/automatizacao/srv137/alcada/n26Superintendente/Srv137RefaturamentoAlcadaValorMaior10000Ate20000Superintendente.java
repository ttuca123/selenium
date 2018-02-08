package br.com.cagece.prax.automatizacao.srv137.alcada.n26Superintendente;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumUsuario;

@CasoDeTesteServico(id = "CT11", servico = EnumServico.REFATURAMENTO, valor = 17345.67, usuario=EnumUsuario.ADMINISTRADOR,
executarComAlcada=true)
public class Srv137RefaturamentoAlcadaValorMaior10000Ate20000Superintendente extends ServiceTestBase
{

	public Srv137RefaturamentoAlcadaValorMaior10000Ate20000Superintendente()
	{

		super(Srv137RefaturamentoAlcadaValorMaior10000Ate20000Superintendente.class);

	}
}