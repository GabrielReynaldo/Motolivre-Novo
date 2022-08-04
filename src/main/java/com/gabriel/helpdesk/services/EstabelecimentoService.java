package com.gabriel.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.helpdesk.domain.Estabelecimento;
import com.gabriel.helpdesk.repositories.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository repository;
	
	public Estabelecimento findById (Integer id){
		Optional<Estabelecimento> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
