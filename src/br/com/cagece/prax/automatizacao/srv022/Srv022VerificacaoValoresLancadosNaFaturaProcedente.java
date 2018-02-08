package br.com.cagece.prax.automatizacao.srv022;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.VERIFICACAO_DE_VALORES_LANCADOS_NA_FATURA, complemento = "PROCEDENTE", laudo = EnumTipoLaudo.PROCEDENTE, executarBaixa = true)
public class Srv022VerificacaoValoresLancadosNaFaturaProcedente extends
		ServiceTestBase
{

	public Srv022VerificacaoValoresLancadosNaFaturaProcedente()
	{
		super(Srv022VerificacaoValoresLancadosNaFaturaProcedente.class);
	}
}