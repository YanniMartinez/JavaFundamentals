package test;

import java.util.List;

import datos.PersonaDAO;
import domain.Persona;

public class TestManejoPersonas {
	public static void main(String[] args) {
		PersonaDAO personaDAO = new PersonaDAO();
		List<Persona> personas = personaDAO.seleccionar();
		for(Persona persona: personas) { //Forma de recorrer arreglo en base a la lista
			System.out.println("Persona: " + persona);
		}
		
		/*implementaci�n de funci�n lambda*/
		
		/*personas.forEach(persona -> {
			System.out.println("Persona: " + persona);
		});*/
	}
}
/*Alta cohesi�n porque cada clase realiza su propia tarea*/