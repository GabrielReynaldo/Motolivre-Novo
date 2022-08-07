package com.gabriel.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.helpdesk.domain.Motoboy;
import com.gabriel.helpdesk.domain.Pessoa;
import com.gabriel.helpdesk.domain.dtos.MotoboyDTO;
import com.gabriel.helpdesk.repositories.MotoboyRepository;
import com.gabriel.helpdesk.repositories.PessoaRepository;
import com.gabriel.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.gabriel.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class MotoboyService {

	@Autowired
	private MotoboyRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Motoboy findById (Integer id){
		Optional<Motoboy> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: "+id));
	}

	public List<Motoboy> findAll() {
		return repository.findAll();
	}

	public Motoboy create(MotoboyDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Motoboy newObj = new Motoboy(objDTO);
		return repository.save(newObj);
	}
	
	public Motoboy update(Integer id, @Valid MotoboyDTO objDTO) {
		objDTO.setId(id);
		Motoboy oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Motoboy(objDTO);
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Motoboy obj = findById(id);
		if(obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("Motoboy PEssui ordens de serviço e não pode ser deletado!");
		}else {
			repository.deleteById(id);
		}
	}

	private void validaPorCpfEEmail(MotoboyDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF ja cadastrado no sistema");
		}
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email ja cadastrado no sistema"); 
	}
}

	

	
	}
