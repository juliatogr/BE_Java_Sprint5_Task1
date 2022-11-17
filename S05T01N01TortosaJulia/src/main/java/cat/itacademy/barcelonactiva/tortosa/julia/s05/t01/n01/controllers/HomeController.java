package cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/index", "/home", "/"})
	public String index() {
		return "home";
	}

}
