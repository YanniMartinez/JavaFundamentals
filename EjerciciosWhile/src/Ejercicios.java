import java.util.Scanner;

public class Ejercicios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//cicloEntradas();
		cicloDoWhile();
	}
	
	/** Escribir un programa que pida 2 numeros por consola de manera reiterada
		 * La ejecuci?n del programa terminar? cuando los numeros ingresados sean
		 * iguales.
		 * 
		 * Nota: utilizar un ciclo while
	*/
	
	/**
	 * Permite solicitar 2 n?meros de manera infina al usuario hasta que estos tengan el mismo valor,
	 * si se cumple que son iguales entonces sale del ciclo While.
	 * */
	public static void cicloEntradas() {
		boolean bandera = true;
		float num1=0;
		float num2=0;
		Scanner teclado = new Scanner(System.in);
		while(bandera==true) { //Mientras la variable sea verdadera ejecuta el ciclo
			System.out.println("Ingresa el Primer n?mero: ");
			num1= teclado.nextFloat();	//Cacha el n?mero en una variable
			
			System.out.println("Ingresa el Segundo n?mero: ");
			num2= teclado.nextFloat(); //Cacha el n?mero en una variable
			
			if(num1==num2) { //Si los n?meros tienen el mismo valor entonces cambia el valor de la variable
				bandera=false; //Con esto dejaria de cumplirse el ciclo while.
			}
		}
		System.out.println("Su primer n?mero ingresado fue: "+num1);
		System.out.println("Su segundo n?mero ingresado fue: "+num2);
	}
	
	
	/*do{
	  codigo
	  codigo
	  codigo
	  }while(condicion);*/
	/**
	 * Permite solicitar 2 n?meros de manera infina al usuario hasta que estos tengan el mismo valor,
	 * si se cumple que son iguales entonces sale del ciclo While.
	 * */
	public static void cicloDoWhile() {
		boolean bandera = true;
		float num1;
		float num2;
		Scanner teclado = new Scanner(System.in);
		do { //Haz:
			System.out.println("Ingresa el Primer n?mero: ");
			num1= teclado.nextFloat();	//Cacha el n?mero en una variable
			
			System.out.println("Ingresa el Segundo n?mero: ");
			num2= teclado.nextFloat(); //Cacha el n?mero en una variable
			
			if(num1==num2) { //Si los n?meros tienen el mismo valor entonces cambia el valor de la variable
				bandera=false; //Con esto dejaria de cumplirse el ciclo while.
			}
		}while(bandera==true); //Mientras la variable sea verdadera ejecuta el ciclo
		System.out.println("Acab? el ejemplo 1 :D");
		
		//OTRO ejemplo
		do { //Haz:
			System.out.println("Ingresa el Primer n?mero: ");
			num1= teclado.nextFloat();	//Cacha el n?mero en una variable
			
			System.out.println("Ingresa el Segundo n?mero: ");
			num2= teclado.nextFloat(); //Cacha el n?mero en una variable

		}while(num1!=num2); //Mientras la variable sea verdadera ejecuta el ciclo
		teclado.close(); //Cierra la lectura por teclado, se hace por buenas pr?cticas.	
		System.out.println("Hasta luego :D");
	}

}
