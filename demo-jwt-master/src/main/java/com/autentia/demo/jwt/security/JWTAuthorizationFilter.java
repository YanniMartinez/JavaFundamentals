package com.autentia.demo.jwt.security;

import static com.autentia.demo.jwt.security.Constants.HEADER_AUTHORIZACION_KEY;
import static com.autentia.demo.jwt.security.Constants.SUPER_SECRET_KEY;
import static com.autentia.demo.jwt.security.Constants.TOKEN_BEARER_PREFIX;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

//verificará que el usuario es autenticado mediante el token
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	public JWTAuthorizationFilter(AuthenticationManager authManager) {
		super(authManager);
	}

	/**
	 * Recibe peticion
	 * */
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//Obtienes el encabezado
		String header = req.getHeader(HEADER_AUTHORIZACION_KEY);
		//Si el header es nulo o no tiene el token entonces solo hace un return
		if (header == null || !header.startsWith(TOKEN_BEARER_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}
		//Si se cumple entonces recibe la autenticación, de esta manera accederá al usuario que pide la autenticacioon
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		//Reconoce el usuario que hace la petición.
		SecurityContextHolder.getContext().setAuthentication(authentication);
		//Es para mandar a llamar al siguiente filtro
		chain.doFilter(req, res);
	}

	/**
	 * Obtiene la autenticación del header
	 * */
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_AUTHORIZACION_KEY); //De la petición que reciba saca el header
		if (token != null) { //Si el token no es nulo entonces pasa a la comprobación
			// Se procesa el token y se recupera el usuario.
			String user = Jwts.parser()
						.setSigningKey(SUPER_SECRET_KEY) /*Manda la misma firma*/
						.parseClaimsJws(token.replace(TOKEN_BEARER_PREFIX, "")) /*Verifica que se tenga la firma*/
						.getBody() /*Obtiene el cuerpo*/
						.getSubject(); /*Obtiene el sujeto*/

			if (user != null) { //Si obtiene un usuario y no es nulo
				//Procede a ejecutar la petición.
				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>()); 
			}
			//Si no se cumple entonces retorna el nulo
			return null;
		}
		//Si no se cumple entonces retorna el nulo
		return null;
	}
}
