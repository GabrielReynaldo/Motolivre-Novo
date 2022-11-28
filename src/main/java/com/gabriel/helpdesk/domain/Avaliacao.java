package com.gabriel.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy" )
	private LocalDate dataAbertura = LocalDate.now();
	private String defeito;
	private String qualidade;
	private String melhora;
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "estabelecimento_id")
	private Estabelecimento estabelecimento;
	
	@ManyToOne
	@JoinColumn(name = "motoboy_id")
	private Motoboy motoboy;
	
	
	
	public Avaliacao() {
		super();
	}
	public Avaliacao(Integer id, String defeito, String qualidade, String melhora, String observacao, Motoboy motoboy,
			Estabelecimento estabelecimento) {
		super();
		this.id = id;
		this.defeito = defeito;
		this.qualidade = qualidade;
		this.melhora = melhora;
		this.observacao = observacao;
		this.motoboy = motoboy;
		this.estabelecimento = estabelecimento;
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
	public String getDefeito() {
		return defeito;
	}
	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}
	public String getQualidade() {
		return qualidade;
	}
	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}
	public String getMelhora() {
		return melhora;
	}
	public void setMelhora(String melhora) {
		this.melhora = melhora;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Motoboy getMotoboy() {
		return motoboy;
	}
	public void setMotoboy(Motoboy motoboy) {
		this.motoboy = motoboy;
	}
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliacao other = (Avaliacao) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
