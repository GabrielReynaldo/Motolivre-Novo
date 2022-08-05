package com.gabriel.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.helpdesk.domain.Estabelecimento;
import com.gabriel.helpdesk.domain.Pessoa;
import com.gabriel.helpdesk.domain.dtos.EstabelecimentoDTO;
import com.gabriel.helpdesk.repositories.EstabelecimentoRepository;
import com.gabriel.helpdesk.repositories.PessoaRepository;
import com.gabriel.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.gabriel.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Estabelecimento findById (Integer id){
		Optional<Estabelecimento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: "+id));
	}

	public List<Estabelecimento> findAll() {
		return repository.findAll();
	}

	public Estabelecimento create(EstabelecimentoDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Estabelecimento newObj = new Estabelecimento(objDTO);
		return repository.save(newObj);
	}

	private void validaPorCpfEEmail(EstabelecimentoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF ja cadastrado no sistema");
		}
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email ja cadastrado no sistema"); 
	}
}}
