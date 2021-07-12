package paquete1;

public class Persona {
	//modificador Stático
	String nombre = "";
	//Al ser privado sólo puede ser accedido dentro de la clase
	private int edad = 0; 
	
	/*Modificador protected se puede acceder desde la misma clase y mismo paquete
	 * y pueden acceder desde clase que heredan de ella*/
	protected String domicilio="";
	
	String saludar() {
		return "Hola, mi nombre es " + this.nombre + "Mi edad es " + this.edad;
	}
}
