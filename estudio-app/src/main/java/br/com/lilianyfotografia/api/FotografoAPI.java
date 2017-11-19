package br.com.lilianyfotografia.api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.lilianyfotografia.dao.FotografoDAO;
import br.com.lilianyfotografia.dto.FotografoDTO;
import br.com.lilianyfotografia.entidades.Fotografo;
import br.com.lilianyfotografia.security.annotations.JWTTokenNeeded;

@Path("fotografo-api")
@RequestScoped
public class FotografoAPI {

	@Inject
	private FotografoDAO dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/fotografo/{codigo}")
	@JWTTokenNeeded
	public FotografoDTO GetPessoa(@PathParam("codigo") Long codigo) {

		Fotografo entity = dao.getFotografo(codigo);

		if (entity != null)
			return new FotografoDTO(entity.getIdFotografo(), entity.getNomeFotografo());

		return null;
	}
}
