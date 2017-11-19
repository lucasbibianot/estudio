package br.com.lilianyfotografia.service;

import javax.enterprise.context.RequestScoped;

import br.com.lilianyfotografia.exception.UserNotAuthenticatedException;

@RequestScoped
public class UserService {

	//TODO
	public Boolean autenticar(String login, String senha) throws UserNotAuthenticatedException {
		return Boolean.TRUE;
	}
	
}
