package generation.mx.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/*Será el nuevo modelo para una tabla. para ello debemos decir que es una entidad para la base de datos.
 * Con @Table ponemos el nombre que queremos darle a la tabla**/
@Entity
@Table(name="users")
public class UserModel {

	private long id;
	private String name;
	private String surname;
	private String email;
	
	/*Get --> Devuelve
	 *Set --> Establece dato*/
	//ID
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	//Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Surname
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	//email<
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
