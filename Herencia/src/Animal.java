/*El abstracto dice que hacer pero no como hacerlo. Debemos tener por lo menos un método abstracto
 * El abstracto solo aplica sobre métodos, no sobre atributos
 * PRINCIPAL USO:
 * Se usa para clases que sólo queremos que se hereden*/
public abstract class Animal {
	String nombre;
	int patas;
	int edad;
	
	/*Método Abstracto, será forzoso usarlo cuando heredemos*/
	public abstract String comer();
	
	/*Metodo NO abstracto*/
	public String dormir() {
		return "Zzzzzz";
	}
	
	//Obliga a los hijos a usar estos métodos abstractos
}
/*Las clases abstractas No se pueden instanciar*/