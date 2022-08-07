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

import com.gabriel.helpdesk.domain.Motoboy;
import com.gabriel.helpdesk.domain.dtos.MotoboyDTO;
import com.gabriel.helpdesk.services.MotoboyService;

@RestController
@RequestMapping(value = "/motoboys")
public class MotoboyResource {
//localhost:8080/estabelecimentos
	
	@Autowired
	private MotoboyService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MotoboyDTO> findById(@PathVariable Integer id ){
		Motoboy obj = service.findById(id);
		return ResponseEntity.ok().body(new MotoboyDTO(obj));
	}
	@GetMapping
	public ResponseEntity<List<MotoboyDTO>> findAll(){
		List<Motoboy> list = service.findAll();
		List<MotoboyDTO> listDTO = list.stream().map(obj -> new MotoboyDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<MotoboyDTO> create(@Valid @RequestBody MotoboyDTO objDTO){
		
		Motoboy newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<MotoboyDTO> update(@PathVariable Integer id, @Valid @RequestBody MotoboyDTO objDTO){
		Motoboy obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new MotoboyDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<MotoboyDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
