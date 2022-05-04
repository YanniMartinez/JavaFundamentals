package test;

import java.util.List;

import datos.UsuarioJDBC;
import domain.Usuario;

public class ManejoUsuarios {
	public static void main(String[] args) {
		UsuarioJDBC usuarioJdbc = new UsuarioJDBC();
		
		//Ejecutando el listado de usuarios
		List<Usuario> usuarios= usuarioJdbc.seleccionar();
		
		//Insertando usuario
		Usuario usuarioInsert= new Usuario("Yann","123");
		usuarioJdbc.insertar(usuarioInsert);
		
		//Modificando usuario
		Usuario usuarioMod= new Usuario(1,"Yann Martinez","1234");
		usuarioJdbc.actualizar(usuarioMod);
		
		//Eliminando usuario directamente con metodo e instancia dentro del mismo
		usuarioJdbc.eliminar(new Usuario(2));
		
		for(Usuario usuario: usuarios) {
			System.out.println("Usuario: " + usuario);
		}
	}
}
