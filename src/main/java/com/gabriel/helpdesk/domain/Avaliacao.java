package com.gabriel.helpdesk.domain;

import java.time.LocalDate;

public class Avaliacao {
	private Integer id;
	private LocalDate dataAbertura = LocalDate.now();
	private String defeito;
	private String qualidade;
	private String melhora;
	private String Observacao;
}
