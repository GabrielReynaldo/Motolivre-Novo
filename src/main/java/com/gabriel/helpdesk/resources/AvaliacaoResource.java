package com.gabriel.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.helpdesk.domain.Avaliacao;
import com.gabriel.helpdesk.domain.dtos.AvaliacaoDTO;
import com.gabriel.helpdesk.services.AvaliacaoService;

@RestController
@RequestMapping(value = "/avaliacao")
public class AvaliacaoResource {

	@Autowired
	private AvaliacaoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AvaliacaoDTO>findById(@PathVariable Integer id){
		Avaliacao obj = service.findById(id);
		return ResponseEntity.ok().body(new AvaliacaoDTO(obj));
	}
}
