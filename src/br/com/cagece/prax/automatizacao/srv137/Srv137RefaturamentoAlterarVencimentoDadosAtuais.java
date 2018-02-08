package br.com.cagece.prax.automatizacao.srv137;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT03", servico = EnumServico.REFATURAMENTO, complemento = "ATUAL ALTERAR VENCIMENTO")
public class Srv137RefaturamentoAlterarVencimentoDadosAtuais extends ServiceTestBase {

	public Srv137RefaturamentoAlterarVencimentoDadosAtuais() {

		super(Srv137RefaturamentoAlterarVencimentoDadosAtuais.class);
	}

}
