package br.org.celiolemos.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FalhaNaAtualizacao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FalhaNaAtualizacao() {
		super();
	}

	public FalhaNaAtualizacao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FalhaNaAtualizacao(String message, Throwable cause) {
		super(message, cause);
	}

	public FalhaNaAtualizacao(String message) {
		super(message);
	}

	public FalhaNaAtualizacao(Throwable cause) {
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
