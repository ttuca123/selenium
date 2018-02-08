package br.com.cagece.prax.automatizacao.srv100;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT03", servico = EnumServico.SUBST_LIGACAO_DE_AGUA_COM_ALTERACAO_DE_DIAMETRO, 
			 tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, executarBaixa = true)
public class Srv100SubstLigacaoAguaComAlteracaoDiametroParceladoSemEntrada
		extends ServiceTestBase {

	public Srv100SubstLigacaoAguaComAlteracaoDiametroParceladoSemEntrada() {
		super(
				Srv100SubstLigacaoAguaComAlteracaoDiametroParceladoSemEntrada.class);
	}

}
