package br.edu.infnet.appProntuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appProntuario.model.domain.Endereco;
import br.edu.infnet.appProntuario.model.service.EnderecoService;

@Controller
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping(value = "/cep")
	public String obterCep(Model model, @RequestParam String cep) {
	
				
		model.addAttribute("meuEndereco", enderecoService.obterCep(cep));
		
		return "usuario/cadastro";
			
	}
		
}
