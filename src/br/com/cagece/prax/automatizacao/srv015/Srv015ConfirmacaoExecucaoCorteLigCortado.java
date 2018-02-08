package br.com.cagece.prax.automatizacao.srv015;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.CONFIRMACAO_DA_EXECUCAO_DO_CORTE, complemento = "LIG. CORTADA", executarBaixa = true)
public class Srv015ConfirmacaoExecucaoCorteLigCortado extends ServiceTestBase
{
	public Srv015ConfirmacaoExecucaoCorteLigCortado()
	{
		super(Srv015ConfirmacaoExecucaoCorteLigCortado.class);
	}

}
