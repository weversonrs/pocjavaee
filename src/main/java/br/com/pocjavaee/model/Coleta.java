package br.com.pocjavaee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author p059165
 * @version 1.0
 * @created 25-jul-2016 13:27:06
 */
@Entity
public class Coleta {

	@Id @GeneratedValue
	@Column(name="CODIGO")
	private long codigo;
	
	@Column(name="DT_COLETA")
	private Date dataColeta;
	
	@Column(name="FUNCIONARIO_RESP")
	private String funcionarioResponsavel;

	public Coleta(){

	}

	public void finalize() throws Throwable {

	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Date getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(Date dataColeta) {
		this.dataColeta = dataColeta;
	}

	public String getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}

	public void setFuncionarioResponsavel(String funcionarioResponsavel) {
		this.funcionarioResponsavel = funcionarioResponsavel;
	}

}