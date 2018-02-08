package br.com.cagece.prax.automatizacao.srv072;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.DESLOCAMENTO_HIDROMETRO_KIT_CAVALETE, 
             tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, executarBaixa=true, itemLAF="063")
public class Srv072DeslocamentoHidrometroKitCavaleteParceladoSemEntrada extends
		ServiceTestBase {

	public Srv072DeslocamentoHidrometroKitCavaleteParceladoSemEntrada() {
		super(Srv072DeslocamentoHidrometroKitCavaleteParceladoSemEntrada.class);
	}
}
