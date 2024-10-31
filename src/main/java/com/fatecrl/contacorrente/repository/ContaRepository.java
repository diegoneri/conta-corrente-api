package com.fatecrl.contacorrente.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatecrl.contacorrente.model.ContaCorrente;

@Repository
public interface ContaRepository 
         extends JpaRepository<ContaCorrente, Long>{

    public Page<ContaCorrente> findByTitular(String titular, Pageable pageable);
}
