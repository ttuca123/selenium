package br.com.cagece.prax.automatizacao.srv339;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.REVISAO_CALCULO_TARIFA_CONTIGENCIA,tipoPgto= EnumTipoPagamento.SEM_CUSTO,
laudo =EnumTipoLaudo.PROCEDENTE, executarBaixa = true)
public class Srv339RevisaoCalculoTarifaDeContigenciaProcedente extends ServiceTestBase {

	public Srv339RevisaoCalculoTarifaDeContigenciaProcedente() {
		super(Srv339RevisaoCalculoTarifaDeContigenciaProcedente.class);
	}
}
