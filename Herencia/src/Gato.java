/*Aqu� la clase hereda de la clase abstracta, s�lo podemos heredar, no crear objetos.*/
public class Gato extends Animal{
	int numBigotes;
	String color;
	int vidasDisponibles = 9;
	
	/*Necesitamos heredar parte del constructor del padre*/
	public Gato(String nombre, int edad, String color) {
		//Haremos uso de la palabra "super();" hace referencia al constructor del padre
		super(nombre,edad); //Le pasa estas propiedades al constructor padre. SIEMPRE ES LO PRIMERO QUE DEBE DE IR
		this.color = color;
	}
	
	//Es necesario poner un override porque est�mos sobreescribiendo el m�todo
	@Override
	public String comer() {
		return "Comiendo at�n ";
	}
	
	/*@Override
	public String dormir() {
		return "Zzzzzzz";
	}*/
}
