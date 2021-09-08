package br.edu.infnet.appProntuario.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appProntuario.model.domain.Atendimento;
import br.edu.infnet.appProntuario.model.repository.AtendimentoRepository;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	public List<Atendimento> obterLista(){
		return (List<Atendimento>) atendimentoRepository.findAll();
	}
	
	public void incluir(Atendimento atendimento) {
		atendimentoRepository.save(atendimento);
	}
	
	public void excluir(Integer id) {
		atendimentoRepository.deleteById(id);
		
	}
	
	public Atendimento obterPorId(Integer id) {
		return atendimentoRepository.findById(id).orElse(null);
	}
}
