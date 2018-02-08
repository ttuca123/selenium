package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enumerators.EnumTipoExperiencia;

@Entity
@Table(name = "exp_experiencias")
public class BtpExperiencia implements Serializable
{
	private static final long serialVersionUID = 5486103235574819424L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "exp_seq_experiencia")
	private Long expSeqExperiencia;

	@Column(name = "exp_dsc_objetivo")
	private String expDscObjetivo;

	@Column(name = "exp_dsc_experiencia")
	private String insScriptSql;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "exp_cod_classe")
	private EnumTipoExperiencia expCodClasse;

	public Long getExpSeqExperiencia()
	{
		return expSeqExperiencia;
	}

	public void setExpSeqExperiencia(Long expSeqExperiencia)
	{
		this.expSeqExperiencia = expSeqExperiencia;
	}

	public String getExpDscObjetivo()
	{
		return expDscObjetivo;
	}

	public void setExpDscObjetivo(String expDscObjetivo)
	{
		this.expDscObjetivo = expDscObjetivo;
	}

	public String getInsScriptSql()
	{
		return insScriptSql;
	}

	public void setInsScriptSql(String insScriptSql)
	{
		this.insScriptSql = insScriptSql;
	}

	public EnumTipoExperiencia getExpCodClasse()
	{
		return expCodClasse;
	}

	public void setExpCodClasse(EnumTipoExperiencia expCodClasse)
	{
		this.expCodClasse = expCodClasse;
	}

}
