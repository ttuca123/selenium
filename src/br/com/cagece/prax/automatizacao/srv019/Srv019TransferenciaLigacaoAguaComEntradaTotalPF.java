package br.com.cagece.prax.automatizacao.srv019;

import anotations.CasoDeTesteServico;
import auxiliares.BaseVars;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

/**
 * 
 * @author Evandro Custódio Gonçalves[evandro.custodio@cagece.com.br] 02/09/2015
 *         - 15:29:34.
 *
 */
@CasoDeTesteServico(id = "CT01", servico = EnumServico.TRANSFERENCIA_DE_LIGACAO_DE_AGUA, complemento = BaseVars.PESSOA_FISICA, tipoPgto = EnumTipoPagamento.A_VISTA, executarBaixa = true)
public class Srv019TransferenciaLigacaoAguaComEntradaTotalPF extends
		ServiceTestBase
{

	public Srv019TransferenciaLigacaoAguaComEntradaTotalPF()
	{
		super(Srv019TransferenciaLigacaoAguaComEntradaTotalPF.class);
	}

}
