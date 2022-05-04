package datos;

import static datos.Conexion.*; //importa todos los métodos estáticos
import domain.PersonaDTO;
import java.sql.*;
import java.util.*;

/*A la clase que realiza operaciones sobre la base de datos directamente se le conoce 
como data access object (DAO)*/
public class PersonaDaoJDBC implements PersonaDAO{
	
	private Connection conexionTransaccional;
	
	private static final String SQL_SELECT="SELECT id_persona, nombre, apellido, email, telefono FROM persona";
	private static final String SQL_INSERT="INSERT INTO persona(nombre, apellido, email, telefono) values(?,?,?,?)";
	private static final String SQL_UPDATE="UPDATE persona SET nombre=', apellido=?, email=?, telefono=? WHERE id_persona=?";
	private static final String SQL_DELETE="DELETE FROM persona WHERE id_persona=?";
	
	public PersonaDaoJDBC() {
		
	}
	
	public PersonaDaoJDBC(Connection conexionTransaccional) {
		this.conexionTransaccional=conexionTransaccional;
	}
	
	/*Regresa lista de objetos tipo persona*/
	public List<PersonaDTO> select() throws SQLException{
		Connection conn = null;
		
		//Es más conveniente para trabajar con queries
		PreparedStatement stmt = null;
		ResultSet rs=null;
		PersonaDTO persona=null;
		List<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		
		try {
			//conn = Conexion.getConnection();  se puede omitir al importar los metodos staticos
			//Si la conexion transaccional es diferente de nulo entonces lo asigna, caso contrario crea una nueva
			conn = this.conexionTransaccional!=null ? this.conexionTransaccional : getConnection(); 
			stmt = conn.prepareStatement(SQL_SELECT); //Se prepara la query
			rs = stmt.executeQuery(); //Obtenemos el resultado tras ejecutar query
			
			while(rs.next()) {
				//Podriamos recuperar variable a variable pero no es eficiente
				int idPersona = rs.getInt("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				persona = new PersonaDTO(idPersona, nombre, apellido, email, telefono);
				personas.add(persona);
			}
			
			
		}finally { //Nos permitirá cerrar los objetos en caso de estar abiertos
			Conexion.close(rs);
			Conexion.close(stmt);
			if(this.conexionTransaccional==null) {
				Conexion.close(conn);
			}
		}
		return personas;
	}
	
	public int insert(PersonaDTO persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			conn = this.conexionTransaccional!=null ? this.conexionTransaccional : getConnection(); 
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, persona.getNombre()); //Se manda el nombre en la pos1
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			
			registros = stmt.executeUpdate(); //Modifica estado de la BD
			
		} finally {
			Conexion.close(stmt);
			if(this.conexionTransaccional==null) {
				Conexion.close(conn);
			}
			
		}
		
		return registros;
	}
	
	
	public int update(PersonaDTO persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			conn = this.conexionTransaccional!=null ? this.conexionTransaccional : getConnection(); 
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, persona.getNombre()); //Se manda el nombre en la pos1
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			stmt.setInt(5,persona.getIdPersona());
			
			registros = stmt.executeUpdate(); //Modifica estado de la BD
			
		}finally {
			Conexion.close(stmt);
			if(this.conexionTransaccional==null) {
				Conexion.close(conn);
			}
			
		}
		
		return registros;
	}
	
	
	public int delete(PersonaDTO persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			conn = this.conexionTransaccional!=null ? this.conexionTransaccional : getConnection(); 
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1,persona.getIdPersona());
			
			registros = stmt.executeUpdate(); //Modifica estado de la BD
			
		} finally {
			Conexion.close(stmt);
			if(this.conexionTransaccional==null) {
				Conexion.close(conn);
			}
			
		}
		
		return registros;
	}
}
