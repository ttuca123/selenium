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

import enumerators.EnumMomentoExecucao;

@Entity
@Table(name = "INS_INSTRUCOES_SQL")
public class BtpInstrucaoSql implements Serializable
{
	private static final long serialVersionUID = 5486103235574819424L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INS_SEQ_INSTRUCOES")
	private Long insSeqInstrucao;

	@ManyToOne
	@JoinColumn(name = "DEM_SEQ_DEMANDA")
	private BtpDemanda btpDemanda;

	@Column(name = "INS_OBJETIVO_SQL")
	private String insDscObjetivo;

	@Column(name = "INS_SCRIPT_SQL")
	private String insScriptSql;

	@Column(name = "USU_SEQ_USUARIO")
	private String usuSeqUsuario;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "INS_MOMENTO_EXECUCAO")
	private EnumMomentoExecucao insMomentoExecucao;

	@Column(name = "INS_DTA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insDtaCadastro;

	@Column(name = "INS_USR_EXECUTOR")
	private String usuUsrExecutor;

	@Column(name = "INS_DTA_EXECUCAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insDtaExecucao;

	public Long getInsSeqInstrucao()
	{
		return insSeqInstrucao;
	}

	public void setInsSeqInstrucao(Long insSeqInstrucao)
	{
		this.insSeqInstrucao = insSeqInstrucao;
	}

	public BtpDemanda getBtpDemanda()
	{
		return btpDemanda;
	}

	public void setBtpDemanda(BtpDemanda btpDemanda)
	{
		this.btpDemanda = btpDemanda;
	}

	public String getInsScriptSql()
	{
		return insScriptSql;
	}

	public void setInsScriptSql(String insScriptSql)
	{
		this.insScriptSql = insScriptSql;
	}

	public String getUsuSeqUsuario()
	{
		return usuSeqUsuario;
	}

	public void setUsuSeqUsuario(String usuSeqUsuario)
	{
		this.usuSeqUsuario = usuSeqUsuario;
	}

	public EnumMomentoExecucao getInsMomentoExecucao()
	{
		return insMomentoExecucao;
	}

	public void setInsMomentoExecucao(EnumMomentoExecucao insMomentoExecucao)
	{
		this.insMomentoExecucao = insMomentoExecucao;
	}

	public Date getInsDtaCadastro()
	{
		return insDtaCadastro;
	}

	public void setInsDtaCadastro(Date insDtaCadastro)
	{
		this.insDtaCadastro = insDtaCadastro;
	}

	public String getInsDscObjetivo()
	{
		return insDscObjetivo;
	}

	public void setInsDscObjetivo(String insDscObjetivo)
	{
		this.insDscObjetivo = insDscObjetivo;
	}

	public String getUsuUsrExecutor()
	{
		return usuUsrExecutor;
	}

	public void setUsuUsrExecutor(String usuUsrExecutor)
	{
		this.usuUsrExecutor = usuUsrExecutor;
	}

	public Date getInsDtaExecucao()
	{
		return insDtaExecucao;
	}

	public void setInsDtaExecucao(Date insDtaExecucao)
	{
		this.insDtaExecucao = insDtaExecucao;
	}
}
