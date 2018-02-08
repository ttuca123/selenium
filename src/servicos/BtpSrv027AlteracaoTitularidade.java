package servicos;

import org.junit.Assert;
import org.openqa.selenium.By;

import pages.AtendimentoPage;
import auxiliares.BaseVars;
import auxiliares.DriverUtils;
import enumerators.EnumLocalEntregaFatura;
import enumerators.EnumUsuario;
import frames.FramePrincipalPage;

public class BtpSrv027AlteracaoTitularidade extends ServicoPadrao
{

	@Override
	public void preValidar(ServicoPadrao servicoPadrao)
	{
		switch (servicoPadrao.getNrCasoTeste())
		{
			case 1:
			case 2:
			case 4:

				if ( DriverUtils.getDriver()
						.findElements(By.cssSelector("div[class='af_dialog_close-icon']"))
						.size() > 0 )
				{

					DriverUtils.clicar(FramePrincipalPage.popupInformacaoBotaoFechar);

				}

				DriverUtils.clicar(FramePrincipalPage.btnContrato);

				DriverUtils.esperarPorAjax();

				servicoPadrao.setProdutosContrato(servicoPadrao.getValidacao()
						.preencherProdutoContrato());

				DriverUtils.clicar(FramePrincipalPage.btnRegistroAtendimento);

				DriverUtils.esperarPorAjax();

				break;

			case 3:
			{
				if ( servicoPadrao.getUsuario().equals(EnumUsuario.ATENDENTE) )
				{

				}
				else
				{
					Assert.assertTrue(FramePrincipalPage
							.mensagemExibida(BaseVars.MSG_GEFAR_INTERNO));

					servicoPadrao.setExecutarSolicitacao(false);
				}
				break;
			}
			default:
			{

			}
		}

	}

	@Override
	public void preencherDadosComplementares(ServicoPadrao servicoPadrao)
			throws Exception
	{

		DriverUtils.clicar(FramePrincipalPage.btnBuscaDataFinalizacao);
		DriverUtils.esperarPorAjax();

		AtendimentoPage.pesquisarCliente(servicoPadrao.getInscDestino().toString());
		
		DriverUtils.delay(2000);

		AtendimentoPage.selecionarLocalEntrega(EnumLocalEntregaFatura.IMOVEL);

	}

	@Override
	public void validarRegistroAtendimento(ServicoPadrao servico)
	{
		Assert.assertFalse(DriverUtils.getDriver()
				.findElement(By.id("outTxtResAtdAteDatFimAtendimento")).getText()
				.isEmpty());
	}

	@Override
	public void verificar(ServicoPadrao servicoPadrao) throws Exception
	{

		DriverUtils.clicar(FramePrincipalPage.btnImgContrato);

		DriverUtils.delay(1000);

		servicoPadrao.getValidacao().verificarProdutoContrato(
				servicoPadrao.getProdutosContrato());

	}

}
