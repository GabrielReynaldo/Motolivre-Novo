package com.gabriel.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabriel.helpdesk.domain.Avaliacao;

public class AvaliacaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
private Integer id;
@JsonFormat(pattern = "dd/MM/yyyy" )
	private LocalDate dataAbertura = LocalDate.now();
	private String defeito;
	private String qualidade;
	private String melhora;
	private String observacao;
	private Integer estabelecimento;
	private Integer motoboy;
	private String nomeEstabelecimento;
	private String nomeMotoboy;
	public AvaliacaoDTO() {
		super();
	}
	public AvaliacaoDTO(Avaliacao obj) {
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.defeito = obj.getDefeito();
		this.qualidade = obj.getQualidade();
		this.melhora = obj.getMelhora();
		this.observacao = obj.getObservacao();
		this.estabelecimento = obj.getEstabelecimento().getId();
		this.motoboy = obj.getMotoboy().getId();
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
