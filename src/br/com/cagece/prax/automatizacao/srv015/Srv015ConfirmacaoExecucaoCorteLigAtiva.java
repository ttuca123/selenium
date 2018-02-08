package br.com.cagece.prax.automatizacao.srv015;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.CONFIRMACAO_DA_EXECUCAO_DO_CORTE, complemento = "LIG. ATIVA", executarBaixa = true)
public class Srv015ConfirmacaoExecucaoCorteLigAtiva extends ServiceTestBase
{

	public Srv015ConfirmacaoExecucaoCorteLigAtiva()
	{
		super(Srv015ConfirmacaoExecucaoCorteLigAtiva.class);
	}

}
