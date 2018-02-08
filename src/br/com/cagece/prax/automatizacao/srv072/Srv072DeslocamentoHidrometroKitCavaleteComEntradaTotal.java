package br.com.cagece.prax.automatizacao.srv072;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.DESLOCAMENTO_HIDROMETRO_KIT_CAVALETE, 
             tipoPgto = EnumTipoPagamento.A_VISTA, executarBaixa = true, itemLAF="063")
public class Srv072DeslocamentoHidrometroKitCavaleteComEntradaTotal extends
		ServiceTestBase {

	public Srv072DeslocamentoHidrometroKitCavaleteComEntradaTotal() {
		super(Srv072DeslocamentoHidrometroKitCavaleteComEntradaTotal.class);
	}
}
