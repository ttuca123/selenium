package br.com.cagece.prax.automatizacao.srv167;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

/**
 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 15/09/2015 -
 *         16:15:06.
 */

@CasoDeTesteServico(id = "CT01", servico = EnumServico.RECEBIMENTO_ANTECIPADO, complemento = "ÁGUA", tipoPgto = EnumTipoPagamento.SEM_ONUS)
public class Srv167RecebimentoAntecipadoAgua extends ServiceTestBase
{

	public Srv167RecebimentoAntecipadoAgua()
	{
		super(Srv167RecebimentoAntecipadoAgua.class);
	}
}
