package br.com.cagece.prax.automatizacao.srv090;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.SUBSTITUICAO_KIT_CAVALETE,
tipoPgto = EnumTipoPagamento.SEM_CUSTO, executarBaixa=true)
public class Srv090SubstituicaoKitCavalete extends ServiceTestBase {

	public Srv090SubstituicaoKitCavalete() {
		super(Srv090SubstituicaoKitCavalete.class);
	}
}
