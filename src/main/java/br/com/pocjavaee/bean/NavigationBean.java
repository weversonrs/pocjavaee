package br.com.pocjavaee.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name="navigationBean")
public class NavigationBean {
	
	public String inicio() {
		System.out.println("navegacao");
		return "index";
	}
	
	public String home() {
		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String base = url.substring(0, url.length() - uri.length() + ctx.length());		
		
		return base + "/home.xhtml";
	}

}
