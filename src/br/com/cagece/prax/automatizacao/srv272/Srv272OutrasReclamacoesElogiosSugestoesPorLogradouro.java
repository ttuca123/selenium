package br.com.cagece.prax.automatizacao.srv272;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoExecucaoServico;
import enumerators.EnumUsuario;

@CasoDeTesteServico(id = "CT02", servico = EnumServico.OUTRAS_RECLAMACOES_ELOGIOS_SUGESTOES_CRITICAS, complemento = "POR LOGRADOURO",
executarBaixa = false, enumTipoServico=EnumTipoExecucaoServico.LOGRADOURO, usuario=EnumUsuario.UNIDADE_DE_NEGOCIO_INTERNA)
public class Srv272OutrasReclamacoesElogiosSugestoesPorLogradouro extends ServiceTestBase
{

	public Srv272OutrasReclamacoesElogiosSugestoesPorLogradouro()
	{
		super(Srv272OutrasReclamacoesElogiosSugestoesPorLogradouro.class);
	}
}
	