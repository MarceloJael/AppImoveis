package br.edu.infnet.appimoveis.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.appimoveis.model.repository.CasaRepository;
import br.edu.infnet.appimoveis.models.domain.Casa;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Service
public class CasaService {
	
	@Autowired
	private CasaRepository casaRepository;
	
	public Casa incluir(Casa casa) {
		return casaRepository.save(casa);
	}
	
	public void excluir(Integer key) {
		casaRepository.deleteById(key);
	}
	
	public Collection<Casa> obterLista(Usuario usuario){
		return casaRepository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "id"));
	}
	
	public Casa obterPorId(Integer id) {
		return casaRepository.findById(id).orElse(null);
	}

}
