package br.edu.infnet.appimoveis.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.appimoveis.models.domain.Usuario;

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
	
    @RequestMapping("/")
    public ModelAndView minhaPagina(HttpSession session) {
        
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("minhaPagina");
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    public ModelAndView handleMissingSessionAttribute() {
        
        return new ModelAndView("redirect:/");
    }

}
