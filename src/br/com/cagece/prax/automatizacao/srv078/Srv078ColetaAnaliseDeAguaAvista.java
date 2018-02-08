package br.com.cagece.prax.automatizacao.srv078;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
/**
 * 
 * @author 403724
 *
 */
@CasoDeTesteServico(id = "CT01", servico = EnumServico.COLETA_ANALISE_AGUA,
tipoPgto =EnumTipoPagamento.A_VISTA,executarBaixa = true)
public class Srv078ColetaAnaliseDeAguaAvista extends ServiceTestBase {

	public Srv078ColetaAnaliseDeAguaAvista() {
		super(Srv078ColetaAnaliseDeAguaAvista.class);
	}
}
