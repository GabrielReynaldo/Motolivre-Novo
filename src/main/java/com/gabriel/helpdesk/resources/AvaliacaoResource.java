package com.gabriel.helpdesk.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.helpdesk.domain.Avaliacao;
import com.gabriel.helpdesk.domain.dtos.AvaliacaoDTO;
import com.gabriel.helpdesk.domain.dtos.ChamadoDTO;
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
	
	@GetMapping
	public ResponseEntity<List<AvaliacaoDTO>> findAll(){
		List<Avaliacao> list = service.findAll();
		List<AvaliacaoDTO> listDTO = list.stream().map(obj -> new AvaliacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
}
	}
