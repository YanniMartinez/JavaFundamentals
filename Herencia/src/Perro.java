/*Con implements agregamos la interfaz y con ello tenemos que implementar sus métodos abstracto
 * Podemos usar MÁS de 1 interfáz. SOLO se puede HEREDAR de UNA clase. La interfaz Simula una multiple herencia pero de forma
 * correcta
 */
public class Perro extends Animal implements Mascota, Cuidados{ //Hace referencia a que hereda de animal

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

	/******************* Métodos de la interfaz *****************************
	 Es obligatorio usar todos sus métodos porque todos son abstractos
	 */
	@Override
	public String trucos() {
		// TODO Auto-generated method stub
		return "Dar la patita";
	}

	@Override
	public String premios() {
		// TODO Auto-generated method stub
		return "Recibir galletas";
	}

	@Override
	public String jugar() {
		// TODO Auto-generated method stub
		return "Jugando a la pelota";
	}

	/********************* implementando métodos de Cuidados *****************************/
	@Override
	public String irVerterinario() {
		// TODO Auto-generated method stub
		return "Perrito saludable";
	}

	@Override
	public String paseo() {
		// TODO Auto-generated method stub
		return "Caminando por el parque";
	}

	@Override
	public String banio() {
		// TODO Auto-generated method stub
		return "Tomando un baño";
	}
}
