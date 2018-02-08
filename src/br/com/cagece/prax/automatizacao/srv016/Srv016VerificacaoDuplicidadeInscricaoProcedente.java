package br.com.cagece.prax.automatizacao.srv016;

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

@CasoDeTesteServico(id = "CT01", servico = EnumServico.VERIFICACAO_DUPLICIDADE_INSCRICAO,tipoPgto = EnumTipoPagamento.SEM_CUSTO,
complemento = "PROCEDENTE", executarBaixa = true, laudo = EnumTipoLaudo.PROCEDENTE)
public class Srv016VerificacaoDuplicidadeInscricaoProcedente extends ServiceTestBase {

	public Srv016VerificacaoDuplicidadeInscricaoProcedente() {
		super(Srv016VerificacaoDuplicidadeInscricaoProcedente.class);
	}
}
