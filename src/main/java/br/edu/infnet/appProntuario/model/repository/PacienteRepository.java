package br.edu.infnet.appProntuario.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appProntuario.model.domain.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer>{

	@Query("from Paciente p where p.usuario.id = :userId")
	public List<Paciente> obterLista(Integer userId);
}
