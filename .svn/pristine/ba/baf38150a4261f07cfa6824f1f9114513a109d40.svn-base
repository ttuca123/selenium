package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enumerators.EnumSituacaoSimNao;
import enumerators.EnumStatusDemanda;
import enumerators.EnumTipoDemanda;

@Entity
@Table(name = "DEM_DEMANDAS")
public class BtpDemanda implements Serializable
{
	private static final long serialVersionUID = 5486103235574819424L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEM_SEQ_DEMANDA")
	private Long demSeqDemanda;

	@ManyToOne
	@JoinColumn(name = "MOD_SEQ_MODULO")
	private BtpModulo btpModulo;

	@Column(name = "DEM_NUM_SGD")
	private Long demNumSGD;

	@ManyToOne
	@JoinColumn(name = "VER_SEQ_VERSAO")
	private BtpVersao btpVersao;

	@Column(name = "DEM_DSC_DEMANDA")
	private String demDscDemanda;

	@Column(name = "DEM_DSC_ENTRADAS")
	private String demDscEntradas;

	@Column(name = "DEM_CRIT_ACEITACAO")
	private String demCritAceitacao;

	@Column(name = "DEM_DSC_PROCEDIMENTO")
	private String demDscProcedimento;

	@Column(name = "DEM_INSTRUCAO_SQL")
	private String demInstrucaoSql;

	@Column(name = "DEM_DSC_CHAMADO")
	private String demDscChamado;

	@Column(name = "DEM_DSC_OBSERVACAO")
	private String demDscObservacao;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DEM_COD_STATUS")
	private EnumStatusDemanda demCodStatus;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DEM_COD_TIPO_DEMANDA")
	private EnumTipoDemanda demCodTipoDemanda;

	@Column(name = "DEM_DTA_EXECUCAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date demDataExecucao;

	@Column(name = "USU_SEQ_USUARIO")
	private String usuSeqUsuario;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DEM_FLG_EXTRA")
	private EnumSituacaoSimNao demFlgExtra;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DEM_FLG_EXIBIR_CHAMADO")
	private EnumSituacaoSimNao demFlgExibirChamado;

	@OneToMany(mappedBy = "btpDemanda", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	List<BtpInstrucaoSql> lstSQLs;

	@OneToMany(mappedBy = "btpDemanda", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	List<BtpDefeito> lstDefeitos;

	public BtpDemanda()
	{

	}

	public String getChamadoMudanca()
	{
		String imagem = "./images/informationgreen.png";
		if ( demFlgExibirChamado.equals(EnumSituacaoSimNao.SIM)
				&& demDscChamado.length() == 0 )
		{
			imagem = "./images/informationred.png";
		}
		return imagem;
	}

	public Long getDemSeqDemanda()
	{
		return demSeqDemanda;
	}

	public void setDemSeqDemanda(Long demSeqDemanda)
	{
		this.demSeqDemanda = demSeqDemanda;
	}

	public Long getDemNumSGD()
	{
		return demNumSGD;
	}

	public void setDemNumSGD(Long demNumSGD)
	{
		this.demNumSGD = demNumSGD;
	}

	public String getDemDscDemanda()
	{
		return demDscDemanda;
	}

	public void setDemDscDemanda(String demDscDemanda)
	{
		this.demDscDemanda = demDscDemanda;
	}

	public EnumStatusDemanda getDemCodStatus()
	{
		return demCodStatus;
	}

	public void setDemCodStatus(EnumStatusDemanda demCodStatus)
	{
		this.demCodStatus = demCodStatus;
	}

	public Date getDemDataExecucao()
	{
		return demDataExecucao;
	}

	public void setDemDataExecucao(Date demDataExecucao)
	{
		this.demDataExecucao = demDataExecucao;
	}

	public String getUsuSeqUsuario()
	{
		return usuSeqUsuario;
	}

	public void setUsuSeqUsuario(String usuSeqUsuario)
	{
		this.usuSeqUsuario = usuSeqUsuario;
	}

	public String getDemDscEntradas()
	{
		return demDscEntradas;
	}

	public void setDemDscEntradas(String demDscEntradas)
	{
		this.demDscEntradas = demDscEntradas;
	}

	public String getDemCritAceitacao()
	{
		return demCritAceitacao;
	}

	public void setDemCritAceitacao(String demCritAceitacao)
	{
		this.demCritAceitacao = demCritAceitacao;
	}

	public String getDemDscProcedimento()
	{
		return demDscProcedimento;
	}

	public void setDemDscProcedimento(String demDscProcediemnto)
	{
		this.demDscProcedimento = demDscProcediemnto;
	}

	public String getDemInstrucaoSql()
	{
		return demInstrucaoSql;
	}

	public void setDemInstrucaoSql(String demInstrucaoSql)
	{
		this.demInstrucaoSql = demInstrucaoSql;
	}

	public void setBtpVersao(BtpVersao btpVersao)
	{
		this.btpVersao = btpVersao;
	}

	public BtpVersao getBtpVersao()
	{
		return btpVersao;
	}

	public EnumTipoDemanda getDemCodTipoDemanda()
	{
		return demCodTipoDemanda;
	}

	public void setDemCodTipoDemanda(EnumTipoDemanda demCodTipoDemanda)
	{
		this.demCodTipoDemanda = demCodTipoDemanda;
	}

	public EnumSituacaoSimNao getDemFlgExibirChamado()
	{
		return demFlgExibirChamado;
	}

	public void setDemFlgExibirChamado(EnumSituacaoSimNao demFlgExibirChamado)
	{
		this.demFlgExibirChamado = demFlgExibirChamado;
	}

	public String getDemDscChamado()
	{
		return demDscChamado;
	}

	public void setDemDscChamado(String demDscChamado)
	{
		this.demDscChamado = demDscChamado;
	}

	public BtpModulo getBtpModulo()
	{
		return btpModulo;
	}

	public void setBtpModulo(BtpModulo btpModulo)
	{
		this.btpModulo = btpModulo;
	}

	public String getDemDscObservacao()
	{
		return demDscObservacao;
	}

	public void setDemDscObservacao(String demDscObservacao)
	{
		this.demDscObservacao = demDscObservacao;
	}

	public List<BtpDefeito> getLstDefeitos()
	{
		return lstDefeitos;
	}

	public void setLstDefeitos(List<BtpDefeito> lstDefeitos)
	{
		this.lstDefeitos = lstDefeitos;
	}

	public EnumSituacaoSimNao getDemFlgExtra()
	{
		return demFlgExtra;
	}

	public void setDemFlgExtra(EnumSituacaoSimNao demFlgExtra)
	{
		this.demFlgExtra = demFlgExtra;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((demSeqDemanda == null) ? 0 : demSeqDemanda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		BtpDemanda other = (BtpDemanda) obj;
		if ( demSeqDemanda == null )
		{
			if ( other.demSeqDemanda != null )
				return false;
		}
		else if ( !demSeqDemanda.equals(other.demSeqDemanda) )
			return false;
		return true;
	}

	public List<BtpInstrucaoSql> getLstSQLs()
	{
		return lstSQLs;
	}

	public void setLstSQLs(List<BtpInstrucaoSql> lstSQLs)
	{
		this.lstSQLs = lstSQLs;
	}

}