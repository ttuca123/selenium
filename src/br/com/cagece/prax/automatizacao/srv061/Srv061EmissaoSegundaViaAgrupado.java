package br.com.cagece.prax.automatizacao.srv061;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.SEGUNDA_VIA, complemento = "AGRUPADO", tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA)
public class Srv061EmissaoSegundaViaAgrupado extends ServiceTestBase {

	public Srv061EmissaoSegundaViaAgrupado() {
		super(Srv061EmissaoSegundaViaAgrupado.class);
	}

}
