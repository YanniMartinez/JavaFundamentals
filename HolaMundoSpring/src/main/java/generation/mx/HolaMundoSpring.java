package generation.mx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Con REST controller le decmos a java que esa aplicación intereactua con el servidor.
@RestController
public class HolaMundoSpring {
	
	/*DEntro del request mapping debemos especificar unas cosas, por ejemplo el Path, que es la ruta donde se ejecutará
	Y especificar el método mediante el cual se lee.
	Cuando entremos a esa ruta mediante el método GET.
	*/
	@RequestMapping (path = "/", method = RequestMethod.GET)
	public String holaMundo() {
		return "";
	}
}
