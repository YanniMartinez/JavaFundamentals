package com.autentia.demo.jwt.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public abstract Usuario findByUsername(String username);
}
