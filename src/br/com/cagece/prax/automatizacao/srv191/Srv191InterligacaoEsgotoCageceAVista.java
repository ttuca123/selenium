package br.com.cagece.prax.automatizacao.srv191;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.INTERLIGACAO_DE_ESGOTO_FINANCIAMENTO_CAGECE, tipoPgto = EnumTipoPagamento.A_VISTA, executarBaixa = true)
public class Srv191InterligacaoEsgotoCageceAVista extends ServiceTestBase
{

	public Srv191InterligacaoEsgotoCageceAVista()
	{

		super(Srv191InterligacaoEsgotoCageceAVista.class);
	}

}
