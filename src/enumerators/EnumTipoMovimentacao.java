package enumerators;

public enum EnumTipoMovimentacao {
	RETIFICAR(0), 
	
	CANCELAR(1),
	
	COLOCAR_EM_REVISAO(2),
	
	TIRAR_DE_REVISAO(3), 
	
	ALTERAR_VENCIMENTO(4);
	

	private final Integer codigo;

	EnumTipoMovimentacao(final Integer cod) {
		this.codigo = cod;
	}

	public Integer getCodigo() {
		return codigo+1;
	}

}
