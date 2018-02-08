package br.com.cagece.prax.automatizacao.srv137;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.REFATURAMENTO, complemento = "EPOCA ALTERAR VENCIMENTO", valor=1000.01)
public class Srv137RefaturamentoAlterarVencimentoDadosEpoca extends ServiceTestBase {

	public Srv137RefaturamentoAlterarVencimentoDadosEpoca() {

		super(Srv137RefaturamentoAlterarVencimentoDadosEpoca.class);
	}

}
