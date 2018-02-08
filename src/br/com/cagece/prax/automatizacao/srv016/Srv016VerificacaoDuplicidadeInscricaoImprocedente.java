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

@CasoDeTesteServico(id = "CT02", servico = EnumServico.VERIFICACAO_DUPLICIDADE_INSCRICAO,tipoPgto = EnumTipoPagamento.SEM_CUSTO,
complemento = "IMPROCEDENTE", executarBaixa = true, laudo = EnumTipoLaudo.IMPROCEDENTE)
public class Srv016VerificacaoDuplicidadeInscricaoImprocedente extends ServiceTestBase {

	public Srv016VerificacaoDuplicidadeInscricaoImprocedente() {
		super(Srv016VerificacaoDuplicidadeInscricaoImprocedente.class);
	}
}
