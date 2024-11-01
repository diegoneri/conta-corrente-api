package com.fatecrl.contacorrente.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatecrl.contacorrente.model.Conta;

@Repository
public interface ContaRepository 
         extends JpaRepository<Conta, Long>{

    public Page<Conta> findByTitular(String titular, Pageable pageable);
}
