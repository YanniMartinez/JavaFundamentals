package test;

import java.sql.*;
import java.util.List;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;

public class TestManejoPersonas {
	public static void main(String[] args) {
		
		Connection conexion=null;
		try {
			conexion = Conexion.getConnection();
			if(conexion.getAutoCommit()) {
				conexion.setAutoCommit(false); //Elimina el autocommit automático
			}
			
			PersonaDAO personaJdbc = new PersonaDAO();
			
			Persona cambioPersona = new Persona();
			cambioPersona.setIdPersona(2);
			cambioPersona.setNombre("Karla Ivone");
			cambioPersona.setApellido("Gomez");
			cambioPersona.setEmail("ejemplo@ejemplo.com");
			cambioPersona.setTelefono("555521123");
			personaJdbc.actualizar(cambioPersona);
			
			Persona nuevaPersona= new Persona("Emmanuel", "Palaez", "ejemplo2@gmail.com","5511223344");
			personaJdbc.insertar(nuevaPersona);
			
			//Haciendo commit
			conexion.commit();
			
		//Para que esto ocurra debemos propagar la excepcióndesde los otros métodos
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
			System.out.println("Entramos al Rollback");
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(System.out);
			}
		}
	}
}
/*Alta cohesión porque cada clase realiza su propia tarea*/