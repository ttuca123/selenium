package enumerators;

public enum EnumMotivoMovimentacao {
	ERRO_LEITURA(0),
	
	LEITURA_TROCADA(1),
	
	ERRO_NA_MEDIA(2),
	
	ERRO_DE_DIGITACAO(3),
	
	ERRO_DE_CATEGORIA(4),
	
	CONTROLE_DE_BAIXA(5),
	
	ERRO_NO_NUMERO_OU_TIPO_DE_ECONOMIAS(6),
	
	ERRO_TIPO_SERV_PRESTADO(7),
	
	ERRO_VALOR_SERV_PRESTADO(8),
	
	ERRO_PARCELAMENTO(9),
	
	ERRO_CONSUMO_PRESUMIDO(10),
	
	ERRO_TARIFA_FIXA_DE_ESGOTO(11),
	
	ERRO_DE_ARRASTO(12),
	
	COBRANCA_EM_DUPLICIDADE(13),
	
	VAZAMENTO_OCULTO(14),
	
	VAZAMENTO_NO_KIT_CAVALETE_APOS_HIDROMETRO(15),
	
	CREDITO_FINANCEIRO(16),
	
	ERRO_DE_PROCESSAMENTO(17),
	
	ALTERACAO_DE_DATA_DE_VENCIMENTO(18),
	
	COBRANCA_MULTA_JUROS_INDEVIDA(19),
	
	COBRANCA_ESGOTO_INDEVIDA(20),
	
	COBRANCA_SERVICO_EM_DUPLICIDADE(21),
	
	COBRANCA_DE_AGUA_CORTADA(22),
	
	COBRANCA_DE_AGUA_INDEVIDA(23),
	
	FATURAMENTO_INDEVIDO(24),
	
	HIDROMETRO_NAO_CADASTRADO(25),
	
	ERRO_DE_CADASTRO(26),
	
	SEGUNDA_VIA_DE_CONTA(27),
	
	SUSPENSAO_DO_ABASTECIMENTO(28),
	
	DUPLICIDADE_DE_CONTA(29),
	
	PAGAMENTO_NAO_CLASSIFICADO(30),
	
	DESCONFORMIDADE_NO_ABASTECIMENTO(31),
	
	AFERICAO_DE_HIDROMETRO_PROCEDENTE(32),
	
	INFLUENCIA_DO_AR_REDE_DE_DISTRIBUICAO(33),
	
	HIDROMETRO_SUBSTITUIDO(34),
	
	REVISAO_DE_FATURA(35),
	
	REVISAO_DE_CONSUMO_PRESUMIDO(36),
	
	REVISAO_DE_FATUR_DE_SERVICO(37),
	
	ALTO_ESTOURO_DE_CONSUMO(38),
	
	ERRO_NA_IMPLANTACAO_DE_FATURAMENTO(39),
	
	REVISAO_DE_DADOS_CADASTRAIS(40),
	
	REVISAO_DE_VALORES_LANC_EM_CONTA(41),
	
	REVISÃO_DO_END_DE_ENTREGA_DA_CONTA(42),
	
	DEBITO_EM_LITIGIO(43),
	
	FAIXA_ZERO_DE_CONSUMO(44),
	
	AGUARDANDO_INSTAL_SUBST_DO_HIDROMETRO(45),
	
	IMOVEL_SEM_AGUA_LIG_OBSTRUIDA(46),
	
	ERRO_NO_VALOR_DO_CONSUMO_INFORMADO(47),
	
	BAIXA_PARA_DEBITO_DE_PREFEITURAS(48),
	
	CAGECE_NOS_BAIRROS(49),
	
	FALTA_DAGUA(50),
	
	ENCONTRO_DE_CONTAS(51),
	
	DISTRIB_CONSUMO_AUSENCIA_LEITURA_ANTERIOR(52),
	
	DESCONTO_PROMOCIONAL(53),
	
	HIDROMETRO_INVERTIDO(54),
	
	COBRANCA_INDEVIDA_TAXA_EXCEDENTE(55),
	
	NEGOCIACAO_PARA_PARCELAMENTO(56),
	
	TRANSFERENCIA_DE_DEBITO(57),
	
	ENTRADA_PARCELAMENTO(58),
	
	RETIRADA_DE_REVISAO_DA_FATURA(59),
	
	CANCELAMENTO_DE_ESGOTO_NAO_INTERLIGADO(60),
	
	SISTEMA_DE_MEDICAO_DE_ESGOTO(61),
	
	PROJETO_DE_RECUPERACAO_DE_DEBITO(62),
	
	ANALISE_DE_PAGAMENTOS(63),
	
	LITIGIO_COM_LIMINAR(64),
	
	CAMPANHA_DO_PADRAO_BASICO(65),
	
	IMPEDIMENTO_DE_TAMPONAMENTO(66),
	
	TRANSFERENCIA_DE_DEBITO_(67),
	
	IMPEDIMENTO_DE_PROTESTO(68),
	
	IMPEDIMENTO_DE_CORTE(69),
	
	VIRADA_DE_HIDROMETRO(70),
	
	CANCELAMENTO_NO_ATENDIMENTO(71),
	
	PAGAMENTO_PARCIAL(72),
	
	AJUSTE_REGULADOR_CAGECE(73),
	
	NEGOCIACAO_PROCON(74);

	private final Integer codigo;

	EnumMotivoMovimentacao(final Integer cod) {
		this.codigo = cod;
	}

	public Integer getCodigo() {
		return codigo+1;
	}
	
}
