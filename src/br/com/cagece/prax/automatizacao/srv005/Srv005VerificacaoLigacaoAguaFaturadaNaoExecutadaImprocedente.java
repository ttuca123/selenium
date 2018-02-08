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

@CasoDeTesteServico(id = "CT02", servico = EnumServico.VERIFICACAO_LIGACAO_AGUA_FATURADA_NAO_EXECUTADA,
tipoPgto = EnumTipoPagamento.SEM_CUSTO,complemento = "IMPROCEDENTE", executarBaixa = true, laudo = EnumTipoLaudo.IMPROCEDENTE)
public class Srv005VerificacaoLigacaoAguaFaturadaNaoExecutadaImprocedente extends ServiceTestBase {

	public Srv005VerificacaoLigacaoAguaFaturadaNaoExecutadaImprocedente() {
		super(Srv005VerificacaoLigacaoAguaFaturadaNaoExecutadaImprocedente.class);
	}
}
