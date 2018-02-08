package br.com.cagece.prax.automatizacao.srv002;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;
import enumerators.EnumTipoExecucaoServico;
/**
 * 
 * @author 403724
 *
 */

@CasoDeTesteServico(id = "CT02", servico = EnumServico.ENTREGA_FATURA_ENDERECO_ALTERNATIVO, enumTipoServico = EnumTipoExecucaoServico.IMOVEL,
tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA, executarBaixa = true)
public class Srv002EntregaFaturaEnderecoAlternativoParceladoSemEntrada extends
		ServiceTestBase
{

	public Srv002EntregaFaturaEnderecoAlternativoParceladoSemEntrada()
	{
		super(Srv002EntregaFaturaEnderecoAlternativoParceladoSemEntrada.class);
	}
}
