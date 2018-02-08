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

@CasoDeTesteServico(id = "CT01", servico = EnumServico.ENTREGA_FATURA_ENDERECO_ALTERNATIVO, enumTipoServico = EnumTipoExecucaoServico.IMOVEL,
tipoPgto = EnumTipoPagamento.A_VISTA,executarBaixa=true)
public class Srv002EntregaFaturaEnderecoAlternativoVista extends ServiceTestBase
{

	public Srv002EntregaFaturaEnderecoAlternativoVista()
	{
		super(Srv002EntregaFaturaEnderecoAlternativoVista.class);
	}
}
