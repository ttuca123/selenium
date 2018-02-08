package br.com.cagece.prax.automatizacao.srv260;

import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;

@CasoDeTesteServico(id = "CT04", servico = EnumServico.LIGACAO_DE_AGUA_PARA_INSTALACAO_DE_HIDROMETRO_PARA_SUPRIMIDA, 
tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, executarBaixa = true)
public class Srv260LigacaoAguaInstHidrometroSuprimidaSemEntradaParcelado extends
		ServiceTestBase
{

	public Srv260LigacaoAguaInstHidrometroSuprimidaSemEntradaParcelado()
	{

		super(Srv260LigacaoAguaInstHidrometroSuprimidaSemEntradaParcelado.class);
	}
	
}
