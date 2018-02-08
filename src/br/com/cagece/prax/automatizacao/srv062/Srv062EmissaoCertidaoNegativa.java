package br.com.cagece.prax.automatizacao.srv062;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.CERTIDAO_NEGATIVA,  tipoPgto = EnumTipoPagamento.A_VISTA)
public class Srv062EmissaoCertidaoNegativa extends ServiceTestBase {

	public Srv062EmissaoCertidaoNegativa() {
		super(Srv062EmissaoCertidaoNegativa.class);
	}

}
