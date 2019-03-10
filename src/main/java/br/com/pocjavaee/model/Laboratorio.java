package br.com.pocjavaee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author p059165
 * @version 1.0
 * @created 25-jul-2016 13:27:10
 */

@Entity
public class Laboratorio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id@GeneratedValue
	@Column(name="CODIGO")
	private long codigo;
	
	@Column(name="NOME")
	private String nome;
	
	@OneToOne
	@JoinColumn(name="ENDERECO_ID")
	private Endereco endereco;

	public Laboratorio(){

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 33;
		hashCode = (int) (hashCode * 17 + codigo);
		hashCode = hashCode * 31 + nome.hashCode();
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Laboratorio) {
			Laboratorio lab = (Laboratorio) obj;
			return lab.codigo == codigo;
		}
		return false;
	}

	

}