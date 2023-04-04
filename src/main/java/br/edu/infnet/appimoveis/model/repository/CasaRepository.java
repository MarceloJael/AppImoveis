package br.edu.infnet.appimoveis.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appimoveis.models.domain.Casa;

@Repository
public interface CasaRepository extends CrudRepository<Casa, Integer>{
	
	@Query("from Casa s where s.usuario.id = :userId")
	List<Casa> obterLista(Integer userId, Sort sort);

}
