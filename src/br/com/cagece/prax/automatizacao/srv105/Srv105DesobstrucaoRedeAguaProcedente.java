package br.com.cagece.prax.automatizacao.srv105;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
/**
 * 
 * @author 403724
 *
 */

@CasoDeTesteServico(id = "CT01", servico = EnumServico.DESOBSTRUCAO_REDE_AGUA,complemento = "PROCEDENTE",
laudo = EnumTipoLaudo.PROCEDENTE, executarBaixa=true)
public class Srv105DesobstrucaoRedeAguaProcedente extends ServiceTestBase {

	public Srv105DesobstrucaoRedeAguaProcedente() {
		super(Srv105DesobstrucaoRedeAguaProcedente.class);
	}

}
