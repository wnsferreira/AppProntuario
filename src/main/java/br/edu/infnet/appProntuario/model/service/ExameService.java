package br.edu.infnet.appProntuario.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appProntuario.model.domain.Exame;
import br.edu.infnet.appProntuario.model.repository.ExameRepository;

@Service
public class ExameService {

	@Autowired
	private ExameRepository exameRepository;
	
	public List<Exame> obterLista(){
		return (List<Exame>) exameRepository.findAll();
	}
	
	public void incluir(Exame exame) {
		exameRepository.save(exame);
	}
	
	public void excluir(Integer id) {
		exameRepository.deleteById(id);
		
	}
	
	public Exame obterPorId(Integer id) {
		return exameRepository.findById(id).orElse(null);
	}
}
