package com.gabriel.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriel.helpdesk.domain.Estabelecimento;
import com.gabriel.helpdesk.domain.dtos.EstabelecimentoDTO;
import com.gabriel.helpdesk.services.EstabelecimentoService;

@RestController
@RequestMapping(value = "/estabelecimentos")
public class EstabelecimentoResource {
//localhost:8080/estabelecimentos
	
	@Autowired
	private EstabelecimentoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EstabelecimentoDTO> findById(@PathVariable Integer id ){
		Estabelecimento obj = service.findById(id);
		return ResponseEntity.ok().body(new EstabelecimentoDTO(obj));
	}
	@GetMapping
	public ResponseEntity<List<EstabelecimentoDTO>> findAll(){
		List<Estabelecimento> list = service.findAll();
		List<EstabelecimentoDTO> listDTO = list.stream().map(obj -> new EstabelecimentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<EstabelecimentoDTO> create(@Valid @RequestBody EstabelecimentoDTO objDTO){
		
		Estabelecimento newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EstabelecimentoDTO> update(@PathVariable Integer id, @Valid @RequestBody EstabelecimentoDTO objDTO){
		Estabelecimento obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new EstabelecimentoDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<EstabelecimentoDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
