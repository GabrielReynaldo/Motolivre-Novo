package com.gabriel.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.helpdesk.domain.dtos.EstabelecimentoDTO;
import com.gabriel.helpdesk.domain.enums.Perfil;

@Entity
public class Estabelecimento extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "estabelecimento")
	private List<Chamado> chamados = new ArrayList<>();
	@OneToMany(mappedBy = "estabelecimento")
	private List<Avaliacao> avaliacao = new ArrayList<>();

	public Estabelecimento() {
		super();
		addPerfil(Perfil.ESTABELECIMENTO);
	}

	public Estabelecimento(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.ESTABELECIMENTO);
	}
	public Estabelecimento(EstabelecimentoDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}
	

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	public List<Avaliacao> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(List<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}
	

	
	
}
