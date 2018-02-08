package servicos;

import pages.AtendimentoPage;
import pages.ItemAtendimentoPage;
import auxiliares.DriverUtils;
import auxiliares.Util;

public class BtpSrv125VendaAguaGranelCarroPipa extends ServicoPadrao
{

	private Integer nrVolume = Util.gerarNumero(497);

	private static String volume;

	@Override
	public void preencherDadosComplementares() throws Exception
	{

		DriverUtils
				.selecionarComboPeloIndice(AtendimentoPage.selectCarro, nrVolume);

		volume = getVolumeReal(DriverUtils
				.getValorCombo(AtendimentoPage.selectCarro));

		DriverUtils.escrever(AtendimentoPage.txtVolume, volume);

	}

	@Override
	public void preencherDadosBaixa(ServicoPadrao servico)
	{

		DriverUtils.escrever(ItemAtendimentoPage.txtVolumeRetirado, volume);

		DriverUtils.escrever(ItemAtendimentoPage.txtCodLocalidade, Util
				.gerarNumero(80).toString());

		DriverUtils.escrever(ItemAtendimentoPage.txtCodUnidadeNegocio, "1");
	}

	/**
	 * Método para buscar o volume correto selecionado
	 * 
	 * @author Artur Cavalcante[artur.cavalcante@cagece.com.br] 08/12/2015 -
	 *         11:53:58.
	 * @param volume
	 * @return
	 */
	private String getVolumeReal(String volume)
	{

		StringBuilder texto = new StringBuilder(volume);

		String[] partesTexto = texto.toString().split("-", 0);

		String[] partesVolume = partesTexto[1].split("M³", 0);

		return partesVolume[0];

	}

}
