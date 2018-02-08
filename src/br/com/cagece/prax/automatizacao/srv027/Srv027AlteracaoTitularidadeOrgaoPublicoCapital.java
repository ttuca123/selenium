package br.com.cagece.prax.automatizacao.srv027;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumUsuario;

/**
 * Caso de Teste Nº: CT-003-SRV-27 - Mudança de Titularidade de Orgão Público da
 * Capital para outro Órgão público
 * 
 * @author 208396 - EVANDRO CUSTODIO GONCALVES [evandro.custodio@cagece.com.br]
 *         29/08/2015 09:33
 * 
 */

@CasoDeTesteServico(id = "CT03", servico = EnumServico.ALTERACAO_DE_TITULARIDADE, complemento = "ÓRGAO PÚBLICO CAPITAL", usuario = EnumUsuario.ATENDIMENTO_CENTRALIZADO_INTERNO, verificaDebito=true)
public class Srv027AlteracaoTitularidadeOrgaoPublicoCapital extends
		ServiceTestBase {

	public Srv027AlteracaoTitularidadeOrgaoPublicoCapital() {
		super(Srv027AlteracaoTitularidadeOrgaoPublicoCapital.class);
	}

}
