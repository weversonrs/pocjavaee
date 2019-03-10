package br.com.pocjavaee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class TipoSanguineo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name="CODIGO")
	private long codigo;
	
	@Column(name="NOME")
	private String nome;
	
	public TipoSanguineo() {
		
	}

	public TipoSanguineo(long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
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

}
