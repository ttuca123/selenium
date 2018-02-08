package br.com.cagece.prax.automatizacao.srv070;

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
@CasoDeTesteServico(id = "CT02", servico = EnumServico.VERIFICACAO_DE_HIDROMETRO, tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA,
complemento = "IMPROCEDENTE",laudo = EnumTipoLaudo.IMPROCEDENTE, executarBaixa=true)
public class Srv070VerificacaoHidrometroSemEntradaParceladoImprocedente extends
		ServiceTestBase {

	public Srv070VerificacaoHidrometroSemEntradaParceladoImprocedente() {
		super(Srv070VerificacaoHidrometroSemEntradaParceladoImprocedente.class);
	}
}
