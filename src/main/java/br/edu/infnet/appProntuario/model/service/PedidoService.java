package br.edu.infnet.appProntuario.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.appProntuario.model.domain.Pedido;
import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.repository.PedidoRepository;


@Service
public class PedidoService {

	private PedidoRepository pedidoRepository;
	
	public List<Pedido> obterLista(Usuario usuario){
		
		return pedidoRepository.obterLista(usuario.getId());
	}
	
	public List<Pedido> obterLista(){
		
		return (List<Pedido>) pedidoRepository.findAll();
		
	}
	
	public void incluir(Pedido pedido) {
		
		pedidoRepository.save(pedido);
	}
	
	public void excluir(Integer id) {
		
		pedidoRepository.deleteById(id);
	}
	
	public Pedido obterPorId(Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}
}
