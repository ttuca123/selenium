package br.com.cagece.prax.automatizacao.srv331;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoLaudo;
/**
 * 
 * @author 403724
 *
 */
@CasoDeTesteServico(id = "CT02", servico = EnumServico.SUPRESSAO_LIGACAO_CLANDESTINA, complemento = "IMPROCEDENTE", laudo = EnumTipoLaudo.IMPROCEDENTE, executarBaixa = true)
public class Srv331SupressaoLigacaoClandestinaImprocedente extends
		ServiceTestBase
{

	public Srv331SupressaoLigacaoClandestinaImprocedente()
	{
		super(Srv331SupressaoLigacaoClandestinaImprocedente.class);
	}
}
