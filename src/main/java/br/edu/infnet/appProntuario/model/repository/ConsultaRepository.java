package br.edu.infnet.appProntuario.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appProntuario.model.domain.Consulta;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Integer>{

	
}
