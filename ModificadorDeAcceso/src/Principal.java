import paquete1.Persona; //Import nombre del paquete. nombre de la clase
//Cuando usamos paquetes debemos hacer importaciones
public class Principal {

	public static void main(String[] args) {
		/**
		 * MODIFICADORES DE ACCESO:
		 * 
		 * DEFAULT: No es accesible desde otro paquete
		 * PRIVATE:
		 * PUBLIC:
		 * PROTECTED:*/
		
		//El modificador de acceso Default solo est� en el alcance dentro del paquete sino muestra error
		//Persona persona = new Persona();
		//persona.nombre = "Yann"; //Se puede ver que marca error porque el Default solo tiene alcance dentro de su  paquete
		
		//persona.edad = 21; Tambi�n marca error porque s�lo puede ser accedida desde su clase.
		
	}

}
