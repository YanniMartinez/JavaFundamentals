package generation.mx.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



/*JPA: Java persistence Access. Hace las conversiones correspondientes con SQL*/

/*Será el nuevo modelo para una tabla. para ello debemos decir que es una entidad para la base de datos.
 * Con @Table ponemos el nombre que queremos darle a la tabla**/
@Entity
@Table(name="users")
public class UserModel {

	/*
	 * @Id Le indicamos que será el id y que le generará el Id. 
	 * @Generated --> Hará asignación automática con la estrategia identity. Es semejante al PK y Autoincremento
	 * @Column --> Indica que el valor de la columna no puede ser nulo.
	 * */
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (nullable = false)
	private long id;
	
	//Le inficamos que no puede ser nulo, que tenga una longitud de 100 y que su nombre sea name
	@Column (nullable = false, length = 100, name = "name")
	private String name;
	
	//Le inficamos que no puede ser nulo, que tenga una longitud de 100 
	@Column (nullable = false, length = 100)
	private String surname;
	
	//Le inficamos que no puede ser nulo, que tenga una longitud de 100 y que sea un valor unico
	@Column (nullable = false, length = 100, unique = true)
	private String email;
	
	/*Campo que servirá para la contraseña*/
	@Column (nullable = false, length = 100)
	private String password;
	
	//Como pueden ser muchas publicaciones entonces lo ponemos como list
	/*El nombre que va en mappedBy es "user" hace referencia al atributo que se pone en PostModel
	 * Lo usamos para decirle que la relación es bidrireccional, es decir que user se puede conectar con Post y viceversa
	 * Si no lo ponemos es como si hiciera una relacion muchos a muchos
	 * Es Explicito y es bueno dejarlo así para que no genere relaciones de más.
	 * */
	@OneToMany( targetEntity = PostModel.class, mappedBy = "user")
	@JsonManagedReference  //Le decimos que el user manejará la referencia
	private List<PostModel> posts;
	/*Esto quiere decir que nos mostrará las publicaciones que hizo el usuario.*/

	/*Get --> Devuelve
	 *Set --> Establece dato*/
	//ID
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List getPosts() {
		return posts;
	}

	public void setPosts(List posts) {
		this.posts = posts;
	}
	

	
	
}
