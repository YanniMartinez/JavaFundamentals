package paquete1;
//Aqu� no se necesita importar porque estamos en el mism paquete
public class Cuenta {
	
	/*Modificador de acceso default, se puede acceder a los atributos
	 * y objetos del mismo paquete*/
	String estadoCuenta() {
		Persona persona = new Persona();
		persona.nombre = "Yann";
		return "";
	}
}
