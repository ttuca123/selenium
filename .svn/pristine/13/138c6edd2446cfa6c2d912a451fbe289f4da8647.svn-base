package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enumerators.EnumSituacao;
import enumerators.EnumSituacaoSimNao;
import enumerators.EnumTipoPublicacao;

/**
 * Classe utilizada para representar uma Módulos.
 */
@Entity
@Table(name = "sis_sistemas")
public class BtpSistema implements Serializable
{
	/* Serial Version UID */
	private static final long serialVersionUID = 5486103235574819424L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sis_seq_sistema")
	private Long sisSeqSistema;

	@Column(name = "sis_nom_sistema")
	private String sisNomSistema;

	@Column(name = "sis_dsc_sigla")
	private String sisDscSigla;

	@Enumerated
	@Column(name = "sis_flg_situacao")
	private EnumSituacao sisFlgSituacao;

	@Enumerated
	@Column(name = "sis_flg_chamado_mudanca")
	private EnumSituacaoSimNao sisFlgChamadoMudanca;

	@Enumerated
	@Column(name = "sis_flg_importacao")
	private EnumSituacaoSimNao sisFlgImportacao;

	@Column(name = "sis_cod_sgd")
	private Integer sisCodSGD;

	@Enumerated
	@Column(name = "sis_cod_tipo_publicacao")
	private EnumTipoPublicacao sisCodTipoPublicacao;

	@OneToMany(mappedBy = "btpSistema")
	private List<BtpVersao> lstVersoes;

	public Long getSisSeqSistema()
	{
		return sisSeqSistema;
	}

	public void setSisSeqSistema(Long sisSeqSistema)
	{
		this.sisSeqSistema = sisSeqSistema;
	}

	public String getSisNomSistema()
	{
		return sisNomSistema;
	}

	public void setSisNomSistema(String sisNomSistema)
	{
		this.sisNomSistema = sisNomSistema;
	}

	public String getSisDscSigla()
	{
		return sisDscSigla;
	}

	public void setSisDscSigla(String sisDscSigla)
	{
		this.sisDscSigla = sisDscSigla;
	}

	public EnumSituacao getSisFlgSituacao()
	{
		return sisFlgSituacao;
	}

	public void setSisFlgSituacao(EnumSituacao sisFlgSituacao)
	{
		this.sisFlgSituacao = sisFlgSituacao;
	}

	public EnumSituacaoSimNao getSisFlgChamadoMudanca()
	{
		return sisFlgChamadoMudanca;
	}

	public void setSisFlgChamadoMudanca(EnumSituacaoSimNao sisFlgChamadoMudanca)
	{
		this.sisFlgChamadoMudanca = sisFlgChamadoMudanca;
	}

	public List<BtpVersao> getLstVersoes()
	{
		return lstVersoes;
	}

	public void setLstVersoes(List<BtpVersao> lstVersoes)
	{
		this.lstVersoes = lstVersoes;
	}

	public Integer getSisCodSGD()
	{
		return sisCodSGD;
	}

	public void setSisCodSGD(Integer sisCodSGD)
	{
		this.sisCodSGD = sisCodSGD;
	}

	public EnumSituacaoSimNao getSisFlgImportacao()
	{
		return sisFlgImportacao;
	}

	public void setSisFlgImportacao(EnumSituacaoSimNao sisFlgImportacao)
	{
		this.sisFlgImportacao = sisFlgImportacao;
	}

	public EnumTipoPublicacao getSisCodTipoPublicacao()
	{
		return sisCodTipoPublicacao;
	}

	public void setSisCodTipoPublicacao(EnumTipoPublicacao sisCodTipoPublicacao)
	{
		this.sisCodTipoPublicacao = sisCodTipoPublicacao;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sisSeqSistema == null) ? 0 : sisSeqSistema.hashCode());
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
		BtpSistema other = (BtpSistema) obj;
		if ( sisSeqSistema == null )
		{
			if ( other.sisSeqSistema != null )
				return false;
		}
		else if ( !sisSeqSistema.equals(other.sisSeqSistema) )
			return false;
		return true;
	}

}