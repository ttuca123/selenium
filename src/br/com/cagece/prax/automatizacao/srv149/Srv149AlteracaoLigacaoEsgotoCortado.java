package br.com.cagece.prax.automatizacao.srv149;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.ALTERACAO_LIGACAO_DE_ESGOTO, complemento = "CORTADO", executarBaixa=true)
public class Srv149AlteracaoLigacaoEsgotoCortado extends ServiceTestBase {

	public Srv149AlteracaoLigacaoEsgotoCortado() {
		super(Srv149AlteracaoLigacaoEsgotoCortado.class);
	}

}
