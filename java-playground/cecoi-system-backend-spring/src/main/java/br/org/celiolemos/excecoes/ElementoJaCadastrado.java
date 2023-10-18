package br.org.celiolemos.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ElementoJaCadastrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ElementoJaCadastrado() {
		super();
	}

	public ElementoJaCadastrado(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ElementoJaCadastrado(String message, Throwable cause) {
		super(message, cause);
	}

	public ElementoJaCadastrado(String message) {
		super(message);
	}

	public ElementoJaCadastrado(Throwable cause) {
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
