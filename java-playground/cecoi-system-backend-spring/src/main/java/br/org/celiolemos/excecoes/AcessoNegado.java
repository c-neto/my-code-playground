package br.org.celiolemos.excecoes;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AcessoNegado extends RuntimeException {

	private static final long serialVersionUID = 6287888301811335915L;

	public AcessoNegado() {
		super();
	}

	public AcessoNegado(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AcessoNegado(String message, Throwable cause) {
		super(message, cause);
	}

	public AcessoNegado(String message) {
		super(message);
		Logger.getLogger(this.getClass().getName()).warning(message);
	}

	public AcessoNegado(Throwable cause) {
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
