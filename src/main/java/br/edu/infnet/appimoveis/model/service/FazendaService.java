package br.edu.infnet.appimoveis.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.appimoveis.model.repository.FazendaRepository;
import br.edu.infnet.appimoveis.models.domain.Fazenda;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Service
public class FazendaService {

	@Autowired
	private FazendaRepository fazendaRepository;
	
	public Fazenda incluir(Fazenda fazenda) {
		return fazendaRepository.save(fazenda);
	}
	
	public void excluir(Integer key) {
		fazendaRepository.deleteById(key);
	}
	
	public Collection<Fazenda> obterLista(Usuario usuario){
		return fazendaRepository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "id"));
	}
	
	public Fazenda obterPorId(Integer id) {
		return fazendaRepository.findById(id).orElse(null);
	}
	
}
