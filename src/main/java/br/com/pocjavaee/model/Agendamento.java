package br.com.pocjavaee.model;

import java.io.Serializable;
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
 * @created 25-jul-2016 13:27:03
 */
@Entity(name="AGENDAMENTO_DOACAO")
public class Agendamento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name="CODIGO")
	private long codigo;
	
	@Column(name="DT_AGENDAMENTO")
	private Date dataAgendamento;
	
	@Column(name="DT_REGISTRO")
	private Date dataRegistro;
	
	@OneToOne
	@JoinColumn(name="DOADOR_ID")
	private Doador doador;
	
	@OneToOne
	@JoinColumn(name="LABORATORIO_ID")
	private Laboratorio laboratorio;

	public Agendamento(){

	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

}