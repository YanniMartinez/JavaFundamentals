package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrival=true";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "admin";
	
	public static DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		//configurando valores de los parametros
		ds.setUrl(JDBC_URL);
		ds.setUsername(JDBC_USER);
		ds.setPassword(JDBC_PASSWORD);
		
		//Configurando tamaño inicial del pool de conexiones
		ds.setInitialSize(5); //En este caso iniciamos con 5 conexiones, empezar con pocos e iniciar de apoco
		return ds;
	}
	
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
