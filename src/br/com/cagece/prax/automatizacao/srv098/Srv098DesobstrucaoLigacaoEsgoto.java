package br.com.cagece.prax.automatizacao.srv098;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.DESOBSTRUCAO_LIGACAO_ESGOTO, 
tipoPgto = EnumTipoPagamento.SEM_CUSTO, executarBaixa = true, laudo=EnumTipoLaudo.PROCEDENTE)
public class Srv098DesobstrucaoLigacaoEsgoto extends ServiceTestBase {

	public Srv098DesobstrucaoLigacaoEsgoto() {
		super(Srv098DesobstrucaoLigacaoEsgoto.class);
	}

}
