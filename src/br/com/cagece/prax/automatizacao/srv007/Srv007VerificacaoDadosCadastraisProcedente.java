package br.com.cagece.prax.automatizacao.srv007;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPagamento;

/**
 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 15/09/2015 -
 *         16:15:06.
 */

@CasoDeTesteServico(id = "CT01", servico = EnumServico.VERIFICACAO_DADOS_CADASTRAIS, tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, complemento = "PROCEDENTE", executarBaixa = true, laudo = EnumTipoLaudo.PROCEDENTE)
public class Srv007VerificacaoDadosCadastraisProcedente extends ServiceTestBase
{

	public Srv007VerificacaoDadosCadastraisProcedente()
	{
		super(Srv007VerificacaoDadosCadastraisProcedente.class);
	}

}
