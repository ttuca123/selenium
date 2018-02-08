package br.com.cagece.prax.automatizacao.srv260;

import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;

@CasoDeTesteServico(id = "CT03", servico = EnumServico.LIGACAO_DE_AGUA_PARA_INSTALACAO_DE_HIDROMETRO_PARA_SUPRIMIDA, tipoPgto = EnumTipoPagamento.A_VISTA, tipoPgtoServCasado = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, executarBaixa = true)
public class Srv260LigacaoAguaInstHidrometroSuprimidaComEntradaTotal extends
		ServiceTestBase
{

	public Srv260LigacaoAguaInstHidrometroSuprimidaComEntradaTotal()
	{

		super(Srv260LigacaoAguaInstHidrometroSuprimidaComEntradaTotal.class);
	}

}
