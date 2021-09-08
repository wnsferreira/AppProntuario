package br.edu.infnet.appProntuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appProntuario.model.domain.Paciente;
import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.service.PacienteService;


@Controller		
public class PacienteControle {
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping(value = "/paciente")
	public String tela() {
		return "paciente/cadastro";
	}	
	
	@GetMapping(value = "/paciente/lista")  // rota que vai aparecer na url
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
			
		model.addAttribute("lista", pacienteService.obterLista(usuario));
		
		return "paciente/lista";
	}

	@PostMapping(value = "/paciente/incluir")
	public String incluir(Model model, Paciente paciente, @SessionAttribute("user") Usuario usuario) {
		
		paciente.setUsuario(usuario);  // informa que o usuario está relacionado ao paciente
		
		pacienteService.incluir(paciente);
		
		String mensagem = "O paciente "+ paciente.getNome() +" foi cadastrado com sucesso!";
		
		model.addAttribute("msg", mensagem);
				
		return telaLista(model, usuario);
	}
	
	@GetMapping(value ="/paciente/{id}/excluir" )
	public String excluir(Model model, @PathVariable Integer id) {
		
		pacienteService.excluir(id);
		
		return "redirect:/paciente/lista";
	}
}
	