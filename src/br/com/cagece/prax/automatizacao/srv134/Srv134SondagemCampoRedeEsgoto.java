package br.com.cagece.prax.automatizacao.srv134;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.SONDAGEM_EM_CAMPO_DE_REDE_ESGOTO, complemento = "POR IMÓVEL", executarBaixa = true)
public class Srv134SondagemCampoRedeEsgoto extends ServiceTestBase {

	public Srv134SondagemCampoRedeEsgoto() {

		super(Srv134SondagemCampoRedeEsgoto.class);
	}

}
