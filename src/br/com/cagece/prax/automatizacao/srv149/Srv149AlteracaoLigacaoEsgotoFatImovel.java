package br.com.cagece.prax.automatizacao.srv149;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT05", servico = EnumServico.ALTERACAO_LIGACAO_DE_ESGOTO, complemento = "FATURADO POR OUTRO IMÓVEL", executarBaixa=true)
public class Srv149AlteracaoLigacaoEsgotoFatImovel extends ServiceTestBase {

	public Srv149AlteracaoLigacaoEsgotoFatImovel() {
		super(Srv149AlteracaoLigacaoEsgotoFatImovel.class);
	}

}
