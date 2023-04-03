package br.edu.infnet.appimoveis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appimoveis.model.service.ClienteService;
import br.edu.infnet.appimoveis.models.domain.Cliente;
import br.edu.infnet.appimoveis.models.domain.Usuario;


@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	private String msg;

	@GetMapping(value = "/cadastro-cliente")
	public String pagCadastro() {
		return "clientes/cadastro";
	}	

	@GetMapping(value = "/lista-cliente")
	public String pagLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("clientes", clienteService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "clientes/lista";
	}

	@PostMapping(value = "/incluir-cliente")
	public String incluir(Cliente cliente, @SessionAttribute("usuario") Usuario usuario) {
		
		cliente.setUsuario(usuario);

		clienteService.incluir(cliente);
		
		msg = "O "+cliente.getNome()+" foi cadastrado com sucesso!";
		
		return "redirect:/lista-cliente";
	}
		
	@GetMapping(value = "/cliente/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		try {
			clienteService.excluir(id);
			
			msg = "O cliente do "+id+" foi excluido com sucesso.";
		} catch (Exception e) {
			msg = "O cliente do "+id+" não é possivel de exclusão";
		}

		return "redirect:/lista-cliente";
	}
	
}
