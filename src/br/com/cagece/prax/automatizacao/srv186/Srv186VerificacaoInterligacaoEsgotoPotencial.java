package br.com.cagece.prax.automatizacao.srv186;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT03", servico = EnumServico.INTERLIGACAO_DE_ESGOTO, complemento = "POTENCIAL", tipoPgto = EnumTipoPagamento.SEM_CUSTO, executarBaixa = true)
public class Srv186VerificacaoInterligacaoEsgotoPotencial extends ServiceTestBase {

	public Srv186VerificacaoInterligacaoEsgotoPotencial() {

		super(Srv186VerificacaoInterligacaoEsgotoPotencial.class);
	}

}
