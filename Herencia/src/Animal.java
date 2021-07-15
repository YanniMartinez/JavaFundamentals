/*El abstracto dice que hacer pero no como hacerlo. Debemos tener por lo menos un m�todo abstracto
 * El abstracto solo aplica sobre m�todos, no sobre atributos
 * PRINCIPAL USO:
 * Se usa para clases que s�lo queremos que se hereden*/
public abstract class Animal {
	String nombre;
	int patas;
	int edad;
	
	/*M�todo Abstracto, ser� forzoso usarlo cuando heredemos*/
	public abstract String comer();
	
	/*Metodo NO abstracto*/
	public String dormir() {
		return "Zzzzzz";
	}
	
	//Obliga a los hijos a usar estos m�todos abstractos
}
/*Las clases abstractas No se pueden instanciar*/