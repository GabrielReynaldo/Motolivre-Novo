package com.gabriel.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.helpdesk.domain.Motoboy;


public interface PessoaRepository extends JpaRepository<Motoboy, Integer> {

}
