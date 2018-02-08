package br.com.cagece.prax.automatizacao.srv312;

import anotations.CasoDeTesteServico;
import auxiliares.BaseVars;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.VENCIMENTOS_OPCIONAIS, complemento=BaseVars.PESSOA_FISICA)
public class Srv312VencimentoOpcionalPessoaFisica extends ServiceTestBase
{

	public Srv312VencimentoOpcionalPessoaFisica()
	{
		super(Srv312VencimentoOpcionalPessoaFisica.class);
	}
}
