package com.gabriel.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.helpdesk.domain.Pessoa;

public interface MotoboyRepository extends JpaRepository<Pessoa, Integer> {

}
