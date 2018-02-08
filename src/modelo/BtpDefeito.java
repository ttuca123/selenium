package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enumerators.EnumDefCategoria;
import enumerators.EnumDefFase;
import enumerators.EnumDefOrigem;
import enumerators.EnumDefPrioridade;
import enumerators.EnumDefStatus;
import enumerators.EnumTipoDemanda;

@Entity
@Table(name = "DEF_DEFEITOS")
public class BtpDefeito implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEF_SEQ_DEFEITO")
	private Long defSeqDefeito;

	@Column(name = "DEF_DTA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date defDtaCadastro;

	@ManyToOne
	@JoinColumn(name = "DEM_SEQ_DEMANDA")
	private BtpDemanda btpDemanda;

	@ManyToOne
	@JoinColumn(name = "SIS_SEQ_SISTEMA")
	private BtpSistema btpSistema;

	@ManyToOne
	@JoinColumn(name = "VER_SEQ_VERSAO")
	private BtpVersao btpVersao;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "CAT_SEQ_CATEGORIA")
	private EnumDefCategoria enumDefCategoria;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DEF_SEQ_PRIORIDADE")
	private EnumDefPrioridade enumDefPrioridade;

	@ManyToOne
	@JoinColumn(name = "VER_SEQ_VERSAO_PREV")
	private BtpVersao btpVersaoPrev;

	@Column(name = "USU_SEQ_USUARIO")
	private String usuSeqUsuario;

	@Column(name = "USU_SEQ_USUARIO_REP")
	private String usuSeqUsuarioRelator;

	@Column(name = "DEF_DSC_RESUMO")
	private String defDscResumo;

	@Column(name = "DEF_DSC_PASSOS")
	private String defDscPassos;

	@Column(name = "DEF_DSC_OBSERVACAO")
	private String defDscObservacao;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DEF_SEQ_CLASSE")
	private EnumTipoDemanda enumDefClasse;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DEF_SEQ_FASE")
	private EnumDefFase enumDefFase;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DEF_SEQ_ORIGEM")
	private EnumDefOrigem enumDefOrigem;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DEF_COD_STATUS")
	private EnumDefStatus enumDefStatus;

	public String getUsuSeqUsuarioRelator()
	{
		return usuSeqUsuarioRelator;
	}

	public void setUsuSeqUsuarioRelator(String usuSeqUsuarioRelator)
	{
		this.usuSeqUsuarioRelator = usuSeqUsuarioRelator;
	}

	public Long getDefSeqDefeito()
	{
		return defSeqDefeito;
	}

	public void setDefSeqDefeito(Long defSeqDefeito)
	{
		this.defSeqDefeito = defSeqDefeito;
	}

	public Date getDefDtaCadastro()
	{
		return defDtaCadastro;
	}

	public void setDefDtaCadastro(Date defDtaCadastro)
	{
		this.defDtaCadastro = defDtaCadastro;
	}

	public BtpDemanda getBtpDemanda()
	{
		return btpDemanda;
	}

	public void setBtpDemanda(BtpDemanda btpDemanda)
	{
		this.btpDemanda = btpDemanda;
	}

	public BtpSistema getBtpSistema()
	{
		return btpSistema;
	}

	public void setBtpSistema(BtpSistema btpSistema)
	{
		this.btpSistema = btpSistema;
	}

	public BtpVersao getBtpVersao()
	{
		return btpVersao;
	}

	public void setBtpVersao(BtpVersao btpVersao)
	{
		this.btpVersao = btpVersao;
	}

	public EnumDefCategoria getEnumDefCategoria()
	{
		return enumDefCategoria;
	}

	public void setEnumDefCategoria(EnumDefCategoria enumDefCategoria)
	{
		this.enumDefCategoria = enumDefCategoria;
	}

	public EnumDefPrioridade getEnumDefPrioridade()
	{
		return enumDefPrioridade;
	}

	public void setEnumDefPrioridade(EnumDefPrioridade enumDefPrioridade)
	{
		this.enumDefPrioridade = enumDefPrioridade;
	}

	public BtpVersao getBtpVersaoPrev()
	{
		return btpVersaoPrev;
	}

	public void setBtpVersaoPrev(BtpVersao btpVersaoPrev)
	{
		this.btpVersaoPrev = btpVersaoPrev;
	}

	public String getDefDscResumo()
	{
		return defDscResumo;
	}

	public void setDefDscResumo(String defDscResumo)
	{
		this.defDscResumo = defDscResumo;
	}

	public String getDefDscPassos()
	{
		return defDscPassos;
	}

	public void setDefDscPassos(String defDscPassos)
	{
		this.defDscPassos = defDscPassos;
	}

	public String getDefDscObservacao()
	{
		return defDscObservacao;
	}

	public void setDefDscObservacao(String defDscObservacao)
	{
		this.defDscObservacao = defDscObservacao;
	}

	public EnumTipoDemanda getEnumDefClasse()
	{
		return enumDefClasse;
	}

	public void setEnumDefClasse(EnumTipoDemanda enumDefClasse)
	{
		this.enumDefClasse = enumDefClasse;
	}

	public EnumDefFase getEnumDefFase()
	{
		return enumDefFase;
	}

	public void setEnumDefFase(EnumDefFase enumDefFase)
	{
		this.enumDefFase = enumDefFase;
	}

	public EnumDefOrigem getEnumDefOrigem()
	{
		return enumDefOrigem;
	}

	public void setEnumDefOrigem(EnumDefOrigem enumDefOrigem)
	{
		this.enumDefOrigem = enumDefOrigem;
	}

	public EnumDefStatus getEnumDefStatus()
	{
		return enumDefStatus;
	}

	public void setEnumDefStatus(EnumDefStatus enumDefStatus)
	{
		this.enumDefStatus = enumDefStatus;
	}

	public String getUsuSeqUsuario()
	{
		return usuSeqUsuario;
	}

	public void setUsuSeqUsuario(String usuSeqUsuario)
	{
		this.usuSeqUsuario = usuSeqUsuario;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((defSeqDefeito == null) ? 0 : defSeqDefeito.hashCode());
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
		BtpDefeito other = (BtpDefeito) obj;
		if ( defSeqDefeito == null )
		{
			if ( other.defSeqDefeito != null )
				return false;
		}
		else if ( !defSeqDefeito.equals(other.defSeqDefeito) )
			return false;
		return true;
	}

}
