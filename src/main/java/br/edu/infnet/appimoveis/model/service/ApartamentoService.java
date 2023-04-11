package br.edu.infnet.appimoveis.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.appimoveis.model.repository.ApartamentoRepository;
import br.edu.infnet.appimoveis.models.domain.Apartamento;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Service
public class ApartamentoService {
	
	@Autowired
	private ApartamentoRepository apartamentoRepository;
	
	public Apartamento incluir(Apartamento apartamento) {
		return apartamentoRepository.save(apartamento);
	}
	
	public void excluir(Integer key) {
		apartamentoRepository.deleteById(key);
	}
	
	public Collection<Apartamento> obterLista(Usuario usuario){
		return apartamentoRepository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "codigo"));
	}
	
	public Apartamento obterPorId(Integer id) {
		return apartamentoRepository.findById(id).orElse(null);
	}

}
