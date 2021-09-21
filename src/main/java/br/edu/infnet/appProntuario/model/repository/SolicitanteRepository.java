package br.edu.infnet.appProntuario.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appProntuario.model.domain.Solicitante;

@Repository
public interface SolicitanteRepository extends CrudRepository<Solicitante, Integer>{

	@Query("from Solicitante s where s.usuario.id = :userId")
	public List<Solicitante> obterLista(Integer userId);
}
