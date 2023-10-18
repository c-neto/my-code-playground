package br.org.celiolemos.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FalhaNaRemocao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FalhaNaRemocao() {
		super();
	}

	public FalhaNaRemocao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FalhaNaRemocao(String message, Throwable cause) {
		super(message, cause);
	}

	public FalhaNaRemocao(String message) {
		super(message);
	}

	public FalhaNaRemocao(Throwable cause) {
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
