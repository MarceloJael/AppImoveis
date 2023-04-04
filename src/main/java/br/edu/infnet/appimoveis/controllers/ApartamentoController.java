package br.edu.infnet.appimoveis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appimoveis.model.service.ApartamentoService;
import br.edu.infnet.appimoveis.models.domain.Apartamento;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Controller
public class ApartamentoController {
	
	@Autowired
	private ApartamentoService apartamentoService;

	private String msg;

	@GetMapping(value = "/cadastro-apartamento")
	public String pagCadastro() {
		return "apartamento/cadastro";
	}	

	@GetMapping(value = "lista-apartamento")
	public String pagLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("apartamentos", apartamentoService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "apartamento/lista";
	}
	
	@PostMapping(value = "incluir-apartamento")
	public String incluir(Apartamento apartamento, @SessionAttribute("usuario") Usuario usuario) {
		
		apartamento.setUsuario(usuario);

		apartamentoService.incluir(apartamento);
		
		msg = "O apartamento "+apartamento.getId()+" foi cadastrada com sucesso.";
		
		return "redirect:/lista-apartamento";
	}
		
	@GetMapping(value = "/apartamento/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Apartamento apartamento = apartamentoService.obterPorId(id);
		
		try {
			apartamentoService.excluir(id);
			
			msg = "O apartamento "+apartamento.getId()+" foi excluida com exito.";
		} catch (Exception e) {
			msg = "Impossivel excluir o apartamento "+apartamento.getId()+".";
		}

		return "redirect:/lista-fazenda";
	}

}
