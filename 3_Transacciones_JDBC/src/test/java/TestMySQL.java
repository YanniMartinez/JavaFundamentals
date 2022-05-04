import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class TestMySQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String  url="jdbc:mysql://localhost:3306/test"; //Cadena de conexión
		//La sintaxis es: jdbc:Base://ip:Puerto/nombreBase
		String  url="jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&"
				+ "serverTimezone=UTC&allowPublicKeyRetrival=true";
		/*Despues del simbolo de ? podemos usar parametros, por ejemplo zona horaria, 
		 * uso de SSL y más
		 * allowPublicKeyRetrival=true sirve para conectar de forma exitosa a MySQL*/
		
		//La siguiente linea ya no es muy usada pero puede encontrarse aún en otras versiones, sobre todo en aplicaciones web
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		/* Para la Variable de conexión. Es necesario importar de Java.sql
		 * Paramestros: URL, usuario y password
		 * Siempre deberá ir en un bloque try catch*/
		try {
			Connection conexion = DriverManager.getConnection(url,"user","password");
			
			/*Creación de objeto statement que permite realizar sentencias*/
			Statement instruccion = conexion.createStatement(); //Hacemos uso de interfaz sql
			String sql = "SELECT * FROM persona ";
			
			//Ejecución de la instrucción
			ResultSet resultado = instruccion.executeQuery(sql); //Ejecuta la query
			
			/*Como devuelve más de un resultado entonces usamos un ciclo para iterarlo*/
			while(resultado.next()) { //Si aun tiene elementos a iterar devuelve verdadero, además se posiciona en el registro
				System.out.println("Id Persona:" +  resultado.getInt("id_persona")); //Lo más recomendado es usar el nombre en vez de las columnas
				System.out.println("Nombre:" +  resultado.getInt("nombre"));
			}
			
			//Despues de usar el objeto es importante cerrarlo
			resultado.close();
			instruccion.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
		
		
	}

}
