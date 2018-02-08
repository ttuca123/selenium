package br.com.cagece.prax.automatizacao.srv313;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.DEVOLUCAO_DE_VALORES, complemento = "COMPENSAÇÃO DE DÉBITO RECEBIMENTO PENDENTE")
public class Srv313DevolucaoValoresCompensacaoDebito extends
		ServiceTestBase
{
	public Srv313DevolucaoValoresCompensacaoDebito()
	{
		super(Srv313DevolucaoValoresCompensacaoDebito.class);
	}
}
