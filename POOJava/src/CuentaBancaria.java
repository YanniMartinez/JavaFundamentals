
public class CuentaBancaria {
	String institución;
	String beneficiario;
	float saldo;
	long cuenta;
	String producto;
	String dirección;
	String RFC;
	
	CuentaBancaria(){
		
	}
	
	CuentaBancaria(String nombre){
		this.beneficiario= nombre;
	}
	
	CuentaBancaria(String nombre,  float saldo){
		this.beneficiario= nombre;
		this.saldo=saldo;
	}
	
	public void depositos(float monto) {
		this.saldo = this.saldo + monto;
	}
	
	public void retiros(float monto) {
		if(this.saldo > monto && monto > 0) {
			this.saldo = this.saldo - monto;
		}
	}
	
	public float consultarSaldo() {
		
		return this.saldo;
	}
	
	public String estadoDeCuenta() {
		
		return "";
	}
	
}
