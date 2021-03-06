package auxiliares;

import org.openqa.selenium.Capabilities;

import pages.AcessoPage;
import pages.AtendimentoPage;
import pages.ItemAtendimentoPage;
import pages.MenuPage;
import enumerators.EnumServidorTeste;
import frames.FramePrincipalPage;

public class BaseVars
{

	public static EnumServidorTeste servidor = EnumServidorTeste.DESENVOLVIMENTO_72;

	protected static String baseUrl = servidor.getUrl();

	protected static AcessoPage acessoPage;

	public static AtendimentoPage atendimentoPage;

	public static FramePrincipalPage framePrincipal;

	protected static ItemAtendimentoPage itemAtendimentoPage;

	public static MenuPage menuPage;

	protected static Capabilities capabilities;

	protected static final String MSG_TELA_ATENDIMENTO_ERRO = "Tela de registrar atendimento com erros ";

	public static final String MSG_GEFAR_INTERNO = "Somente usuários internos com permissão da GEFAR podem registrar o serviço.";

	public static final String MSG_VENC_OPC_ORGAO_PUBLICO = "Não é permitido gravar vencimento opcional para órgãos publicos.";

	protected static final String MSG_MULTA_INFRACAO = "Existe multa por infração ainda não negociada para a inscrição: ";

	public static final String PESSOA_FISICA = "PESSOA FÍSICA";

	public static final String PESSOA_JURIDICA = "PESSOA JURÍDICA";

	public static final String ORGAO_PUBLICO_CAPITAL = "ÓRGÃO PUBLICO DA CAPITAL";

	public static final String ORGAO_PUBLICO_INTERIOR = "ÓRGÃO PUBLICO DO INTERIOR";

	public static final String TIPO_REINCIDENTE = "REINCIDENTE";

}
