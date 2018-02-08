package br.com.cagece.prax.automatizacao.srv021;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT03", servico = EnumServico.VERIFICACAO_CONSUMO_MEDIDO, tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, executarBaixa = true, complemento = "IMPROCEDENTE", laudo = EnumTipoLaudo.IMPROCEDENTE, movimentarFatura=true)
public class Srv021VerificacaoConsumoMedidoImprocedenteRevisao extends ServiceTestBase
{

	public Srv021VerificacaoConsumoMedidoImprocedenteRevisao()
	{
		super(Srv021VerificacaoConsumoMedidoImprocedenteRevisao.class);
	}
}
