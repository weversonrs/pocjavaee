package br.com.pocjavaee.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@NamedQuery(name = "Usuario.findUsuarioByUsername", query = "select u from Usuario u where u.username = :username")
public class Usuario implements Serializable, UserDetails{

	private static final long serialVersionUID = -4267657821459956012L;
	
	public static final String FIND_BY_USERNAME = "Usuario.findUsuarioByUsername";

	@Id
	private long codigo;
	
	@Column
	private String nome;
	
	@Column(name="usuario")
	private String username;
	
	@Column(name="senha")
	private String password;
	
	@Column(name="ativo")
	private boolean enable;
	
	@ManyToMany
	@JoinTable(name="usuario_papel", joinColumns={@JoinColumn(name="id_usuario", referencedColumnName="codigo")}, 
	inverseJoinColumns={@JoinColumn(name="id_papel", referencedColumnName="id")})
	private List<Papel> authorities;
	
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

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enable;
	}

}
