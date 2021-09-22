package br.edu.infnet.appProntuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appProntuario.model.domain.Atendimento;
import br.edu.infnet.appProntuario.model.domain.Consulta;
import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.service.AtendimentoService;
import br.edu.infnet.appProntuario.model.service.ConsultaService;


@Component
@Order(3)
public class PedidoLoader implements ApplicationRunner{

	@Autowired
	private AtendimentoService atendimentoService;
	@Autowired
	private ConsultaService consultaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);		
		
		Atendimento a1 = new Atendimento("psicologo", 100, true);
		a1.setEspecializacao("criança");
		a1.setHonorario(100);
		a1.setNomeProfissional("Maria");
		a1.setTempoAtendimento(1);
		a1.setUsuario(usuario);
			
		atendimentoService.incluir(a1);
		
		Consulta c2 = new Consulta("Consulta teste", 150, false);
		c2.setConvenio(false);
		c2.setDataMarcada("10/11");
		c2.setHoraMarcada(15);
		
		consultaService.incluir(c2);
		
	}

}
