
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Animal animal = new Animal();
		//animal.nombre = "Gato";
		//System.out.println(animal.beber());
		
		Perro canelo = new Perro("Canelo",3); //Se cambió la instanciación
		System.out.println(canelo.ladrar());
		System.out.println(canelo.dormir());
		System.out.println(canelo.nombre); //Imprimimos su nombre
		System.out.println(canelo.edad); //Imprimimos su edad
		
		Gato pulgas = new Gato("Bigotes",2,"Naranja"); //Estamos instanciando un nuevo objeto Gato
		System.out.println(pulgas.comer());
	}

}
