package generation.mx.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import generation.mx.models.PostModel;
/*JPA = Java Persistence API*/
@Repository
public interface PostRepository extends CrudRepository<PostModel, Long>{
	/*
	 * Buscando elementos por titulo cuando contengan cierta cadena
	 * findBy nombreDelCampo Containing
	 * Containing significa que contengan eso en la busqueda*/
	public abstract ArrayList<PostModel> findByTitleContaining(String title);
	
	/*
	 * Obteniendo las publicaciones por titulo y ordenando de forma descendiente mediante el Id
	 * Lo que hace es obtener todos y ordenar de forma descendente.
	 * Esto debemos manejarlo en el PostService
	 * @param title Es el titulo por el cual hará la consulta
	 * */
	public abstract ArrayList<PostModel> findByTitleContainingOrderByIdDesc(String title);
}

/*ORDEN DE MANEJO:
 * 
 * Repositorio --> Serivio --> Controlador
 * */