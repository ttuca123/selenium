package br.com.cagece.prax.automatizacao.srv086;

import enumerators.EnumServico;
import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;

@CasoDeTesteServico(id="CT01", servico=EnumServico.CONSERTO_NA_CAIXA_DO_HIDROMETRO, executarBaixa = true)
public class Srv086ConsertoCaixaHidrometro extends ServiceTestBase {

	public Srv086ConsertoCaixaHidrometro() {
		super(Srv086ConsertoCaixaHidrometro.class);
	}

}
