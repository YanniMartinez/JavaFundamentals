/*Aqu� la clase hereda de la clase abstracta, s�lo podemos heredar, no crear objetos.*/
public class Gato extends Animal{
	int numBigotes;
	String color;
	int vidasDisponibles = 9;
	
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
