package br.com.cagece.prax.automatizacao.srv011;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
import enumerators.EnumTipoExecucaoServico;

/**
 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 15/09/2015 -
 *         16:15:06.
 */

@CasoDeTesteServico(id = "CT01", servico = EnumServico.CADASTRAMENTO_IMOVEL, enumTipoServico = EnumTipoExecucaoServico.CLIENTE, tipoPgto = EnumTipoPagamento.SEM_CUSTO, executarBaixa = true)
public class Srv011CadastramentoImovel extends ServiceTestBase
{

	public Srv011CadastramentoImovel()
	{
		super(Srv011CadastramentoImovel.class);
	}
}
