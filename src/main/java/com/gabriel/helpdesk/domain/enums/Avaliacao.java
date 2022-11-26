package com.gabriel.helpdesk.domain.enums;

public enum Avaliacao {

	MUITO_BOM(0, "MUITO BOM"), BOM(1, "BOM"), RUIM(2, "RUIM"), MUITO_RUIM(3, "MUITO RUIM");
	
	private Integer codigo;
	private String descricao;
	
	private Avaliacao(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Avaliacao toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(Avaliacao x: Avaliacao.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Avaliação invalido");
	}
}
