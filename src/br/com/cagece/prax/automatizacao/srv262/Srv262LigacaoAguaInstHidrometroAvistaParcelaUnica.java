package br.com.cagece.prax.automatizacao.srv262;

import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;

@CasoDeTesteServico(id = "CT04", servico = EnumServico.LIGACAO_DE_AGUA_PARA_INSTALACAO_DE_HIDROMETRO, tipoPgto = EnumTipoPagamento.A_VISTA_PARCELADO , servicoCasado = EnumServico.REATIVACAO_FATURAMENTO_ESGOTO,  executarBaixa = true)
public class Srv262LigacaoAguaInstHidrometroAvistaParcelaUnica extends
		ServiceTestBase
{

	public Srv262LigacaoAguaInstHidrometroAvistaParcelaUnica()
	{

		super(Srv262LigacaoAguaInstHidrometroAvistaParcelaUnica.class);
	}

}
