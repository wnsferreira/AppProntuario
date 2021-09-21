package br.edu.infnet.appProntuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appProntuario.model.domain.Atendimento;
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
	
	@GetMapping(value = "/atendimento")
	public String telaCadastro() {
		return "atendimento/cadastro";
	}
	
	@PostMapping(value = "/atendimento/incluir") 
	public String incluir(Model model, Atendimento atendimento) {
		
		atendimentoService.incluir(atendimento);
		
		model.addAttribute("msg", "Atendimento " + atendimento.getDescricao() +" cadastrado com sucesso!");
		
		return telaLista(model);
	}
	
	
	@GetMapping(value = "/atendimento/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		
		// excluir através do id
		Atendimento atendimento = atendimentoService.obterPorId(id);
		
		// chama o método excluir no Service
		atendimentoService.excluir(id);
		
		// mensagem
		model.addAttribute("msg", "Atendimento " + atendimento.getDescricao() +" removido com sucesso!");
		
		// chama a tela de lista novamente
		return telaLista(model);
		
		//return "atendimento/lista";
	}
	
}
	