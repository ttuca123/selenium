package br.com.cagece.prax.automatizacao.srv289;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.SUBSTITUICAO_HIDROMETRO_PESQUISA,tipoPgto=EnumTipoPagamento.SEM_CUSTO, executarBaixa = true)
public class Srv289SubstituicaoHidrometroParaPesquisa extends ServiceTestBase {

	public Srv289SubstituicaoHidrometroParaPesquisa() {
		super(Srv289SubstituicaoHidrometroParaPesquisa.class);
	}
}
