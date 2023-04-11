package br.edu.infnet.appimoveis.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appimoveis.models.domain.Imovel;

@Repository
public interface ImovelRepository extends CrudRepository<Imovel, Integer> {
	
	@Query("from Imovel p where p.usuario.id = :userId")
	List<Imovel> obterLista(Integer userId, Sort sort);

}
