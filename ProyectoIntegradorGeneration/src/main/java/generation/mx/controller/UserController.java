package generation.mx.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import generation.mx.models.UserModel;
import generation.mx.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	/*Autowired se encarga de inicializar el objeto, de deja todo este trabajo 
	 * al spring*/
	@Autowired
	UserService userService;
	
	/*Si quiero acceder a la ruta /users entonces se disparará el método:*/
	@GetMapping
	public ArrayList<UserModel> getUsers(){
		return userService.getUsers();
	}
	
	/*Sólo recibirá un valor o un usuario*/
	@PostMapping
	public UserModel saveUser(@RequestBody UserModel user) {
		return userService.saveUser(user);
	}
	
	/*Retorna la busqueda de usuario por ID por lo que esto solo se manda mediante POSTMAN
	 * como GET: localhost;8080/user/3 */
	@GetMapping(path = "/{id}")
	public Optional<UserModel> getUserById(@PathVariable("id") Long id){
		return userService.getUserById(id); //Se cambio el null por el id
	}
	
	/*Metodo para la eliminación*/
	/*Se usa el método HTTP de DELETE mediante el @DeleteMapping
	 * Esta función nos devolverá una cadena que diga si se eliminó o no el usuario*/
	@DeleteMapping(path="/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		boolean ok = userService.deleteUser(id); //Cachamos el valor del booleano
		
		/*ok Es equivalente a ok==true*/
		if(ok) {
			return "Se eliminó el usuario";
		}else {
			return "No se pudo eliminar el usuario";
		}
	} 
	
	/*Hace referencia a una consulta
	 * Con el método get apuntaremos a la dirección "users/query"  y le decimos que
	 * obtendremos parametros por la url, un parametro llamado name y una parametro por defecto.
	 * Este valor lo almacenaremos en una variable String llamada name
	 * 
	 * Atravez de la url obtenemos un parametro y atraves de ese parametro haremos una busqueda
	 * GetMapping intercepta todas las consultas que se harán por GET*/
	@GetMapping("/query")
	public ArrayList<UserModel> getUsersByName(@RequestParam(value = "name", defaultValue = "") String name){
		return userService.getUsersByName(name);
	}
}
