package br.com.cagece.prax.bci;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import anotations.CasoDeTeste;
import auxiliares.DriverUtils;
import auxiliares.Util;
import enumerators.EnumAreaTipoPadrao;
import enumerators.EnumTipoConstrucao;
import enumerators.EnumTipoPiso;

public class CalculoPadraoVagoCadastro extends BciTestBase
{

	public CalculoPadraoVagoCadastro()
	{
		super(CalculoPadraoVagoCadastro.class);
	}

	@SuppressWarnings("static-access")
	public void executarTeste() throws IOException, InterruptedException
	{

		bciPageCadastro.excluirTodasEconomias();

		if ( bciPageCadastro.flgPadraoVago.isSelected() )
		{
			DriverUtils.clicar(bciPageCadastro.flgPadraoVago);
			DriverUtils.esperarPorAjax();
		}

		if ( bciPageCadastro.flgEstruturaPrecaria.isSelected() )
		{
			DriverUtils.clicar(bciPageCadastro.flgEstruturaPrecaria);
			DriverUtils.esperarPorAjax();
		}

		if ( bciPageCadastro.flgForro.isSelected() )
		{
			bciPageCadastro.flgForro.click();
		}

		if ( bciPageCadastro.flgGaragem.isSelected() )
		{
			bciPageCadastro.flgGaragem.click();
		}

		if ( bciPageCadastro.flgJardim.isSelected() )
		{
			bciPageCadastro.flgJardim.click();
		}

		bciPageCadastro.txtAreaConstruida.clear();
		bciPageCadastro.txtAreaConstruida.sendKeys(EnumAreaTipoPadrao.REGULAR
				.getNomeAmigavel());

		bciPageCadastro.txtTipoConstrucao.clear();
		bciPageCadastro.txtTipoConstrucao
				.sendKeys(EnumTipoConstrucao.TIJOLO_CONCRETO.getCodigo().toString());

		bciPageCadastro.txtTipoPiso.clear();
		bciPageCadastro.txtTipoPiso.sendKeys(EnumTipoPiso.CERAMICA_ESMALTADA
				.getCodigo().toString());

		bciPageCadastro.txtQtdBanheiro.clear();
		bciPageCadastro.txtQtdBanheiro.sendKeys(QTD_BANHEIROS);

		bciPageCadastro.txtPontosUtilizacao.clear();
		bciPageCadastro.txtPontosUtilizacao.sendKeys(qtdPontosUtilizacao);

		DriverUtils.clicar(bciPageCadastro.btnCalcularPadrao);
		DriverUtils.esperarPorAjax();

		List<String> mensagensRetorno = new ArrayList<String>();
		{
			mensagensRetorno.add(MSG_SEM_ECONOMIAS);
		}

		Util.verificarMensagem(mensagensRetorno);

	}
}
