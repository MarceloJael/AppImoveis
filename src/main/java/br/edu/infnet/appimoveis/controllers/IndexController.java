package br.edu.infnet.appimoveis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(value = "/")
	public String pagIndex() {
		return "index";
	}
	
	@GetMapping(value = "/home")
	public String pagHome() {
		return "index";
	}
	
	@GetMapping(value = "*")
	public String pagErro() {
		return "index";
	}

}
