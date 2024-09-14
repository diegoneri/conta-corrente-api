package com.fatecrl.contacorrente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/testes")
public class TesteController {

    @Autowired
    private TesteService testeService;

    @GetMapping
    public List<Teste> getAllTestes() {
        return testeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teste> getTesteById(@PathVariable Integer id) {
        Optional<Teste> teste = testeService.findById(id);
        return teste.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Teste> createTeste(@RequestBody Teste teste) {
        Teste savedTeste = testeService.save(teste);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeste);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teste> updateTeste(@PathVariable Integer id, @RequestBody Teste teste) {
        if (!testeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        teste.setId(id);
        Teste updatedTeste = testeService.save(teste);
        return ResponseEntity.ok(updatedTeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeste(@PathVariable Integer id) {
        if (!testeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        testeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}