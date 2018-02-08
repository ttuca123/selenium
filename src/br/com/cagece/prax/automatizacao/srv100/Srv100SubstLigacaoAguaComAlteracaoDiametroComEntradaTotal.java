package br.com.cagece.prax.automatizacao.srv100;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.SUBST_LIGACAO_DE_AGUA_COM_ALTERACAO_DE_DIAMETRO, 
tipoPgto = EnumTipoPagamento.A_VISTA, executarBaixa = true)
public class Srv100SubstLigacaoAguaComAlteracaoDiametroComEntradaTotal extends
		ServiceTestBase {

	public Srv100SubstLigacaoAguaComAlteracaoDiametroComEntradaTotal() {
		super(Srv100SubstLigacaoAguaComAlteracaoDiametroComEntradaTotal.class);
	}

}
