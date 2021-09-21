package br.edu.infnet.appProntuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appProntuario.model.domain.Atendimento;
import br.edu.infnet.appProntuario.model.domain.Consulta;
import br.edu.infnet.appProntuario.model.service.ConsultaService;

@Controller
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;
	
	@GetMapping(value = "/consulta/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("consultas", consultaService.obterLista());
		
		return "/consulta/lista";
	}
	
	@GetMapping(value = "/consulta")
	public String telaCadastro() {
		return "consulta/cadastro";
	}
	
	@PostMapping(value = "/consulta/incluir")
	public String incluir(Model model, Consulta consulta) {
		
		consultaService.incluir(consulta);
		
		model.addAttribute("msg","Consulta" + consulta.getDescricao() + " cadastrada com sucesso!!");
		
		return telaLista(model);
	}
	
	@GetMapping(value = "/consulta/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		
		
		Consulta consulta = consultaService.obterPorId(id);
		
		consultaService.excluir(id);
	
		model.addAttribute("msg", "Consulta " + consulta.getDescricao() +" removido com sucesso!");
		
	
		return telaLista(model);
	}
}
