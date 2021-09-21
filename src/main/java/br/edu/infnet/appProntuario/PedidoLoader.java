package br.edu.infnet.appProntuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appProntuario.model.domain.Atendimento;
import br.edu.infnet.appProntuario.model.domain.Consulta;
import br.edu.infnet.appProntuario.model.repository.ConsultaRepository;
import br.edu.infnet.appProntuario.model.service.AtendimentoService;


@Component
public class PedidoLoader implements ApplicationRunner{

	@Autowired
	private AtendimentoService atendimentoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
			
		Atendimento a1 = new Atendimento("médico", 150, true);
		a1.setEspecializacao("clinico geral");
		a1.setHonorario(150);
		a1.setNomeProfissional("Pedro");
		a1.setTempoAtendimento(1);
			
		atendimentoService.incluir(a1);
				
		
		Atendimento a2 = new Atendimento("psicologo", 100, true);
		a2.setEspecializacao("criança");
		a2.setHonorario(100);
		a2.setNomeProfissional("Maria");
		a2.setTempoAtendimento(1);
			
		atendimentoService.incluir(a2);
		
		for (Atendimento a : atendimentoService.obterLista()) {
			System.out.println(a);
		}
		
		atendimentoService.excluir(1);
		
		for (Atendimento b : atendimentoService.obterLista()) {
			System.out.println(b);
		}
		
		Atendimento a3 = atendimentoService.obterPorId(2);
		System.out.println(a3.getDescricao());
	}

}
