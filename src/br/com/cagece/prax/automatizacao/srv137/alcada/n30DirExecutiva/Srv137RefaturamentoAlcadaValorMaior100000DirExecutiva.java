package br.com.cagece.prax.automatizacao.srv137.alcada.n30DirExecutiva;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumUsuario;

@CasoDeTesteServico(id = "CT11", servico = EnumServico.REFATURAMENTO, valor = 198765.43, usuario=EnumUsuario.ATENDIMENTO_CENTRALIZADO,
executarComAlcada=true)
public class Srv137RefaturamentoAlcadaValorMaior100000DirExecutiva extends ServiceTestBase
{

	public Srv137RefaturamentoAlcadaValorMaior100000DirExecutiva()
	{

		super(Srv137RefaturamentoAlcadaValorMaior100000DirExecutiva.class);

	}
}