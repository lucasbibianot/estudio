package br.com.lilianyfotografia.security.api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.net.HttpHeaders;

import br.com.lilianyfotografia.security.SecurityJWT;
import br.com.lilianyfotografia.service.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class UserEndPoint {

	@Inject
	private SecurityJWT securityJWT;
	@Inject
	private UserService userService;
	
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("login") String login,
                                     @FormParam("password") String password) {
        try {
 
            // Authenticate the user using the credentials provided
        	userService.autenticar(login, password);
 
            // Issue a token for the user
            String token = this.securityJWT.createJWT(login, 600000);
 
            // Return the token on the response
            return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
 
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
	
}
