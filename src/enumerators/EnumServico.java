package enumerators;

import servicos.*;

public enum EnumServico
{

	REVISAO_DE_DADOS_CADASTRAIS(1, "REVISAO DE DADOS CADASTRAIS",
			BtpSrv001RevisaoDadosCadastrais.class),

	ENTREGA_FATURA_ENDERECO_ALTERNATIVO(2,
			"ENTREGA DE FATURA EM ENDEREÇO ALTERNATIVO",
			BtpSrv002EntregaFaturaEnderecoAlternativo.class),

	VERIFICACAO_LIGACAO_AGUA_EXECUTADA_NAO_FATURADA(4,
			"VERIF. LIGAÇÃO ÁGUA EXECUTADA NÃO FATURADA",
			BtpSrv004VerificacaoLigacaoAguaExecutadaNaoFaturada.class),

	VERIFICACAO_LIGACAO_AGUA_FATURADA_NAO_EXECUTADA(5,
			"VERIF. LIGAÇÃO ÁGUA FATURADA NÃO EXECUTADA",
			BtpSrv005VerificacaoLigacaoAguaFaturadaNaoExecutada.class),

	VERIFICACAO_DADOS_CADASTRAIS(7, "VERIF. DADOS CADASTRAIS",
			BtpSrv007VerificacaoDadosCadastrais.class),

	CADASTRAMENTO_IMOVEL(11, "CADAST. IMÓVEL", BtpSrv011CadastramentoImovel.class),

	CORTE_POR_INFRACAO(12, "CORTE POR INFRAÇÃO", BtpSrv012CortePorInfracao.class),

	SUPRESSAO_RAMAL_PREDIAL(13, "SUPRESSÃO RAMAL PREDIAL",
			BtpSrv013SupressaoRamalPredial.class),

	VERIFICACAO_FONTE_PROPRIA_ABASTECIMENTO(14,
			"VERIFICAÇÃO FONTE PROPRIA ABASTECIMENTO",
			BtpSrv014VerificacaoFontePropriaAbastecimento.class),

	CONFIRMACAO_DA_EXECUCAO_DO_CORTE(15, "CONFIRMAÇÃO EXEC. DE CORTE",
			BtpSrv015ConfirmacaoExecucaoCorte.class),

	VERIFICACAO_DUPLICIDADE_INSCRICAO(16, "VERIF. DUPLICIDADE DE INSCRIÇÃO",
			BtpSrv016VerificacaoDuplicidadeInscricao.class),

	SUSPENSAO_FATURAMENTO_ESGOTO(17, "SUSPENSÃO FAT. ESGOTO",
			BtpSrv017SuspensaoFaturamentoEsgoto.class),

	REATIVACAO_FATURAMENTO_ESGOTO(18, "REATIVAÇÃO FAT. ESGOTO",
			BtpSrv018ReativacaoFaturamentoEsgoto.class),

	TRANSFERENCIA_DE_LIGACAO_DE_AGUA(19, "TRANSF. LIG. DE ÁGUA",
			BtpSrv019TransferenciaLigacaoAgua.class),

	VERIFICACAO_CONSUMO_MEDIDO(21, "VERIF. CONSUMO MEDIDO",
			BtpSrv021VerificacaoConsumoMedido.class),

	VERIFICACAO_DE_VALORES_LANCADOS_NA_FATURA(22,
			"VERIF. VALORES LANCADOS NA FATURA",
			BtpSrv022VerificacaoValoresLancadosNaFatura.class),

	VERIFICACAO_DO_NAO_RECEBIMENTO_FATURA(23,
			"VERIF. DO NÃO RECEBIMENTO DA FATURA",
			BtpSrv023VerificacaoDoNaoRecebimentoFatura.class),

	ALTERACAO_DE_TITULARIDADE(27, "ALTERAÇÃO DE TITULARIDADE",
			BtpSrv027AlteracaoTitularidade.class),

	SUPRESSAO_PARA_LIGACAO_SUPRIMIDA(37, "SUPRESSÃO PARA LIGAÇÃO SUPRIMIDA",
			BtpSrv037SupressaoParaLigacaoSuprimida.class),

	CORTE_POR_DEBITO(46, "CORTE POR DEBITO", BtpSrv046CortePorDebito.class),

	LIGACAO_ESGOTO_PARCERIA(52, "LIG. ESGOTO RAMAL PARCERIA",
			BtpSrv052LigacaoEsgotoRamalParceria.class),

	CARTA_ANUENCIA(55, "EMISSAO DE CARTA DE ANUÊNCIA",
			BtpSrv055EmissaoCartaAnuencia.class),

	SEGUNDA_VIA(61, "EMISSÃO DE SEGUNDA VIA", BtpSrv061EmissaoSegundaVia.class),

	CERTIDAO_NEGATIVA(62, "CERTIDÃO NEGATIVA",
			BtpSrv062EmissaoCertidaoNegativa.class),

	LIGACAO_ESGOTO(65, "LIGAÇÃO DE ESGOTO", BtpSrv065LigacaoEsgoto.class),

	SUBSTITUICAO_LIGACAO_AGUA(66, "SUBSTITUICAO DE LIGACAO DE AGUA",
			BtpSrv066SubstituicaoDeLigacaoAgua.class),

	RETIRADA_HIDROMETRO(68, "RETIRADA DE HIDRÔMETRO",
			BtpSrv068RetiradaHidrometro.class),

	INSTALACAO_DE_HIDROMETRO(69, "INSTALAÇÃO DE HIDRÔMETRO",
			BtpSrv069InstalacaoHidrometro.class),

	VERIFICACAO_DE_HIDROMETRO(70, "VERIFICAÇÃO DE HIDRÔMETRO",
			BtpSrv070VerificacaoHidrometro.class),

	SUBSTITUICAO_DE_HIDROMETRO_MANUTENCAO(71, "SUBSTITUIÇÃO DE HIDRÔMETRO",
			BtpSrv071SubstituicaoHidrometro.class),

	DESLOCAMENTO_HIDROMETRO_KIT_CAVALETE(72, "DESLOC.KIT CAVALETE",
			BtpSrv072DeslocamentoHidrometroKitCavalete.class),

	CONSERTO_VAZAMENTO_LIGACAO_PREDIAL(74,
			"CONSERTO DE VAZAMENTO DE LIGAÇÃO PREDIAL",
			BtpSrv074ConsertoVazamentoLigacaoPredial.class),

	CONSERTO_VAZAMENTO_REDE(75, "CONSERTO DE VAZAMENTO DE REDE",
			BtpSrv075ConsertoVazamentoRede.class),

	RECLAMACAO_DE_FALTA_DAGUA_NO_IMOVEL(76, "RECLAMAÇÃO DE FALTA DE ÁGUA",
			BtpSrv076ReclamacaoFaltaDagua.class),

	DESOBSTRUCAO_REDE_ESGOTO(77, "DESOBSTRUÇÃO DE REDE DE ESGOTO",
			BtpSrv077DesobstrucaoRedeEsgoto.class),

	COLETA_ANALISE_AGUA(78, "COLETA E ANALISE DE ÁGUA",
			BtpSrv078ColetaAnaliseDeAgua.class),

	COLETA_ANALISE_ESGOTO(79, "COLETA E ANALISE DE ESGOTO",
			BtpSrv079ColetaAnaliseDeEsgoto.class),

	ANALISE_AGUA(80, "ANALISE DE ÁGUA", BtpSrv080AnaliseDeAgua.class),

	TAMPONAMENTO_LIGACAO_ESGOTO(82, "TAMPONAMENTO DA LIGAÇÃO DE ESGOTO",
			BtpSrv082TamponamentoLigacaoEsgoto.class),

	SOLICITACAO_DE_CORTE(83, "CORTE SOLICITADO", BtpSrv083SolicitacaoCorte.class),

	RELIGACAO_DE_AGUA(84, "RELIGAÇÃO DE AGUA", BtpSrv084ReligacaoAgua.class),

	INSTALACAO_HIDROMETRO_POCO(85, "INSTALAÇÃO DE HIDROMETRO EM POCO",
			BtpSrv085InstalacaoHidrometroEmPoco.class),

	CONSERTO_NA_CAIXA_DO_HIDROMETRO(86, "CONSERTO NA CAIXA DE HIDRÔMETRO",
			BtpSrv086ConsertoCaixaHidrometro.class),

	MEDICAO_PRESSAO_REDE_AGUA(87, "MEDIÇÃO DE PRESSÃO DA REDE ÁGUA",
			BtpSrv087MedicaoPressaoRedeAgua.class),

	SUBSTITUICAO_KIT_CAVALETE(90, "SUBSTITUIÇÃO KIT CAVALETE",
			BtpSrv090SubstituicaoKitCavalete.class),

	MANUTENCAO_HIDROMETRO_TERCEIROS(91, "MANUTENÇÃO DE HIDROMETRO DE TERCEIROS",
			BtpSrv091ManutencaoHidrometroTerceiros.class),

	CONSERTO_VAZAMENTO_KIT_CAVALETE(95, "CONSERTO VAZAMENTO KIT CAVALETE",
			BtpSrv095ConsertoVazamentoKitCavalete.class),

	RECUPERACAO_DO_PAVIMENTO(96, "RECUPERAÇÃO PAVIMENTO",
			BtpSrv096RecuperacaoPavimento.class),

	RECUPERACAO_DO_PASSEIO(97, "RECUPERAÇÃO PASSEIO",
			BtpSrv097RecuperacaoPasseio.class),

	DESOBSTRUCAO_LIGACAO_ESGOTO(98, "DESOBSTRUÇÃO DA LIGAÇÃO DE ESGOTO",
			BtpSrv098DesobstrucaoLigacaoEsgoto.class),

	SUBST_LIGACAO_DE_AGUA_COM_ALTERACAO_DE_DIAMETRO(100,
			"SUB. LIG.AGUA C/ALT.DIAM.",
			BtpSrv100SubstLigacaoAguaComAlteracaoDiametro.class),

	SUBST_LIGACAO_DE_ESGOTO_COM_ALTERACAO_DE_DIAMETRO(101,
			"SUB. LIG.ESG.C/ALT.DIAM.",
			BtpSrv101SubstLigacaoEsgotoComAlteracaoDiametro.class),

	RECOLOCACAO_DO_TAMPAO_DO_POCO_DE_VISITA(103,
			"RECOLOCAÇÃO DE TAMPÃO EM POÇO DE VISITA",
			BtpSrv103RecolocacaoTampaoPocoVisita.class),

	DESOBSTRUCAO_DE_FERRULE(104, "DESOBSTRUÇÃO DE FERRULE",
			BtpSrv104DesobstrucaoFerrule.class),

	DESOBSTRUCAO_REDE_AGUA(105, "DESOBSTRUÇÃO DA REDE DE ÁGUA",
			BtpSrv105DesobstrucaoRedeAgua.class),

	DESCARGA_NA_REDE_DE_AGUA(106, "DESCARGA NA REDE DE ÁGUA",
			BtpSrv106RealizacaoDescargaRedeAgua.class),

	VERIFICACAO_POSSIB_EXEC_LIGACAO(107, "VER. POSSIB. EXECUCAO LIGAÇÃO",
			BtpSrv107VerificacaoPossibilidadeExecucaoLigacao.class),

	SUBSTITUICAO_DA_CAIXA_DO_HIDROMETRO(110, "SUB. CAIXA DE HIDRÔMETRO",
			BtpSrv110SubstCaixaHidrometro.class),

	SELAGEM_DE_HIDROMETRO(111, "SELAGEM DE HIDRÔMETRO",
			BtpSrv111SelagemHidrometro.class),

	SUPRESSAO_LIGACAO_CORTADA(112, "SUPRESSÃO PARA LIGAÇÃO CORTADA",
			BtpSrv112SupressaoLigacaoCortada.class),

	RECUPERACAO_CAIXA_DE_INSPECAO_DANIFICADA(115,
			"RECUPERAÇÃO DA CAIXA DE INSPEÇÃO DANIFICADA",
			BtpSrv115RecuperacaoCaixaInspecao.class),

	RETIRADA_DE_FUGA(116, "RETIRADA DE FULGA", BtpSrv116RetiradaFulga.class),

	NIVELAMENTO_DO_POCO_DE_VISITA(117, "NIVELAMENTO DE POÇO DE VISITA",
			BtpSrv117NivelamentoPocoVisita.class),

	LIMPEZA_DO_POCO_DE_VISITA(118, "LIMPEZA DE POÇO DE VISITA",
			BtpSrv118LimpezaPocoVisita.class),

	VENDA_AGUA_GRANEL_CARRO_PIPA(125, "VENDA DE ÁGUA A GRANEL EM CARRO PIPA",
			BtpSrv125VendaAguaGranelCarroPipa.class),

	ESTUDO_VIABILIDADE_TECNICA_PROJETO_AGUA(127,
			"ESTUDO DE VIABILIDADE TÉCNICA PROJETO ÁGUA",
			BtpSrv127EstudoViabilidadeTecnicaProjetoAgua.class),

	SONDAGEM_EM_CAMPO_DE_REDE_AGUA(131, "SONDAGEM EM CAMPO DE REDE DE ÁGUA",
			BtpSrv131SondagemCampoRedeAgua.class),

	SONDAGEM_EM_CAMPO_DE_REDE_ESGOTO(134, "SONDAGEM EM CAMPO DE REDE DE ESGOTO",
			BtpSrv134SondagemCampoRedeEsgoto.class),

	REFATURAMENTO(137, "REFATURAMENTO", BtpSrv137Refaturamento.class),

	DESTAMPONAMENTO_LIGACAO_ESGOTO(138, "DESTAMPONAMENTO DE LIGACAO DE ESGOTO",
			BtpSrv138DestamponamentoLigacaoEsgoto.class),

	AMPLIACAO_REDE_ESGOTO(140, "AMPLIACAO REDE  DE ESGOTO",
			BtpSrv140AmpliacaoRedeEsgoto.class),

	ALTERACAO_LIGACAO_DE_ESGOTO(149, "ALTERAÇÃO DE LIGAÇÃO DE ESGOTO",
			BtpSrv149AlteracaoLigacaoEsgoto.class),

	AVISO_TAMPONAMENTO(151, "AVISO DE TAMPONAMENTO",
			BtpSrv151AvisoDeTamponamento.class),

	TAMPONAMENTO_LIGACAO_TAMPONADA(152, "TAMPONAMENTO PARA LIGAÇÃO TAMPONADA",
			BtpSrv152TamponamentoParaLigacaoTamponada.class),

	VERIF_REDUCAO_CONSUMO(157, "VERIFICAÇÃO REDUÇÃO CONSUMO",
			BtpSrv157VerificacaoReducaoConsumo.class),

	RECEBIMENTO_ANTECIPADO(167, "RECEBIMENTO ANTECIPADO",
			BtpSrv167RecebimentoAntecipado.class),

	SISTEMA_MEDICAO_ESGOTO(174, "SISTEMA MEDIÇÃO ESGOTO",
			BtpSrv174SistemaMedicaoEsgoto.class),

	INSTALACAO_HIDRANTE(175, "INSTALAÇÃO DE HIDRANTE",
			BtpSrv175InstalacaoHidrante.class),

	FINANCIAMENTO_BANHEIRO(179, "FINANCIAMENTO DE BANHEIRO",
			BtpSrv179FinanciamentoDeBanheiro.class),

	INTERLIGACAO_DE_ESGOTO(186, "INTERLIGAÇÃO DE ESGOTO",
			BtpSrv186VerificacaoInterligacaoEsgoto.class),

	VERIFICAO_DE_IRREGULARIDADES(188, "VER. DE IRREGULARIDADES",
			BtpSrv188VerificacaoIrregularidade.class),

	LIGACAO_ESGOTO_FINANCIAMENTO_CAGECE(190, "LIG.DE ESG.FIN.CAGECE",
			BtpSrv190LigacaoEsgotoFinancCagece.class),

	INTERLIGACAO_DE_ESGOTO_FINANCIAMENTO_CAGECE(191,
			"INTERLIGAÇÃO DE ESGOTO FINANCIAMENTO CAGECE",
			BtpSrv191InterligacaoEsgotoFinanciamentoCagece.class),

	ARR_LIGACAO_AGUA_EXERC(214, "ARR. LIGAÇÃO ÁGUA EXERC",
			BtpSrv214ArrLigacaoAguaExerc.class),

	ARR_ACRESC_IMPONT_EXERC(215, "ARR. ACRESC IMPONT EXERC",
			BtpSrv215ArrAcrescImpontExerc.class),

	ARR_RELIGACAO_SANCOES_EXERC(216, "ARR RELIGAÇÃO SANÇÕES EXERC",
			BtpSrv216ArrReligacaoSancoesExerc.class),

	ARR_SERV_HIDROM_EXERC(217, "ARR SERVIÇO HIDROMETRO EXERC",
			BtpSrv217ArrServicoHidrometroExerc.class),

	MEDICAO_VAZAO_REDE_AGUA(233, "MEDIÇÃO DE VAZÃO DA REDE DE ÁGUA",
			BtpSrv233MedicaoVazaoRedeAgua.class),

	PARCELAMENTO_DE_DEBITO(257, "PARCELAMENTO DE DÉBITO",
			BtpSrv257TransferenciaDebito.class),

	LIGACAO_DE_AGUA_PARA_INSTALACAO_DE_HIDROMETRO_PARA_SUPRIMIDA(260,
			"LIG.AGUA C/ INSTAL.HIDRÔMETRO P/SUPRIMIDA",
			BtpSrv260LigacaoAguaInstHidrometroSuprimida.class),

	LIGACAO_DE_AGUA_PARA_INSTALACAO_DE_HIDROMETRO(262,
			"LIG.AGUA C/ INSTAL.HIDROMETRO", BtpSrv262LigacaoAguaInstHidrometro.class),

	INSTALACAO_SISTEMA_ALTERNATIVO_MEDICAO(266,
			"INSTALAÇÃO DE SISTEMA ALTERNATIVO DE MEDIÇÃO",
			BtpSrv266InstalacaoSistemaAlternativoMedicao.class),

	RETIRADA_SISTEMA_ALTERNATIVO_MEDICAO(267,
			"RETIRADA DE SISTEMA ALTERNATIVO DE MEDIÇÃO",
			BtpSrv267RetiradaSistemaAlternativoMedicao.class),

	ALTERACAO_HIDROMETRO_INSTALADO(269, "ALTERAÇÃO PARA HIDROMETRO INSTALADO",
			BtpSrv269AlteracaoHidrometroInstalado.class),

	OUTRAS_RECLAMACOES_ELOGIOS_SUGESTOES_CRITICAS(272, "OUTRAS RECLAMAÇÕES",
			BtpSrv272OutrasReclamacoesElogiosSugestoes.class),

	SUBSTITUICAO_DE_HIDROMETRO_ROUBADO(278, "SUBSTITUICAO HID. ROUBADO",
			BtpSrv278SubstituicaoHidrometroRoubado.class),

	RELIGACAO_URGENTE_DE_AGUA(284, "RELIGACAO URGENTE",
			BtpSrv284ReligacaoAgua.class),

	SUBSTITUICAO_HIDROMETRO_VERIFICACAO(288,
			"SUBSTITUIÇÃO DE HIDROMETRO PARA VERIFICAÇÃO",
			BtpSrv288SubstituicaoHidrometroParaVerificacao.class),

	SUBSTITUICAO_HIDROMETRO_PESQUISA(289,
			"SUBSTITUIÇÃO DE HIDROMETRO PARA PESQUISA",
			BtpSrv289SubstituicaoHidrometroParaPesquisa.class),

	TRANFERENCIA_DE_DEBITO(290, "TRANSF. DE DÉBITO",
			BtpSrv290TransferenciaDebito.class),

	VERIFICACAO_CONSUMO_ELEVADO(295, "VERIFICAÇÃO CONSUMO ELEVADO",
			BtpSrv295VerificacaoConsumoElevado.class),

	VERIFICACAO_DE_BAIXA_PRESSAO(303, "VER. BAIXA PRESSÃO",
			BtpSrv303VerificacaoBaixaPressao.class),

	VENCIMENTOS_OPCIONAIS(312, "VENCIMENTOS OPCIONAIS",
			BtpSrv312VencimentoOpcional.class),

	DEVOLUCAO_DE_VALORES(313, "DEVOLUÇÃO DE VALORES",
			BtpSrv313DevolucaoValores.class),

	REGULARIZACAO_DE_FRAUDE(321, "REGULARIZAÇÃO FRAUDE",
			BtpSrv321RegularizacaoFraude.class),

	SERVICOS_LABORATORIAIS_AGUA(327, "SERVIÇOS LABORATORIAIS ÁGUA",
			BtpSrv327ServicosLaboratoriaisAgua.class),

	SERVICOS_LABORATORIAIS_ESGOTO(328, "SERVIÇOS LABORATORIAIS ESGOTO",
			BtpSrv328ServicosLaboratoriaisEsgoto.class),

	SUPRESSAO_LIGACAO_CLANDESTINA(331, "SUPRESSÃO PARA LIGAÇÃO CLANDESTINA",
			BtpSrv331SupressaoLigacaoClandestina.class),

	ANALISE_PREVENTIVA_GRANDES_CLIENTES(334,
			"ANALISE E VISITA PREVENTIVA DE GRANDES CLIENTES",
			BtpSrv334VisitaPreventivaGrandesClientes.class),

	ANALISE_PREVENTIVA_GRANDES_CONSUMIDORES(335,
			"ANALISE E VISITA PREVENTIVA DE GRANDES CONSULMIDORES",
			BtpSrv335VisitaPreventivaGrandesConsumidores.class),

	INTERVENCAO_ASFALTICA(337, "INTERVENÇÃO ASFÁLTICA PARA EXECUÇÃO DE SERVIÇO",
			BtpSrv337IntervencaoAsfaltica.class),

	REVISAO_CALCULO_TARIFA_CONTIGENCIA(339,
			"REVISÃO DE MEDIA CALCULO DA TARIFA DE CONTIGENCIA",
			BtpSrv339RevisaoCalculoTarifaDeContigencia.class),

	FISCALIZACAO_SEGURANCA_HIDRICA(351,
			"FISCALIZACAO PLANO DE SEGURANCA HIDRICA",
			BtpSrv351SegurancaHidrica.class),

	NENHUM(0, "NENHUM", null);

	private final Integer codigo;

	private final String nome;

	private final Class<?> classe;

	EnumServico(final Integer codigo, final String nome, final Class<?> classe)
	{
		this.codigo = codigo;
		this.nome = nome;
		this.classe = classe;
	}

	public Integer getCodigo()
	{
		return codigo;
	}

	public String getNome()
	{
		return nome;
	}

	public static EnumServico valueOf(final Integer codigo)
	{

		EnumServico result = null;

		final EnumServico[] values = EnumServico.values();

		for (final EnumServico enumServicos : values)
		{

			if ( enumServicos.codigo.equals(codigo) )
			{
				result = enumServicos;
				break;
			}

		}

		return result;
	}

	public Class<?> getClasse()
	{
		return classe;
	}

}
