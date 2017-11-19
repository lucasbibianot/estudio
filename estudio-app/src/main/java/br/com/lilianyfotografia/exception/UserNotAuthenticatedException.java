package br.com.lilianyfotografia.exception;

public class UserNotAuthenticatedException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7036923411191646025L;

	public UserNotAuthenticatedException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}
