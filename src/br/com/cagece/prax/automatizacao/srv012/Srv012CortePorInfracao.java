package br.com.cagece.prax.automatizacao.srv012;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumUsuario;

/**
 * Caso de Teste Nº: CT01-SRV-012 - CORTE POR INFRAÇÃO
 * 
 * @author 208396 - EVANDRO CUSTODIO GONCALVES [evandro.custodio@cagece.com.br]
 *         15/10/2014 11:30
 * 
 */
@CasoDeTesteServico(id = "CT01", servico = EnumServico.CORTE_POR_INFRACAO, executarBaixa=true)
public class Srv012CortePorInfracao extends ServiceTestBase {

	public Srv012CortePorInfracao() {
		super(Srv012CortePorInfracao.class);
	}
}
	