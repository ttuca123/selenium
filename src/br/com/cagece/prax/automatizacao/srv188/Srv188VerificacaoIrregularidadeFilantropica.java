package br.com.cagece.prax.automatizacao.srv188;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumUsuario;

@CasoDeTesteServico(id = "CT08", servico = EnumServico.VERIFICAO_DE_IRREGULARIDADES, complemento = "PROCEDENTE FILANTROPICA", laudo = EnumTipoLaudo.PROCEDENTE, executarBaixa = true, usuario = EnumUsuario.ADMINISTRADOR)
public class Srv188VerificacaoIrregularidadeFilantropica extends ServiceTestBase
{

	public Srv188VerificacaoIrregularidadeFilantropica()
	{

		super(Srv188VerificacaoIrregularidadeFilantropica.class);
	}

}
