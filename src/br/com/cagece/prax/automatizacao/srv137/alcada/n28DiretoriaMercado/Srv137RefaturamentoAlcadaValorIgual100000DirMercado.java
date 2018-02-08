package br.com.cagece.prax.automatizacao.srv137.alcada.n28DiretoriaMercado;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumUsuario;

@CasoDeTesteServico(id = "CT11", servico = EnumServico.REFATURAMENTO, valor = 100000.00, usuario=EnumUsuario.ATENDIMENTO_CENTRALIZADO,
executarComAlcada=true)
public class Srv137RefaturamentoAlcadaValorIgual100000DirMercado extends ServiceTestBase
{

	public Srv137RefaturamentoAlcadaValorIgual100000DirMercado()
	{

		super(Srv137RefaturamentoAlcadaValorIgual100000DirMercado.class);

	}
}