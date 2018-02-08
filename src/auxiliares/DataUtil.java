package auxiliares;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 
 * @author 210266 - Artur
 *
 */
public class DataUtil
{

	public static final Locale LOCALE_BR = new Locale("pt", "BR");

	private static final String PADRAO_DATA_DDMMYYYY = "dd/MM/yyyy";

	public static String adicionaDiasData(String dataAtual, int diferenca)
			throws java.text.ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat(PADRAO_DATA_DDMMYYYY);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(format.parse(dataAtual));
		calendar.add(Calendar.DAY_OF_MONTH, diferenca);
		calendar.getTime();

		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(
				"pt", "BR"));

		return df.format(calendar.getTime());

	}

	public static String adicionaMesesData(String dataAtual, int diferenca)
	{
		SimpleDateFormat format = new SimpleDateFormat(PADRAO_DATA_DDMMYYYY);

		Calendar calendar = null;
		try
		{
			calendar = Calendar.getInstance();
			calendar.setTime(format.parse(dataAtual));
			calendar.add(Calendar.MONTH, diferenca);
			calendar.getTime();
		}
		catch (ParseException e)
		{

			e.printStackTrace();
		}

		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(
				"pt", "BR"));

		return df.format(calendar.getTime());

	}

	public static String adicionaAnosData(String dataAtual, int diferenca)
			throws java.text.ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat(PADRAO_DATA_DDMMYYYY);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(format.parse(dataAtual));
		calendar.add(Calendar.YEAR, diferenca);
		calendar.getTime();

		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(
				"pt", "BR"));

		return df.format(calendar.getTime());

	}

	public static boolean comparaDtInicialMaiorQueFinal(String dataAtual,
			String dataFinal) throws java.text.ParseException
	{

		SimpleDateFormat format = new SimpleDateFormat(PADRAO_DATA_DDMMYYYY);

		Calendar dtAtual = Calendar.getInstance();
		dtAtual.setTime(format.parse(dataAtual));
		dtAtual.getTime();

		Calendar dtFim = Calendar.getInstance();
		dtFim.setTime(format.parse(dataFinal));
		dtFim.getTime();

		if ( dtAtual.before(dtFim) )
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	public static String converterDataFormatoddMMyyy(Date dataModificada)
	{

		SimpleDateFormat simple = new SimpleDateFormat(PADRAO_DATA_DDMMYYYY);
		return simple.format(dataModificada);
	}

	public static String converterData(String data)
	{

		try
		{
			SimpleDateFormat format = new SimpleDateFormat(PADRAO_DATA_DDMMYYYY);

			String dataModificada = data.replace("-", "/");

			Date dataM = format.parse(dataModificada);

			Calendar calendar = Calendar.getInstance();

			calendar.setTime(format.parse(dataM.toString()));

			Calendar dtM1 = Calendar.getInstance();
			dtM1.setTime(format.parse(data));
			dtM1.getTime();

			DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(
					"pt", "BR"));

			return df.format(calendar.getTime());
		}
		catch (java.text.ParseException e)
		{

			e.printStackTrace();
		}
		return null;

	}

	public static Date adicionarDiasEmUmaData(final Date dataEntrada,
			final int qtdDias)
	{
		final Calendar calendar = Calendar.getInstance();

		calendar.setTime(dataEntrada);

		calendar.add(Calendar.DATE, qtdDias);

		return calendar.getTime();
	}

	public static Date removeDias(final Date data, final int numDias)
	{
		if ( data != null )
		{
			final Date novaData = new Date(data.getTime() - 1000 * 60 * 60 * 24
					* numDias);

			return novaData;
		}

		return null;
	}

	public static Date getDataAtualSemHHMMSS()
	{
		final Calendar calendar = Calendar.getInstance(LOCALE_BR);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Date(calendar.getTime().getTime());
	}

	public static boolean isSabadoOuDomingo(GregorianCalendar data)
	{
		GregorianCalendar gc = data;
		int diaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);

		return diaSemana == GregorianCalendar.SATURDAY
				|| diaSemana == GregorianCalendar.SUNDAY;
	}

	public static String getCompetenciaMesAnterior(boolean isBanco)

	{

		String competencia = DataUtil.adicionaMesesData(
				DataUtil.converterDataFormatoddMMyyy(DataUtil.getDataAtualSemHHMMSS()),
				-1);

		String ano = competencia.substring(6, 10);
		String mes = competencia.substring(3, 5);

		if ( isBanco )
		{

			return ano + mes;

		}
		else
		{

			return mes + ano;

		}
	}

	public static String getCompetenciaTarifaria(String mes01, String mes02)
			throws ClassNotFoundException, SQLException

	{

		String query = "SELECT FAT.FAT_CPT_FATURA FROM FAT_FATURA FAT"
				+ " WHERE FAT_DAT_GERACAO BETWEEN to_date(add_months(sysdate , "
				+ mes01 + ")) AND to_date(add_months(sysdate , " + mes02
				+ ")) AND ROWNUM=1";

		Integer competencia = null;
		Connection connection = null;

		try
		{
			connection = new ConnectJDBC().createConnectionPrax();

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			final ResultSet rs = preparedStatement.executeQuery(query);

			while (rs.next())
			{
				competencia = rs.getInt(1);

			}
		}
		finally
		{

			connection.close();

		}

		return competencia.toString();
	}

	public static String alterarDiaUtilData(Date data, int qtd)
	{

		Date dataModificada = DataUtil.adicionarDiasEmUmaData(data, qtd);

		GregorianCalendar gc = new GregorianCalendar();

		gc.setTime(dataModificada);

		if ( DataUtil.isSabadoOuDomingo(gc) )
		{

			return alterarDiaUtilData(dataModificada, qtd++);

		}
		else
		{

			return DataUtil.converterDataFormatoddMMyyy(dataModificada);

		}

	}

}
