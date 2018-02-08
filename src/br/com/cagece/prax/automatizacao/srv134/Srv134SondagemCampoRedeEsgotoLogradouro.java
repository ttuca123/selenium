package br.com.cagece.prax.automatizacao.srv134;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoExecucaoServico;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.SONDAGEM_EM_CAMPO_DE_REDE_ESGOTO, complemento = "POR LOGRADOURO", enumTipoServico = EnumTipoExecucaoServico.LOGRADOURO, executarBaixa = true)
public class Srv134SondagemCampoRedeEsgotoLogradouro extends ServiceTestBase {

	public Srv134SondagemCampoRedeEsgotoLogradouro() {

		super(Srv134SondagemCampoRedeEsgotoLogradouro.class);
	}

}
