package enumerators;

/**
 * 
 * @since modelo - 2008.
 */
public enum EnumUsuario {
	
	ADMINISTRADOR("500130", "C@gece123"),

	ATENDENTE("500005", "35DZ6PoYd1L247ChrCXM"),

	ATENDENTE_DE_LOJA_0800("500006", "udkCxHe5fasXJAEoG4K8"),

	UNIDADE_DE_NEGOCIO_INTERNA("500007", "E5SLEKCJsz8pdwalANrd"),

	UNIDADE_DE_NEGOCIO("500007", "E5SLEKCJsz8pdwalANrd"),

	ATENDIMENTO_CENTRALIZADO_INTERNO("500007", "E5SLEKCJsz8pdwalANrd"),

	ATENDIMENTO_CENTRALIZADO("500008", "BxANEV1OJQ3OU9sjnzwe");

	private final String usuario;

	private final String senha;

	EnumUsuario(final String usuario, final String senha) {
		this.senha = senha;
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public String getUsuario() {
		return usuario;
	}

}
