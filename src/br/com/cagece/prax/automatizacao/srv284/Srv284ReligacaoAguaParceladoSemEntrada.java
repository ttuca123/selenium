package br.com.cagece.prax.automatizacao.srv284;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.RELIGACAO_URGENTE_DE_AGUA, tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, executarBaixa = true, servicoCasado = EnumServico.REATIVACAO_FATURAMENTO_ESGOTO)
public class Srv284ReligacaoAguaParceladoSemEntrada extends ServiceTestBase {

	public Srv284ReligacaoAguaParceladoSemEntrada() {
		super(Srv284ReligacaoAguaParceladoSemEntrada.class);
	}

}
