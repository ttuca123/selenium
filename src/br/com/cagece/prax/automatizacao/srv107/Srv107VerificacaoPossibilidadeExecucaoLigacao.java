package br.com.cagece.prax.automatizacao.srv107;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.VERIFICACAO_POSSIB_EXEC_LIGACAO, executarBaixa = true)
public class Srv107VerificacaoPossibilidadeExecucaoLigacao extends ServiceTestBase {

	public Srv107VerificacaoPossibilidadeExecucaoLigacao() {

		super(Srv107VerificacaoPossibilidadeExecucaoLigacao.class);
	}

}
