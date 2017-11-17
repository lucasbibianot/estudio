package br.com.lilianyfotografia.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.lilianyfotografia.FotografoDTO;
import br.com.lilianyfotografia.dao.FotografoDAO;
import br.com.lilianyfotografia.entidades.Fotografo;

@Path("fotografo-api")
public class FotografoAPI {

	private final FotografoDAO dao = new FotografoDAO();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/fotografo/{codigo}")
	public FotografoDTO GetPessoa(@PathParam("codigo") Long codigo) {

		Fotografo entity = dao.getFotografo(codigo);

		if (entity != null)
			return new FotografoDTO(entity.getIdFotografo(), entity.getNomeFotografo());

		return null;
	}
}
