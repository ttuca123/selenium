package br.com.cagece.prax.automatizacao.srv019;

import anotations.CasoDeTesteServico;
import auxiliares.BaseVars;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT03", servico = EnumServico.TRANSFERENCIA_DE_LIGACAO_DE_AGUA, complemento = BaseVars.PESSOA_FISICA, 
tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, executarBaixa = true)
public class Srv019TransferenciaLigacaoAguaParceladoSemEntradaPF extends
		ServiceTestBase
{

	public Srv019TransferenciaLigacaoAguaParceladoSemEntradaPF()
	{
		super(Srv019TransferenciaLigacaoAguaParceladoSemEntradaPF.class);
	}

}