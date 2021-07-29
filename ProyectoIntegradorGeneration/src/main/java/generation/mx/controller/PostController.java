package generation.mx.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import generation.mx.models.PostModel;
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
 * 
 * */