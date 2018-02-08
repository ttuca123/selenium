package modelo;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enumerators.EnumResultadoTeste;
import enumerators.EnumTipoErro;

@Entity
@Table(name = "testes")
public class BtpTeste implements Serializable
{
	private static final long serialVersionUID = 5486103235574819424L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "versao", referencedColumnName = "codigo")
	private BtpVersao versao;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "caso_Teste", referencedColumnName = "id_caso")
	private BtpCasoTeste casoTeste;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status")
	private EnumResultadoTeste status;

	@Column(name = "data_execucao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataExecucao;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "erro")
	private EnumTipoErro erro;

	@Column(name = "log_erro")
	private String catLogErro;

	@Column(name = "ver_nr_teste")
	private Integer resteste;

	public BtpVersao getVersao()
	{
		return versao;
	}

	public void setVersao(BtpVersao versao)
	{
		this.versao = versao;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public BtpCasoTeste getCasoTeste()
	{
		return casoTeste;
	}

	public void setCasoTeste(BtpCasoTeste casoTeste)
	{
		this.casoTeste = casoTeste;
	}

	public EnumResultadoTeste getStatus()
	{
		return status;
	}

	public void setStatus(EnumResultadoTeste status)
	{
		this.status = status;
	}

	public EnumTipoErro getErro()
	{
		return erro;
	}

	public void setErro(EnumTipoErro erro)
	{
		this.erro = erro;
	}

	public String getCatLogErro()
	{
		return catLogErro;
	}

	public void setCatLogErro(String catLogErro)
	{
		this.catLogErro = catLogErro;
	}

	public Date getDataExecucao()
	{
		return dataExecucao;
	}

	public void setDataExecucao(Date dataExecucao)
	{
		this.dataExecucao = dataExecucao;
	}

	public Integer getResteste()
	{
		return resteste;
	}

	public void setResteste(Integer resteste)
	{
		this.resteste = resteste;
	}

}