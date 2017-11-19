package br.com.lilianyfotografia.security.filters;

import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import br.com.lilianyfotografia.security.SecurityJWT;
import br.com.lilianyfotografia.security.annotations.JWTTokenNeeded;

@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
@RequestScoped
public class JWTTokenNeededFilter implements ContainerRequestFilter {

	private static final Logger logger = Logger.getLogger("JWTTokenNeededFilter");

	@Inject
	private SecurityJWT securityJWT;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// Get the HTTP Authorization header from the request
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (authorizationHeader != null) {
			// Extract the token from the HTTP Authorization header
			String token = authorizationHeader.substring("Bearer".length()).trim();
			if (this.securityJWT.isTokenValid(token)) {
				logger.info("#### valid token : " + token);

			} else {
				logger.severe("#### invalid token : " + token);
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			}
		} else {
			logger.severe("Sem Autenticação");
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}

}
