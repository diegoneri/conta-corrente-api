package com.fatecrl.contacorrente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.fatecrl.contacorrente.model.PessoaJuridica;
import com.fatecrl.contacorrente.service.PessoaJuridicaService;

public class PessoaJuridicaController implements IController<PessoaJuridica> {

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @Override
    public ResponseEntity<List<PessoaJuridica>> getAll() {
        return ResponseEntity.ok(pessoaJuridicaService.findAll());
    }

    @Override
    public ResponseEntity<PessoaJuridica> get(Long id) {
        return ResponseEntity.ok(pessoaJuridicaService.findById(id));
    }

    @Override
    public ResponseEntity<PessoaJuridica> post(PessoaJuridica obj) {
        return ResponseEntity.ok(pessoaJuridicaService.create(obj));
    }

    @Override
    public ResponseEntity<?> put(PessoaJuridica obj) {
        return ResponseEntity.ok(pessoaJuridicaService.update(obj));
    }

    @Override
    public ResponseEntity<?> patch(PessoaJuridica obj) {
        return ResponseEntity.ok(pessoaJuridicaService.update(obj));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return ResponseEntity.ok(pessoaJuridicaService.delete(id));
    }

}
