package br.com.cagece.prax.automatizacao.srv174;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
/**
 * 
 * @author 403724
 *
 */

@CasoDeTesteServico(id = "CT01", servico = EnumServico.SISTEMA_MEDICAO_ESGOTO,tipoPgto = EnumTipoPagamento.SEM_CUSTO, executarBaixa=true)
public class Srv174SistemaMedicaoEsgoto extends ServiceTestBase {

	public Srv174SistemaMedicaoEsgoto() {
		super(Srv174SistemaMedicaoEsgoto.class);
	}

}
