package br.com.pocjavaee.dao;

import javax.persistence.Persistence;

public class GerarBaseDados {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("sisangue");

	}

}
