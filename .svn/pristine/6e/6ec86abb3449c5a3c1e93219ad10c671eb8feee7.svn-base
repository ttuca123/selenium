package pages.bci;

import enumerators.EnumTipoEconomia;
import enumerators.EnumTipoPadrao;

public interface IBci
{

	public static final String QTD_BANHEIROS = "2";

	public static final String MSG_SUCESSO = "Padrão do imóvel e consumo presumido calculados com sucesso.";

	public static final String MSG_SEM_ECONOMIAS = "Economia / Categoria: deve ser preenchida; com os campos: Tipo e Quantidade ; para efetuar o calculo do padrão imóvel.";

	public void testDefinirPadraoVago();

	public void testDefinirSemEconomias();

	public void testDefinirComEmpateUmaEconomiaResidencial()
			throws InterruptedException;

	public void testDefinirEmpateComTresPadroesBRADuasEconomiasRegular()
			throws InterruptedException;

	public void testDefinirEmpateComTresPadroesBRMDuasEconomiasRegular()
			throws InterruptedException;

	public void testDefinirEmpateComTresPadroesBMADuasEconomiasMedio()
			throws InterruptedException;

	public void testDefinirEmpateComTresPadroesRMADuasEconomiasMedio()
			throws InterruptedException;

	public void testDefinirEmpateComDoisPadroesBRDuasEconomias()
			throws InterruptedException;

	public void testDefinirEmpateComDoisPadroesBMDuasEconomias()
			throws InterruptedException;

	public void testDefinirEmpateComDoisPadroesBADuasEconomias()
			throws InterruptedException;

	public void testDefinirEmpateComDoisPadroesRMDuasEconomias()
			throws InterruptedException;

	public void testDefinirEmpateComDoisPadroesRADuasEconomias()
			throws InterruptedException;

	public void testDefinirEmpateComDoisPadroesMADuasEconomias()
			throws InterruptedException;

	public void testDefinirEmpateComDoisPadroesBRDuasEconomiasPrecaria()
			throws InterruptedException;

	public void testDefinirEmpateComDoisPadroesBMDuasEconomiasPrecaria()
			throws InterruptedException;

	public void testDefinirEmpateComDoisPadroesBADuasEconomiasPrecaria()
			throws InterruptedException;

	public void testDefinirEmpateComDoisPadroesRMDuasEconomiasPrecaria()
			throws InterruptedException;

	public void testDefinirEmpateComDoisPadroesRADuasEconomiasPrecaria()
			throws InterruptedException;

	public void testDefinirEmpateComDoisPadroesMADuasEconomiasPrecaria()
			throws InterruptedException;

	public void selecionarDuasEconomias(EnumTipoEconomia economia1,
			EnumTipoEconomia economia2);

	public void finalizarCalculoPadrao(EnumTipoPadrao tipoPadrao);
}
