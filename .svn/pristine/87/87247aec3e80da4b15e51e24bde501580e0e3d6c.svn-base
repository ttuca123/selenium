package excessoes;

import enumerators.EnumTipoErro;

public class RegistrosInexistenteNaTeaException extends Exception
{

	private static final long serialVersionUID = 1L;

	public RegistrosInexistenteNaTeaException(String casoTeste)
	{
		super("Nenhum registro foi encontrado na TEA para o caso de Teste "
				.concat(casoTeste));
	}

	private EnumTipoErro tipoErro = EnumTipoErro.TEA;

	public EnumTipoErro getErro()
	{

		return tipoErro;
	}

}
