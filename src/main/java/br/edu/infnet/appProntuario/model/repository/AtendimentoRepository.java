package br.edu.infnet.appProntuario.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appProntuario.model.domain.Atendimento;

@Repository
public interface AtendimentoRepository extends CrudRepository<Atendimento, Integer> {
	

}
