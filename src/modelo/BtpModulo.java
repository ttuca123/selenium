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

/**
 * Classe utilizada para representar uma Módulos.
 */
@Entity
@Table(name = "MOD_MODULOS")
public class BtpModulo implements Serializable
{
	/* Serial Version UID */
	private static final long serialVersionUID = 5486103235574819424L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MOD_SEQ_MODULO")
	private Long modSeqModulo;

	@ManyToOne
	@JoinColumn(name = "SIS_SEQ_SISTEMA")
	private BtpSistema btpSistema;

	@Column(name = "MOD_DSC_MODULO")
	private String modDscModulo;

	@Column(name = "MOD_NOM_IMAGEM")
	private String modNomImagem;

	public Long getModSeqModulo()
	{
		return modSeqModulo;
	}

	public void setModSeqModulo(Long modSeqModulo)
	{
		this.modSeqModulo = modSeqModulo;
	}

	public BtpSistema getBtpSeqSistema()
	{
		return btpSistema;
	}

	public void setBtpSeqSistema(BtpSistema btpSistema)
	{
		this.btpSistema = btpSistema;
	}

	public String getModDscModulo()
	{
		return modDscModulo;
	}

	public void setModDscModulo(String modDscModulo)
	{
		this.modDscModulo = modDscModulo;
	}

	public String getModNomImagem()
	{
		return modNomImagem;
	}

	public void setModNomImagem(String modNomImagem)
	{
		this.modNomImagem = modNomImagem;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((modSeqModulo == null) ? 0 : modSeqModulo.hashCode());
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
		BtpModulo other = (BtpModulo) obj;
		if ( modSeqModulo == null )
		{
			if ( other.modSeqModulo != null )
				return false;
		}
		else if ( !modSeqModulo.equals(other.modSeqModulo) )
			return false;
		return true;
	}

}