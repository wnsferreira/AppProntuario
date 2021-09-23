package br.edu.infnet.appProntuario.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appProntuario.model.domain.Prontuario;
import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.repository.ProntuarioRepository;

@Service
public class ProntuarioService {

	@Autowired
	private ProntuarioRepository prontuarioRepository;
	
	public List<Prontuario> obterLista(Usuario usuario){
		
		return prontuarioRepository.obterLista(usuario.getId());
	}
	
	public List<Prontuario> obterLista(){
		
		return (List<Prontuario>) prontuarioRepository.findAll();
		
	}
	
	public void incluir(Prontuario prontuario) {
		
		prontuarioRepository.save(prontuario);
	}
	
	public void excluir(Integer id) {
		
		prontuarioRepository.deleteById(id);
	}
	
	public Prontuario obterPorId(Integer id) {
		return prontuarioRepository.findById(id).orElse(null);
	}
	
	public Integer obterQtde() {
		return (int) prontuarioRepository.count();
	}
}
