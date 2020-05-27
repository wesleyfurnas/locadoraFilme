package br.ufc.quixada;

/**
 * @author Anderson Uchoa
 */

public class DAOException extends RuntimeException{

	
	private static final long serialVersionUID = 3107865679724865428L;

	public DAOException() {
		super();
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
}

}
