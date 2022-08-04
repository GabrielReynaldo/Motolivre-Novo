package com.gabriel.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.helpdesk.domain.Estabelecimento;
import com.gabriel.helpdesk.domain.dtos.EstabelecimentoDTO;
import com.gabriel.helpdesk.repositories.EstabelecimentoRepository;
import com.gabriel.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository repository;
	
	public Estabelecimento findById (Integer id){
		Optional<Estabelecimento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: "+id));
	}

	public List<Estabelecimento> findAll() {
		return repository.findAll();
	}

	public Estabelecimento create(EstabelecimentoDTO objDTO) {
		objDTO.setId(null);
		Estabelecimento newObj = new Estabelecimento(objDTO);
		return repository.save(newObj);
	}
}
