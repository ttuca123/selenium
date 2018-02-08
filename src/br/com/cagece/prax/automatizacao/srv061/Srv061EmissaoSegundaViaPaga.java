package br.com.cagece.prax.automatizacao.srv061;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT03", servico = EnumServico.SEGUNDA_VIA, complemento = "PAGA", tipoPgto = EnumTipoPagamento.PARCELADO_SEM_ENTRADA)
public class Srv061EmissaoSegundaViaPaga extends ServiceTestBase
{

	public Srv061EmissaoSegundaViaPaga()
	{
		super(Srv061EmissaoSegundaViaPaga.class);
	}

}
