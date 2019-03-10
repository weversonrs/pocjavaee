package br.com.pocjavaee.bean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.pocjavaee.model.Agendamento;
import br.com.pocjavaee.model.Endereco;
import br.com.pocjavaee.model.Laboratorio;

@ManagedBean(name="agendamentoBean")
public class AgendamentoBean {
	
	private Laboratorio selectedLaboratorio;
	private Agendamento agendamento= null;
	private List<Laboratorio> laboratorios = null;
	private Date dataAgendamento = null;
	
	public AgendamentoBean(){
		
		//dataAgendamento = new Date();
		
		setAgendamento(new Agendamento());
		laboratorios = new ArrayList<Laboratorio>();
		Laboratorio lab1 = new Laboratorio();
		lab1.setCodigo(100l);
		lab1.setNome("LABORATORIO 1");
		
		Endereco endereco1 = new Endereco();
		endereco1.setBairro("Centro");
		endereco1.setCep("31000000");
		endereco1.setCidade("Belo Horizonte");
		endereco1.setEstado("MG");
		endereco1.setLogradouro("RUA A");
		endereco1.setNumero(1);
		
		lab1.setEndereco(endereco1);
		
		laboratorios.add(lab1);
		
		
		Laboratorio lab2 = new Laboratorio();
		lab2.setCodigo(100l);
		lab2.setNome("LABORATÓRIO 2");
		
		Endereco endereco2 = new Endereco();
		endereco2.setBairro("Centro");
		endereco2.setCep("31000000");
		endereco2.setCidade("Belo Horizonte");
		endereco2.setEstado("MG");
		endereco2.setLogradouro("RUA B");
		endereco2.setNumero(2);
		
		lab2.setEndereco(endereco2);
		
		laboratorios.add(lab2);
	}
	
	public Laboratorio getSelectedLaboratorio() {
		return selectedLaboratorio;
	}

	public void setSelectedLaboratorio(Laboratorio selectedLaboratorio) {
		this.selectedLaboratorio = selectedLaboratorio;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	
	public List<SelectItem> getLaboratorios() {  
	    List<SelectItem> items = new ArrayList<SelectItem>();  
	    for (Laboratorio e : this.laboratorios) {  
	        // observem que o value do meu SelectItem a própria entidade  
	        items.add(new SelectItem(e, e.getNome() + " - " + e.getEndereco().getLogradouro() + " - " + e.getEndereco().getBairro()));  
	    }  
	    return items;  
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}	

	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}
	
	public void agendar(){
		FacesContext.getCurrentInstance().getViewRoot().setViewId("/pages/protected/doador/confirmacao.xhtml");
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	public void voltar(){
		FacesContext.getCurrentInstance().getViewRoot().setViewId("/pages/protected/home.xhtml");
		FacesContext.getCurrentInstance().renderResponse();
	}

}
