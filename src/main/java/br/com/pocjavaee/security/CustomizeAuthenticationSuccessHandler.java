package br.com.pocjavaee.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
 
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
        //set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);
        
        StringBuilder url = new StringBuilder();
        
        url.append(request.getContextPath());
        
        System.out.println("AT onAuthenticationSuccess(...) function!");
        
        for (GrantedAuthority auth : authentication.getAuthorities()) {
        	
        	System.out.println(auth.getAuthority());
        	
        	if(auth.getAuthority().equals("ROLE_USER")) 
        		url.append("/pages/protected/doador/solicitarDoacao.xhtml"); 
        	else
        		url.append("/pages/protected/home.xhtml"); 
        }
        
        System.out.println(url.toString());
        
        response.sendRedirect(url.toString());
        
	}
}