package br.com.cagece.prax.automatizacao.srv190;

import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;

@CasoDeTesteServico(id="CT01",servico=EnumServico.LIGACAO_ESGOTO_FINANCIAMENTO_CAGECE, tipoPgto = EnumTipoPagamento.A_VISTA, executarBaixa=true)
public class Srv190LigacaoEsgotoFinancCageceComEntradaTotal extends ServiceTestBase {

	public Srv190LigacaoEsgotoFinancCageceComEntradaTotal() {
		
	   super(Srv190LigacaoEsgotoFinancCageceComEntradaTotal.class);
	}
	
}
