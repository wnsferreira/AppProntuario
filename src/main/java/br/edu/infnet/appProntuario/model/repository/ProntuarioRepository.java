package br.edu.infnet.appProntuario.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appProntuario.model.domain.Prontuario;

@Repository
public interface ProntuarioRepository extends CrudRepository<Prontuario, Integer> {

	@Query("from Prontuario p where p.usuario.id = :userId")
	public List<Prontuario> obterLista(Integer userId);
}
