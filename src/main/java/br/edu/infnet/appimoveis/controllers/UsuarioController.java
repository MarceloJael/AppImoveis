package br.edu.infnet.appimoveis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.appimoveis.models.domain.EnderecoModels;
import br.edu.infnet.appimoveis.models.domain.Usuario;
import br.edu.infnet.appimoveis.model.service.UsuarioService;


@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	private String msg;
	
	@GetMapping(value = "/cadastrar")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@PostMapping("/form_cep")
	public ModelAndView FormCep(@RequestParam("cep") String cep) {
		
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        EnderecoModels endereco = restTemplate.getForObject(url, EnderecoModels.class);       
        ModelAndView mav = new ModelAndView("usuario/cadastro");
        mav.addObject("endereco", endereco);
        return mav;  
	}
	
	@PostMapping(value = "/form_endereco")
	public String incluir(Usuario usuario) {

		usuarioService.incluir(usuario);
		
		msg = "O" + usuario.getNome()+ "foi cadastro com sucesso!";
		
		return "redirect:login";
	}
	
	@GetMapping(value = "/lista-usuario")
	public String telaLista(Model model) {
		
		model.addAttribute("usuarios", usuarioService.obterLista());
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "usuario/lista";
	}
	
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		usuarioService.excluir(id);
		
		msg = "Usuario "+ id+" foi excluido.";

		return "redirect:/lista-usuario";
	}

}
