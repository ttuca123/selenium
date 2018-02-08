package br.com.cagece.prax.automatizacao.srv131;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.SONDAGEM_EM_CAMPO_DE_REDE_AGUA, complemento = "POR IMÓVEL", executarBaixa = true)
public class Srv131SondagemCampoRedeAgua extends ServiceTestBase {

	public Srv131SondagemCampoRedeAgua() {

		super(Srv131SondagemCampoRedeAgua.class);
	}

}
