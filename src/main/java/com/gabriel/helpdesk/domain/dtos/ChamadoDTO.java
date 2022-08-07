package com.gabriel.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabriel.helpdesk.domain.Chamado;

public class ChamadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy" )
	private LocalDate dataAbertura = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy" )
	private LocalDate dataFechamento;
	@NotNull(message = "O campo prioridade é requerido")
	private Integer prioridade;
	@NotNull(message = "O campo Status é requerido")
	private Integer status;
	@NotNull(message = "O campo Titulo é requerido")
	private String titulo;
	@NotNull(message = "O campo Observações é requerido")
	private String observacoes;
	@NotNull(message = "O campo Estabelecimento é requerido")
	private Integer estabelecimento;
	@NotNull(message = "O campo Motoboy é requerido")
	private Integer motoboy;
	private String nomeEstabelecimento;
	private String nomeMotoboy;
	public ChamadoDTO() {
		super();
	}
	public ChamadoDTO(Chamado obj) {
		super();
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
		this.prioridade = obj.getPrioridade().getCodigo();
		this.status = obj.getStatus().getCodigo();
		this.titulo = obj.getTitulo();
		this.observacoes = obj.getObservacoes();
		this.motoboy = obj.getMotoboy().getId();
		this.estabelecimento = obj.getEstabelecimento().getId();
		this.nomeEstabelecimento = obj.getEstabelecimento().getNome();
		this.nomeMotoboy = obj.getMotoboy().getNome();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public LocalDate getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public Integer getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Integer getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Integer estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public Integer getMotoboy() {
		return motoboy;
	}
	public void setMotoboy(Integer motoboy) {
		this.motoboy = motoboy;
	}
	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}
	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}
	public String getNomeMotoboy() {
		return nomeMotoboy;
	}
	public void setNomeMotoboy(String nomeMotoboy) {
		this.nomeMotoboy = nomeMotoboy;
	}
	
	
}
