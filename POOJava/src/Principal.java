import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CuentaBancaria cuentaPersonal = new CuentaBancaria("Yann Martinez", 15000);
		//CuentaBancaria cuentaM = new CuentaBancaria();
		
		Scanner teclado = new Scanner(System.in);
		/*System.out.println("Ingresa el monto a depositar:");
		float deposito = teclado.nextFloat();
		
		System.out.println("Ingresa el monto a depositar:");
		float retiro = teclado.nextFloat();
		
		cuentaPersonal.depositos(deposito);
		cuentaPersonal.retiros(retiro);
		
		cuentaPersonal.beneficiario = "Yann";
		System.out.println("El due�o de la cuenta es: "+cuentaPersonal.beneficiario);
		System.out.println("Su saldo actual es: " + cuentaPersonal.consultarSaldo());
		
		cuentaM.beneficiario = "Carlos";
		System.out.println("El due�o de la cuenta es: "+cuentaPersonal.beneficiario);
		cuentaPersonal.consultarSaldo();*/
		
		/*
		 * Men� cajero
		 * 1. Retiro
		 * 2. Deposito
		 * 3. Imprimir saldo
		 * 4. Estado de cuenta
		 * 5. Agregar Beneficiario
		 * 6. Salir
		 * */
		int opcion = 0;
		do {
			System.out.println("Men� cajero\n"
					+ "1. Retiro\n"
					+ "2. Deposito\n"
					+ "3. Imprimir saldo\n"
					+ "4. Beneficiario de cuenta\n"
					+ "5. Agregar Beneficiario\n"
					+ "6. Salir\n");
			
			opcion = teclado.nextInt();
			//Scanner teclado = new Scanner(System.in);
			
			switch(opcion) {
				case 1:
					System.out.println("Ingrese la cantidad que desea retirar");
					float monto = teclado.nextFloat();
					cuentaPersonal.retiros(monto);
					break;
				case 2:
					System.out.println("Ingrese la cantidad que desea depositar");
					float depositos = teclado.nextFloat();
					cuentaPersonal.depositos(depositos);
					break;
				case 3:
					System.out.println("EL monto total de su saldo es: " +
							cuentaPersonal.consultarSaldo());
					break;
					
				case 4:
					System.out.println("EL Beneficiario de la cuenta es: " +
							cuentaPersonal.beneficiario);
					break;
					
				case 5:
					System.out.println("Ingrese el nombre del beneficiario");
					String nombre = teclado.nextLine();
					cuentaPersonal.beneficiario = nombre;
					break;
					
				default:
					System.out.println("Usted ingres� una opci�n incorrecta");
					break;
			}
		}while(opcion != 6);
	}

}
