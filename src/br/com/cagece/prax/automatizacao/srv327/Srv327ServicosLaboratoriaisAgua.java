package br.com.cagece.prax.automatizacao.srv327;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
import enumerators.EnumTipoExecucaoServico;
/**
 * 
 * @author 403724
 *
 */
@CasoDeTesteServico(id = "CT01", servico = EnumServico.SERVICOS_LABORATORIAIS_AGUA, enumTipoServico=EnumTipoExecucaoServico.CLIENTE,tipoPgto= EnumTipoPagamento.SEM_ONUS)
public class Srv327ServicosLaboratoriaisAgua extends ServiceTestBase
{

	public Srv327ServicosLaboratoriaisAgua()
	{
		super(Srv327ServicosLaboratoriaisAgua.class);
	}
}
