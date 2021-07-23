package generation.mx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Con REST controller le decmos a java que esa aplicación intereactua con el servidor.
@RestController
public class HolaMundoSpring {
	
	/*DEntro del request mapping debemos especificar unas cosas, por ejemplo el Path, que es la ruta donde se ejecutará
	Y especificar el método mediante el cual se lee.
	Cuando entremos a esa ruta mediante el método GET.
	El RequestParam lee los valores que recibe mediante la UDL
	*/
	@RequestMapping (path = "/", method = RequestMethod.GET)
	public String holaMundo(@RequestParam(name = "nombre", defaultValue = "defecto") String nombre) {
		return "Hola" + nombre;
	}
	//En URL mandamos el parametro y sería de la siguiente manera: localhost:808?nombre=Yann
}
