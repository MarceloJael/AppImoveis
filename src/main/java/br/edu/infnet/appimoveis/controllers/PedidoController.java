package br.edu.infnet.appimoveis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appimoveis.model.service.ClienteService;
import br.edu.infnet.appimoveis.model.service.ImovelService;
import br.edu.infnet.appimoveis.model.service.PedidoService;
import br.edu.infnet.appimoveis.models.domain.Pedido;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ImovelService imovelService;

	private String msg;

	@GetMapping(value = "/cadastro-pedido")
	public String pagCadastro(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("clientes", clienteService.obterLista(usuario));
				
		model.addAttribute("imoveis", imovelService.obterLista(usuario));

		return "pedido/cadastro";
	}	

	@GetMapping(value = "/lista-pedido")
	public String pagLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("pedidos", pedidoService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "pedido/lista";
	}
	
	@PostMapping(value = "incluir-pedido")
	public String incluir(Pedido pedido, @SessionAttribute("usuario") Usuario usuario) {
		
		pedido.setUsuario(usuario);

		pedidoService.incluir(pedido);

		msg = "O pedido de ID "+pedido.getId()+" foi feita com exito.";
		
		return "redirect:/lista-pedido";
	}
		
	@GetMapping(value = "/pedido/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Pedido pedido = pedidoService.obterPorId(id);
		
		pedidoService.excluir(id);
		
		msg = "O pedido de ID "+pedido.getId()+" foi excluido.";

		return "redirect:/lista-pedido";
	}

}
