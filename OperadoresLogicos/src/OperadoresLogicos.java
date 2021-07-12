import java.util.Scanner;
public class OperadoresLogicos {

	/**
	 * Función principal
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * OPERADORES LÓGICOS
		 * 
		 * a == b es igual a b
		 * a>b a es mayor que b
		 * a < b a es menor que
		 * a != b a es diferente de 
		 * >=, <=
		 * 
		 * */
		System.out.println(saludo());
		OperadoresLogicos operador = new OperadoresLogicos();
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingresa tu nombre aquí:");
		String textoPrueba = teclado.nextLine();
		saludoScanner(textoPrueba);
		saludoScanner2(textoPrueba);
	}
	
	//Manejo de Métodos
	//publico desde cualquier lado puedo acceder a este método.
	//Método stático se refiere a que para acceder a este método no necesitamos instanciar el objeto
	
	/**
	 * Método Stático
	 * @return Cadena Retorna una cadena.
	 * */
	public static String saludo() {
		
		return "Saludos :D";
	}
	
	/**
	 * @param nombre indica el nombre que recibe la función
	 * */
	public static void saludoScanner(String nombre) {
		System.out.println("Hola: " + nombre);
	}
	
	/**
	 * @param nombre indica el nombre que recibe la función
	 * @return CadenaSaludo Regresa una cadena que simula un saludo.
	 * */
	public static String saludoScanner2(String nombre) {
		return "Hola: " + nombre;
	}

}
