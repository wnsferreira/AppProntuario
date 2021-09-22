package br.edu.infnet.appProntuario.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.service.UsuarioService;

@SessionAttributes("user")
@Controller	
public class AcessoController {
	
	@Autowired		
	private UsuarioService usuarioService;   
	
	@GetMapping(value = "/app")
	public String telaApp() {
		return "app";
	}
	
	@GetMapping(value="/")
	public String telaHome(){
		return "index";
	}
	
	@GetMapping(value="/login")
	public String telaLogin(){
		return "login";
	}
		
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session, SessionStatus status){
		
		status.setComplete();          			 // tira o usuario da sessão
		
		session.removeAttribute("user");		// tira o usuario da sessão
		
		return "redirect:/";					// redireciona para telaHome()
	}
	
	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {		
		
		Usuario usuario = usuarioService.validar(email, senha);  									
		
		if (usuario != null) {
			
			model.addAttribute("user", usuario);   // recupera várias informações sem precisar refazer a operação
			
			return "index";
		
		}else {
									
			model.addAttribute("mensagem","Autenticacao invalida para o usuario " + email + "!");
			
			return "login";
		}
		
	}
	
}
