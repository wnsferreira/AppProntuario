package br.edu.infnet.appProntuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appProntuario.model.domain.Atendimento;
import br.edu.infnet.appProntuario.model.domain.Consulta;
import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.service.ConsultaService;

@Controller
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;
	
	@GetMapping(value = "/consulta/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("consultas", consultaService.obterLista());
		
		return "/consulta/lista";
	}
	
	@GetMapping(value = "/consulta")
	public String telaCadastro() {
		return "consulta/cadastro";
	}
	
	@PostMapping(value = "/consulta/incluir")
	public String incluir(Model model, Consulta consulta, @SessionAttribute("user") Usuario usuario) {
		
		consulta.setUsuario(usuario);
		
		consultaService.incluir(consulta);
		
		model.addAttribute("msg","Consulta" + consulta.getDescricao() + " cadastrada com sucesso!!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/consulta/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		
		Consulta consulta = consultaService.obterPorId(id);
		
		String mensagem = null;
		
		try {
			consultaService.excluir(id);	
			mensagem = "Consulta " + consulta.getDescricao() +" removido com sucesso!";	
		} catch (Exception e) {
			mensagem = "Não foi possível excluir a consulta "+ consulta.getDescricao();
		}
		
	
		model.addAttribute("msg", mensagem);
		
	
		return telaLista(model, usuario);
	}
}
