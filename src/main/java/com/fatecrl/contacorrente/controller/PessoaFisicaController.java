package com.fatecrl.contacorrente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.fatecrl.contacorrente.model.PessoaFisica;
import com.fatecrl.contacorrente.service.PessoaFisicaService;

public class PessoaFisicaController implements IController<PessoaFisica> {

    @Autowired
    private final PessoaFisicaService pessoaFisicaService;

    @Override
    public ResponseEntity<List<PessoaFisica>> getAll() {
        return ResponseEntity.ok(pessoaFisicaService.findAll());
    }

    @Override
    public ResponseEntity<PessoaFisica> get(Long id) {
        return ResponseEntity.ok(pessoaFisicaService.getById(id));
    }

    @Override
    public ResponseEntity<PessoaFisica> post(PessoaFisica obj) {
        return ResponseEntity.ok(pessoaFisicaService.post(obj));
    }

    @Override
    public ResponseEntity<?> put(PessoaFisica obj) {
        return ResponseEntity.ok(pessoaFisicaService.put(obj));
    }

    @Override
    public ResponseEntity<?> patch(PessoaFisica obj) {
        return ResponseEntity.ok(pessoaFisicaService.patch(obj));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return ResponseEntity.ok(pessoaFisicaService.delete(id));
    }

}
