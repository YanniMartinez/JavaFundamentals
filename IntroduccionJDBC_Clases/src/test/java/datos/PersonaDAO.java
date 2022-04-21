package datos;

import static datos.Conexion.*; //importa todos los métodos estáticos
import domain.Persona;
import java.sql.*;
import java.util.*;

/*A la clase que realiza operaciones sobre la base de datos directamente se le conoce 
como data access object (DAO)*/
public class PersonaDAO {
	private static final String SQL_SELECT="SELECT id_persona, nombre, apellido, email, telefono FROM persona";
	
	/*Regresa lista de objetos tipo persona*/
	public List<Persona> seleccionar(){
		Connection conn = null;
		
		//Es más conveniente para trabajar con queries
		PreparedStatement stmt = null;
		ResultSet rs=null;
		Persona persona=null;
		List<Persona> personas = new ArrayList<Persona>();
		
		try {
			//conn = Conexion.getConnection();  se puede omitir al importar los metodos staticos
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT); //Se prepara la query
			rs = stmt.executeQuery(); //Obtenemos el resultado tras ejecutar query
			
			while(rs.next()) {
				//Podriamos recuperar variable a variable pero no es eficiente
				int idPersona = rs.getInt("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				persona = new Persona(idPersona, nombre, apellido, email, telefono);
				personas.add(persona);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally { //Nos permitirá cerrar los objetos en caso de estar abiertos
			try { //Se hace el cierre de forma inversa
				Conexion.close(rs); 
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
			
		}
		return personas;
	}
}
