package com.fatecrl.contacorrente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatecrl.contacorrente.model.PessoaFisica;

public interface PessoaFisicaRepository 
        extends JpaRepository<PessoaFisica, Long> {

}
