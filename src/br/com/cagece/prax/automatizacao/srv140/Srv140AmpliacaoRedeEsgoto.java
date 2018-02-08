package br.com.cagece.prax.automatizacao.srv140;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
/**
 * 
 * @author 403724
 *
 */

@CasoDeTesteServico(id = "CT01", servico = EnumServico.AMPLIACAO_REDE_ESGOTO,
tipoPgto = EnumTipoPagamento.A_VISTA,executarBaixa=true)
public class Srv140AmpliacaoRedeEsgoto extends ServiceTestBase {

	public Srv140AmpliacaoRedeEsgoto() {
		super(Srv140AmpliacaoRedeEsgoto.class);
	}

}
