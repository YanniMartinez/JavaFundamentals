package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrival=true";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "admin";
	
	//Si este método genera una excepcion la propaga al getconecction
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}
	
	public static void close(ResultSet rs) throws SQLException {
		rs.close();
	}
	
	//Sobrecarga de metodo
	public static void close(Statement smtm) throws SQLException {
		smtm.close();
	}
	
	
	//Uso de la interfaz para mejor performance
	public static void close(PreparedStatement smtm) throws SQLException {
		smtm.close();
	}
	
	public static void close(Connection conn) throws SQLException {
		conn.close();
	}
	
}
