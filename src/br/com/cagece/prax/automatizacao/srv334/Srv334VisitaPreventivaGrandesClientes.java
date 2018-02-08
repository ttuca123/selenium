package br.com.cagece.prax.automatizacao.srv334;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.ANALISE_PREVENTIVA_GRANDES_CLIENTES, tipoPgto = EnumTipoPagamento.SEM_CUSTO, executarBaixa = true, laudo = EnumTipoLaudo.PROCEDENTE)
public class Srv334VisitaPreventivaGrandesClientes extends ServiceTestBase {

	public Srv334VisitaPreventivaGrandesClientes() {

		super(Srv334VisitaPreventivaGrandesClientes.class);
	}

}
