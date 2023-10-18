package br.org.celiolemos.excecoes;

import java.util.Objects;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CampoObrigatorio extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ NullPointerException.class })
	public ResponseEntity<?> handleAccessDeniedException(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		StringBuffer mensagemDeErro = new StringBuffer("{\"mensagem\":\"");
		if (Objects.nonNull(ex.getMessage()))
			mensagemDeErro.append(ex.getMessage() + "\"}");
		else
			mensagemDeErro.append("Campos obrigatorios não estão preenchidos verifique sua requisição\"}");
		return new ResponseEntity<String>(mensagemDeErro.toString(), headers, HttpStatus.BAD_REQUEST);
	}
}
