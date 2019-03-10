package br.com.pocjavaee.model;

import java.io.Serializable;
import java.util.Date;

public class AnaliseSolicitacaoSangue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long codigo;
	private SolicitacaoSangue solicitacao;
	private Funcionario responsavelAnalise;
	private Date dataAnalise;
	private String resultado;
	private String Justificativa;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public SolicitacaoSangue getSolicitacao() {
		return solicitacao;
	}
	public void setSolicitacao(SolicitacaoSangue solicitacao) {
		this.solicitacao = solicitacao;
	}
	public Funcionario getResponsavelAnalise() {
		return responsavelAnalise;
	}
	public void setResponsavelAnalise(Funcionario responsavelAnalise) {
		this.responsavelAnalise = responsavelAnalise;
	}
	public Date getDataAnalise() {
		return dataAnalise;
	}
	public void setDataAnalise(Date dataAnalise) {
		this.dataAnalise = dataAnalise;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getJustificativa() {
		return Justificativa;
	}
	public void setJustificativa(String justificativa) {
		Justificativa = justificativa;
	}
	
}
