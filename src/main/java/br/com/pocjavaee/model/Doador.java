package br.com.pocjavaee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Doador.findDoadorByUsername", query = "select d from Doador d where d.username = :username")
public class Doador extends Usuario{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_BY_USERNAME = "Doador.findDoadorByUsername";
	
	@Column(name="ID")
	private long id;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="EMAIL")
	private String email;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return username;
	}
	public void setLogin(String login) {
		this.username = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
