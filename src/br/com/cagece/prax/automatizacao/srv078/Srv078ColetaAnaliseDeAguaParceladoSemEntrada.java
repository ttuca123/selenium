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
@CasoDeTesteServico(id = "CT02", servico = EnumServico.COLETA_ANALISE_AGUA,
tipoPgto =EnumTipoPagamento.PARCELADO_SEM_ENTRADA,executarBaixa = true)
public class Srv078ColetaAnaliseDeAguaParceladoSemEntrada extends ServiceTestBase {

	public Srv078ColetaAnaliseDeAguaParceladoSemEntrada() {
		super(Srv078ColetaAnaliseDeAguaParceladoSemEntrada.class);
	}
}
