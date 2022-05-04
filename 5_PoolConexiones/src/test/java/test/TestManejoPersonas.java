package test;

import java.sql.*;
import java.util.List;

import datos.Conexion;
import datos.PersonaDAO;
import datos.PersonaDaoJDBC;
import domain.PersonaDTO;

public class TestManejoPersonas {
	public static void main(String[] args) {
		
		Connection conexion=null;
		try {
			conexion = Conexion.getConnection();
			if(conexion.getAutoCommit()) {
				conexion.setAutoCommit(false); //Elimina el autocommit autom�tico
			}
			
			/*Tambien puede ser esto:
			PersonaDaoJDBC personaJdbc = new PersonaDaoJDBC();
			
			List<PersonaDTO> personas= personaJdbc.select();*/
			
			//Lo vuelve mucho m�s gen�rico
			PersonaDAO personaDao = new PersonaDaoJDBC();
			
			List<PersonaDTO> personas= personaDao.select();
			
			for(PersonaDTO persona:personas) {
				System.out.println("Persona DTO: " + persona);
			}
			
			//Haciendo commit
			conexion.commit();
			
		//Para que esto ocurra debemos propagar la excepci�ndesde los otros m�todos
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
/*Alta cohesi�n porque cada clase realiza su propia tarea*/