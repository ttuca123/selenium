package br.com.cagece.prax.automatizacao.srv005;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPagamento;
/**
 * 
 * @author 403724
 *
 */

@CasoDeTesteServico(id = "CT01", servico = EnumServico.VERIFICACAO_LIGACAO_AGUA_FATURADA_NAO_EXECUTADA,
tipoPgto = EnumTipoPagamento.SEM_CUSTO, complemento = "PROCEDENTE", executarBaixa = true, laudo = EnumTipoLaudo.PROCEDENTE)
public class Srv005VerificacaoLigacaoAguaFaturadaNaoExecutadaProcedente extends ServiceTestBase {

	public Srv005VerificacaoLigacaoAguaFaturadaNaoExecutadaProcedente() {
		super(Srv005VerificacaoLigacaoAguaFaturadaNaoExecutadaProcedente.class);
	}
}
