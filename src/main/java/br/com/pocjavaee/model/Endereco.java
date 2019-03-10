package br.com.pocjavaee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author p059165
 * @version 1.0
 * @created 25-jul-2016 13:27:08
 */

@Entity
public class Endereco {

	@Id @GeneratedValue
	@Column(name="ID")
	private long id;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@Column(name="CEP")
	private String cep;
	
	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name="COMPLEMENTO")
	private String complemento;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="LOGRADOURO")
	private String logradouro;
	
	@Column(name="NUMERO")
	private int numero;
	
	@Column(name="TELEFONE")
	private String telefone;

	public Endereco(){

	}

	public void finalize() throws Throwable {

	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}