package generation.mx.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="posts")
public class PostModel {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false, length=200)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@ManyToOne
	@JsonBackReference //Retorna la referencia, o la hace inversa
	private UserModel user;
	/*De esta manera cuando consultemos el post sólo muestra los datos del post*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
	
	
	
}
