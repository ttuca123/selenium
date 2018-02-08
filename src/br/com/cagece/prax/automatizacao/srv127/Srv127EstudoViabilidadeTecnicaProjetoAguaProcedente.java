package br.com.cagece.prax.automatizacao.srv127;

import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPagamento;
import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
/**
 * 
 * @author 403724
 *
 */
@CasoDeTesteServico(id = "CT01", servico = EnumServico.ESTUDO_VIABILIDADE_TECNICA_PROJETO_AGUA,
tipoPgto = EnumTipoPagamento.A_VISTA,complemento = "PROCEDENTE",laudo = EnumTipoLaudo.PROCEDENTE,
servicoCasado = EnumServico.MEDICAO_PRESSAO_REDE_AGUA,tipoPgtoServCasado = EnumTipoPagamento.A_VISTA,executarBaixa=true)

public class Srv127EstudoViabilidadeTecnicaProjetoAguaProcedente extends
		ServiceTestBase
{

	public Srv127EstudoViabilidadeTecnicaProjetoAguaProcedente()
	{

		super(Srv127EstudoViabilidadeTecnicaProjetoAguaProcedente.class);
	}

}
