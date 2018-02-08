package br.com.cagece.prax.automatizacao.srv188;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumUsuario;

@CasoDeTesteServico(id = "CT03", servico = EnumServico.VERIFICAO_DE_IRREGULARIDADES, complemento = "PROCEDENTE RESID. NORMAL", laudo = EnumTipoLaudo.PROCEDENTE, executarBaixa = true, usuario = EnumUsuario.ADMINISTRADOR)
public class Srv188VerificacaoIrregularidadeResidencialNormal extends
		ServiceTestBase
{

	public Srv188VerificacaoIrregularidadeResidencialNormal()
	{

		super(Srv188VerificacaoIrregularidadeResidencialNormal.class);
	}

}
