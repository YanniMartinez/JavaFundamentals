import java.util.Scanner;

public class EntradaDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingresa algo aquí:");
		String textoPrueba = teclado.nextLine();
		System.out.println("Su texto ingresado fue: "+textoPrueba);
		
		System.out.println("Ingresa otra cosa aquí:");
		textoPrueba = teclado.nextLine();
		System.out.println("Su texto ingresado fue: "+textoPrueba);
	}

}
