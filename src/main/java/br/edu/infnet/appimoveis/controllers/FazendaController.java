package br.edu.infnet.appimoveis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FazendaController {
	
	@GetMapping(value = "/lista-fazenda")
	public String pagFazenda() {
		return "fazenda/lista";
	}

}
