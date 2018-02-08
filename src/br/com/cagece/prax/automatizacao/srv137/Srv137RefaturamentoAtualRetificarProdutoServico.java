package br.com.cagece.prax.automatizacao.srv137;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT05", servico = EnumServico.REFATURAMENTO, complemento = "ATUAL RETIFICAR PROD. SERV.")
public class Srv137RefaturamentoAtualRetificarProdutoServico extends ServiceTestBase {

	public Srv137RefaturamentoAtualRetificarProdutoServico() {

		super(Srv137RefaturamentoAtualRetificarProdutoServico.class);
		
	}

}
