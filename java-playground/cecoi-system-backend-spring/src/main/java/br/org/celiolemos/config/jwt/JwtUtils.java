package br.org.celiolemos.config.jwt;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.org.celiolemos.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {

	/**
	 * variavel de ambiente com chave do jwt trocar pra System.getEnv depois
	 */
	private final static String CHAVE = "CHAVE_JWT";

	public static String gerarToken(Usuario usuario) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String usuarioJson = mapper.writeValueAsString(usuario);
		Date agora = new Date();
		Long validade = 1000L * 60L * 60L;
		return Jwts.builder().claim("userDetails", usuarioJson).setIssuer("br.org.celiolemos")
				.setSubject(usuario.getNome()).setExpiration(new Date(agora.getTime() + validade))
				.signWith(SignatureAlgorithm.HS512, CHAVE).compact();
	}

	public static Usuario parseToken(String token) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		String credentialsJson = Jwts.parser().setSigningKey(CHAVE).parseClaimsJws(token).getBody()
				.get("userDetails", String.class);
		return mapper.readValue(credentialsJson, Usuario.class);
	}

}
