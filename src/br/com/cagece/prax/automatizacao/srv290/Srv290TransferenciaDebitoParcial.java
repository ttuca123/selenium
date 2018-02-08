package br.com.cagece.prax.automatizacao.srv290;

import anotations.CasoDeTesteServico;
import auxiliares.ServiceTestBase;
import enumerators.EnumServico;

@CasoDeTesteServico(id = "CT01", servico = EnumServico.TRANFERENCIA_DE_DEBITO, complemento = "PARCIAL", gerarParInscricao = true)
public class Srv290TransferenciaDebitoParcial extends ServiceTestBase
{
	public Srv290TransferenciaDebitoParcial()
	{
		super(Srv290TransferenciaDebitoParcial.class);
	}
}
