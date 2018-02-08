package br.com.cagece.prax.automatizacao.srv312;

import anotations.CasoDeTesteServico;
import auxiliares.BaseVars;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT03", servico = EnumServico.VENCIMENTOS_OPCIONAIS, complemento = BaseVars.ORGAO_PUBLICO_INTERIOR)
public class Srv312VencimentoOpcionalOrgaoPublicoInterior extends
		ServiceTestBase
{
	public Srv312VencimentoOpcionalOrgaoPublicoInterior()
	{
		super(Srv312VencimentoOpcionalOrgaoPublicoInterior.class);
	}
}
