package br.com.pocjavaee.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author p059165
 * @version 1.0
 * @created 25-jul-2016 16:27:41
 */
@Entity(name="UNIDADE_HOSPITALAR")
public class UnidadeHospitalar {

	@Id @GeneratedValue
	@Column(name="CODIGO")
	private long codigo;
	
	@Column(name="NOME")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="PACIENTE_ID")
	private List<Paciente> pacientes = null;

	public UnidadeHospitalar(){
		pacientes = new ArrayList<Paciente>();
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

	public List<Paciente> getPaciente() {
		return pacientes;
	}

	public void setPaciente(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}