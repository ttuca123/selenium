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
@CasoDeTesteServico(id = "CT01", servico = EnumServico.FISCALIZACAO_SEGURANCA_HIDRICA, tipoPgto = EnumTipoPagamento.SEM_CUSTO, laudo = EnumTipoLaudo.PROCEDENTE, executarBaixa = true)
public class Srv351SegurancaHidricaResidPopular extends ServiceTestBase
{

	public Srv351SegurancaHidricaResidPopular()
	{
		super(Srv351SegurancaHidricaResidPopular.class);
	}
}
