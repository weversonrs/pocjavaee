package br.com.pocjavaee.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.pocjavaee.model.Doador;

public class DoadorDAO extends GenericDAO<Doador>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DoadorDAO() {
		super(Doador.class);
		// TODO Auto-generated constructor stub
	}

	   
	public Doador findUserByEmail(String username){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("username", username);     
 
        return super.findOneResult(Doador.FIND_BY_USERNAME, parameters);
    }
		  
}
