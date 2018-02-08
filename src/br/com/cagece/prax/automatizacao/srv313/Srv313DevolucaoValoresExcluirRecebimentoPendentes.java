package br.com.cagece.prax.automatizacao.srv313;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.DEVOLUCAO_DE_VALORES, complemento = "EXCLUIR RECEBIMENTO PENDENTE")
public class Srv313DevolucaoValoresExcluirRecebimentoPendentes extends
		ServiceTestBase
{
	public Srv313DevolucaoValoresExcluirRecebimentoPendentes()
	{
		super(Srv313DevolucaoValoresExcluirRecebimentoPendentes.class);
	}
}
