import java.util.Scanner;

public class Ejercicios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese su primer n?mero aqu?:");
		float num1 = teclado.nextFloat();
		System.out.println("Ingrese su segundo n?mero aqu?:");
		float num2 = teclado.nextFloat();
		System.out.println("Ingrese su tercer n?mero aqu?:");
		float num3 = teclado.nextFloat();
		
		System.out.println("Procedimiento con puros if's, s?lo imprime el mayor:");
		ordenNumeros(num1,num2,num3);
		System.out.println("Procedimiento con puros if's:");
		
		System.out.println("Procedimiento con Arreglo: ");
	}
	
	
	/*Debe dise?ar un programa que reciba 3 n?meros por consola y determine cual de los 3 n?meros es el mayor.
	Plus: Imprimir los n?meros ordenados de mayor a menor.
	Plus: Imprimir los n?meros ordenados de menor a mayor.
	*/
	public static void ordenNumeros(float num1, float num2, float num3) {
		//M?todo 1:
		if(num1 > num2) {
			if(num1<num3) {
				System.out.println("El n?mero mayor es: " +num3);
			}
			else {
				System.out.println("El n?mero mayor es: " +num1);
			}
		}
		else {
			if(num2<num3) {
				System.out.println("El n?mero mayor es: " +num3);
			}
			else {
				System.out.println("El n?mero mayor es: " +num2);
			}
		}
	}
	
	public static void ordenNumerosBonus(float num1, float num2, float num3) {
		//M?todo 1:
		float mayor=0;
		float medio=0;
		float menor=0;
		if(num1 > num2) {
			menor=num2;
			if(num1<num3) {
				medio=num1;
				System.out.println("El n?mero mayor es: " +num3);
				mayor=num3;
			}
			else {
				medio=num3;
				mayor=num1;
				System.out.println("El n?mero mayor es: " +num1);
			}
		}
		else {
			menor=num1;
			if(num2<num3) {
				medio=num2;
				mayor=num3;
				System.out.println("El n?mero mayor es: " +num3);
			}
			else {
				medio=num3;
				mayor=num2;
				System.out.println("El n?mero mayor es: " +num2);
			}
		}
		System.out.println("De forma ascendente: "+menor+", "+medio+", "+mayor);
		System.out.println("De forma descendente: "+mayor+", "+medio+", "+menor);
	}
	
	public static void ordenNumerosArr(float num1, float num2, float num3) {
		//M?todo 1:
		float arreglo[] = new float[3]; //Declaro un arreglo de 3 posiciones
		if(num1 > num2) {
			arreglo[0]=num2;
			if(num1<num3) {
				arreglo[1]=num1;
				System.out.println("El n?mero mayor es: " +num3);
				arreglo[2]=num3;
			}
			else {
				arreglo[1]=num3;
				arreglo[2]=num1;
				System.out.println("El n?mero mayor es: " +num1);
			}
		}
		else {
			arreglo[0]=num1;
			if(num2<num3) {
				arreglo[1]=num2;
				arreglo[2]=num3;
				System.out.println("El n?mero mayor es: " +num3);
			}
			else {
				arreglo[1]=num3;
				arreglo[2]=num2;
				System.out.println("El n?mero mayor es: " +num2);
			}
		}
	}

}
