package br.edu.infnet.appimoveis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class  CasaController {
	
	@GetMapping(value = "/lista-casa")
	public String pagCasa() {
		return "casa/lista";
	}

}
