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
		Estabelecimento est2 = new Estabelecimento(null, "Gabriel 2","47549328030","gabriel4@gmail.com",encoder.encode("123"));
		est2.addPerfil(Perfil.ADMIN);
		Estabelecimento est3 = new Estabelecimento(null, "Gabriel 3","42738072038","gabriel5@gmail.com",encoder.encode("123"));
	
		Estabelecimento est4 = new Estabelecimento(null, "Gabriel 4","91348229098","gabriel6@gmail.com",encoder.encode("123"));
		
		
		Motoboy mot1 = new Motoboy(null, "Gabriel 5","41995562068","gabriel2@gmail.com",encoder.encode("123"));
		mot1.addPerfil(Perfil.ADMIN);
		Motoboy mot2 = new Motoboy(null, "Gabriel 6","15382201056","gabriel3@gmail.com",encoder.encode("123")); 
		mot2.addPerfil(Perfil.ADMIN);
		Motoboy mot3 = new Motoboy(null, "Gabriel 7","27599788000","gabriel7@gmail.com",encoder.encode("123"));

		Motoboy mot4 = new Motoboy(null, "Gabriel 8","93847449052","gabriel8@gmail.com",encoder.encode("123")); 

		
		
		Chamado c1 = new Chamado(null,Prioridade.MEDIA,Status.ANDAMENTO,"Chamado 01","Primeiro chamado",est1,mot1);
		Chamado c2 = new Chamado(null,Prioridade.BAIXA,Status.ABERTO,"Chamado 02","Primeiro chamado",est1,mot2);
		Chamado c3 = new Chamado(null,Prioridade.ALTA,Status.ENCERRADO,"Chamado 03","Primeiro chamado",est1,mot3);
		Chamado c4 = new Chamado(null,Prioridade.MEDIA,Status.ABERTO,"Chamado 04","Primeiro chamado",est1,mot4);
		Chamado c5 = new Chamado(null,Prioridade.BAIXA,Status.ENCERRADO,"Chamado 05","Primeiro chamado",est2,mot1);
		Chamado c6 = new Chamado(null,Prioridade.ALTA,Status.ANDAMENTO,"Chamado 06","Primeiro chamado",est2,mot2);
		Chamado c7 = new Chamado(null,Prioridade.MEDIA,Status.ENCERRADO,"Chamado 07","Primeiro chamado",est2,mot3);
		Chamado c8 = new Chamado(null,Prioridade.BAIXA,Status.ANDAMENTO,"Chamado 08","Primeiro chamado",est4,mot1);
		Chamado c9 = new Chamado(null,Prioridade.ALTA,Status.ABERTO,"Chamado 09","Primeiro chamado",est3,mot4);
		
		pessoaRepository.saveAll(Arrays.asList(est1,est2,est3,est4 , mot1, mot2,mot3,mot4));
		chamadoRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9));
	}
	
	

}
