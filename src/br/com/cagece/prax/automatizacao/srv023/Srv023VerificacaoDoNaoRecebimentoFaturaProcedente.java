package br.com.cagece.prax.automatizacao.srv023;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.VERIFICACAO_DO_NAO_RECEBIMENTO_FATURA, tipoPgto = EnumTipoPagamento.SEM_CUSTO, complemento = "PROCEDENTE", laudo = EnumTipoLaudo.PROCEDENTE, executarBaixa = true)
public class Srv023VerificacaoDoNaoRecebimentoFaturaProcedente extends ServiceTestBase {

	public Srv023VerificacaoDoNaoRecebimentoFaturaProcedente() {
		super(Srv023VerificacaoDoNaoRecebimentoFaturaProcedente.class);
	}
}