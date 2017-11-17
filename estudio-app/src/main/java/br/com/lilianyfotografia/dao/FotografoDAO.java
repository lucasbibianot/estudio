package br.com.lilianyfotografia.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.lilianyfotografia.entidades.Fotografo;

public class FotografoDAO {

	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public FotografoDAO() {
		/*
		 * CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO
		 * persistence.xml
		 */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("estudio-app-pu");

		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public Fotografo getFotografo(Long codigo){
		 
		return this.entityManager.find(Fotografo.class, codigo);
	}
}
