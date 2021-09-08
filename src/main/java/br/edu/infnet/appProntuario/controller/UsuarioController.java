package br.edu.infnet.appProntuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@GetMapping(value = "/usuario/lista") 
	public String telaLista(Model model) {
			
		model.addAttribute("lista",usuarioService.obterLista());
		
		return "usuario/lista";
	}
	
	@PostMapping(value = "/usuario")
	public String incluir(Usuario usuario) {  //(Usuario usuario) reflexão... traz todas as informações de usuario de dentro da tela de cadastro
		
		usuarioService.incluir(usuario);
		
		return "redirect:/";
	}
}
