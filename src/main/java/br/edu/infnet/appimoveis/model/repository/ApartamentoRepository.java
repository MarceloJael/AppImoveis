package br.edu.infnet.appimoveis.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appimoveis.models.domain.Apartamento;

@Repository
public interface ApartamentoRepository extends CrudRepository<Apartamento, Integer>{
	
	@Query("from Apartamento s where s.usuario.id = :userId")
	List<Apartamento> obterLista(Integer userId, Sort sort);
}
