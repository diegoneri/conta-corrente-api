package com.fatecrl.contacorrente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesteRepository extends JpaRepository<Teste, Integer> {
    // Custom query methods (if needed) can be defined here
}