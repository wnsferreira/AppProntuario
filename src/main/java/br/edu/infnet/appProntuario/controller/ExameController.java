package br.edu.infnet.appProntuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appProntuario.model.domain.Consulta;
import br.edu.infnet.appProntuario.model.domain.Exame;
import br.edu.infnet.appProntuario.model.service.ExameService;

@Controller
public class ExameController {

	@Autowired
	private ExameService exameService;
	
	@GetMapping(value = "/exame/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("exames", exameService.obterLista());
		
		return "/exame/lista";
	}	

	@GetMapping(value = "/exame")
	public String telaCadastro() {
		return "exame/cadastro";
	}
	
	@PostMapping(value = "/exame/incluir")
	public String incluir(Model model, Exame exame) {
		
		exameService.incluir(exame);
		
		model.addAttribute("msg","Exame" + exame.getDescricao() + " cadastrada com sucesso!!");
		
		return telaLista(model);
	}
	
	@GetMapping(value = "/exame/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		
		
		Exame exame = exameService.obterPorId(id);
		
		String mensagem = null;
		
		try {
			exameService.excluir(id);	
			mensagem = "Exame " + exame.getDescricao() +" removido com sucesso!";	
		} catch (Exception e) {
			mensagem = "Não foi possível excluir o exame "+ exame.getDescricao();
		}
		
		model.addAttribute("msg", mensagem);
		
	
		return telaLista(model);
	}
}
