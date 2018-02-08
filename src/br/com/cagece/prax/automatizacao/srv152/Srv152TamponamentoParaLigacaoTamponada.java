package br.com.cagece.prax.automatizacao.srv152;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
/**
 * 
 * @author 403724
 *
 */
@CasoDeTesteServico(id = "CT01", servico = EnumServico.TAMPONAMENTO_LIGACAO_TAMPONADA, executarBaixa = true)
public class Srv152TamponamentoParaLigacaoTamponada extends ServiceTestBase
{

	public Srv152TamponamentoParaLigacaoTamponada()
	{
		super(Srv152TamponamentoParaLigacaoTamponada.class);
	}

}
