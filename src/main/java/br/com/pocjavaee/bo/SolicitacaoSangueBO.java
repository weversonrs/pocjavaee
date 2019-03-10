package br.com.pocjavaee.bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Min;

import br.com.pocjavaee.model.Paciente;
import br.com.pocjavaee.model.SolicitacaoSangue;
import br.com.pocjavaee.model.TipoSanguineo;
import br.com.pocjavaee.model.TipoSanguineoEnum;
import br.com.pocjavaee.model.UnidadeHospitalar;

public class SolicitacaoSangueBO {

	private SolicitacaoSangue solicitacao = null;
	private UnidadeHospitalar selectedUnidade;
	private Paciente selectedPaciente;
	private List<UnidadeHospitalar> unidades = null;
	private Date dataSolicitacao = null;
	private List<SelectItem> pacientes = null;
	@Min(1)
	private int quantidadeBolsa;
	private List<TipoSanguineo> tiposSangue = null;
	private List<SelectItem> tiposSanguineos = null;
	private TipoSanguineo selectedTipoSanguineo;
	private String justificativa;
	

	public SolicitacaoSangueBO(){
		setSolicitacao(new SolicitacaoSangue());
		
		selectedUnidade = null;
		selectedPaciente = null;
		selectedTipoSanguineo = null;
		justificativa = "";
		
		dataSolicitacao = new Date();
		
		unidades = new ArrayList<UnidadeHospitalar>();
		
		UnidadeHospitalar unidade1 = new UnidadeHospitalar();
		unidade1.setCodigo(1);
		unidade1.setNome("UNIDADE 1");
				
		List<Paciente> pacientes = new ArrayList<Paciente>();
		pacientes.add(new Paciente(1, "JOAO", new Date(), "MASCULINO", "A+", "CIRURGIA"));
		pacientes.add(new Paciente(2, "JOSE", new Date(), "MASCULINO", "B+", "CIRURGIA"));
		pacientes.add(new Paciente(3, "MARIA", new Date(), "FEMININO", "AB+", "CIRURGIA"));
		pacientes.add(new Paciente(4, "ANA", new Date(), "FEMININO", "O+", "CIRURGIA"));
		pacientes.add(new Paciente(5, "BIA", new Date(), "FEMININO", "O-", "CIRURGIA"));
		
		unidade1.setPaciente(pacientes);
		
		unidades.add(unidade1);
		
		UnidadeHospitalar unidade2 = new UnidadeHospitalar();
		unidade2.setCodigo(1);
		unidade2.setNome("UNIDADE 2");
				
		List<Paciente> pacientes1 = new ArrayList<Paciente>();
		pacientes1.add(new Paciente(1, "JOAO 2", new Date(), "MASCULINO", "A+", "CIRURGIA"));
		pacientes1.add(new Paciente(2, "JOSE 2", new Date(), "MASCULINO", "B+", "CIRURGIA"));
		pacientes1.add(new Paciente(3, "MARIA 2", new Date(), "FEMININO", "AB+", "CIRURGIA"));
		pacientes1.add(new Paciente(4, "ANA 2", new Date(), "FEMININO", "O+", "CIRURGIA"));
		pacientes1.add(new Paciente(5, "BIA 2", new Date(), "FEMININO", "O-", "CIRURGIA"));
		
		unidade2.setPaciente(pacientes1);
		
		unidades.add(unidade2);
		
	}

	public SolicitacaoSangue getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoSangue solicitacao) {
		this.solicitacao = solicitacao;
	}

	public UnidadeHospitalar getSelectedUnidade() {
		return selectedUnidade;
	}

	public void setSelectedUnidade(UnidadeHospitalar selectedUnidade) {
		this.selectedUnidade = selectedUnidade;
	}

	public Paciente getSelectedPaciente() {
		return selectedPaciente;
	}

	public void setSelectedPaciente(Paciente selectedPaciente) {
		this.selectedPaciente = selectedPaciente;
	}

	public List<SelectItem> getUnidades() {
		
		List<SelectItem> items = new ArrayList<SelectItem>();  
	    for (UnidadeHospitalar e : this.unidades) {  
	        // observem que o value do meu SelectItem a própria entidade  
	        items.add(new SelectItem(e, e.getNome()));  
	    }  
	    return items;
	}

	public void setUnidades(List<UnidadeHospitalar> unidades) {
		this.unidades = unidades;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public List<SelectItem> getPacientes() {
		
		pacientes = new ArrayList<SelectItem>();  

		if(selectedUnidade != null) {
			
			for (Paciente e : this.selectedUnidade.getPaciente()) {  
				// observem que o value do meu SelectItem a própria entidade  
				pacientes.add(new SelectItem(e, e.getNome()));  
			}
		}
		
		return pacientes;
	}

	public void setPacientes(List<SelectItem> pacientes) {
		this.pacientes = pacientes;
	}

	public int getQuantidadeBolsa() {
		return quantidadeBolsa;
	}

	public void setQuantidadeBolsa(int quantidadeBolsa) {
		this.quantidadeBolsa = quantidadeBolsa;
	}

	public List<TipoSanguineo> getTiposSangue() {
		return tiposSangue;
	}

	public void setTiposSangue(List<TipoSanguineo> tiposSangue) {
		this.tiposSangue = tiposSangue;
	}

	public List<SelectItem> getTiposSanguineos() {
		
		if(tiposSanguineos == null) {
			List<TipoSanguineo> listaTipoSangue = new ArrayList<TipoSanguineo>();
			listaTipoSangue.add(new TipoSanguineo(1, TipoSanguineoEnum.ANEGATIVO.getValor()));
			listaTipoSangue.add(new TipoSanguineo(2, TipoSanguineoEnum.APOSITIVO.getValor()));
			listaTipoSangue.add(new TipoSanguineo(3, TipoSanguineoEnum.ABNEGATIVO.getValor()));
			listaTipoSangue.add(new TipoSanguineo(4, TipoSanguineoEnum.ABPOSITIVO.getValor()));
			listaTipoSangue.add(new TipoSanguineo(5, TipoSanguineoEnum.ONEGATIVO.getValor()));
			listaTipoSangue.add(new TipoSanguineo(6, TipoSanguineoEnum.OPOSITIVO.getValor()));
			
			tiposSanguineos = new ArrayList<SelectItem>();  
			
			for (TipoSanguineo e : listaTipoSangue) {  
				// observem que o value do meu SelectItem a própria entidade  
				tiposSanguineos.add(new SelectItem(e, e.getNome()));  
			}
		}		
		
		return tiposSanguineos;
	}

	public void setTiposSanguineos(List<SelectItem> tiposSanguineos) {
		this.tiposSanguineos = tiposSanguineos;
	}

	public TipoSanguineo getSelectedTipoSanguineo() {
		return selectedTipoSanguineo;
	}

	public void setSelectedTipoSanguineo(TipoSanguineo selectedTipoSanguineo) {
		this.selectedTipoSanguineo = selectedTipoSanguineo;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public void atualizarPaciente() {
		setSelectedUnidade(selectedUnidade);
	}
	
	public void solicitar() throws IOException {
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		response.sendRedirect(request.getRequestURL().toString().replace("solicitacao.xhtml", "confirmacao.xhtml"));
	}
	
	
	
}
