package br.edu.infnet.appimoveis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApartamentoController {
	
	@GetMapping(value = "/lista-apartamento")
	public String pagApartamento() {
		return "apartamento/lista";
	}

}
