package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import enumerators.EnumSituacao;

@Entity
@Table(name = "CAT_CASO_TESTE")
public class BtpCasoTeste implements Serializable
{

	private static final long serialVersionUID = -8920281763742948821L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CAT_SEQ_CASO_TESTE")
	private Long catSeqCasoTeste;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "servico", referencedColumnName = "id")
	private BtpServico servico;

	@Column(name = "id_caso")
	private String idCaso;

	@Column(name = "CAT_DSC_CASO_TESTE")
	private String descricao;

	@Column(name = "CAT_INSTRUCAO_SQL")
	private String sqlInstrucao;

	@Column(name = "CAT_DSC_ENTRADAS")
	private String dadosEntrada;

	@Column(name = "CAT_NOM_CLASSE")
	private String catNomClasse;

	@Column(name = "CAT_CRIT_ACEITACAO")
	private String criteriosAceitacao;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "CAT_FLG_SITUACAO")
	private EnumSituacao catFlgSituacao;

	public Long getCatSeqCasoTeste()
	{
		return catSeqCasoTeste;
	}

	public void setCatSeqCasoTeste(Long catSeqCasoTeste)
	{
		this.catSeqCasoTeste = catSeqCasoTeste;
	}

	public String getCatNomClasse()
	{
		return catNomClasse;
	}

	public void setCatNomClasse(String catNomClasse)
	{
		this.catNomClasse = catNomClasse;
	}

	public BtpServico getServico()
	{
		return servico;
	}

	public void setServico(BtpServico servico)
	{
		this.servico = servico;
	}

	public String getIdCaso()
	{
		return idCaso;
	}

	public void setIdCaso(String idCaso)
	{
		this.idCaso = idCaso;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public String getSqlInstrucao()
	{
		return sqlInstrucao;
	}

	public void setSqlInstrucao(String sqlInstrucao)
	{
		this.sqlInstrucao = sqlInstrucao;
	}

	public boolean getIsSqlInstrucao()
	{
		return sqlInstrucao.length() > 0;
	}

	public boolean getIsDadosEntrada()
	{
		return dadosEntrada.length() > 0;
	}

	public boolean getIsCriteriosAceitacao()
	{
		return criteriosAceitacao.length() > 0;
	}

	public String getCriteriosAceitacao()
	{
		return criteriosAceitacao;
	}

	public String getDadosEntrada()
	{
		return dadosEntrada;
	}

	public void setCriteriosAceitacao(String criteriosAceitacao)
	{
		this.criteriosAceitacao = criteriosAceitacao;
	}

	public void setDadosEntrada(String dadosEntrada)
	{
		this.dadosEntrada = dadosEntrada;
	}

	public EnumSituacao getCatFlgSituacao()
	{
		return catFlgSituacao;
	}

	public void setCatFlgSituacao(EnumSituacao catFlgSituacao)
	{
		this.catFlgSituacao = catFlgSituacao;
	}

}
