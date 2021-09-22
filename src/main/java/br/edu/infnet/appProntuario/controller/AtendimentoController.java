package br.edu.infnet.appProntuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appProntuario.model.domain.Atendimento;
import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.service.AtendimentoService;

@Controller
public class AtendimentoController {
	
	@Autowired
	private AtendimentoService atendimentoService;

	@GetMapping(value ="/atendimento/lista")
	public String telaLista(Model model,  @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("atendimentos", atendimentoService.obterLista());
		
		return "atendimento/lista";
	}
	
	@GetMapping(value = "/atendimento")
	public String telaCadastro() {
		return "atendimento/cadastro";
	}
	
	@PostMapping(value = "/atendimento/incluir") 
	public String incluir(Model model, Atendimento atendimento,  @SessionAttribute("user") Usuario usuario) {
		
		atendimentoService.incluir(atendimento);
		
		model.addAttribute("msg", "Atendimento " + atendimento.getDescricao() +" cadastrado com sucesso!");
		
		return telaLista(model, usuario);
	}
	
	
	@GetMapping(value = "/atendimento/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id,  @SessionAttribute("user") Usuario usuario) {
		
	
		Atendimento atendimento = atendimentoService.obterPorId(id);
		
		String mensagem = null;
		
		try {
			atendimentoService.excluir(id);		
			mensagem = "Atendimento " + atendimento.getDescricao() +" removido com sucesso!";
			
		} catch (Exception e) {
			mensagem = "Não foi possível excluir o solicitante "+ atendimento.getDescricao();
		}
		
	
		model.addAttribute("msg", mensagem);
			
		return telaLista(model, usuario);
	
	}
	
}
	