package br.com.cagece.prax.automatizacao.srv217;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
/**
 * 
 * @author 403724
 *
 */

@CasoDeTesteServico(id = "CT01", servico = EnumServico.ARR_SERV_HIDROM_EXERC, executarBaixa = true)
public class Srv217ArrServicoHidrometroExerc extends ServiceTestBase
{

	public Srv217ArrServicoHidrometroExerc()
	{
		super(Srv217ArrServicoHidrometroExerc.class);
	}

}
