import java.util.Scanner;
public class CiclosJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingresa el primer n?mero: ");
		int num1= teclado.nextInt();
		
		//tabla(num1);
		numeroParImpar(num1);
	}
	
	/**
	 * Crear un metodo que reciba por parametro un n?mero y nos muestre la 
	 * tabla de multiplicar de ese n?mero
	 * Ejemplo:
	 * 1 X 1 = 1
	 * 1 X 2 = 2
	 * 1 X 3 = 3
	 * ...
	 * 1 X 10 = 10

	 * */
	public static void tabla(int numero) {
		System.out.println("La tabla de multiplicar de "+numero+ " es: ");
		for(int i = 0; i<10; i++) {
			System.out.println(numero+" x "+(i+1)+" = "+(numero*(i+1)));
		}
	}
	
	/*Hacer un programa que pida un n?mero por teclado
	 * Se tiene que hacer un recorrido desde 1 hasta el numero introducido
	 * Tiene que imprimir la suma de los numeros pares e imparres*/
	public static void numeroParImpar(int numero) {
		int par=0; //Declaracion de variables para almacenar resultado de pares
		int impar=0; //Declaracion de variables para almacenar resultado de impares
		int contador = 1; //La variable nos servir? para evitar que el ciclo se haga infinito, y llevar la cuenta
		//de en que n?mero va
		for(int i=1; i<numero+1; i++) { 	//i++  <=> i = i+1;
			if(i %2 == 0) { //Si el residuo del numero entre 2 es igual a 0 entonces signfica que es par.
				par = par + i; //0+2 +4 + 6 +8 +10
			}
			else { //Si no se cumpli? lo anterior entonces ejecuta lo siguiente:
				impar = impar + i; // 0 + 1 + 3 +5 +7 +9 +11
			}
		}
		System.out.println("La suma de n?meros pares hasta "+numero+" es: "+par);
		System.out.println("La suma de n?meros impares hasta "+numero+" es: "+impar);
		
		//Ejemplo usando ciclo While      
		par=0;
		impar=0;
		//Ejemplo usando For:
		while(contador <=numero) { //Ouede no ejecutarse ninguna vez
			if(contador %2 ==0) { //Si el residuo del numero entre 2 es igual a 0 entonces signfica que es par.
				par = par + contador;
			}
			else { //Si no se cumpli? lo anterior entonces ejecuta lo siguiente:
				impar = impar + contador;
			}
			
			contador= contador +1; // Aumenta la variable, de no hacerlo nunca saldremos del ciclo.
			//contador++; Es equivalente a la linea de arriba
		}
		System.out.println("La suma de n?meros pares hasta "+numero+" es: "+par);
		System.out.println("La suma de n?meros impares hasta "+numero+" es: "+impar);
		
		par=0;
		impar=0;
		contador = 1; //Para regresar al valor original.
		//Ejemplo usando Do-While //Siempre se ejecuta akmenos 1 vez
		do { //Haz: 
			if(contador %2 ==0) { //Si el residuo del numero entre 2 es igual a 0 entonces signfica que es par.
				par = par + contador;
			}
			else { //Si no se cumpli? lo anterior entonces ejecuta lo siguiente:
				impar = impar + contador;
			}
			contador = contador +1; //Hace que aumente el contador para que llegue a n. Pasar? de 1 a N
		}while(contador<=numero); //Mientras el contador sea menor o igual al n?mero repite el proceso.
		
		System.out.println("La suma de n?meros pares hasta "+numero+" es: "+par);
		System.out.println("La suma de n?meros impares hasta "+numero+" es: "+impar);
	}
	/*10
	 * 2+4+6+8+10 = 20
	 * 1+3+5+7+9 = 25
	 * */
	// control + s
}
