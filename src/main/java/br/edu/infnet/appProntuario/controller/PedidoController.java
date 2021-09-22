package br.edu.infnet.appProntuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appProntuario.model.domain.Pedido;
import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.service.PedidoService;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(value = "/pedido/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("pedidos", pedidoService.obterLista(usuario));
		
		return "pedido/lista";
	}
	
	@GetMapping(value = "/pedido/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Pedido pedido = pedidoService.obterPorId(id);
		
		String mensagem = null;
		
		try {
			pedidoService.excluir(id);		
			mensagem = "O pedido "+ pedido.getDescricao() +" foi removido com sucesso!";
			
		} catch (Exception e) {
			mensagem = "Não foi possível excluir o pedido "+ pedido.getDescricao();
		}
				
		model.addAttribute("msg", mensagem);
		
		return telaLista(model, usuario);
	}
	

}
