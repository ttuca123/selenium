package pages.bci;

/**
 * @author Desconhecido Jun 22, 2010 - 9:01:10 AM.
 */

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe responsável para trocar os caracteres acentuados e cedilha de um
 * texto.
 * 
 * @author Desconhecido Jun 22, 2010 - 9:01:10 AM.
 */
public final class SpecialCharFilter
{

	private static String[] REPLACES = { "a", "e", "i", "o", "u", "c", "A", "E",
			"I", "O", "U", "C", " " };

	private static Pattern[] PATTERNS;

	static
	{
		PATTERNS = new Pattern[REPLACES.length];

		PATTERNS[0] = Pattern.compile("[âãáàä]", Pattern.CASE_INSENSITIVE);
		PATTERNS[1] = Pattern.compile("[éèêë]", Pattern.CASE_INSENSITIVE);
		PATTERNS[2] = Pattern.compile("[íìîï]", Pattern.CASE_INSENSITIVE);
		PATTERNS[3] = Pattern.compile("[óòôõö]", Pattern.CASE_INSENSITIVE);
		PATTERNS[4] = Pattern.compile("[úùûü]", Pattern.CASE_INSENSITIVE);
		PATTERNS[5] = Pattern.compile("[ç]", Pattern.CASE_INSENSITIVE);
		PATTERNS[6] = Pattern.compile("[âãáàä]".toUpperCase(),
				Pattern.CASE_INSENSITIVE);
		PATTERNS[7] = Pattern.compile("[éèêë]".toUpperCase(),
				Pattern.CASE_INSENSITIVE);
		PATTERNS[8] = Pattern.compile("[íìîï]".toUpperCase(),
				Pattern.CASE_INSENSITIVE);
		PATTERNS[9] = Pattern.compile("[óòôõö]".toUpperCase(),
				Pattern.CASE_INSENSITIVE);
		PATTERNS[10] = Pattern.compile("[úùûü]".toUpperCase(),
				Pattern.CASE_INSENSITIVE);
		PATTERNS[11] = Pattern.compile("[ç]".toUpperCase(),
				Pattern.CASE_INSENSITIVE);
		PATTERNS[12] = Pattern.compile("[°ºª¿']".toUpperCase(),
				Pattern.CASE_INSENSITIVE);

	}

	private static Pattern[] PATTERNS_NUMBER;

	private static String NUMBER = "^[0-9]*$";

	/**
	 * !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
	 */
	private static String PUNCT = "\\p{Punct}";

	private static String DIGIT = "\\p{Digit}";

	private static String ESPECIAL = "[¬¹²³£¢¬øþ´ªæßµºº«»©§®ð]";

	private static String[] REPLACES_NUMBER = { "", "", "", "" };

	private static String LETRA = "[a-zA-Z]";

	static
	{
		PATTERNS_NUMBER = new Pattern[REPLACES_NUMBER.length];

		PATTERNS_NUMBER[0] = Pattern.compile("[.]", Pattern.CASE_INSENSITIVE);
		PATTERNS_NUMBER[1] = Pattern.compile("[,]", Pattern.CASE_INSENSITIVE);
		PATTERNS_NUMBER[2] = Pattern.compile("[-]", Pattern.CASE_INSENSITIVE);
		PATTERNS_NUMBER[3] = Pattern.compile("[_]", Pattern.CASE_INSENSITIVE);
	}

	/**
	 * Remover os caracteres acentuados e cedilha.
	 * 
	 * @author Aldivone Correia[aldivone@gmail.com] Jun 22, 2010 - 9:44:48 AM.
	 * @param text
	 *          Texto para remoção.
	 * @return Texto sem acentos e cedilha.
	 */
	public static String replaceSpecialChar(final String text)
	{
		if ( text != null && text.trim().length() > 0 )
		{
			String result = text;

			for (int i = 0; i < PATTERNS.length; i++)
			{
				final Matcher matcher = PATTERNS[i].matcher(result);

				final String charParaReplace = REPLACES[i];

				result = matcher.replaceAll(charParaReplace);
			}

			return result;
		}
		return null;
	}

	/**
	 * Remove os carateres de acordo com o enum:ACENTO: Permite todos os
	 * caracteres; CONSULTA:Permite todos os caracteres menos o %";REMOVE: remove
	 * todos os caracteres
	 * 
	 * @author Dirceu da Silva [dirceu.rodrigues@cagece.com.br -
	 *         dirceusr@gmail.com] 04/02/2013 - 16:33:47.
	 * @param text
	 * @param tipoSpecialChar
	 * @return
	 */
	public static String replaceSpecialChar(final String text,
			EnumTipoSpecialChar tipoSpecialChar)
	{
		if ( text != null && text.trim().length() > 0 )
		{
			String result = text;

			tipoSpecialChar = tipoSpecialChar == null ? EnumTipoSpecialChar.REMOVE
					: tipoSpecialChar;

			switch (tipoSpecialChar)
			{
				case ACENTO:

					break;
				case CONSULTA:
					result = result.replace("%", "");

					break;
				case REMOVE:
					result = replaceSpecialChar(text);
					result = replaceCharSpecial(result);
					break;
			}
			return result;
		}
		return text;
	}

	/**
	 * Remove os caracteres especiais
	 * 
	 * @author Dirceu da Silva [dirceu.rodrigues@cagece.com.br -
	 *         dirceusr@gmail.com] 30/01/2013 - 17:34:27.
	 * @param text
	 * @return
	 */
	public static String replaceCharSpecial(final String text)
	{
		if ( text != null && text.trim().length() > 0 )
		{
			String result = text;

			result = Normalizer.normalize(result, Normalizer.Form.NFD);
			result = result.replaceAll("[^\\p{ASCII}]", "");
			result = result.replaceAll("[\\p{Punct}]", "");

			return result;
		}
		return null;
	}

	public static String removeSpecialChar(final String text)
	{
		if ( text != null && text.trim().length() > 0 )
		{
			String result = text;

			result = Normalizer.normalize(result, Normalizer.Form.NFD);
			result = result.replaceAll("[^\\p{ASCII}]", "");
			result = result.replaceAll("[\\p{Punct}]", "");
			result = result.replaceAll("[\\p{Digit}]", "");

			return result;
		}
		return null;
	}

	public static String removeSpecialNumero(final String text)
	{
		if ( text != null && text.trim().length() > 0 )
		{
			String result = text;
			result = result.replaceAll("\\D", "");
			return result;

		}

		return null;
	}

	/**
	 * Retorna uma string onde a letra inicial de cada palavra é passada para
	 * maiúscula.
	 * 
	 * @author Dirceu da Silva [dirceu.rodrigues@cagece.com.br -
	 *         dirceusr@gmail.com] 02/08/2013 - 10:43:12.
	 * @param str
	 * @return
	 */
	public static String capitalize(final String str)
	{
		final char[] letras = str.toCharArray();
		for (int i = 0; i < letras.length; ++i)
		{
			if ( i == 0 || !Character.isLetterOrDigit(letras[i - 1]) )
			{
				letras[i] = Character.toUpperCase(letras[i]);
			}
		}
		return new String(letras);
	}

	public static boolean existeLetra(final String texto)
	{
		final Pattern p = Pattern.compile(LETRA);

		final boolean retorno = p.matcher(texto).find();

		return retorno;
	}

	/**
	 * Remover os caracteres de um número que não seja número de acordo com o
	 * padrão previamente cadastrado.
	 * 
	 * @author Aldivone Correia[aldivone@gmail.com] Jun 22, 2010 - 9:44:48 AM.
	 * @param text
	 *          Texto para remoção.
	 * @return Número sem separação de decimais.
	 */
	public static String replaceSpecialNumber(final String text)
	{
		if ( text != null && text.trim().length() > 0 )
		{
			String result = text;

			for (int i = 0; i < PATTERNS_NUMBER.length; i++)
			{
				final Matcher matcher = PATTERNS_NUMBER[i].matcher(result);

				final String charParaReplace = REPLACES_NUMBER[i];

				result = matcher.replaceAll(charParaReplace);
			}

			return result;
		}
		return null;
	}

	/**
	 * 
	 * @author Dirceu da Silva [dirceu.rodrigues@cagece.com.br -
	 *         dirceusr@gmail.com] 09/03/2012 - 16:40:51.
	 * @param valor
	 * @return
	 */
	public static boolean somenteNumero(final String valor)
	{
		if ( valor.matches(NUMBER) )
		{
			return true;
		}
		return false;
	}

	public static boolean containsSpecialChar(final String valor)
	{
		final Pattern pattern = Pattern.compile("[" + PUNCT + DIGIT + ESPECIAL
				+ "]");
		final Matcher matcher = pattern.matcher(valor);

		return matcher.find();
	}

	/**
	 * Não critica a existência de Punct (barras, parênteses, hífens...)
	 * 
	 * @author Rodolfo Lopes [rodolfo.lopes@cagece.com.br] 15/12/2014 - 19:58:25.
	 * @param valor
	 * @return
	 */
	public static boolean containsSpecialCharWithoutPunct(final String texto)
	{
		if ( texto.length() != 0 )
		{
			final Pattern pattern = Pattern.compile("[" + DIGIT + ESPECIAL + "]");
			final Matcher matcher = pattern.matcher(texto);

			return matcher.find();
		}

		return false;
	}

	/**
	 *
	 * @author Rodolfo Lopes[rodolfo.lopes@gmail.com] 19/02/2015 - 11:18:43.
	 * @param valor
	 * @return
	 */
	public static boolean containsSpecialCharWithoutPunctAndDigit(
			final String texto)
	{
		if ( texto.length() != 0 )
		{
			final Pattern pattern = Pattern.compile("[" + ESPECIAL + "]");
			final Matcher matcher = pattern.matcher(texto);

			return matcher.find();
		}

		return false;
	}

}
