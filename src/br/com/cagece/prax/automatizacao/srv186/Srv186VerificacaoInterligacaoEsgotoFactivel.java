package br.com.cagece.prax.automatizacao.srv186;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.INTERLIGACAO_DE_ESGOTO, complemento = "FACTÍVEL", executarBaixa = true)
public class Srv186VerificacaoInterligacaoEsgotoFactivel extends ServiceTestBase
{

	public Srv186VerificacaoInterligacaoEsgotoFactivel()
	{

		super(Srv186VerificacaoInterligacaoEsgotoFactivel.class);
	}

}
