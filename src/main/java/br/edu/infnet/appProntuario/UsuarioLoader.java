package br.edu.infnet.appProntuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appProntuario.model.domain.Endereco;
import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.service.UsuarioService;


@Component
@Order(1)
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Outeiro");
		endereco.setCep("24800000");
		endereco.setComplemento("rua x");
		endereco.setLocalidade("localidade x");
		endereco.setLogradouro("logradouro x");
		endereco.setUf("RJ");
		
		Usuario usuario = new Usuario();
		usuario.setNome("Wellington Nascimento");
		usuario.setEmail("wellington@gmail.com");
		usuario.setSenha("123");
		usuario.setAdmin(true);
		
		usuarioService.incluir(usuario);
		
		System.out.println("Inclusão realizada!");
		
	}

}
