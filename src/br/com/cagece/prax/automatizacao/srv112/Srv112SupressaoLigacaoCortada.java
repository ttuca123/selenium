package br.com.cagece.prax.automatizacao.srv112;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.SUPRESSAO_LIGACAO_CORTADA,tipoPgto=EnumTipoPagamento.SEM_CUSTO, executarBaixa = true)
public class Srv112SupressaoLigacaoCortada extends ServiceTestBase
{

	public Srv112SupressaoLigacaoCortada()
	{

		super(Srv112SupressaoLigacaoCortada.class);
	}

}
