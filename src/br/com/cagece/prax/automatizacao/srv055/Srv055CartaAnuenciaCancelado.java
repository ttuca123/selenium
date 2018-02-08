package br.com.cagece.prax.automatizacao.srv055;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.CARTA_ANUENCIA, complemento = "CANCELADO", tipoPgto = EnumTipoPagamento.SEM_ONUS)
public class Srv055CartaAnuenciaCancelado extends ServiceTestBase {

	public Srv055CartaAnuenciaCancelado() {
		super(Srv055CartaAnuenciaCancelado.class);
	}
}
