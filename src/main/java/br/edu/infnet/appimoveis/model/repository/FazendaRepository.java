package br.edu.infnet.appimoveis.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appimoveis.models.domain.Fazenda;

@Repository
public interface FazendaRepository extends CrudRepository<Fazenda, Integer>{
	
	@Query("from Fazenda s where s.usuario.id = :userId")
	List<Fazenda> obterLista(Integer userId, Sort sort);
	
}
