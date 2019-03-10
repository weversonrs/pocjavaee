package br.com.pocjavaee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author p059165
 * @version 1.0
 * @created 25-jul-2016 13:27:13
 */

@Entity
public class Resultado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name="CODIGO")
	private long codigo;
	
	@Column(name="DT_RESULTADO")
	private Date dataResultado;
	
	@Column(name="RESPONSAVEL")
	private String responsaval;
	
	@Column(name="RESULTADO")
	private String resultado;

	public Resultado(){

	}

	public void finalize() throws Throwable {

	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Date getDataResultado() {
		return dataResultado;
	}

	public void setDataResultado(Date dataResultado) {
		this.dataResultado = dataResultado;
	}

	public String getResponsaval() {
		return responsaval;
	}

	public void setResponsaval(String responsaval) {
		this.responsaval = responsaval;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}