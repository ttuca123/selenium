package br.com.cagece.prax.automatizacao.srv001;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoExecucaoServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.REVISAO_DE_DADOS_CADASTRAIS, enumTipoServico = EnumTipoExecucaoServico.IMOVEL, tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, laudo = EnumTipoLaudo.PROCEDENTE, executarBaixa = true, geraLancamentoFuturo=false)
public class Srv001RevisaoDadosCadastraisProcedente extends ServiceTestBase
{

	public Srv001RevisaoDadosCadastraisProcedente()
	{
		super(Srv001RevisaoDadosCadastraisProcedente.class);
	}
}
