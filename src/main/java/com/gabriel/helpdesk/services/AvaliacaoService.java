package com.gabriel.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.helpdesk.domain.Avaliacao;
import com.gabriel.helpdesk.repositories.AvaliacaoRepository;
import com.gabriel.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository repository;
	
	public Avaliacao findById(Integer id) {
		Optional<Avaliacao> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto Não Encontrado id:"+ id));
	}

	public List<Avaliacao> findAll() {
		return repository.findAll();
	}
}
