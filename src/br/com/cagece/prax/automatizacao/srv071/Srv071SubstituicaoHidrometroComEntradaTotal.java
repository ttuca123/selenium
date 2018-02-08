package br.com.cagece.prax.automatizacao.srv071;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

/**
 * Caso de Teste Nº: CT-001-SRV-71 - Substituição de Hidrômetro - Manutenção
 * 
 * @author 208396 - EVANDRO CUSTODIO GONCALVES [evandro.custodio@cagece.com.br]
 *         22/07/2014 16:07
 * 
 */

@CasoDeTesteServico(id = "CT01", servico = EnumServico.SUBSTITUICAO_DE_HIDROMETRO_MANUTENCAO, 
			 tipoPgto = EnumTipoPagamento.A_VISTA, executarBaixa = true)
public class Srv071SubstituicaoHidrometroComEntradaTotal extends ServiceTestBase {

	public Srv071SubstituicaoHidrometroComEntradaTotal() {
		super(Srv071SubstituicaoHidrometroComEntradaTotal.class);
	}	
}
