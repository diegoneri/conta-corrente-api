package com.fatecrl.contacorrente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatecrl.contacorrente.model.PessoaJuridica;

public interface PessoaJuridicaRepository
        extends JpaRepository<PessoaJuridica, Long> {

}
