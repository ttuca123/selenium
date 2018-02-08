package servicos;

public class BtpSrv008VerificacaoLigacaoClandestinaAgua extends ServicoPadrao{

	@Override
	public void preencherDadosBaixa(ServicoPadrao servicoPadrao){
			
		preencheLaudo(servicoPadrao.getLaudo());	
 }
}
