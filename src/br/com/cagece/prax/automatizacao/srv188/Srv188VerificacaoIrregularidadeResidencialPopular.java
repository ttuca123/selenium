package br.com.cagece.prax.automatizacao.srv188;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumUsuario;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.VERIFICAO_DE_IRREGULARIDADES, complemento = "PROCEDENTE RESID. POPULAR", laudo = EnumTipoLaudo.PROCEDENTE, executarBaixa = true, usuario = EnumUsuario.ADMINISTRADOR)
public class Srv188VerificacaoIrregularidadeResidencialPopular extends
		ServiceTestBase
{

	public Srv188VerificacaoIrregularidadeResidencialPopular()
	{

		super(Srv188VerificacaoIrregularidadeResidencialPopular.class);
	}

}
