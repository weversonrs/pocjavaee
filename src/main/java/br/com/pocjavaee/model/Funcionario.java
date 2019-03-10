package br.com.pocjavaee.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Funcionario extends Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8240079872848197250L;

	@Column
	private String matricula;
	
	@Column
	private String cargo;
	
	@Column(name="DT_ADMISSAO")
	private String dataAdmissao;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
}
