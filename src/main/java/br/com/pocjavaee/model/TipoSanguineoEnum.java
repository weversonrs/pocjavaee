package br.com.pocjavaee.model;

public enum TipoSanguineoEnum {

	APOSITIVO("A+"), ANEGATIVO("A-"), ABPOSITIVO("AB+"), ABNEGATIVO("AB-"), OPOSITIVO("O+"), ONEGATIVO("O-");
	
	private final String tipo;
    
	TipoSanguineoEnum(String valor){
        tipo = valor;
    }
	
	public String getValor(){
        return tipo;
    }
}
