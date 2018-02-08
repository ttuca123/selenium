package br.com.cagece.prax.automatizacao.srv022;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.VERIFICACAO_DE_VALORES_LANCADOS_NA_FATURA, complemento = "IMPROCEDENTE", laudo = EnumTipoLaudo.IMPROCEDENTE, tipoPgto = EnumTipoPagamento.SEM_CUSTO, executarBaixa = true)
public class Srv022VerificacaoValoresLancadosNaFaturaImprocedente extends ServiceTestBase {

	public Srv022VerificacaoValoresLancadosNaFaturaImprocedente() {
		super(Srv022VerificacaoValoresLancadosNaFaturaImprocedente.class);
	}
}