package com.gabriel.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabriel.helpdesk.domain.Chamado;
import com.gabriel.helpdesk.domain.Estabelecimento;
import com.gabriel.helpdesk.domain.Motoboy;
import com.gabriel.helpdesk.domain.enums.Perfil;
import com.gabriel.helpdesk.domain.enums.Prioridade;
import com.gabriel.helpdesk.domain.enums.Status;
import com.gabriel.helpdesk.repositories.ChamadoRepository;
import com.gabriel.helpdesk.repositories.EstabelecimentoRepository;
import com.gabriel.helpdesk.repositories.MotoboyRepository;

@SpringBootApplication
public class MotolivreNovoApplication implements CommandLineRunner{
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	@Autowired
	private MotoboyRepository motoboyRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(MotolivreNovoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estabelecimento est1 = new Estabelecimento(null, "Gabriel 1","15975708001","gabriel1@gmail.com","123");
		est1.addPerfil(Perfil.ADMIN);
		
		Motoboy mot1 = new Motoboy(null, "Gabriel 2","41995562068","gabriel2@gmail.com","123"); 
		
		Chamado c1 = new Chamado(null,Prioridade.MEDIA,Status.ANDAMENTO,"Chamado 01","Primeiro chamado",est1,mot1);
		
		estabelecimentoRepository.saveAll(Arrays.asList(est1));
		motoboyRepository.saveAll(Arrays.asList(mot1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
