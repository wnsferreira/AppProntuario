package br.edu.infnet.appProntuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appProntuario.model.domain.Solicitante;
import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.service.SolicitanteService;
import br.edu.infnet.appProntuario.model.service.UsuarioService;


@Component
@Order(2)
public class SolicitanteLoader implements ApplicationRunner {

	@Autowired
	private SolicitanteService solicitanteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Solicitante solicitante = new Solicitante("Pedro", "pedro@teste.com", 32);
		solicitante.setUsuario(usuario);
		
		solicitanteService.incluir(solicitante);
		
	}

}
