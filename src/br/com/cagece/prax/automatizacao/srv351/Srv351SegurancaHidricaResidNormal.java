package br.com.cagece.prax.automatizacao.srv351;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPagamento;

/**
 * 
 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 27/09/2015 -
 *         13:59:38.
 *
 */
@CasoDeTesteServico(id = "CT03", servico = EnumServico.FISCALIZACAO_SEGURANCA_HIDRICA, laudo = EnumTipoLaudo.PROCEDENTE, tipoPgto = EnumTipoPagamento.SEM_CUSTO, executarBaixa = true)
public class Srv351SegurancaHidricaResidNormal extends ServiceTestBase
{

	public Srv351SegurancaHidricaResidNormal()
	{
		super(Srv351SegurancaHidricaResidNormal.class);
	}
}
