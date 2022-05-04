package datos;

import static datos.Conexion.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Usuario;

public class UsuarioJDBC {
	
	private static final String SQL_SELECT="SELECT id_usuario, username, password FROM usuario";
	private static final String SQL_INSERT="INSERT INTO usuario(username, password) values(?,?)";
	private static final String SQL_UPDATE="UPDATE usuario SET username=', password=? WHERE id_usuario=?";
	private static final String SQL_DELETE="DELETE FROM usuario WHERE id_usuario=?";
	
	/*Regresa lista de objetos tipo usuario*/
	public List<Usuario> seleccionar(){
		Connection conn = null;
		
		//Es más conveniente para trabajar con queries
		PreparedStatement stmt = null;
		ResultSet rs=null;
		Usuario usuario=null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			//conn = Conexion.getConnection();  se puede omitir al importar los metodos staticos
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT); //Se prepara la query
			rs = stmt.executeQuery(); //Obtenemos el resultado tras ejecutar query
			
			while(rs.next()) {
				//Podriamos recuperar variable a variable pero no es eficiente
				int id_usuario = rs.getInt("id_usuario");
				String username = rs.getString("username");
				String password = rs.getString("password");
				usuario = new Usuario(id_usuario, username, password);
				usuarios.add(usuario);
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
		return usuarios;
	}
	
	public int insertar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, usuario.getUsername()); //Se manda el username en la pos1
			stmt.setString(2, usuario.getPassword());
			
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
	
	
	public int actualizar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, usuario.getUsername()); //Se manda el username en la pos1
			stmt.setString(2, usuario.getPassword());
			stmt.setInt(3,usuario.getId_usuario());
			
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
	
	
	public int eliminar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1,usuario.getId_usuario());
			
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
