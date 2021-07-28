package generation.mx.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import generation.mx.models.PostModel;

@Repository
public interface PostRepository extends CrudRepository<PostModel, Long>{
	
}
