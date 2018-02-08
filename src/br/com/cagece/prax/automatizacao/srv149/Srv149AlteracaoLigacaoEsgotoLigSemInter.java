package br.com.cagece.prax.automatizacao.srv149;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT03", servico = EnumServico.ALTERACAO_LIGACAO_DE_ESGOTO, complemento = "LIGADO S/ INTERLIGAÇÃO", executarBaixa=true)
public class Srv149AlteracaoLigacaoEsgotoLigSemInter extends ServiceTestBase {

	public Srv149AlteracaoLigacaoEsgotoLigSemInter() {
		super(Srv149AlteracaoLigacaoEsgotoLigSemInter.class);
	}

}
