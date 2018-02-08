package br.com.cagece.prax.automatizacao.srv151;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
/**
 * 
 * @author 403724
 *
 */
@CasoDeTesteServico(id = "CT01", servico = EnumServico.AVISO_TAMPONAMENTO, executarBaixa = true)
public class Srv151AvisoDeTamponamento extends ServiceTestBase
{

	public Srv151AvisoDeTamponamento()
	{
		super(Srv151AvisoDeTamponamento.class);
	}

}
