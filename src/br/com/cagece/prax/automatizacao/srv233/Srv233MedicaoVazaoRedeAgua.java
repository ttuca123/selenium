package br.com.cagece.prax.automatizacao.srv233;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoExecucaoServico;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.MEDICAO_VAZAO_REDE_AGUA, enumTipoServico=EnumTipoExecucaoServico.CLIENTE )
public class Srv233MedicaoVazaoRedeAgua extends ServiceTestBase {

	public Srv233MedicaoVazaoRedeAgua() {
		super(Srv233MedicaoVazaoRedeAgua.class);
	}
}
