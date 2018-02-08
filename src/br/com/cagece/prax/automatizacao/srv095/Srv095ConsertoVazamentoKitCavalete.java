package br.com.cagece.prax.automatizacao.srv095;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.CONSERTO_VAZAMENTO_KIT_CAVALETE, tipoPgto = EnumTipoPagamento.SEM_CUSTO, executarBaixa = true)
public class Srv095ConsertoVazamentoKitCavalete extends ServiceTestBase {

	public Srv095ConsertoVazamentoKitCavalete() {
		super(Srv095ConsertoVazamentoKitCavalete.class);
	}
}
