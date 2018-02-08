package br.com.cagece.prax.automatizacao.srv188;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumUsuario;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.VERIFICAO_DE_IRREGULARIDADES, complemento = "PROCEDENTE RESID. SOCIAL", laudo = EnumTipoLaudo.PROCEDENTE, executarBaixa = true, usuario = EnumUsuario.ADMINISTRADOR)
public class Srv188VerificacaoIrregularidadeResidencialSocial extends
		ServiceTestBase
{

	public Srv188VerificacaoIrregularidadeResidencialSocial()
	{

		super(Srv188VerificacaoIrregularidadeResidencialSocial.class);
	}

}
