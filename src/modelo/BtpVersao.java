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
import javax.persistence.Transient;

import enumerators.EnumAtivoAfetado;
import enumerators.EnumSituacaoSimNao;
import enumerators.EnumStatusVersao;
import enumerators.EnumTipoExecucao;
import enumerators.EnumTipoVersao;

@Entity
@Table(name = "versao")
public class BtpVersao implements Serializable
{
	/* Serial Version UID */
	private static final long serialVersionUID = 5486103235574819424L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "sistema")
	private BtpSistema btpSistema;

	@Column(name = "ver_id_versao")
	private String verIdVersao;

	@Column(name = "ver_dsc_compl")
	private String verDscCompl;

	@Column(name = "ver_dta_ini_desen")
	@Temporal(TemporalType.DATE)
	private Date verDtaIniDesen;

	@Column(name = "ver_dta_fim_desen")
	@Temporal(TemporalType.DATE)
	private Date verDtaFimDesen;

	@Column(name = "ver_dta_ini_testes")
	@Temporal(TemporalType.DATE)
	private Date verDtaIniTestes;

	@Column(name = "ver_dta_fim_testes")
	@Temporal(TemporalType.DATE)
	private Date verDtaFimTestes;

	@Column(name = "ver_dta_ini_public")
	@Temporal(TemporalType.TIMESTAMP)
	private Date verDtaIniPublic;

	@Column(name = "ver_dta_fim_public")
	@Temporal(TemporalType.TIMESTAMP)
	private Date verDtaFimPublic;

	@Column(name = "ver_dta_sol_mudanca")
	@Temporal(TemporalType.TIMESTAMP)
	private Date verDtaSolMudanca;

	@Column(name = "ver_dta_conf_testes")
	@Temporal(TemporalType.TIMESTAMP)
	private Date verDtaConfTestes;

	@Enumerated(EnumType.ORDINAL)
	private EnumTipoExecucao execucao;

	@Column(name = "ver_flg_reversao")
	@Enumerated(EnumType.ORDINAL)
	private EnumSituacaoSimNao verFlgReversao;

	@Column(name = "ver_flg_dashboard")
	@Enumerated(EnumType.ORDINAL)
	private EnumSituacaoSimNao verFlgDashboard;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo_versao")
	private EnumTipoVersao tipoVersao;

	@Column(name = "observacoes")
	private String observacao;

	@Column(name = "ver_dsc_md5")
	private String verDscMd5;

	@Enumerated(EnumType.ORDINAL)
	private EnumSituacaoSimNao reportar;

	@Column(name = "ver_dsc_riscos")
	private String verDscRiscos;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ver_ativo_afetado")
	private EnumAtivoAfetado enumAtivoAfetado;

	@Enumerated(EnumType.ORDINAL)
	private EnumStatusVersao situacao = EnumStatusVersao.DESENVOLVIMENTO;

	@OneToMany(mappedBy = "versao", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	List<BtpTeste> lstTestes;

	@OneToMany(mappedBy = "btpVersao", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	List<BtpDemanda> lstDemandas;

	@OneToMany(mappedBy = "btpVersaoPai", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	List<BtpDependencia> lstDependencias;

	@OneToMany(mappedBy = "btpVersao", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	List<BtpDefeito> lstDefeitos;

	@Column(name = "ver_nr_teste")
	private Integer verNrTeste = 1;

	@Transient
	private boolean abrirChamadoMudanca;

	public Boolean getVerFlgDashboard()

	{

		if ( this.verFlgDashboard != null )
		{
			if ( this.verFlgDashboard.equals(EnumSituacaoSimNao.SIM) )
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}

	}

	public void setVerFlgDashboard(Boolean verFlgDashboard)
	{
		if ( verFlgDashboard )
		{
			this.verFlgDashboard = EnumSituacaoSimNao.SIM;
		}
		else
		{
			this.verFlgDashboard = EnumSituacaoSimNao.NAO;
		}
	}

	public String getVerIdVersaoCompleta()
	{

		if ( verDscCompl != null && (verDscCompl.length() > 0) )
		{
			return verIdVersao.concat(" " + verDscCompl);
		}
		return verIdVersao;
	}

	public boolean getAbrirChamadoMudanca()
	{
		return ((btpSistema.getSisFlgChamadoMudanca()
				.equals(EnumSituacaoSimNao.SIM) && situacao
				.equals(EnumStatusVersao.AGUARDANDO_PUBLICACAO)));
	}

	public Integer getVerNrTeste()
	{
		return verNrTeste;
	}

	public void setAbrirChamadoMudanca(boolean abrirChamadoMudanca)
	{
		this.abrirChamadoMudanca = abrirChamadoMudanca;
	}

	public void setVerNrTeste(Integer verNrTeste)
	{
		this.verNrTeste = verNrTeste;
	}

	public String getVerDscCompl()
	{
		return verDscCompl;
	}

	public void setVerDscCompl(String verDscCompl)
	{
		this.verDscCompl = verDscCompl;
	}

	public String getVerDscRiscos()
	{
		return verDscRiscos;
	}

	public void setVerDscRiscos(String verDscRiscos)
	{
		this.verDscRiscos = verDscRiscos;
	}

	public EnumAtivoAfetado getEnumAtivoAfetado()
	{
		return enumAtivoAfetado;
	}

	public void setEnumAtivoAfetado(EnumAtivoAfetado enumAtivoAfetado)
	{
		this.enumAtivoAfetado = enumAtivoAfetado;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public BtpSistema getBtpSistema()
	{
		return btpSistema;
	}

	public void setBtpSistema(BtpSistema btpSistema)
	{
		this.btpSistema = btpSistema;
	}

	public String getVerIdVersao()
	{
		return verIdVersao;
	}

	public void setVerIdVersao(String verIdVersao)
	{
		this.verIdVersao = verIdVersao;
	}

	public Date getVerDtaSolMudanca()
	{
		return verDtaSolMudanca;
	}

	public void setVerDtaSolMudanca(Date verDtaSolMudanca)
	{
		this.verDtaSolMudanca = verDtaSolMudanca;
	}

	public Date getVerDtaConfTestes()
	{
		return verDtaConfTestes;
	}

	public void setVerDtaConfTestes(Date verDtaConfTestes)
	{
		this.verDtaConfTestes = verDtaConfTestes;
	}

	public EnumStatusVersao getSituacao()
	{
		return situacao;
	}

	public void setSituacao(EnumStatusVersao situacao)
	{
		this.situacao = situacao;
	}

	public List<BtpTeste> getLstTestes()
	{
		return lstTestes;
	}

	public void setLstTestes(List<BtpTeste> lstTestes)
	{
		this.lstTestes = lstTestes;
	}

	public EnumTipoExecucao getExecucao()
	{
		return execucao;
	}

	public void setExecucao(EnumTipoExecucao execucao)
	{
		this.execucao = execucao;
	}

	public Boolean getReportar()
	{
		if ( this.reportar != null )
		{
			if ( this.reportar.equals(EnumSituacaoSimNao.SIM) )
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	public void setReportar(Boolean reportar)
	{
		if ( reportar )
		{
			this.reportar = EnumSituacaoSimNao.SIM;
		}
		else
		{
			this.reportar = EnumSituacaoSimNao.NAO;
		}
	}

	public String getVerDscMd5()
	{
		return verDscMd5;
	}

	public void setVerDscMd5(String verDscMd5)
	{
		this.verDscMd5 = verDscMd5;
	}

	public Date getVerDtaIniPublic()
	{
		return verDtaIniPublic;
	}

	public void setVerDtaIniPublic(Date verDtaIniPublic)
	{
		this.verDtaIniPublic = verDtaIniPublic;
	}

	public Date getVerDtaFimPublic()
	{
		return verDtaFimPublic;
	}

	public void setVerDtaFimPublic(Date verDtaFimPublic)
	{
		this.verDtaFimPublic = verDtaFimPublic;
	}

	public List<BtpDemanda> getLstDemandas()
	{
		return lstDemandas;
	}

	public void setLstDemandas(List<BtpDemanda> lstDemandas)
	{
		this.lstDemandas = lstDemandas;
	}

	public EnumTipoVersao getTipoVersao()
	{
		return tipoVersao;
	}

	public void setTipoVersao(EnumTipoVersao tipoVersao)
	{
		this.tipoVersao = tipoVersao;
	}

	public String getObservacao()
	{
		return observacao;
	}

	public void setObservacao(String observacao)
	{
		this.observacao = observacao;
	}

	public List<BtpDependencia> getLstDependencias()
	{
		return lstDependencias;
	}

	public void setLstDependencias(List<BtpDependencia> lstDependencias)
	{
		this.lstDependencias = lstDependencias;
	}

	public List<BtpDefeito> getLstDefeitos()
	{
		return lstDefeitos;
	}

	public void setLstDefeitos(List<BtpDefeito> lstDefeitos)
	{
		this.lstDefeitos = lstDefeitos;
	}

	public Boolean getVerFlgReversao()
	{

		if ( this.verFlgReversao != null )
		{
			if ( this.verFlgReversao.equals(EnumSituacaoSimNao.SIM) )
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}

	}

	public void setVerFlgReversao(Boolean verFlgReversao)
	{
		if ( verFlgReversao )
		{
			this.verFlgReversao = EnumSituacaoSimNao.SIM;
		}
		else
		{
			this.verFlgReversao = EnumSituacaoSimNao.NAO;
		}
	}

	public Date getVerDtaIniDesen()
	{
		return verDtaIniDesen;
	}

	public void setVerDtaIniDesen(Date verDtaIniDesen)
	{
		this.verDtaIniDesen = verDtaIniDesen;
	}

	public Date getVerDtaFimDesen()
	{
		return verDtaFimDesen;
	}

	public void setVerDtaFimDesen(Date verDtaFimDesen)
	{
		this.verDtaFimDesen = verDtaFimDesen;
	}

	public Date getVerDtaIniTestes()
	{
		return verDtaIniTestes;
	}

	public void setVerDtaIniTestes(Date verDtaIniTestes)
	{
		this.verDtaIniTestes = verDtaIniTestes;
	}

	public Date getVerDtaFimTestes()
	{
		return verDtaFimTestes;
	}

	public void setVerDtaFimTestes(Date verDtaFimTestes)
	{
		this.verDtaFimTestes = verDtaFimTestes;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BtpVersao other = (BtpVersao) obj;
		if ( id == null )
		{
			if ( other.id != null )
				return false;
		}
		else if ( !id.equals(other.id) )
			return false;
		return true;
	}

}