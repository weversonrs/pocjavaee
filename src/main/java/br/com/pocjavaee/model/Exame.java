package br.com.pocjavaee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author p059165
 * @version 1.0
 * @created 25-jul-2016 13:27:10
 */
@Entity
public class Exame {

	@Id @GeneratedValue
	@Column(name="CODIGO")
	private long codigo;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="VR_REFERENCIA")
	private String valorReferencia;

	public Exame(){

	}

	public void finalize() throws Throwable {

	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValorReferencia() {
		return valorReferencia;
	}

	public void setValorReferencia(String valorReferencia) {
		this.valorReferencia = valorReferencia;
	}

}