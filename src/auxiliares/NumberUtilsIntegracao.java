/**
 * @author Aldivone Correia[aldivone@gmail.com] 29/01/2013 - 18:01:00.
 */
package auxiliares;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import enumerators.EnumCasasDecimais;

/**
 * Classe que contém funções genericas para operação com numeros.
 * 
 * @author Aldivone Correia[aldivone@gmail.com] 29/01/2013 - 18:01:00.
 * 
 */
public final class NumberUtilsIntegracao {

	public static Double multiply(final Number a, final Number b,
			final int scale, final int precision) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(3);
		dc.setMinimumFractionDigits(3);

		dc.setMaximumIntegerDigits(19);

		final BigDecimal retorno = mul(a, b, scale, precision);

		return new Double(dc.format(retorno.doubleValue()));
	}

	public static Double divide(final Number a, final Number b,
			final int scale, final int precision) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(3);
		dc.setMinimumFractionDigits(3);

		dc.setMaximumIntegerDigits(19);

		final BigDecimal retorno = div(a, b, scale, precision);

		return new Double(dc.format(retorno.doubleValue()));
	}

	/**
	 * Truncar um valor passado com parâmetro, será 0 (zero) caso o valor
	 * passado seja nulo. O valor retornado será com duas casas decimais.
	 * 
	 * @author Aldivone Correia[aldivone@gmail.com] 29/01/2013 - 18:06:37.
	 * 
	 * @param valorParametro
	 *            Valor informado.
	 * @param enumCasasDecimais
	 *            Quantidade de casas decimais a serem considerada no trunc.
	 * 
	 * @return Valor truncado.
	 */
	public static Double truncarValor(final Double valorParametro,
			final EnumCasasDecimais enumCasasDecimais) {
		if (valorParametro != null) {
			final String valorStrTemp = new BigDecimal(valorParametro)
					.toString();

			int indexPontoTemp = valorStrTemp.indexOf(",");

			if (indexPontoTemp <= 0) {
				indexPontoTemp = valorStrTemp.indexOf(".");
			}

			if (indexPontoTemp <= 0) {
				indexPontoTemp = valorStrTemp.length();
			}

			final String temp = valorStrTemp.substring(indexPontoTemp,
					valorStrTemp.length());

			NumberFormat dc = new DecimalFormat("#######0.000");

			if (enumCasasDecimais != null) {
				switch (enumCasasDecimais) {
				case DUAS_CASAS_DECIMAIS: {
					dc = new DecimalFormat("#######0.000");
					break;
				}
				case QUATRO_CASAS_DECIMAIS: {
					dc = new DecimalFormat("#######0.00000");
					break;
				}
				case CINCO_CASAS_DECIMAIS: {
					dc = new DecimalFormat("#######0.000000");
					break;
				}
				}
			}

			String valorStr = dc.format(valorParametro);

			if (temp != null && temp.length() > 3) {
				valorStr = valorStr.toString();
			}

			int indexPonto = valorStr.indexOf(",");

			if (indexPonto <= 0) {
				indexPonto = valorStr.indexOf(".");
			}

			if (indexPonto <= 0) {
				indexPonto = valorStr.length();
			}

			final StringBuilder valorNovo = new StringBuilder();

			valorNovo.append(valorStr.substring(0, indexPonto));

			if (indexPonto < valorStr.length()) {
				valorNovo.append(".");

				int indexFinal = indexPonto + 3;

				if (enumCasasDecimais != null) {
					switch (enumCasasDecimais) {
					case DUAS_CASAS_DECIMAIS: {
						indexFinal = indexPonto + 3;
						break;
					}
					case QUATRO_CASAS_DECIMAIS: {
						indexFinal = indexPonto + 5;
						break;
					}
					case CINCO_CASAS_DECIMAIS: {
						indexFinal = indexPonto + 6;
						break;
					}
					}
				}

				if (indexFinal >= valorStr.length()) {
					indexFinal = valorStr.length();
				}

				valorNovo
						.append(valorStr.substring(indexPonto + 1, indexFinal));
			}

			if (valorNovo.toString().contains("E")) {
				throw new IllegalArgumentException("Valor com hexadecional...."
						+ valorStr);
			}

			final Double valorRetorno = new Double(valorNovo.toString());

			return valorRetorno;
		}

		return 0D;
	}

	/**
	 * Truncar um valor passado com parâmetro, será 0 (zero) caso o valor
	 * passado seja nulo. O valor retornado será com duas casas decimais.
	 * 
	 * @author Aldivone Correia[aldivone@gmail.com] 29/01/2013 - 18:06:37.
	 * 
	 * @param valorParametro
	 *            Valor informado.
	 * @param enumCasasDecimais
	 *            Quantidade de casas decimais a serem considerada no trunc.
	 * 
	 * @return Valor truncado.
	 */
	public static Double truncarValor(final BigDecimal valorParametro,
			final EnumCasasDecimais enumCasasDecimais) {
		if (valorParametro != null) {
			final String valorStrTemp = valorParametro.toString();

			int indexPontoTemp = valorStrTemp.indexOf(",");

			if (indexPontoTemp <= 0) {
				indexPontoTemp = valorStrTemp.indexOf(".");
			}

			if (indexPontoTemp <= 0) {
				indexPontoTemp = valorStrTemp.length();
			}

			final String temp = valorStrTemp.substring(indexPontoTemp,
					valorStrTemp.length());

			NumberFormat dc = new DecimalFormat("#######0.000");

			if (enumCasasDecimais != null) {
				switch (enumCasasDecimais) {
				case DUAS_CASAS_DECIMAIS: {
					dc = new DecimalFormat("#######0.000");
					break;
				}
				case QUATRO_CASAS_DECIMAIS: {
					dc = new DecimalFormat("#######0.00000");
					break;
				}
				case CINCO_CASAS_DECIMAIS: {
					dc = new DecimalFormat("#######0.000000");
					break;
				}
				}
			}

			String valorStr = dc.format(valorParametro);

			if (temp != null && temp.length() > 3) {
				valorStr = valorStr.toString();
			}

			int indexPonto = valorStr.indexOf(",");

			if (indexPonto <= 0) {
				indexPonto = valorStr.indexOf(".");
			}

			if (indexPonto <= 0) {
				indexPonto = valorStr.length();
			}

			final StringBuilder valorNovo = new StringBuilder();

			valorNovo.append(valorStr.substring(0, indexPonto));

			if (indexPonto < valorStr.length()) {
				valorNovo.append(".");

				int indexFinal = indexPonto + 3;

				if (enumCasasDecimais != null) {
					switch (enumCasasDecimais) {
					case DUAS_CASAS_DECIMAIS: {
						indexFinal = indexPonto + 3;
						break;
					}
					case QUATRO_CASAS_DECIMAIS: {
						indexFinal = indexPonto + 5;
						break;
					}
					case CINCO_CASAS_DECIMAIS: {
						indexFinal = indexPonto + 6;
						break;
					}
					}
				}

				if (indexFinal >= valorStr.length()) {
					indexFinal = valorStr.length();
				}

				valorNovo
						.append(valorStr.substring(indexPonto + 1, indexFinal));
			}

			if (valorNovo.toString().contains("E")) {
				throw new IllegalArgumentException("Valor com hexadecional...."
						+ valorStr);
			}

			final Double valorRetorno = new Double(valorNovo.toString());

			return valorRetorno;
		}

		return 0D;
	}

	/**
	 * Truncar um valor passado com parâmetro, será 0 (zero) caso o valor
	 * passado seja nulo. O valor retornado será com duas casas decimais.
	 * 
	 * @author Aldivone Correia[aldivone@gmail.com] 29/01/2013 - 18:06:37.
	 * 
	 * @param valorParametro
	 *            Valor informado.
	 * 
	 * @return Valor truncado.
	 */
	public static Double truncarValor(final Double valorParametro) {
		return truncarValor(valorParametro,
				EnumCasasDecimais.DUAS_CASAS_DECIMAIS);
	}

	/**
	 * Diminuir dois numeros, com precisão de duas casas decimais e 19 posições.
	 * 
	 * @author Aldivone Correia[aldivone@gmail.com] 30/01/2013 - 11:44:09.
	 * 
	 * @param a
	 *            Primeiro numero.
	 * @param b
	 *            Segundo numero.
	 * 
	 * 
	 * @return Valor calculado.
	 */
	public static Double diminuir(final Number a, final Number b) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(3);
		dc.setMinimumFractionDigits(3);

		dc.setMaximumIntegerDigits(19);

		final BigDecimal valor = sub(a, b, 19, 3);

		return new Double(dc.format(valor.doubleValue()));
	}

	public static Double diminuir(final Number a, final Number b,
			final int digitos) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(digitos);
		dc.setMinimumFractionDigits(digitos);

		dc.setMaximumIntegerDigits(19);

		final BigDecimal valor = sub(a, b, 19, digitos);

		return new Double(dc.format(valor.doubleValue()));
	}

	/**
	 * Diminuir dois numeros, com precisão de duas casas decimais e 19 posições.
	 * 
	 * @author Aldivone Correia[aldivone@gmail.com] 30/01/2013 - 11:44:51.
	 * 
	 * @param a
	 *            Primeiro numero.
	 * @param b
	 *            Segundo numero.
	 * 
	 * @param scale
	 *            Tamanho do numero.
	 * 
	 * @param precision
	 *            Casas decimais.
	 * 
	 * @return Valor calculado.
	 */
	private static BigDecimal sub(final Number a, final Number b,
			final int scale, final int precision) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(precision);
		dc.setMinimumFractionDigits(precision);

		dc.setMaximumIntegerDigits(scale);

		final String strA = dc.format(a);
		final String strB = dc.format(b);

		final BigDecimal numberA = new BigDecimal(strA);
		final BigDecimal numberB = new BigDecimal(strB);

		final BigDecimal retorno = numberA.subtract(numberB);

		return retorno;
	}

	/**
	 * Somar dois numeros, com precisão de duas casas decimais e 19 posições.
	 * 
	 * @author Aldivone Correia[aldivone@gmail.com] 30/01/2013 - 11:36:39.
	 * 
	 * @param a
	 *            Primeiro numero.
	 * @param b
	 *            Segundo numero.
	 * 
	 * @return Valor calculado.
	 */
	public static Double somar(final Number a, final Number b) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(3);
		dc.setMinimumFractionDigits(3);

		dc.setMaximumIntegerDigits(19);

		final BigDecimal valor = sum(a, b, 19, 3);

		return new Double(dc.format(valor.doubleValue()));
	}

	public static Double somar(final Number a, final Number b, final int digitos) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(digitos);
		dc.setMinimumFractionDigits(digitos);

		dc.setMaximumIntegerDigits(19);

		final BigDecimal valor = sum(a, b, 19, digitos);

		return new Double(dc.format(valor.doubleValue()));
	}

	public static Double somarImposto(final Number a, final Number b) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(4);
		dc.setMinimumFractionDigits(4);

		dc.setMaximumIntegerDigits(19);

		final BigDecimal valor = sum(a, b, 19, 4);

		return new Double(dc.format(valor.doubleValue()));
	}

	/**
	 * Método utilitario para somatorio de valores.
	 * 
	 * @param a
	 *            Primeiro numero.
	 * @param b
	 *            Segundo numero.
	 * 
	 * @param scale
	 *            Tamanho do numero.
	 * 
	 * @param precision
	 *            Casas decimais.
	 * 
	 * @return Valor calculado.
	 * 
	 * @author F. Assis V. M. Junior[assisprog@gmail.com] $16/03/2009 -
	 *         11:34:53$.
	 * 
	 * @since modelo - 2009.
	 */
	private static BigDecimal sum(final Number a, final Number b,
			final int scale, final int precision) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(precision);
		dc.setMinimumFractionDigits(precision);

		dc.setMaximumIntegerDigits(scale);

		final String strA = dc.format(a);
		final String strB = dc.format(b);

		final BigDecimal numberA = new BigDecimal(strA);
		final BigDecimal numberB = new BigDecimal(strB);

		final BigDecimal retorno = numberA.add(numberB);

		return retorno;
	}

	/**
	 * Dividir dois numeros, com precisão de duas casas decimais e 19 posições.
	 * 
	 * @author Aldivone Correia[aldivone@gmail.com] 29/01/2013 - 18:03:11.
	 * 
	 * @param a
	 *            Primeiro numero.
	 * @param b
	 *            Segundo numero.
	 * 
	 * @return Valor calculado.
	 */
	public static Double dividir(final Number a, final Number b) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(3);
		dc.setMinimumFractionDigits(3);

		dc.setMaximumIntegerDigits(19);

		final BigDecimal valor = div(a, b, 19, 3);

		return new Double(dc.format(valor.doubleValue()));
	}

	public static Double dividir(final Number a, final Number b,
			final int digitos) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(digitos);
		dc.setMinimumFractionDigits(digitos);

		dc.setMaximumIntegerDigits(19);

		final BigDecimal valor = div(a, b, 19, digitos);

		return new Double(dc.format(valor.doubleValue()));
	}

	/**
	 * Multiplicar dois numeros, com precisão de duas casas decimais e 19
	 * posições.
	 * 
	 * @author Aldivone Correia[aldivone@gmail.com] 29/01/2013 - 18:03:11.
	 * @param a
	 *            Primeiro numero.
	 * @param b
	 *            Segundo numero.
	 * 
	 * @return Valor calculado.
	 */
	public static Double multiplicar(final Number a, final Number b) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(3);
		dc.setMinimumFractionDigits(3);

		dc.setMaximumIntegerDigits(19);

		final BigDecimal valor = mul(a, b, 19, 3);

		return new Double(dc.format(valor.doubleValue()));
	}

	public static Double multiplicar(final Number a, final Number b,
			final int digitos) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(digitos);
		dc.setMinimumFractionDigits(digitos);

		dc.setMaximumIntegerDigits(19);

		final BigDecimal valor = mul(a, b, 19, digitos);

		return new Double(dc.format(valor.doubleValue()));
	}

	/**
	 * Multiplicar dois numeros, com precisão de duas casas decimais e 19
	 * posições. Usado para calculo do valor, este usa 4 casas decimais.
	 * 
	 * @author Aldivone Correia[aldivone@gmail.com] 26/02/2013 - 10:41:40.
	 * 
	 * @param a
	 *            Primeiro numero.
	 * @param b
	 *            Segundo numero.
	 * @return Valor calculado.
	 */
	public static Double mulCalculoValor(final Number a, final Number b) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(5);
		dc.setMinimumFractionDigits(5);

		dc.setMaximumIntegerDigits(19);

		final BigDecimal valor = mulCalculoValor(a, b, 19, 5);

		return new Double(dc.format(valor.doubleValue()));
	}

	/**
	 * Multiplicado dois numeros passado a precisão e casas decimais.
	 * 
	 * @author Aldivone Correia[aldivone@gmail.com] 29/01/2013 - 18:04:29.
	 * @param a
	 *            Primeiro nmero.
	 * @param b
	 *            Segundo numero.
	 * @param scale
	 *            Tamanho do numero.
	 * @param precision
	 *            Casas decimais.
	 * 
	 * @return Valor calculado.
	 */
	private static BigDecimal mul(final Number a, final Number b,
			final int scale, final int precision) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(precision);
		dc.setMinimumFractionDigits(precision);

		dc.setMaximumIntegerDigits(scale);

		final String strA = dc.format(a);
		final String strB = dc.format(b);

		final BigDecimal numberA = new BigDecimal(strA);
		final BigDecimal numberB = new BigDecimal(strB);

		final BigDecimal retorno = numberA.multiply(numberB);

		retorno.setScale(precision, RoundingMode.HALF_DOWN);

		return retorno;
	}

	private static BigDecimal mulCalculoValor(final Number a, final Number b,
			final int scale, final int precision) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(precision);
		dc.setMinimumFractionDigits(precision);

		dc.setMaximumIntegerDigits(scale);

		final String strA = dc.format(a);
		final String strB = dc.format(b);

		final BigDecimal numberA = new BigDecimal(strA);

		final BigDecimal numberB = new BigDecimal(strB);

		final BigDecimal retorno = numberA.multiply(numberB);

		retorno.setScale(5);

		return retorno;
	}

	/**
	 * Dividir dois numeros passado a precisão e casas decimais.
	 * 
	 * @author Aldivone Correia[aldivone@gmail.com] 29/01/2013 - 18:04:29.
	 * @param a
	 *            Primeiro numero.
	 * @param b
	 *            Segundo numero.
	 * @param scale
	 *            Tamanho do numero.
	 * @param precision
	 *            Casas decimais.
	 * 
	 * @return Valor calculado.
	 */
	private static BigDecimal div(final Number a, final Number b,
			final int scale, final int precision) {
		final NumberFormat dc = NumberFormat.getInstance(Locale.US);

		dc.setGroupingUsed(false);

		dc.setMaximumFractionDigits(precision);
		dc.setMinimumFractionDigits(precision);

		dc.setMaximumIntegerDigits(scale);

		final String strA = dc.format(a);
		final String strB = dc.format(b);

		final BigDecimal numberA = new BigDecimal(strA);
		final BigDecimal numberB = new BigDecimal(strB);

		final BigDecimal retorno = numberA.divide(numberB, precision,
				RoundingMode.HALF_UP);

		return retorno;
	}

	/**
	 * Retornar o valor
	 * 
	 * @author Valdenir Martins Melo J�nior[valdenir.melo@cagece.com.br]
	 *         01/02/2013 - 17:34:12.
	 * @param valor
	 * @return
	 */
	public static String valorFormatado(final Double valor) {
		String retorno = "0";

		final DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale(
				"pt", "BR"));

		final DecimalFormat df1 = new DecimalFormat("#,##0.00", dfs);

		retorno = df1.format(valor);

		return retorno;
	}

	public static void main(String[] args) {
		final Double vlrPis = NumberUtilsIntegracao.multiplicar(new Double(
				"0.04"), new Double("0.0096"), 5);

		Double novovlrpis = NumberUtilsIntegracao.truncarValor(vlrPis);

		System.out.println(novovlrpis);
	}

}
