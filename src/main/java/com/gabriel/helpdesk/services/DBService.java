package com.gabriel.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gabriel.helpdesk.domain.Chamado;
import com.gabriel.helpdesk.domain.Estabelecimento;
import com.gabriel.helpdesk.domain.Motoboy;
import com.gabriel.helpdesk.domain.enums.Perfil;
import com.gabriel.helpdesk.domain.enums.Prioridade;
import com.gabriel.helpdesk.domain.enums.Status;
import com.gabriel.helpdesk.repositories.ChamadoRepository;
import com.gabriel.helpdesk.repositories.PessoaRepository;

@Service
public class DBService {
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	public void instanciaDB() {
		Estabelecimento est1 = new Estabelecimento(null, "Gabriel 1","15975708001","gabriel1@gmail.com",encoder.encode("123"));
		est1.addPerfil(Perfil.ADMIN);
		Estabelecimento est2 = new Estabelecimento(null, "Gabriel 1","47549328030","gabriel4@gmail.com",encoder.encode("123"));
		est2.addPerfil(Perfil.ADMIN);
		
		Motoboy mot1 = new Motoboy(null, "Gabriel 2","41995562068","gabriel2@gmail.com",encoder.encode("123"));
		mot1.addPerfil(Perfil.ADMIN);
		Motoboy mot2 = new Motoboy(null, "Gabriel 2","15382201056","gabriel3@gmail.com",encoder.encode("123")); 
		mot2.addPerfil(Perfil.ADMIN);
		Chamado c1 = new Chamado(null,Prioridade.MEDIA,Status.ANDAMENTO,"Chamado 01","Primeiro chamado",est1,mot1);
		
		pessoaRepository.saveAll(Arrays.asList(est1,est2 , mot1, mot2));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
	
	

}
