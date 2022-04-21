package test;

import java.util.List;

import datos.PersonaDAO;
import domain.Persona;

public class TestManejoPersonas {
	public static void main(String[] args) {
		PersonaDAO personaDAO = new PersonaDAO();
		List<Persona> personas = personaDAO.seleccionar();
		
		//Insertando un nuevo objeto de tipo persona
		Persona personaNueva = new Persona("Yanni", "Martinez", "tester@mail.com","550123456789");
		personaDAO.insertar(personaNueva);
		
		for(Persona persona: personas) { //Forma de recorrer arreglo en base a la lista
			System.out.println("Persona: " + persona);
		}
		
		/*implementación de función lambda*/
		
		/*personas.forEach(persona -> {
			System.out.println("Persona: " + persona);
		});*/
	}
}
/*Alta cohesión porque cada clase realiza su propia tarea*/