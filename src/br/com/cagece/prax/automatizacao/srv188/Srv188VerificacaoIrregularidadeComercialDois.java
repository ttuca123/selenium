package br.com.cagece.prax.automatizacao.srv188;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumUsuario;

@CasoDeTesteServico(id = "CT05", servico = EnumServico.VERIFICAO_DE_IRREGULARIDADES, complemento = "PROCEDENTE COMERC. DOIS", laudo = EnumTipoLaudo.PROCEDENTE, executarBaixa = true, usuario = EnumUsuario.ADMINISTRADOR)
public class Srv188VerificacaoIrregularidadeComercialDois extends ServiceTestBase
{

	public Srv188VerificacaoIrregularidadeComercialDois()
	{

		super(Srv188VerificacaoIrregularidadeComercialDois.class);
	}

}
