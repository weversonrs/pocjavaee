package br.com.pocjavaee.bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pocjavaee.model.Agendamento;
import br.com.pocjavaee.model.AnaliseSolicitacaoSangue;
import br.com.pocjavaee.model.Endereco;
import br.com.pocjavaee.model.Laboratorio;
import br.com.pocjavaee.model.Paciente;
import br.com.pocjavaee.model.SolicitacaoSangue;
import br.com.pocjavaee.model.UnidadeHospitalar;

public class AnaliseBolsaSangueBO {
	
	private List<SolicitacaoSangue> solicitacoes = null;
	private AnaliseSolicitacaoSangue analise = null;
	private int decisao;
	private String justificativa;
	private String decisaoStr;
	
	public AnaliseBolsaSangueBO(){
		
		setAnalise(new AnaliseSolicitacaoSangue());
		solicitacoes = new ArrayList<SolicitacaoSangue>();
		SolicitacaoSangue solicitacao1 = new SolicitacaoSangue();
		solicitacao1.setCodigo(1);
		solicitacao1.setDataSolicitacao(new Date());
		solicitacao1.setJustificativa("TESTE 1");
		solicitacao1.setTipoSanguineo("A-");
		solicitacao1.setQuantidadeBolsa(5);
		solicitacao1.setSituacao("Em Analise");
		solicitacao1.setResponsavelSolicitacao("MARIA");
		
		UnidadeHospitalar unidade1 = new UnidadeHospitalar();
		unidade1.setCodigo(1);
		unidade1.setNome("UNIDADE 1");
		
		solicitacao1.setUnidadeHospitalar(unidade1);
		
		/*Paciente paciente1 = new Paciente();
		paciente1.setCodigo(1);
		paciente1.setNome("JOÃO");*/
		
		solicitacao1.setPacienteBeneficiario("JOÃO");
		
		solicitacoes.add(solicitacao1);
		
		SolicitacaoSangue solicitacao2 = new SolicitacaoSangue();
		solicitacao2.setCodigo(1);
		solicitacao2.setDataSolicitacao(new Date());
		solicitacao2.setJustificativa("TESTE 2");
		solicitacao2.setTipoSanguineo("A-");
		solicitacao2.setQuantidadeBolsa(10);
		solicitacao2.setSituacao("Em Analise");
		solicitacao2.setResponsavelSolicitacao("MARIA 2");
		
		/*Paciente paciente = new Paciente();
		paciente.setCodigo(1);
		paciente.setNome("JOÃO");*/
		
		UnidadeHospitalar unidade2 = new UnidadeHospitalar();
		unidade2.setCodigo(2);
		unidade2.setNome("UNIDADE 2");
		
		solicitacao2.setUnidadeHospitalar(unidade2);
		
		solicitacao2.setPacienteBeneficiario("JOÃO 2");
		
		solicitacoes.add(solicitacao2);
		
	}
	
	public List<SolicitacaoSangue> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<SolicitacaoSangue> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public AnaliseSolicitacaoSangue getAnalise() {
		return analise;
	}

	public void setAnalise(AnaliseSolicitacaoSangue analise) {
		this.analise = analise;
	}

	public int getResultado() {
		return decisao;
	}

	public void setResultado(int resultado) {
		this.decisao = resultado;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getDecisaoStr() {
		
		if(decisao == 1)
			decisaoStr = "Aprovado";
		else
			decisaoStr = "Reprovado";
		
		return decisaoStr;
	}

	public void setDecisaoStr(String decisaoStr) {
		this.decisaoStr = decisaoStr;
	}

	public void selecionarAnalise(SolicitacaoSangue solicitacao) throws IOException{
		
		/*HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();*/
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		System.out.println(solicitacao.getCodigo());
		
		analise = new AnaliseSolicitacaoSangue();
		analise.setCodigo(1);
		analise.setDataAnalise(new Date());
		analise.setSolicitacao(solicitacao);
		
		/*FacesContext fc = FacesContext.getCurrentInstance();
	    NavigationHandler nh = fc.getApplication().getNavigationHandler();
	    nh.handleNavigation(fc, null, "/analise.xhtml?faces-redirect=true");*/
		
		FacesContext.getCurrentInstance().getExternalContext().redirect(request.getRequestURL().toString().replace("solicitacoes.xhtml", "analise.xhtml"));
		
		/*response.sendRedirect(request.getRequestURL().toString().replace("solicitacoes.xhtml", "analise.xhtml"));*/
		
	}
	
	
	public void analisar() throws IOException{
		
		/*HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();*/
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		/*System.out.println(solicitacao.getCodigo());*/
		
		/*analise = new AnaliseSolicitacaoSangue();
		analise.setCodigo(1);
		analise.setDataAnalise(new Date());*/
		/*analise.setSolicitacao(solicitacao);*/
		
		/*FacesContext fc = FacesContext.getCurrentInstance();
	    NavigationHandler nh = fc.getApplication().getNavigationHandler();
	    nh.handleNavigation(fc, null, "/analise.xhtml?faces-redirect=true");*/
		
		FacesContext.getCurrentInstance().getExternalContext().redirect(request.getRequestURL().toString().replace("analise.xhtml", "confirmacao.xhtml"));
		
		/*response.sendRedirect(request.getRequestURL().toString().replace("solicitacoes.xhtml", "analise.xhtml"));*/
		
	}

}
