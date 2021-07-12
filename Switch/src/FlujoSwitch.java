import java.util.Scanner;

public class FlujoSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingresa el primer número: ");
		float num1= teclado.nextFloat();
		
		System.out.println("Ingresa el segundo número:");
		float num2= teclado.nextFloat();
		
		System.out.println("Ingresa la operación que quieres realizar:");
		float num3 = teclado.nextFloat();
		
		System.out.println(angulos(num1,num2,num3));
		
		//float resultado = calculadora(num1, num2, operacion);
		//System.out.println("El resultado fue: " + resultado);
		
	}
	public void ejemplo() {
		/*Switch*/
		int dia = 7;
		String mensaje = "";
		switch(dia) {
			case 1:
				mensaje = "Lunes";
				break;
			case 2:
				mensaje = "Martes";
				break;
			case 3:
				mensaje = "Miercoles";
				break;
			case 4:
				mensaje = "Jueves";
				break;
			case 5:
				mensaje = "Viernes";
				break;
			case 6:
				mensaje = "Sabado";
				break;
			case 7:
				mensaje = "Domingo";
				break;
			default:
				mensaje ="Opción incorrecta";
				break;
		}
		System.out.println(mensaje);
	}
	
	/*Crear una calculadora que pueda sumar, restar, multiplicar y dividirr 2 números
	 * La calculadora debe perdir los dos numeros y posterior preguntar que operacion se quiere realizar,
	 * el menu es el siguiente:
	 * 1. suma
	 * 2. Resta
	 * 3. Multiplicacion
	 * 4. Division
	 * 
	 * Al final debe mostrar los resultados de la operacion y que se realizó. Se debe usar Switch*/
	public static float calculadora(float num1 , float num2, String operacion) {
		float resultado = 0;
		
		switch(operacion) {
		case "Suma":
			resultado = num1+num2;
			break;
		case "Resta":
			resultado = num1-num2;
			break;
		case "Multiplicacion":
			resultado = num1*num2;
			break;
		case "Division":
			if(num2 > 0) {
				resultado = num1/num2;
			}
			else {
				resultado = 0;
			}
			break;
		default:
			System.out.println("La operación indicada no es correcta");
			break;
		}
		return resultado;
	}
	/*Crear un programa donde se introduzcan los tres ángulos internos de un triángulo y se determine si el triángulo es válido o no.*/
	/**
	 * Permite determinar si la suma de los angulos determinan un triangulo.
	 * @param ang1 Hace referencia al angulo
	 * @param ang2 Hace referencia al angulo
	 * @param ang3 Hace referencia al angulo
	 * @return resultado Indica si el angulo está bien construido o no.
	 * */
	public static String angulos(float ang1, float ang2, float ang3) {
		String resultado = "El triángulo no es valido";
		if((ang1 + ang2 + ang3) == 180) {
			resultado = "El triángulo es valido";
		}
		return resultado;
	}
}
