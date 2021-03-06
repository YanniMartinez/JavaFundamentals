import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EstructurasDeDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*Acceso posicional a elementos: manipula elementos en funci?n de su posici?n en la lista.
		B?squeda de elementos: busca un elemento concreto de la lista y devuelve su posici?n.
		Rango de operaci?n: permite realizar ciertas operaciones sobre ragos de elementos dentro de la propia lista.
		implementaciones:
		ArrayList
		LinkedList
		*
		*/
		List<String> frutas2 = new ArrayList<String>();
		frutas2.add("Mango");	
		frutas2.add("Manzana");
		frutas2.add("Durazno");
		frutas2.add("Pera");
		frutas2.add("Cereza");
		frutas2.add("Mandarina");
		frutas2.add("Carambola");
		frutas2.add("Maracuya");
		frutas2.add("Platano");
		frutas2.add("Mango");
		
		for (String f : frutas2) {
			System.out.println(f);
		}
		int pera = frutas2.indexOf("Pera"); //Obtenemos el indice
		System.out.println(pera); //Imprimimos el indice
		System.out.println(frutas2.get(pera)); //Obtiene el contenido de ese indice
	
		//ARRAYLIST de enteros: Simplemente enlazado
		//int es un dato primitivo
		//Integer es un objeto
		List<Integer> agenda = new ArrayList<Integer>();
		agenda.add(123);
		agenda.add(456);
		agenda.add(789);
		
		for(Integer a: agenda) {
			System.out.println(a);
		}
		
		
		/*LinkedList. Doblemente enlazado*/
		List <String> animales = new LinkedList<String>();
		animales.add("Perro");
		animales.add("Gato");
		animales.add("Conejo");
		animales.add("Tortuga");
		animales.add("Oso");
		animales.add("Quetzal");
		
		for(String an: animales) {
			System.out.println(an);
		}
		
		
		/*La interzas Map asocia claves a valores
		 * No puede contener claves duplicadas
		 * Clave s?lo puede tener asociado un valor
		 * 
		 * Implementaciones:
		 * HashMap
		 * TreeMap
		 * LinkedHash*/
		
		/*La implementaci?n de HashMap
		 * Es la implementaci?n con mejor rendimiento pero no garantiza
		 * ningun orden a la hora de realizar iteraciones*/
		Map<String,String> diccionario = new HashMap<>();
		diccionario.put("Elemento1", "Yann Martinez");
		diccionario.put("Telefono", "123");
		diccionario.put("Llave", "True");
		System.out.println(diccionario.get("Elemento1")); //Imprimimos el elemento1
		for(Map.Entry<String, String> entry: diccionario.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
		//Otro m?todo para recorrer el hash:
		Iterator it = diccionario.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry<String, String> entry = (Map.Entry)it.next();
	        System.out.println(entry.getKey() + " = " + entry.getValue()); 
	    }
		
		
		/*Implementacion 
		 * TreeMap
		 * Ordena los elementos de menor a mayor*/
		Map<String, String> diccionario2 = new TreeMap<>();
		diccionario2.put("Elemento1", "Yann Martinez");
		diccionario2.put("Telefono", "123");
		diccionario2.put("Llave", "True");
		System.out.println(diccionario2.get("Elemento1")); //Imprimimos el elemento1
		for(Map.Entry<String, String> entry: diccionario2.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
		/*Implementacion 
		 * TreeMap
		 * Ordena los elementos por oden de inserci?n*/
		Map<String,String> diccionario3 = new LinkedHashMap<>();
		diccionario3.put("Elemento1", "Yann Martinez");
		diccionario3.put("Telefono", "123");
		diccionario3.put("Llave", "True");
		System.out.println("Implementando LinkedHashMap"); //Imprimimos el elemento1
		for(Map.Entry<String, String> entry: diccionario3.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}

}
