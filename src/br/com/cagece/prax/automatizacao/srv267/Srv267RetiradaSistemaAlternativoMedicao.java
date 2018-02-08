package br.com.cagece.prax.automatizacao.srv267;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoExecucaoServico;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.RETIRADA_SISTEMA_ALTERNATIVO_MEDICAO,enumTipoServico=EnumTipoExecucaoServico.IMOVEL, executarBaixa = true)
public class Srv267RetiradaSistemaAlternativoMedicao extends ServiceTestBase {

	public Srv267RetiradaSistemaAlternativoMedicao() {
		super(Srv267RetiradaSistemaAlternativoMedicao.class);
	}
}
