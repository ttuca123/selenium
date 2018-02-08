package br.com.cagece.prax.automatizacao.srv077;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.DESOBSTRUCAO_REDE_ESGOTO, executarBaixa = true)
public class Srv077DesobstrucaoRedeEsgoto extends ServiceTestBase {

	public Srv077DesobstrucaoRedeEsgoto() {
		super(Srv077DesobstrucaoRedeEsgoto.class);
	}
}
