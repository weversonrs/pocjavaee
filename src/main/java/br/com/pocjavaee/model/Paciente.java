package br.com.pocjavaee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author p059165
 * @version 1.0
 * @created 25-jul-2016 13:27:12
 */
@Entity
public class Paciente extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="DIAGNOSTICO")
	private String diagnostico;

	public Paciente(){

	}

	public Paciente(long codigo, String nome, Date dataNascimento, String sexo, String tipoSanguineo, String diagnostico) {
		super.codigo = codigo;
		super.nome = nome;
		super.dataNascimento = dataNascimento;
		super.sexo = sexo;
		super.tipoSanguineo = tipoSanguineo;
		this.diagnostico = diagnostico;
	}




	public void finalize() throws Throwable {
		super.finalize();
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

}