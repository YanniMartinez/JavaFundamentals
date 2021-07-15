
public class Perro extends Animal{ //Hace referencia a que hereda de animal

	String raza = "";
	String color = "";
	int peso = 0;
	
	/*Se puede hacer sólo el constructor para llenar datos del padre*/
	public Perro(String nombre, int edad) {
		super(nombre,edad);
	}
	
	public String ladrar() {
		return "Guau Guau";
	}
	
	@Override
	public String comer() {
		return "Comiendo croquetas";
	}
}
