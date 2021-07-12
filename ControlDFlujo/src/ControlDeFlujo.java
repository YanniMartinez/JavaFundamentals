import java.util.Scanner;
public class ControlDeFlujo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingresa algo aqu�:");
		int edad = teclado.nextInt();
		String mensaje = votar(edad);
		
		System.out.println("Ingresa algo aqu�:");
		String nombre = teclado.nextLine();
		bootCamp(nombre, edad);
	}
	
	/*Escribir un programa que pida el nombre y la edad de un participante
		 si la edad es mayor o igual a 18 y menor o igual a 29, mostrar un
		 mensaje que diga "Felicidades + nombreIngresado, estas aceptado en
		 el programa de generation Java Full Stack".
		 En caso de no cumplirse la condici�n, mostrar un mensaje que diga
		 "No cumples lo requisitos para el bootcamp Java Full Stack"
	 */
	public static String bootCamp(String nombre, int edad) {
		String mensaje="";
		if(edad >=18 && edad <=29) {
			mensaje = "Felicidades "+ nombre + ", has sido aceptado en el programa de generation Java FullStack";
			
		} else {
			mensaje = "No cumples lo requisitos para el bootcamp Java Full Stack";
		}
		return mensaje;
	}
	
	public static String votar(int edad) {
		String mensaje="";
		if(edad >=18) {
			mensaje = "Felicidades, puedes votar";
			
		} else {
			mensaje = "No puedes votar";
		}
		return mensaje;
	}

}
