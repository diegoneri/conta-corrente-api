package com.fatecrl.contacorrente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatecrl.contacorrente.model.PessoaFisica;
import com.fatecrl.contacorrente.service.PessoaFisicaService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/pessoa-fisica")
@Tag(name = "Pessoa física", description = "Cadastro de pessoas físicas")
public class PessoaFisicaController implements IController<PessoaFisica> {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @Override
    public ResponseEntity<Page<PessoaFisica>> getAll(Pageable pageable) {
        return ResponseEntity.ok(pessoaFisicaService.findAll(pageable));
    }

    @Override
    public ResponseEntity<PessoaFisica> get(Long id) {
        return ResponseEntity.ok(pessoaFisicaService.findById(id));
    }

    @Override
    public ResponseEntity<PessoaFisica> post(PessoaFisica obj) {
        return ResponseEntity.ok(pessoaFisicaService.create(obj));
    }

    @Override
    public ResponseEntity<?> put(PessoaFisica obj) {
        return ResponseEntity.ok(pessoaFisicaService.update(obj));
    }

    @Override
    public ResponseEntity<?> patch(PessoaFisica obj) {
        return ResponseEntity.ok(pessoaFisicaService.update(obj));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return ResponseEntity.ok(pessoaFisicaService.delete(id));
    }
}
