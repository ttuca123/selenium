package br.com.cagece.prax.automatizacao.srv118;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoExecucaoServico;
/**
 * 
 * @author 403724
 *
 */
@CasoDeTesteServico(id = "CT01", servico = EnumServico.LIMPEZA_DO_POCO_DE_VISITA,
executarBaixa = true, enumTipoServico=EnumTipoExecucaoServico.LOGRADOURO)
public class Srv118LimpezaPocoVisita extends ServiceTestBase
{
	
	public Srv118LimpezaPocoVisita()
	{
		super(Srv118LimpezaPocoVisita.class);
	}

}
