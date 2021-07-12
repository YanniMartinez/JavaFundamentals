package paquete1;
//Aquí no se necesita importar porque estamos en el mism paquete
public class Cuenta {
	
	/*Modificador de acceso default, se puede acceder a los atributos
	 * y objetos del mismo paquete
	 * */
	private int edad = 21; //Al ser privado sólo puede ser accedido dentro de la clase
	
	String estadoCuenta() {
		Persona persona = new Persona();
		persona.nombre = "Yann";
		return "";
	}
}
