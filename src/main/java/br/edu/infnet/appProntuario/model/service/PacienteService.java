package br.edu.infnet.appProntuario.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appProntuario.model.domain.Paciente;
import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public List<Paciente> obterLista(Usuario usuario){
		
		return pacienteRepository.obterLista(usuario.getId());
	}
	
	public List<Paciente> obterLista(){
		
		return (List<Paciente>) pacienteRepository.findAll();
		
	}
	
	public void incluir(Paciente paciente) {
		
		pacienteRepository.save(paciente);
	}
	
	public void excluir(Integer id) {
		
		pacienteRepository.deleteById(id);
	}
}
