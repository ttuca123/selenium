package br.com.cagece.prax.automatizacao.srv080;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
/**
 * 
 * @author 403724
 *
 */
@CasoDeTesteServico(id = "CT01", servico = EnumServico.ANALISE_AGUA,
tipoPgto =EnumTipoPagamento.A_VISTA ,executarBaixa = true)
public class Srv080AnaliseDeAguaAvista extends ServiceTestBase {

	public Srv080AnaliseDeAguaAvista() {
		super(Srv080AnaliseDeAguaAvista.class);
	}
}
