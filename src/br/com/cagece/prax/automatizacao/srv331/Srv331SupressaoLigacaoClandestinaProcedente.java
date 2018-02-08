package br.com.cagece.prax.automatizacao.srv331;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
import enumerators.EnumTipoPagamento;
/**
 * 
 * @author 403724
 *
 */
@CasoDeTesteServico(id = "CT01", servico = EnumServico.SUPRESSAO_LIGACAO_CLANDESTINA,complemento ="PROCEDENTE",
laudo=EnumTipoLaudo.PROCEDENTE,executarBaixa=true)
public class Srv331SupressaoLigacaoClandestinaProcedente extends ServiceTestBase
{

	public Srv331SupressaoLigacaoClandestinaProcedente()
	{
		super(Srv331SupressaoLigacaoClandestinaProcedente.class);
	}
}
