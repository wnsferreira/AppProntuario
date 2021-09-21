package br.edu.infnet.appProntuario.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appProntuario.model.domain.Consulta;
import br.edu.infnet.appProntuario.model.repository.ConsultaRepository;


@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	public List<Consulta> obterLista(){
		return (List<Consulta>) consultaRepository.findAll();
	}
	
	public void incluir(Consulta consulta) {
		consultaRepository.save(consulta);
	}
	
	public void excluir(Integer id) {
		consultaRepository.deleteById(id);
		
	}
	
	public Consulta obterPorId(Integer id) {
		return consultaRepository.findById(id).orElse(null);
	}
}
