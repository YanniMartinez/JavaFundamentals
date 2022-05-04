package domain;

/*
 * Este tipo de clases se les conoce como clases entidad dado que representan
 * un objeto real y potencialmente reutilizable
 * */
public class PersonaDTO {
	private int idPersona;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	
	
	/*Sobrecarga de contructores*/
	public PersonaDTO() {
		
	}


	public PersonaDTO(int idPersona) {
		this.idPersona = idPersona;
	}


	/*Podemos usarlo debido a que no necesitamos el id al ser autoincrementable*/
	public PersonaDTO(String nombre, String apellido, String email, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}


	/*Sirve para el caso de una modificación*/
	public PersonaDTO(int idPersona, String nombre, String apellido, String email, String telefono) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	//Para modificar atributos de forma individual usamos gets y sets

	public int getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/*Nos permitirá devolver el estado del objeto con todos los atributos o elementos*/
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
	
}

