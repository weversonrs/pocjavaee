package br.com.pocjavaee.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.pocjavaee.model.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioDAO() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	   
	public Usuario retornaUsuarioPeloLogin(String login){
		Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("username", login);     
 
        return super.findOneResult(Usuario.FIND_BY_USERNAME, parameters);
	}
		  
}
