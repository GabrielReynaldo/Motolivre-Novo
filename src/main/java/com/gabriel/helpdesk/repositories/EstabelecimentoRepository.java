package com.gabriel.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.helpdesk.domain.Estabelecimento;



public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Integer> {

}
