package br.com.pocjavaee.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Papel implements Serializable, GrantedAuthority{

	private static final long serialVersionUID = 2445070130705720791L;

	@Id
	private Integer id;
	
	@Column(name="nome")
	private String authority;
	
	@ManyToMany
	private List<Usuario> usuarios;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
