package br.org.celiolemos.excecoes;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 6287888301811335915L;

	public NaoEncontrado() {
		super();
	}

	public NaoEncontrado(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NaoEncontrado(String message, Throwable cause) {
		super(message, cause);
	}

	public NaoEncontrado(String message) {
		super(message);
		Logger.getLogger(this.getClass().getName()).warning(message);
	}

	public NaoEncontrado(Throwable cause) {
		super(cause);
	}
	
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    
    @Override
    public String toString() {
    	return this.getClass().getName();
    }

}
