package br.com.cagece.prax.automatizacao.srv313;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT03", servico = EnumServico.DEVOLUCAO_DE_VALORES, complemento = "CRÉDITO FINANCEIRO RECEBIMENTO PENDENTE")
public class Srv313DevolucaoValoresCreditoFinanceiro extends
		ServiceTestBase
{
	public Srv313DevolucaoValoresCreditoFinanceiro()
	{
		super(Srv313DevolucaoValoresCreditoFinanceiro.class);
	}
}
