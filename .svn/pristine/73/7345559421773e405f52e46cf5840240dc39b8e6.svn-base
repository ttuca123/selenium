package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ved_versao_dependencia")
public class BtpDependencia implements Serializable
{
	/* Serial Version UID */
	private static final long serialVersionUID = 5486103235574819424L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ved_seq_versao_dependencia")
	private Long vedSeqVersaoDependencia;

	@ManyToOne
	@JoinColumn(name = "ver_seq_versao_pai")
	private BtpVersao btpVersaoPai;

	@ManyToOne
	@JoinColumn(name = "sis_seq_sistema")
	private BtpSistema btpSistema;

	@ManyToOne
	@JoinColumn(name = "ver_seq_versao")
	private BtpVersao btpVersao;

	public Long getVedSeqVersaoDependencia()
	{
		return vedSeqVersaoDependencia;
	}

	public void setVedSeqVersaoDependencia(Long vedSeqVersaoDependencia)
	{
		this.vedSeqVersaoDependencia = vedSeqVersaoDependencia;
	}

	public BtpVersao getBtpVersao()
	{
		return btpVersao;
	}

	public void setBtpVersao(BtpVersao btpVersao)
	{
		this.btpVersao = btpVersao;
	}

	public BtpVersao getBtpVersaoPai()
	{
		return btpVersaoPai;
	}

	public void setBtpVersaoPai(BtpVersao btpVersaoPai)
	{
		this.btpVersaoPai = btpVersaoPai;
	}

	public BtpSistema getBtpSistema()
	{
		return btpSistema;
	}

	public void setBtpSistema(BtpSistema btpSistema)
	{
		this.btpSistema = btpSistema;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((vedSeqVersaoDependencia == null) ? 0 : vedSeqVersaoDependencia
						.hashCode());
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
		BtpDependencia other = (BtpDependencia) obj;
		if ( vedSeqVersaoDependencia == null )
		{
			if ( other.vedSeqVersaoDependencia != null )
				return false;
		}
		else if ( !vedSeqVersaoDependencia.equals(other.vedSeqVersaoDependencia) )
			return false;
		return true;
	}

}