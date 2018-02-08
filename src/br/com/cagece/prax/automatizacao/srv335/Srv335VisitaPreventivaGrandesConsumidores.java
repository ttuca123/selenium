package br.com.cagece.prax.automatizacao.srv335;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.ANALISE_PREVENTIVA_GRANDES_CONSUMIDORES, tipoPgto = EnumTipoPagamento.SEM_CUSTO, executarBaixa = true, laudo = EnumTipoLaudo.PROCEDENTE)
public class Srv335VisitaPreventivaGrandesConsumidores extends ServiceTestBase {

	public Srv335VisitaPreventivaGrandesConsumidores() {

		super(Srv335VisitaPreventivaGrandesConsumidores.class);
	}

}
