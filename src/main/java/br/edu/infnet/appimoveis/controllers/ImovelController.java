package br.edu.infnet.appimoveis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appimoveis.model.service.ImovelService;
import br.edu.infnet.appimoveis.models.domain.Imovel;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Controller
public class ImovelController {
	
	@Autowired
	private ImovelService imovelService;
	
	private String msg;
	
	@GetMapping(value = "/lista-imovel")
	public String pagLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("imoveis", imovelService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "imoveis/lista";
	}
	
	@GetMapping(value = "/imovel/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Imovel imovel = imovelService.obterPorId(id);
		
		try {
			imovelService.excluir(id);
			
			msg = "O imovel "+imovel.getId()+" foi excluido com sucesso!";
			
		} catch (Exception e) {
			msg = "Impossivel excluir o "+imovel.getId()+".";
		}
		
		return "redirect:/lista-imovel";
	}

}
