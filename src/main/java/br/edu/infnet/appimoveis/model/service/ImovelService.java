package br.edu.infnet.appimoveis.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appimoveis.model.repository.ImovelRepository;
import br.edu.infnet.appimoveis.models.domain.Imovel;
import br.edu.infnet.appimoveis.models.domain.Usuario;

@Service
public class ImovelService {
	
	@Autowired
	private ImovelRepository imovelRepository;

	public void excluir(Integer id) {
		imovelRepository.deleteById(id);
	}
	
	public Collection<Imovel> obterLista(){
		return (Collection<Imovel>) imovelRepository.findAll();
	}
	
	public Collection<Imovel> obterLista(Usuario usuario){
		return (Collection<Imovel>) imovelRepository.obterLista(usuario.getId());
	}

	public Imovel obterPorId(Integer id) {
		return imovelRepository.findById(id).orElse(null);
	}

}
