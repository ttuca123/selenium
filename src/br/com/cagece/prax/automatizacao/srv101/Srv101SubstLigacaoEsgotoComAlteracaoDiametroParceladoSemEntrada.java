package br.com.cagece.prax.automatizacao.srv101;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.SUBST_LIGACAO_DE_ESGOTO_COM_ALTERACAO_DE_DIAMETRO, tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, executarBaixa = true)
public class Srv101SubstLigacaoEsgotoComAlteracaoDiametroParceladoSemEntrada
		extends ServiceTestBase {
	public Srv101SubstLigacaoEsgotoComAlteracaoDiametroParceladoSemEntrada() {
		super(
				Srv101SubstLigacaoEsgotoComAlteracaoDiametroParceladoSemEntrada.class);
	}

}
