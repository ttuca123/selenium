package br.com.cagece.prax.automatizacao.srv157;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.VERIF_REDUCAO_CONSUMO, tipoPgto = EnumTipoPagamento.SEM_CUSTO, executarBaixa = true)
public class Srv157VerificacaoReducaoConsumo extends ServiceTestBase {

	public Srv157VerificacaoReducaoConsumo() {
		super(Srv157VerificacaoReducaoConsumo.class);
	}

}
