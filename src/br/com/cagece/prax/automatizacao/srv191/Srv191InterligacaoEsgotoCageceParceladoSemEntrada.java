package br.com.cagece.prax.automatizacao.srv191;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.INTERLIGACAO_DE_ESGOTO_FINANCIAMENTO_CAGECE, tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, executarBaixa = true)
public class Srv191InterligacaoEsgotoCageceParceladoSemEntrada extends ServiceTestBase
{

	public Srv191InterligacaoEsgotoCageceParceladoSemEntrada()
	{

		super(Srv191InterligacaoEsgotoCageceParceladoSemEntrada.class);
	}

}
