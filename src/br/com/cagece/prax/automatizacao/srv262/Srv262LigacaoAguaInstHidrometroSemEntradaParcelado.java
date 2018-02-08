package br.com.cagece.prax.automatizacao.srv262;

import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;

@CasoDeTesteServico(id = "CT03", servico = EnumServico.LIGACAO_DE_AGUA_PARA_INSTALACAO_DE_HIDROMETRO, servicoCasado = EnumServico.REATIVACAO_FATURAMENTO_ESGOTO,
tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, executarBaixa = true)
public class Srv262LigacaoAguaInstHidrometroSemEntradaParcelado extends
		ServiceTestBase
{

	public Srv262LigacaoAguaInstHidrometroSemEntradaParcelado()
	{

		super(Srv262LigacaoAguaInstHidrometroSemEntradaParcelado.class);
	}

}
