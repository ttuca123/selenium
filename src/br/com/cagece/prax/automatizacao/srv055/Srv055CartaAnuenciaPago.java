package br.com.cagece.prax.automatizacao.srv055;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;


@CasoDeTesteServico(id = "CT02", servico = EnumServico.CARTA_ANUENCIA, complemento = "PAGO", tipoPgto = EnumTipoPagamento.SEM_ONUS)
public class Srv055CartaAnuenciaPago extends ServiceTestBase {

	public Srv055CartaAnuenciaPago() {
		super(Srv055CartaAnuenciaPago.class);
	}
}
