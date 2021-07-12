package paquete1;
//Aquí no se necesita importar porque estamos en el mism paquete
public class Cuenta {
	
	/*Modificador de acceso default, se puede acceder a los atributos
	 * y objetos del mismo paquete
	 * */
	
	
	String estadoCuenta() {
		Persona persona = new Persona();
		persona.nombre = "Yann";
		//persona.edad = 21; Marca error porque no es desde su clase.
		persona.domicilio = "CDMX"; //Si puede accesar porque está en el mismo paquete
		
		return "";
	}
}
