package br.org.celiolemos.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FalhaNoCadastro extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FalhaNoCadastro() {
		super();
	}

	public FalhaNoCadastro(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FalhaNoCadastro(String message, Throwable cause) {
		super(message, cause);
	}

	public FalhaNoCadastro(String message) {
		super(message);
	}

	public FalhaNoCadastro(Throwable cause) {
		super(cause);
	}
}
