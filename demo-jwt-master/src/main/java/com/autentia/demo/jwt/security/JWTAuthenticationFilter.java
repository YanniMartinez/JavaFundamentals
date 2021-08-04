package com.autentia.demo.jwt.security;

import static com.autentia.demo.jwt.security.Constants.HEADER_AUTHORIZACION_KEY;
import static com.autentia.demo.jwt.security.Constants.ISSUER_INFO;
import static com.autentia.demo.jwt.security.Constants.SUPER_SECRET_KEY;
import static com.autentia.demo.jwt.security.Constants.TOKEN_BEARER_PREFIX;
import static com.autentia.demo.jwt.security.Constants.TOKEN_EXPIRATION_TIME;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.autentia.demo.jwt.usuario.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*
 * Permite hacer la autentización mediante usernames(en este caso correo) y password
 * **/
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	/**
	 * Autenticación
	 * @param request que vamos a solicitar
	 * @param Response es la respuesta
	 * */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try { //Intenta comprobar las credenciales.
			//Usamos un object mapper porque solo queremos usar el tema del username y del password.
			//Leerá los valores y los meterá a las credenciales. y decimos de que tipo de objeto es, este caso usuario.classs
			Usuario credenciales = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

			//Si los campos coinciden entonces regresamos un tocken.
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					credenciales.getUsername(), credenciales.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * Cuando la autentización se realiza de forma correcta
	 * Al token le podemos meter información. 
	 * 
	 * setSubject(((User)auth.getPrincipal()).getUsername())
	 * Establece el nombre de usuario
	 * 
	 * Establece la expiración del token:
	 * setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
	 * 
	 * Firma con el algoritmo HS512 y la clave secreta:
	 * signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();
	 * 
	 * Cuando se haya generado el token lo mandará a los headers, este lo manda al autorization y le pone el bearer
	 * response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);
	 * **/
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		//serIssuer le está pasando un url lo podemos cambiar u omitir
		String token = Jwts.builder().setIssuedAt(new Date())/*.setIssuer(ISSUER_INFO)*/
				.setSubject(((User)auth.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();
		//Mandamos la información mediante el body directamente como un texto, no como un JSON.
		//response.getWriter().write(TOKEN_BEARER_PREFIX + " " + token);
		//Agregamos el token en el header. De momento lo comentaremos porque no tenemos acceso:
		response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);
	}
}
