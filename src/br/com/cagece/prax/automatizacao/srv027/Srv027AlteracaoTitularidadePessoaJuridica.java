package br.com.cagece.prax.automatizacao.srv027;

import anotations.CasoDeTesteServico;
import auxiliares.BaseVars;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

/**
 * Caso de Teste Nº: CT-002-SRV-27 - Mudança de Tutularidade de Pessoa Jurídica
 * para Pessoa Juridica
 * 
 * @author 208396 - EVANDRO CUSTODIO GONCALVES [evandro.custodio@cagece.com.br]
 *         28/08/2015 08:24
 * 
 */
@CasoDeTesteServico(id = "CT02", servico = EnumServico.ALTERACAO_DE_TITULARIDADE, complemento = BaseVars.PESSOA_JURIDICA, gerarParInscricao = true, verificaDebito = true)
public class Srv027AlteracaoTitularidadePessoaJuridica extends ServiceTestBase
{

	public Srv027AlteracaoTitularidadePessoaJuridica()
	{
		super(Srv027AlteracaoTitularidadePessoaJuridica.class);
	}
}
