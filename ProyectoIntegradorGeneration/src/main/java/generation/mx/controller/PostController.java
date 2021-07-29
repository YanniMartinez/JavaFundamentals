package generation.mx.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
