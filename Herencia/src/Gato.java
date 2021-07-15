/*Aquí la clase hereda de la clase abstracta, sólo podemos heredar, no crear objetos.*/
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
	
	//Es necesario poner un override porque estámos sobreescribiendo el método
	@Override
	public String comer() {
		return "Comiendo atún ";
	}
	
	/*@Override
	public String dormir() {
		return "Zzzzzzz";
	}*/
}
