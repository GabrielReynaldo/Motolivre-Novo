package com.gabriel.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.helpdesk.domain.Avaliacao;




public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {

}
