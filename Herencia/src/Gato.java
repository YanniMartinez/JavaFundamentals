/*Aquí la clase hereda de la clase abstracta, sólo podemos heredar, no crear objetos.*/
public class Gato extends Animal{
	int numBigotes;
	String color;
	int vidasDisponibles = 9;
	
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
