package br.edu.infnet.appimoveis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appimoveis.model.service.CasaService;
import br.edu.infnet.appimoveis.models.domain.Casa;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Controller
public class  CasaController {
	
	@Autowired
	private CasaService casaService;

	private String msg;

	@GetMapping(value = "/cadastro-casa")
	public String pagCadastro() {
		return "casa/cadastro";
	}	

	@GetMapping(value = "lista-casa")
	public String pagLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("casas", casaService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "casa/lista";
	}
	
	@PostMapping(value = "incluir-casa")
	public String incluir(Casa casa, @SessionAttribute("usuario") Usuario usuario) {
		
		casa.setUsuario(usuario);

		casaService.incluir(casa);
		
		msg = "A casa "+casa.getId()+" foi cadastrada com sucesso.";
		
		return "redirect:/lista-casa";
	}
		
	@GetMapping(value = "/casa/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Casa casa = casaService.obterPorId(id);
		
		try {
			casaService.excluir(id);
			
			msg = "A casa "+casa.getId()+" foi excluida com exito.";
		} catch (Exception e) {
			msg = "Impossivel excluir a casa "+casa.getId()+".";
		}

		return "redirect:/lista-casa";
	}
}
