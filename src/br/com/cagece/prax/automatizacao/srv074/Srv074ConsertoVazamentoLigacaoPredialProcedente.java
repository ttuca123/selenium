package br.com.cagece.prax.automatizacao.srv074;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.CONSERTO_VAZAMENTO_LIGACAO_PREDIAL, 
             complemento = "PROCEDENTE", executarBaixa = true, laudo = EnumTipoLaudo.PROCEDENTE)
public class Srv074ConsertoVazamentoLigacaoPredialProcedente extends ServiceTestBase {

	public Srv074ConsertoVazamentoLigacaoPredialProcedente() {
		super(Srv074ConsertoVazamentoLigacaoPredialProcedente.class);
	}
}
