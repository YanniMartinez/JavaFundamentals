package datos;

import static datos.Conexion.*; //importa todos los métodos estáticos
import domain.Persona;
import java.sql.*;
import java.util.*;

/*A la clase que realiza operaciones sobre la base de datos directamente se le conoce 
como data access object (DAO)*/
public class PersonaDAO {
	private static final String SQL_SELECT="SELECT id_persona, nombre, apellido, email, telefono FROM persona";
	private static final String SQL_INSERT="INSERT INTO persona(nombre, apellido, email, telefono) values(?,?,?,?)";
	private static final String SQL_UPDATE="UPDATE persona SET nombre=', apellido=?, email=?, telefono=? WHERE id_persona=?";
	
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
	
	public int insertar(Persona persona) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, persona.getNombre()); //Se manda el nombre en la pos1
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			stmt.setInt(5,persona.getIdPersona());
			
			registros = stmt.executeUpdate(); //Modifica estado de la BD
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
			
		}
		
		return registros;
	}
	
	
	public int actualizar(Persona persona) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, persona.getNombre()); //Se manda el nombre en la pos1
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			
			registros = stmt.executeUpdate(); //Modifica estado de la BD
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
			
		}
		
		return registros;
	}
}
