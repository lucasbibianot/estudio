package br.com.lilianyfotografia.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.lilianyfotografia.entidades.Fotografo;
import br.com.lilianyfotografia.jpa.annotations.Repository;

@Repository
public class FotografoDAO {

	@Inject
	private EntityManager entityManager;

	public Fotografo getFotografo(Long codigo) {

		return this.entityManager.find(Fotografo.class, codigo);
	}
}
