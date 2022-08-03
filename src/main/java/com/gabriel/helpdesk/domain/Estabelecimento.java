package com.gabriel.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Estabelecimento extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "estabelecimento")
	private List<Chamado> chamados = new ArrayList<>();

	public Estabelecimento() {
		super();
	}

	public Estabelecimento(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	
	
}
