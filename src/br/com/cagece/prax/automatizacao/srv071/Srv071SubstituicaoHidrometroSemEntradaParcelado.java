package br.com.cagece.prax.automatizacao.srv071;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

/**
 * Caso de Teste Nº: CT-002-SRV-71 - Substituição de Hidrometro MAnutenção
 * 
 * @author 208396 - EVANDRO CUSTODIO GONCALVES [evandro.custodio@cagece.com.br]
 *         22/07/2014 16:19
 * 
 */

@CasoDeTesteServico(id = "CT02", servico = EnumServico.SUBSTITUICAO_DE_HIDROMETRO_MANUTENCAO, 
             tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, executarBaixa = true)
public class Srv071SubstituicaoHidrometroSemEntradaParcelado extends
		ServiceTestBase {

	public Srv071SubstituicaoHidrometroSemEntradaParcelado() {
		super(Srv071SubstituicaoHidrometroSemEntradaParcelado.class);
	}

}
