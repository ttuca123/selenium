package enumerators;

public enum EnumTipoExperiencia
{
	BANCO_DE_DADOS (0, "BANCO DE DADOS"),

	CONTROLE_DE_VERSAO (1, "CONTROLE DE VERSÃO"),

	OUTROS (2, "OUTROS");

	
	private final Integer codigo;

	private final String nomeAmigavel;

	EnumTipoExperiencia(final Integer letra, final String nomeAmigavel) {
		this.codigo = letra;
		this.nomeAmigavel = nomeAmigavel;
	}

	public Integer getLetra() {
		return codigo;
	}

	public String getNomeAmigavel() {
		return nomeAmigavel;
	}

	public static EnumTipoExperiencia valueOf(final Integer letra) {
		EnumTipoExperiencia result = null;

		final EnumTipoExperiencia[] values = EnumTipoExperiencia.values();

		for (final EnumTipoExperiencia enumTipoExperiencia : values) {
			if (enumTipoExperiencia.codigo.equals(letra)) {
				result = enumTipoExperiencia;
				break;
			}
		}
		return result;
	}

	public static EnumTipoExperiencia valueOf(final int ordinal) {
		EnumTipoExperiencia result = null;

		final EnumTipoExperiencia[] values = EnumTipoExperiencia.values();

		for (final EnumTipoExperiencia enumTipoExperiencia : values) {
			if (enumTipoExperiencia.ordinal() == ordinal) {
				result = enumTipoExperiencia;
				break;
			}
		}
		return result;
	}

	public int getOrdinal() {
		return ordinal();
	}

}
