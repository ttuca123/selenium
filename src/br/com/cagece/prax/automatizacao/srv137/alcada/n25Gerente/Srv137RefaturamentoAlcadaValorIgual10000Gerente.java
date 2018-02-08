package br.com.cagece.prax.automatizacao.srv137.alcada.n25Gerente;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumUsuario;

@CasoDeTesteServico(id = "CT11", servico = EnumServico.REFATURAMENTO, valor = 5675.43, usuario=EnumUsuario.ATENDIMENTO_CENTRALIZADO,
executarComAlcada=true)
public class Srv137RefaturamentoAlcadaValorIgual10000Gerente extends ServiceTestBase
{

	public Srv137RefaturamentoAlcadaValorIgual10000Gerente()
	{

		super(Srv137RefaturamentoAlcadaValorIgual10000Gerente.class);

	}
}