/*MANEJO DE EXCEPCIONES*/
public class Principal {
	static int numerador = 10;
	static Integer denominador = null;
	static float division;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Antes de la division");
		try { //INTENTA
			division = numerador / denominador;
		}catch(ArithmeticException error) { //Si ocurre un error ejecuta lo siguiente:
			division = 0;
			System.out.println("Error: " +error.getMessage());
		}catch(NullPointerException ex) {//Si ocurre un error ejecuta lo siguiente:
			division = 0;
			System.out.println("Error: "+ex.getMessage());
			System.out.println("Segundo Catch");
		}
		System.out.println("Despues de la divisi�n");
	}
	

}
