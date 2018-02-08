package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import enumerators.EnumStatus;
import enumerators.EnumTipoServico;

/**
 * Classe utilizada para representar uma Pessoa.
 */
@Entity
@Table(name = "servicos")
public class BtpServico implements Serializable
{
	/* Serial Version UID */
	private static final long serialVersionUID = 5486103235574819424L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long codigo;

	@Transient
	private String codServico;

	private String descricao;

	@Column(name = "nr_casos")
	private Integer nrCasos;

	@Column(name = "nr_casos_ignorados")
	private Integer nrCasosIgnorados;

	@Enumerated
	@Column(name = "situacao")
	private EnumStatus status;

	@Enumerated
	@Column(name = "tipo_servico")
	private EnumTipoServico tipoServico;

	@OneToMany(mappedBy = "servico", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	List<BtpCasoTeste> lstCasosTestes;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Long codigo)
	{
		this.codigo = codigo;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public Integer getNrCasos()
	{
		return nrCasos;
	}

	public void setNrCasos(Integer nrCasos)
	{
		this.nrCasos = nrCasos;
	}

	public EnumStatus getStatus()
	{
		return status;
	}

	public void setStatus(EnumStatus status)
	{
		this.status = status;
	}

	public EnumTipoServico getTipoServico()
	{
		return tipoServico;
	}

	public void setTipoServico(EnumTipoServico tipoServico)
	{
		this.tipoServico = tipoServico;
	}

	public List<BtpCasoTeste> getLstCasosTestes()
	{
		return lstCasosTestes;
	}

	public void setLstCasosTestes(List<BtpCasoTeste> lstCasosTestes)
	{
		this.lstCasosTestes = lstCasosTestes;
	}

	public String getCodServico()
	{
		return String.format("%03d", codigo);
	}

	public Integer getNrCasosIgnorados()
	{
		return nrCasosIgnorados;
	}

	public void setNrCasosIgnorados(Integer nrCasosIgnorados)
	{
		this.nrCasosIgnorados = nrCasosIgnorados;
	}
}