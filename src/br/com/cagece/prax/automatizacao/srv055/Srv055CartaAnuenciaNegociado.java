package br.com.cagece.prax.automatizacao.srv055;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;


@CasoDeTesteServico(id = "CT03", servico = EnumServico.CARTA_ANUENCIA, complemento = "NEGOCIADO", tipoPgto = EnumTipoPagamento.SEM_ONUS)
public class Srv055CartaAnuenciaNegociado extends ServiceTestBase {

	public Srv055CartaAnuenciaNegociado() {
		super(Srv055CartaAnuenciaNegociado.class);
	}
}
