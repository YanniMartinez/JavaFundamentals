package generation.mx.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import generation.mx.models.PostModel;
import generation.mx.models.UserModel;
import generation.mx.repositories.PostRepository;
import generation.mx.services.PostService;

/*Sirve para indicarle que interactuará con toda la parte del HTML*/
@RestController
@RequestMapping("/post") //Le indicamos que a la url que responderá es en post
public class PostController {
	
	@Autowired
	PostService postService;
	
	/*Para recuperar todos los post tenemos el siguiente método, en plural porque recuperará varios
	 * Con esto estariamos recuperando todos los Post*/
	@GetMapping
	public ArrayList<PostModel> getPosts() {
		return postService.getPosts();
	}
	
	/*request body hace referencia a los datos que viajan a través del body, este contenido
	 * lo meterá en una variable de tipo PostModel que se llame post*/
	@PostMapping
	public PostModel savePost( @RequestBody PostModel post) {
		return postService.savePost(post);
	}
	
	/*Obtendrá el post por Id, recordemos que aquí se concatenará la cadena entonces sería alco como
	 *   localhost:8080/post/id   
	 *   Así se vería en PostMan para consultar localhost:8080/post/1  */
	@GetMapping(path="/{id}")
	public Optional<PostModel> getPostById(@PathVariable("id") Long id){
		return postService.findPostByID(id);
	}
	
	/*Implementando el método papa buscar por titulo.
	 * Es muy importante poner el GetMapping("/query") para hacer una consulta
	 * En PostMan iría: localhost:8080/post/query?title=LoQueBuscamos
	 * Ejemplo: localhost:8080/post/query?title=Noticia */
	@GetMapping("/query")
	public ArrayList<PostModel> getPostsByTitle(@RequestParam(value = "title", defaultValue = "") String title){
		return postService.getPostsByTitle(title);
	}
	
	/*Implementando el método papa buscar por titulo.
	 * Es muy importante poner el GetMapping("/q") para que no choque con lo anterior
	 * En PostMan iría: localhost:8080/post/q Esto buscará todos los titulos y lo ordenará de forma descendiente por id
	 * Otro es Ejemplo: localhost:8080/post/q?title=noti -->	traerá todos los que contengan noti en su titulo*/
	@GetMapping("/q")
	public ArrayList<PostModel> getByTitleOrderById(@RequestParam(value = "title", defaultValue = "") String title) {
		return postService.getByTitleContainingOrderByIdDesc(title);
	}

}


/*Notas al modificar un Post
 * 
 * 
 * Forma INCORRECTA de asignar un id.
 {
    "id" : 1,
    "title": "Noticias CDMX",
    "content": "Aprendiendo como guardar post",
    "user": 1
}
 * 
 * 
 * Forma CORRECTA de asignar un id.
 {
    "id" : 1,
    "title": "Noticias CDMX",
    "content": "Aprendiendo como guardar post",
    "user": {
        "id":1
    }
	
 }
 * 
 * Para evitar este ciclo ponermos en: USER MODEL:
 * 
@OneToMany( targetEntity = PostModel.class, mappedBy = "user")
@JsonManagedReference  //Le decimos que el user manejará la referencia
private List<PostModel> posts;


y en POSTMODEL:
	@ManyToOne
	@JsonBackReference //Retorna la referencia, o la hace inversa
	
	private UserModel user;
 * */