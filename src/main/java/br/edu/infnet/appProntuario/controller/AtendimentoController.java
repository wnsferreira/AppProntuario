package br.edu.infnet.appProntuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appProntuario.model.service.AtendimentoService;

@Controller
public class AtendimentoController {
	
	@Autowired
	private AtendimentoService atendimentoService;

	@GetMapping(value ="/atendimento/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("atendimentos", atendimentoService.obterLista());
		
		return "atendimento/lista";
	}
}
