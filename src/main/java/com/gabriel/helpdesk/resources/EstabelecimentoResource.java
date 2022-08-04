package com.gabriel.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
