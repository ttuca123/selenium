package br.com.cagece.prax.automatizacao.srv313;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT04", servico = EnumServico.DEVOLUCAO_DE_VALORES, complemento = "CHEQUE")
public class Srv313DevolucaoValoresCheque extends ServiceTestBase
{
	public Srv313DevolucaoValoresCheque()
	{
		super(Srv313DevolucaoValoresCheque.class);
	}
}
