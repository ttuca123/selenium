package br.com.cagece.prax.automatizacao.srv074;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.CONSERTO_VAZAMENTO_LIGACAO_PREDIAL, complemento = "IMPROCEDENTE", executarBaixa = true, 
laudo = EnumTipoLaudo.IMPROCEDENTE)
public class Srv074ConsertoVazamentoLigacaoPredialImprocedente extends ServiceTestBase {

	public Srv074ConsertoVazamentoLigacaoPredialImprocedente() {
		super(Srv074ConsertoVazamentoLigacaoPredialImprocedente.class);
	}
}
