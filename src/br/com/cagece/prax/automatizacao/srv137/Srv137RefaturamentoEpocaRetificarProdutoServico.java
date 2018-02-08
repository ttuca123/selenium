package br.com.cagece.prax.automatizacao.srv137;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.REFATURAMENTO, complemento = "EPOCA RETIFICAR PROD. SERV.")
public class Srv137RefaturamentoEpocaRetificarProdutoServico extends ServiceTestBase {

	public Srv137RefaturamentoEpocaRetificarProdutoServico() {

		super(Srv137RefaturamentoEpocaRetificarProdutoServico.class);
		
	}

}
