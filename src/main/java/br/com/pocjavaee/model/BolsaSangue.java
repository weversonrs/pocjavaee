package br.com.pocjavaee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author p059165
 * @version 1.0
 * @created 25-jul-2016 13:27:05
 */
@Entity(name="BOLSA_SANGUE")
public class BolsaSangue {
	
	@Id @GeneratedValue
	private long codigo;
	
	@Column(name="TIPO_SANGUE")
	private String tipoSanguineo;
	
	@Column(name="ARMAZENAMENTO")
	private String armazenamento;

	public BolsaSangue(){

	}

	public void finalize() throws Throwable {

	}

	public String getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

}