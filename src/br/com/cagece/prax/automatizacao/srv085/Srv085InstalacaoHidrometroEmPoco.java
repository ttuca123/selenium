package br.com.cagece.prax.automatizacao.srv085;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;
import enumerators.EnumTipoPagamento;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.INSTALACAO_HIDROMETRO_POCO, tipoPgto = EnumTipoPagamento.SEM_CUSTO,
             executarBaixa = true)
public class Srv085InstalacaoHidrometroEmPoco extends ServiceTestBase
{

	public Srv085InstalacaoHidrometroEmPoco()
	{
		super(Srv085InstalacaoHidrometroEmPoco.class);
	}

}
