package generation.mx.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import generation.mx.models.PostModel;
import generation.mx.repositories.PostRepository;
/*NOTA: Todo lo que se hará con la BD se debe hacer mediante el repositorio*/
@Service
public class PostService {
	
	/*Gestión de objetos de manera automática*/
	@Autowired
	PostRepository postRepository;
	
	public ArrayList<PostModel> getPosts(){
		//Es importante poner el casteo al inicio
		return (ArrayList<PostModel>) postRepository.findAll(); /*Regresa todos los elementos que tenemos en nuestra BD*/
	}
	
	/*Servirá para guardar los Post*/
	public PostModel savePost(PostModel post) {
		//Guardará en la base de datos
		return postRepository.save(post);
	}
	
	/*
	 * Método por busqueda por ID.
	 * Como puede o no devolver es necesario ponerlo como opcional.
	 * */
	public Optional<PostModel> findPostByID(Long id) {
		return postRepository.findById(id);
	}
}
