package br.com.cagece.prax.automatizacao.srv014;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.VERIFICACAO_FONTE_PROPRIA_ABASTECIMENTO, tipoPgto = EnumTipoPagamento.SEM_CUSTO)
public class Srv014VerificacaoFontePropriaAbastecimento extends ServiceTestBase {

	public Srv014VerificacaoFontePropriaAbastecimento() {
		super(Srv014VerificacaoFontePropriaAbastecimento.class);
	}

}
