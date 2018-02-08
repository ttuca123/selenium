package br.com.cagece.prax.automatizacao.srv131;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoExecucaoServico;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.SONDAGEM_EM_CAMPO_DE_REDE_AGUA, complemento = "POR LOGRADOURO",
enumTipoServico = EnumTipoExecucaoServico.LOGRADOURO, executarBaixa = true)
public class Srv131SondagemCampoRedeAguaLogradouro extends ServiceTestBase {

	public Srv131SondagemCampoRedeAguaLogradouro() {

		super(Srv131SondagemCampoRedeAguaLogradouro.class);
	}

}
