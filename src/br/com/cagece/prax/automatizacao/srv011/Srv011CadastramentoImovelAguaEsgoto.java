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

@CasoDeTesteServico(id = "CT03", servico = EnumServico.CADASTRAMENTO_IMOVEL, complemento = "ÁGUA E ESGOTO", enumTipoServico = EnumTipoExecucaoServico.CLIENTE, tipoPgto = EnumTipoPagamento.SEM_CUSTO, executarBaixa = true)
public class Srv011CadastramentoImovelAguaEsgoto extends ServiceTestBase
{

	public Srv011CadastramentoImovelAguaEsgoto()
	{
		super(Srv011CadastramentoImovelAguaEsgoto.class);
	}
}
