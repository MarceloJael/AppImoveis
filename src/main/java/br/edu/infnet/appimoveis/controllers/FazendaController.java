package br.edu.infnet.appimoveis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appimoveis.model.service.FazendaService;
import br.edu.infnet.appimoveis.models.domain.Fazenda;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Controller
public class FazendaController {
	
	@Autowired
	private FazendaService fazendaService;

	private String msg;

	@GetMapping(value = "/cadastro-fazenda")
	public String pagCadastro() {
		return "fazenda/cadastro";
	}	

	@GetMapping(value = "lista-fazenda")
	public String pagLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("fazendas", fazendaService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "fazenda/lista";
	}
	
	@PostMapping(value = "incluir-fazenda")
	public String incluir(Fazenda fazenda, @SessionAttribute("usuario") Usuario usuario) {
		
		fazenda.setUsuario(usuario);

		fazendaService.incluir(fazenda);
		
		msg = "A fazenda "+fazenda.getId()+" foi cadastrada com sucesso.";
		
		return "redirect:/lista-fazenda";
	}
		
	@GetMapping(value = "/fazenda/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Fazenda fazenda = fazendaService.obterPorId(id);
		
		try {
			fazendaService.excluir(id);
			
			msg = "A fazenda "+fazenda.getId()+" foi excluida com exito.";
		} catch (Exception e) {
			msg = "Impossivel excluir a fazenda "+fazenda.getId()+".";
		}

		return "redirect:/lista-fazenda";
	}

}
