package br.edu.infnet.appimoveis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PedidoController {
	
	@GetMapping(value = "/lista-pedido")
	public String pagPedido() {
		return "pedido/lista";
	}

}
