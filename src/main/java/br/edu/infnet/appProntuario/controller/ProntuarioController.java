package br.edu.infnet.appProntuario.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appProntuario.model.domain.Pedido;
import br.edu.infnet.appProntuario.model.domain.Prontuario;
import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.service.PedidoService;
import br.edu.infnet.appProntuario.model.service.ProntuarioService;
import br.edu.infnet.appProntuario.model.service.SolicitanteService;

@Controller
public class ProntuarioController {

	@Autowired
	private ProntuarioService prontuarioService;
	@Autowired
	private SolicitanteService solicitanteService;
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(value = "/prontuario")
	public String tela(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("solicitantes",solicitanteService.obterLista(usuario));
		
		model.addAttribute("pedidos",pedidoService.obterLista(usuario));
		
		return "prontuario/cadastro";
	}	
	
	@GetMapping(value = "/prontuario/lista") 	
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
			
		model.addAttribute("lista", prontuarioService.obterLista(usuario));
		
		return "prontuario/lista";
	}

	@PostMapping(value = "/prontuario/incluir")
	public String incluir(Model model, Prontuario prontuario,@RequestParam String[] pedidosId ,@SessionAttribute("user") Usuario usuario) {
				
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		for(String id : pedidosId) {
			pedidos.add(pedidoService.obterPorId(Integer.valueOf(id)));
		}
		
		prontuario.setPedidos(pedidos);
		
		prontuario.setUsuario(usuario); 
		
		prontuarioService.incluir(prontuario);
		
		String mensagem = "O prontuario "+ prontuario.getDescricao() +" foi cadastrado com sucesso!";
		
		model.addAttribute("msg", mensagem);
				
		return telaLista(model, usuario);
	}
	
	@GetMapping(value ="/prontuario/{id}/excluir" )
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Prontuario prontuario = prontuarioService.obterPorId(id);
		
		prontuarioService.excluir(id);		
		
		String mensagem = "O prontuário" + prontuario.getDescricao() + " foi removido com sucesso!!";
		
		model.addAttribute("msg", mensagem);
		
		return telaLista(model, usuario);
	}
}
