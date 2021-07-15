
public class Perro extends Animal{ //Hace referencia a que hereda de animal

	String raza = "";
	String color = "";
	int peos = 0;
	
	public String ladrar() {
		return "Guau Guau";
	}
	
	@Override
	public String comer() {
		return "Comiendo croquetas";
	}
}
