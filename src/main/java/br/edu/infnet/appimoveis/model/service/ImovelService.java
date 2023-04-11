package br.edu.infnet.appimoveis.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.appimoveis.model.repository.ImovelRepository;
import br.edu.infnet.appimoveis.models.domain.Imovel;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Service
public class ImovelService {
	
	@Autowired
	private ImovelRepository imovelRepository;
	
	public Imovel incluir(Imovel imovel) {
		return imovelRepository.save(imovel);
	}

	public void excluir(Integer id) {
		imovelRepository.deleteById(id);
	}
	
	public Collection<Imovel> obterLista(){
		return (Collection<Imovel>) imovelRepository.findAll();
	}
	
	public Collection<Imovel> obterLista(Usuario usuario){
		return (Collection<Imovel>) imovelRepository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "codigo"));
	}

	public Imovel obterPorId(Integer id) {
		return imovelRepository.findById(id).orElse(null);
	}

}
