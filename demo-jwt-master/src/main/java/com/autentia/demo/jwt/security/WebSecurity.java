package com.autentia.demo.jwt.security;

import static com.autentia.demo.jwt.security.Constants.LOGIN_URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import static com.autentia.demo.jwt.security.Constants.HEADER_AUTHORIZACION_KEY;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	public WebSecurity(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		/*
		 * 1. Se desactiva el uso de cookies
		 * 2. Se activa la configuraciÃ³n CORS con los valores por defecto
		 * 3. Se desactiva el filtro CSRF
		 * 4. Se indica que el login no requiere autenticaciÃ³n
		 * 5. Se indica que el resto de URLs esten securizadas
		 */
		
		/*
		 * Permite desactivar las Cookies:
		 * sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() 
		 * 
		 * CORS (Croos site Request Forefgery):
		 * El cors permite bloquear dominio, IP, actua como firewall
		 * 
		 * CRFS:
		 * Lo desactivamos porque no manejamos el Front-End desde java, normalmente se usa en formularios
		 * csrf().disable() deshabilita la petición enviando tokens
		 * 
		 * AurotizeRequests:
		 * Nos ayuda a permitir que esta ruta sea accesada sin que tengamos un token o hayamos
		 * iniciado sesión. La ruta del login no tiene sentido restringida porque permite hacer post desde ahí
		 * authorizeRequests().antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
		 * .authorizeRequests().antMatchers(HttpMethod.POST, "/users/")
		 * 
		 * Son las rutas libres, todas las demás peticiones tienen que estár autenticadas.
		 * Es lo que nos dice la siguiente linea:
		 * .anyRequest().authenticated().and()
		 * 
		 * Los filtros son para:
		 * 1 hacer el login
		 * 2 para comprobar las credenciales
		 * */
		httpSecurity
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.cors().and()
			.csrf().disable()
			.authorizeRequests().antMatchers(HttpMethod.POST, LOGIN_URL).permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.POST, "/users/").permitAll()
			.anyRequest().authenticated().and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager()));
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Se define la clase que recupera los usuarios y el algoritmo para procesar las passwords
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	/*Configuración del CORS*/
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				/*addMapping(/**) Le decimos que son todas las rutas
				 * allowedOrigins("*") permite las peticiones por todos lados
				 * */
				registry.addMapping("/**").allowedOrigins("*")
				.exposedHeaders(HEADER_AUTHORIZACION_KEY);
				//Aqui configuramos que headers sean visibles:
			}
		};
	}

}


/**
 * Mandamos peticion de login:
 * {
 * 	"password" : algo,
 * 	"username" : email@ejemplo.com
 * }
 * 
 * Si se ingresa mal un dato lo que dice es que es un elemento invalido
 * */
 