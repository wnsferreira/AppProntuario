package br.edu.infnet.appProntuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appProntuario.model.domain.Atendimento;
import br.edu.infnet.appProntuario.model.domain.Consulta;
import br.edu.infnet.appProntuario.model.domain.Pedido;
import br.edu.infnet.appProntuario.model.domain.Prontuario;
import br.edu.infnet.appProntuario.model.domain.Solicitante;
import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.service.ProntuarioService;


@Component
@Order(4)
public class ProntuarioLoader implements ApplicationRunner{

	@Autowired
	private ProntuarioService prontuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);		
		
		Solicitante solicitante = new Solicitante();
		solicitante.setId(1);
		
		Atendimento a1 = new Atendimento();
		a1.setId(1);
		
		Consulta c1 = new Consulta();
		c1.setId(2);
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(a1);
		pedidos.add(c1);
		
		Prontuario prontuario = new Prontuario();
		prontuario.setDescricao("Prontuario teste");
		prontuario.setPedidos(pedidos);
		prontuario.setSolicitante(solicitante);
		prontuario.setUsuario(usuario);
		
		prontuarioService.incluir(prontuario);
		
	}

}
